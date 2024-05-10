package com.cdeh.msa.rickandmorty.repository.impl;

import com.cdeh.msa.rickandmorty.repository.ICharactersRepository;
import com.cdeh.msa.rickandmorty.service.dto.Character;
import com.cdeh.msa.rickandmorty.service.dto.ResponseWrapper;
import com.cdeh.msa.rickandmorty.utils.JsonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Repository
public class CharactersRepositoryImpl implements ICharactersRepository {
    @Value( "${api.base-url}" )
    private String baseUl;
    @Value( "${api.end-points.character}" )
    private String characterEndpoint;
    @Autowired
    RestTemplate restTemplate;
    @Override
    public List<Character> getCharacter() throws JsonProcessingException {
        ResponseEntity<ResponseWrapper> responseCharacter = restTemplate.getForEntity(
                baseUl.concat(characterEndpoint),
                ResponseWrapper.class);

        return Objects.requireNonNull(responseCharacter.getBody()).getResults();
    }

    @Override
    public Character getSingleCharacter(String id) throws JsonProcessingException {
        ResponseEntity<Character> responseCharacter = restTemplate.getForEntity(
                baseUl.concat(characterEndpoint).concat(id),
                Character.class);

        return Objects.requireNonNull(responseCharacter.getBody());
    }
}
