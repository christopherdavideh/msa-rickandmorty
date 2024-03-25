package com.cdeh.msa.rickandmorty.repository.impl;

import com.cdeh.msa.rickandmorty.repository.ICharactersRepository;
import com.cdeh.msa.rickandmorty.service.dto.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Repository
public class CharactersRepositoryImpl implements ICharactersRepository {
    private String URI="https://rickandmortyapi.com/api/character";
    @Autowired
    RestTemplate restTemplate;
    @Override
    public List<Character> getCharacter() {
        Character[] data = restTemplate.getForObject(
                URI,
                Character[].class);
        List<Character> listCharacter = Arrays.asList(data);
        return  listCharacter;
    }
}
