package com.cdeh.msa.rickandmorty.controller;

import com.cdeh.msa.rickandmorty.domain.EventLog;
import com.cdeh.msa.rickandmorty.service.ICharactersService;
import com.cdeh.msa.rickandmorty.service.dto.Character;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class CharactersController {

    @Autowired
    private Logger loggerUtil;
    @Autowired
    ICharactersService charactersService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("characters")
    public List<Character> getCharacters(){
        loggerUtil.info(EventLog.builder().eventType("REQUEST").build());
        List<Character> characters = charactersService.listCharacters();
        loggerUtil.info(EventLog.builder().eventType("RESPONSE").data(characters).build());
        return characters;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("characters/{id}")
    public Character getSingleCharacters(@PathVariable String id){
        loggerUtil.info(EventLog.builder().eventType("REQUEST").build());
        Character character = charactersService.singleCharacter(id);
        loggerUtil.info(EventLog.builder().eventType("RESPONSE").data(character).build());
        return character;
    }
}
