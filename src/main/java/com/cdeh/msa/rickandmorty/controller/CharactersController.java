package com.cdeh.msa.rickandmorty.controller;

import com.cdeh.msa.rickandmorty.service.ICharactersService;
import com.cdeh.msa.rickandmorty.service.dto.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class CharactersController {
    @Autowired
    ICharactersService charactersService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("characters")
    public List<Character> getCharacters(){
        return charactersService.listCharacters();
    }
}
