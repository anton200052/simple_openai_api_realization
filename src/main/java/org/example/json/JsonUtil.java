package org.example.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;

import java.io.IOException;

public class JsonUtil
{
    private static final ObjectMapper objectMapper = getDefaultObjectMapper();

    private static ObjectMapper getDefaultObjectMapper()
    {
        ObjectMapper defaultObjectMapper = new ObjectMapper();
        defaultObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return defaultObjectMapper;
    }

    public static JsonNode parse(String string) throws IOException
    {
        return objectMapper.readTree(string);
    }

    public static <T> T fromJson(JsonNode node, Class<T> clazz) throws JsonProcessingException
    {
        return objectMapper.treeToValue(node, clazz);
    }

    public static JsonNode toJson(Object o)
    {
        return objectMapper.valueToTree(o);
    }

    public static String stringify(JsonNode node) throws JsonProcessingException
    {
        return generateString(node, false);
    }

    public static String prettyStringify(JsonNode node) throws JsonProcessingException
    {
        return generateString(node, true);
    }

    public static String generateString(JsonNode node, boolean pretty) throws JsonProcessingException
    {
        ObjectWriter objectWriter = objectMapper.writer();
        if (pretty)
        {
            objectWriter = objectMapper.writer(SerializationFeature.INDENT_OUTPUT);
        }
        return objectWriter.writeValueAsString(node);
    }
}
