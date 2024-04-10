package com.cdeh.msa.rickandmorty.controller;

import com.cdeh.msa.rickandmorty.service.ICharactersService;
import com.cdeh.msa.rickandmorty.service.dto.Character;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class CharactersController {

    private static final Logger logger = LogManager.getLogger(CharactersController.class);
    @Autowired
    ICharactersService charactersService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("characters")
    public List<Character> getCharacters(){
        logger.info(charactersService.listCharacters());
        return charactersService.listCharacters();
    }
}
