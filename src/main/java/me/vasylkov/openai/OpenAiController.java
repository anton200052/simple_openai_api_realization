package me.vasylkov.openai;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import me.vasylkov.http.OpenAiHttpRequestUtil;
import me.vasylkov.json.JsonUtil;
import me.vasylkov.openai.files.OpenAiFile;
import me.vasylkov.openai.files.OpenAiFileCreator;
import me.vasylkov.openai.utils.DeleteResult;
import me.vasylkov.openai.utils.ListQueryParameters;
import me.vasylkov.openai.utils.ListedObjects;
import me.vasylkov.openai.utils.OpenAIServiceType;
import me.vasylkov.openai.assistants.Assistant;
import me.vasylkov.openai.assistants.AssistantsManager;
import me.vasylkov.openai.chatcompletion.ChatCompletionRequest;
import me.vasylkov.openai.chatcompletion.ChatCompletionResponse;

import java.io.IOException;

public class OpenAiController
{
    private final String apiKey;
    private final String completionsApiUrl = "https://api.openai.com/v1/chat/completions";
    private final String assistantsApiUrl = "https://api.openai.com/v1/assistants";

    private final String filesApiUrl = "https://api.openai.com/v1/files";

    public OpenAiController(String apiKey)
    {
        this.apiKey = apiKey;
    }

    public ChatCompletionResponse createChatCompletionRequest(ChatCompletionRequest chatRequest)
    {
        try
        {
            return JsonUtil.fromJsonToObject(OpenAiHttpRequestUtil.sendPostRequest(JsonUtil.prettyStringify(JsonUtil.toJsonFromObject(chatRequest)), completionsApiUrl, apiKey, OpenAIServiceType.CHAT_COMPLETION), ChatCompletionResponse.class);
        }
        catch (JsonProcessingException e)
        {
            throw new RuntimeException(e);
        }
    }

    public Assistant createAssistant(AssistantsManager manager)
    {
        try
        {
            return JsonUtil.fromJsonToObject(OpenAiHttpRequestUtil.sendPostRequest(JsonUtil.prettyStringify(JsonUtil.toJsonFromObject(manager)), assistantsApiUrl, apiKey, OpenAIServiceType.ASSISTANT), Assistant.class);
        }
        catch (JsonProcessingException e)
        {
            throw new RuntimeException(e);
        }
    }

    public Assistant retrieveAssistant(String assistantId)
    {
        String retrieveUrl = assistantsApiUrl + "/" + assistantId;
        try
        {
            return JsonUtil.fromJsonToObject(OpenAiHttpRequestUtil.sendGetRequest(retrieveUrl, apiKey, OpenAIServiceType.ASSISTANT), Assistant.class);
        }
        catch (JsonProcessingException e)
        {
            throw new RuntimeException(e);
        }
    }

    public Assistant modifyAssistant(String assistantId, AssistantsManager manager)
    {
        String modifyUrl = assistantsApiUrl + "/" + assistantId;
        try
        {
            return JsonUtil.fromJsonToObject(OpenAiHttpRequestUtil.sendPostRequest(JsonUtil.prettyStringify(JsonUtil.toJsonFromObject(manager)), modifyUrl, apiKey, OpenAIServiceType.ASSISTANT), Assistant.class);
        }
        catch (JsonProcessingException e)
        {
            throw new RuntimeException(e);
        }
    }

    public DeleteResult deleteAssistant(String assistantId)
    {
        String deleteAssistantUrl = assistantsApiUrl + "/" + assistantId;
        try
        {
            return JsonUtil.fromJsonToObject(OpenAiHttpRequestUtil.sendDeleteRequest(deleteAssistantUrl, apiKey, OpenAIServiceType.ASSISTANT), DeleteResult.class);
        }
        catch (JsonProcessingException e)
        {
            throw new RuntimeException(e);
        }
    }


    public ListedObjects<Assistant> listAssistants(ListQueryParameters parameters)
    {
        int limit = parameters.getLimit();
        String order = parameters.getOrder();
        String after = parameters.getAfter();
        String before = parameters.getBefore();

        StringBuilder listAssistantsUrlBuilder = new StringBuilder(assistantsApiUrl).append("?");
        if (limit != 0)
        {
            listAssistantsUrlBuilder.append("limit=").append(limit).append("&");
        }
        if (order != null) {
            listAssistantsUrlBuilder.append("order=").append(order).append("&");
        }

        if (after != null) {
            listAssistantsUrlBuilder.append("after=").append(after).append("&");
        }

        if (before != null) {
            listAssistantsUrlBuilder.append("before=").append(before);
        }

        String listAssistantsUrl = listAssistantsUrlBuilder.toString();

        try
        {
            return JsonUtil.fromJsonToGenericObject(OpenAiHttpRequestUtil.sendGetRequest(listAssistantsUrl, apiKey, OpenAIServiceType.ASSISTANT), new TypeReference<ListedObjects<Assistant>>() {});
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public OpenAiFile uploadOpenAiFile(OpenAiFileCreator fileCreator)
    {
        try
        {
            return JsonUtil.fromJsonToObject(OpenAiHttpRequestUtil.sendFilePostRequest(JsonUtil.prettyStringify(JsonUtil.toJsonFromObject(fileCreator)), filesApiUrl, apiKey, OpenAIServiceType.FILE, fileCreator), OpenAiFile.class);
        }
        catch (JsonProcessingException e)
        {
            throw new RuntimeException(e);
        }
    }
}
