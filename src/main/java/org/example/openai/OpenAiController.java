package org.example.openai;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.http.OpenAiHttpRequestUtil;
import org.example.json.JsonUtil;
import org.example.openai.assistanst.AssistantsCreator;
import org.example.openai.chatcompletion.ChatCompletionRequest;
import org.example.openai.chatcompletion.ChatCompletionResponse;

public class OpenAiController
{
    private String apiKey;
    private String completionsApiUrl = "https://api.openai.com/v1/chat/completions";

    private String assistantsApiUrl = "https://api.openai.com/v1/assistants";
    public OpenAiController(String apiKey)
    {
        this.apiKey = apiKey;
    }
    public ChatCompletionResponse createChatCompletionRequest(ChatCompletionRequest chatRequest)
    {
        try
        {
            return JsonUtil.fromJson(OpenAiHttpRequestUtil.createPostRequest(JsonUtil.prettyStringify(JsonUtil.toJson(chatRequest)), completionsApiUrl, apiKey, false), ChatCompletionResponse.class);
        }
        catch (JsonProcessingException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void createAssistant(AssistantsCreator creator)
    {
        try
        {
            System.out.println(JsonUtil.prettyStringify(OpenAiHttpRequestUtil.createPostRequest(JsonUtil.prettyStringify(JsonUtil.toJson(creator)), assistantsApiUrl, apiKey, true)));
        }
        catch (JsonProcessingException e)
        {
            throw new RuntimeException(e);
        }
    }
}
