package com.cdeh.msa.rickandmorty.service.impl;

import com.cdeh.msa.rickandmorty.repository.ICharactersRepository;
import com.cdeh.msa.rickandmorty.service.ICharactersService;
import com.cdeh.msa.rickandmorty.service.dto.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharactersServiceImpl implements ICharactersService {
    @Autowired
    ICharactersRepository characterRepository;

    @Override
    public List<Character> listCharacters() {
        try {
            return characterRepository.getCharacter();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
