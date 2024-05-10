package com.cdeh.msa.rickandmorty.service.impl;

import com.cdeh.msa.rickandmorty.domain.EventLog;
import com.cdeh.msa.rickandmorty.repository.ICharactersRepository;
import com.cdeh.msa.rickandmorty.service.ICharactersService;
import com.cdeh.msa.rickandmorty.service.dto.Character;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharactersServiceImpl implements ICharactersService {
    @Autowired
    private Logger loggerUtil;
    @Autowired
    ICharactersRepository characterRepository;

    @Override
    public List<Character> listCharacters() {
        try {
            loggerUtil.info(EventLog.builder().eventType("REQUEST").build());
            List<Character> characters = characterRepository.getCharacter();
            loggerUtil.info(EventLog.builder().eventType("RESPONSE").data(characters).build());
            return characters;
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
