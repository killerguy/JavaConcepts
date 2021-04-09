package com.mukul.utility;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class JsonUtils {
    private ObjectMapper jsonObjectMapper;

    public JsonUtils() {
        jsonObjectMapper = new ObjectMapper();
    }

    public static JsonUtils getInstance() {
        return new JsonUtils();
    }

    public JsonNode convertJsonStringToJsonNode(String jsonString) {
        JsonNode rootNode;
        try {
            rootNode = jsonObjectMapper.readTree(jsonString);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return rootNode;
    }

    public String objectToJsonString(final Object objectToConvertToJsonString) {
        StringWriter jsonWriter = new StringWriter();
        try {
            jsonObjectMapper.writeValue(jsonWriter, objectToConvertToJsonString);
            return jsonWriter.toString();
        } catch (IOException e) {
            return "{}";
        }
    }

    public <T> T convertJSONStringToObject(String jsonFormattedString, Class<T> clazz) {
        try {
            return new ObjectMapper().readValue(jsonFormattedString, clazz);
        } catch (Exception e) {
            throw new ParseException(e);
        }
    }

    public <T> T convertStringToObject(String jsonFormattedString, Class<T> clazz) {
        try {
            return new ObjectMapper().readValue(jsonFormattedString, clazz);
        } catch (Exception e) {
            throw new ParseException(e);
        }
    }


    public void setJsonObjectMapper(ObjectMapper jsonObjectMapper) {
        this.jsonObjectMapper = jsonObjectMapper;
    }

    public List<String> findChildrenAsString(JsonNode root, String child) {
        return root == null ? new ArrayList<>() : root.findValuesAsText(child);
    }

    public String findChildValue(JsonNode root, String child) {
        List<String> childrenAsString = findChildrenAsString(root, child);
        return childrenAsString.isEmpty() ? "" : childrenAsString.get(0);
    }

    public List<String> findChildrenAsString(JsonNode root, String parent, String child) {
        List<JsonNode> parents = root == null ? new ArrayList<>() : root.findValues(parent);
        ArrayList<String> children = new ArrayList<>();
        for (JsonNode parentNode : parents) {
            children.addAll(findChildrenAsString(parentNode, child));
        }
        return children;
    }

    public static class ParseException extends RuntimeException {
        public ParseException(Throwable cause) {
            super(cause);
        }
    }
}
