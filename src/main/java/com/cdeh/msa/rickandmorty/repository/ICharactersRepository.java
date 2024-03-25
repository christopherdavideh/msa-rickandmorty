package com.cdeh.msa.rickandmorty.repository;

import com.cdeh.msa.rickandmorty.service.dto.Character;

import java.util.List;


public interface ICharactersRepository {
    public List<Character> getCharacter();
}
