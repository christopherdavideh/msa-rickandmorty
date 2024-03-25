package com.cdeh.msa.rickandmorty.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.math.BigDecimal;

public class JsonUtil {
    private static ObjectMapper mapper = new ObjectMapper();

    private JsonUtil() {}

    public static JsonNode getRoot(String root) throws JsonProcessingException {
        return mapper.readTree(root);
    }

    public static String transformObjectToJson(Object object) throws JsonProcessingException {
        if (object == null) {
            throw new RuntimeException();
        }
        return mapper.writeValueAsString(object);
    }

    public static JsonNode getChildByRootByNode(JsonNode rootNode, String node) {
        return rootNode.path(node);
    }

    public static JsonNode addNode(JsonNode node, String fieldName, BigDecimal value) {
        ObjectNode newNode = ((ObjectNode) node);
        newNode.put(fieldName, value);
        return newNode;
    }

    public static JsonNode addNode(JsonNode node, String fieldName, String value) {
        ObjectNode newNode = ((ObjectNode) node);
        newNode.put(fieldName, value);
        return newNode;
    }

    public static JsonNode addNodePojo(JsonNode node, String propertyName, Object pojo) {
        ObjectNode newNode = ((ObjectNode) node);
        newNode.putPOJO(propertyName, pojo);
        return newNode;
    }

    public static JsonNode updateNodeValue(JsonNode node, String fieldName, String value) {
        ObjectNode updateNode = ((ObjectNode) node);
        updateNode.put(fieldName, value);
        return updateNode;
    }
}

