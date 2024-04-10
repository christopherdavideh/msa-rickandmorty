package com.cdeh.msa.rickandmorty.service.impl;

import com.cdeh.msa.rickandmorty.controller.CharactersController;
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
    private static final Logger logger = LogManager.getLogger(CharactersController.class);
    @Autowired
    ICharactersRepository characterRepository;

    @Override
    public List<Character> listCharacters() {
        try {
            logger.info(characterRepository.getCharacter());
            return characterRepository.getCharacter();
        } catch (Exception e) {
            logger.error("ServiceCDEH: " + e.getMessage());
            throw new RuntimeException("Ha occurido un error en la consulta");
        }
    }
}
