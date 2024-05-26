package com.cdeh.msa.rickandmorty.service.impl;

import com.cdeh.msa.rickandmorty.domain.EventLog;
import com.cdeh.msa.rickandmorty.domain.cache.CharacterCacheDto;
import com.cdeh.msa.rickandmorty.repository.CacheRepository;
import com.cdeh.msa.rickandmorty.repository.ICharactersRepository;
import com.cdeh.msa.rickandmorty.service.ICharactersService;
import com.cdeh.msa.rickandmorty.service.dto.Character;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import static com.cdeh.msa.rickandmorty.utils.RickAndMortyConstant.KEY_CACHE;

@Service
public class CharactersServiceImpl implements ICharactersService {


    @Autowired
    private Logger loggerUtil;
    @Autowired
    ICharactersRepository characterRepository;

    @Autowired
    CacheRepository cacheRepository;

    @Override
    public List<Character> listCharacters() {
        try {
            loggerUtil.info(EventLog.builder().eventType("REQUEST").build());
            Optional<CharacterCacheDto> characters = cacheRepository.findById(KEY_CACHE);

            List<Character> listCharacters = null;

            if(characters.isPresent()) {
                listCharacters = characters.get().getCharacters();
                loggerUtil.info(EventLog.builder().eventType("RESPONSE-REDIS").data(listCharacters).build());
                return listCharacters;
            }

            listCharacters = characterRepository.getCharacter();
            loggerUtil.info(EventLog.builder().eventType("RESPONSE").data(listCharacters).build());
            cacheRepository.save(CharacterCacheDto.builder().characters(listCharacters).id(KEY_CACHE).ttl(60L).build());
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
            Character character = characterRepository.getSingleCharacter(id);
            loggerUtil.info(EventLog.builder().eventType("RESPONSE").data(character).build());
            return character;
        } catch (Exception e) {
            loggerUtil.error("ServiceCDEH: " + e.getMessage());
            throw new RuntimeException("Ha occurido un error en la consulta");
        }
    }
}
