package com.cdeh.msa.rickandmorty.service.impl;

import com.cdeh.msa.rickandmorty.domain.EventLog;
import com.cdeh.msa.rickandmorty.domain.cache.CharacterCacheDto;
import com.cdeh.msa.rickandmorty.domain.cache.CharactersCacheDto;
import com.cdeh.msa.rickandmorty.repository.CharacterCacheRepository;
import com.cdeh.msa.rickandmorty.repository.CharactersCacheRepository;
import com.cdeh.msa.rickandmorty.repository.CharactersRepository;
import com.cdeh.msa.rickandmorty.service.ICharactersService;
import com.cdeh.msa.rickandmorty.service.dto.Character;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.cdeh.msa.rickandmorty.utils.RickAndMortyConstant.KEY_CACHE;
import static com.cdeh.msa.rickandmorty.utils.RickAndMortyConstant.KEY_CACHE_CHARACTER;

@Service
public class CharactersServiceImpl implements ICharactersService {


    @Autowired
    private Logger loggerUtil;
    @Autowired
    CharactersRepository characterRepository;

    @Autowired
    CharacterCacheRepository characterCacheRepository;

    @Autowired
    CharactersCacheRepository cacheRepository;

    @Override
    public List<Character> listCharacters() {
        try {
            loggerUtil.info(EventLog.builder().eventType("REQUEST").build());
            Optional<CharactersCacheDto> characters = cacheRepository.findById(KEY_CACHE);

            List<Character> listCharacters;

            if(characters.isPresent()) {
                listCharacters = characters.get().getCharacters();
                loggerUtil.info(EventLog.builder().eventType("RESPONSE-REDIS").data(listCharacters).build());
                return listCharacters;
            }

            listCharacters = characterRepository.getCharacter();
            loggerUtil.info(EventLog.builder().eventType("RESPONSE").data(listCharacters).build());
            cacheRepository.save(CharactersCacheDto.builder().characters(listCharacters).id(KEY_CACHE).ttl(60L).build());
            return listCharacters;


        } catch (Exception e) {
            loggerUtil.error("ServiceCDEH: " + e.getMessage());
            throw new RuntimeException("Ha occurido un error en la consulta");
        }
    }

    @Override
    public Character singleCharacter(String id) {
        try {
            loggerUtil.info(EventLog.builder().eventType("REQUEST").build());

            Optional<CharactersCacheDto> characters = cacheRepository.findById(KEY_CACHE);

            Optional<CharacterCacheDto> characterRedis = characterCacheRepository.findById(KEY_CACHE_CHARACTER + id);
            Character character;

            if(characters.isPresent()) {
                character = characters.get().getCharacters().get(Integer.parseInt(id)-1);
                loggerUtil.info(EventLog.builder().eventType("RESPONSE-REDIS-LIST").data(character).build());
                characterCacheRepository.save(CharacterCacheDto.builder().character(character).id(KEY_CACHE_CHARACTER + id).ttl(60L).build());
                return character;
            }

            if(characterRedis.isPresent()) {
                character = characterRedis.get().getCharacter();
                loggerUtil.info(EventLog.builder().eventType("RESPONSE-REDIS").data(character).build());
                return character;
            }
            character = characterRepository.getSingleCharacter(id);
            loggerUtil.info(EventLog.builder().eventType("RESPONSE").data(character).build());
            characterCacheRepository.save(CharacterCacheDto.builder().character(character).id(KEY_CACHE_CHARACTER + id).ttl(60L).build());
            return character;
        } catch (Exception e) {
            loggerUtil.error("ServiceCDEH: " + e.getMessage());
            throw new RuntimeException("Ha occurido un error en la consulta");
        }
    }
}
