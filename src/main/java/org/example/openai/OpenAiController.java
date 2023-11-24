package org.example.openai;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.http.OpenAiHttpRequestUtil;
import org.example.json.JsonUtil;
import org.example.openai.apiobjects.OpenAIServiceType;
import org.example.openai.assistanst.Assistant;
import org.example.openai.assistanst.AssistantsManager;
import org.example.openai.chatcompletion.ChatCompletionRequest;
import org.example.openai.chatcompletion.ChatCompletionResponse;

public class OpenAiController
{
    private final String apiKey;
    private final String completionsApiUrl = "https://api.openai.com/v1/chat/completions";

    private final String assistantsApiUrl = "https://api.openai.com/v1/assistants";

    public OpenAiController(String apiKey)
    {
        this.apiKey = apiKey;
    }

    public ChatCompletionResponse createChatCompletionRequest(ChatCompletionRequest chatRequest)
    {
        try
        {
            return JsonUtil.fromJson(OpenAiHttpRequestUtil.sendPostRequest(JsonUtil.prettyStringify(JsonUtil.toJson(chatRequest)), completionsApiUrl, apiKey, OpenAIServiceType.CHAT_COMPLETION), ChatCompletionResponse.class);
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
            return JsonUtil.fromJson(OpenAiHttpRequestUtil.sendPostRequest(JsonUtil.prettyStringify(JsonUtil.toJson(manager)), assistantsApiUrl, apiKey, OpenAIServiceType.ASSISTANTS), Assistant.class);
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
            return JsonUtil.fromJson(OpenAiHttpRequestUtil.sendGetRequest(retrieveUrl, apiKey, OpenAIServiceType.ASSISTANTS), Assistant.class);
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
            return JsonUtil.fromJson(OpenAiHttpRequestUtil.sendPostRequest(JsonUtil.prettyStringify(JsonUtil.toJson(manager)), modifyUrl, apiKey, OpenAIServiceType.ASSISTANTS), Assistant.class);
        }
        catch (JsonProcessingException e)
        {
            throw new RuntimeException(e);
        }
    }
}
