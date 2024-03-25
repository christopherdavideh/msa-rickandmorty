package com.cdeh.msa.rickandmorty.repository.impl;

import com.cdeh.msa.rickandmorty.repository.ICharactersRepository;
import com.cdeh.msa.rickandmorty.service.dto.Character;
import com.cdeh.msa.rickandmorty.utils.JsonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class CharactersRepositoryImpl implements ICharactersRepository {
    private String URI="https://rickandmortyapi.com/api/character";
    @Autowired
    RestTemplate restTemplate;
    @Override
    public List<Character> getCharacter() throws JsonProcessingException {
        ResponseEntity<String> responseCharacter = restTemplate.getForEntity(
                URI,
                String.class);
        JsonNode root = JsonUtil.getRoot(responseCharacter.getBody());
        JsonNode data = JsonUtil.getChildByRootByNode(root, "results");
        ObjectMapper mapper = new ObjectMapper();
        ArrayNode arrayNode = (ArrayNode) data;
        //Convertir ArrayNode a lista de objetos CharacterResult
        List<Character> characterDto = new ArrayList<>();
        for (JsonNode marvelComicJson : arrayNode) {
            Character character = mapper.treeToValue(marvelComicJson, Character.class);
            characterDto.add(character);
        }

        return characterDto;
    }
}
