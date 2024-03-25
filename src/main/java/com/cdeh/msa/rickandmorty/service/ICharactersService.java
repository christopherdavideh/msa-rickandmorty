package com.cdeh.msa.rickandmorty.service;

import com.cdeh.msa.rickandmorty.service.dto.Character;

import java.util.List;

public interface ICharactersService {
    public List<Character> listCharacters();
}
