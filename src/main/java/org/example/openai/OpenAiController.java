package org.example.openai;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.http.OpenAiHttpRequestUtil;
import org.example.json.JsonUtil;
import org.example.openai.chatcompletion.ChatCompletionRequest;
import org.example.openai.chatcompletion.ChatCompletionResponse;

public class OpenAiService
{
    private String apiKey;
    private String completionsApiUrl = "https://api.openai.com/v1/chat/completions";
    public OpenAiService(String apiKey)
    {
        this.apiKey = apiKey;
    }
    public ChatCompletionResponse createChatCompletionRequest(ChatCompletionRequest chatRequest)
    {
        try
        {
            return JsonUtil.fromJson(OpenAiHttpRequestUtil.createPostRequest(JsonUtil.prettyStringify(JsonUtil.toJson(chatRequest)), completionsApiUrl, apiKey), ChatCompletionResponse.class);
        }
        catch (JsonProcessingException e)
        {
            throw new RuntimeException(e);
        }
    }
}
