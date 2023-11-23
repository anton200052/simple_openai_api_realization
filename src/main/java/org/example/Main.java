package org.example;

import org.example.openai.ChatCompletionRequest;
import org.example.openai.ChatCompletionResponse;
import org.example.openai.Message;
import org.example.openai.OpenAiService;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        Message message = new Message("user", "Hello!");
        List<Message> messages = new ArrayList<>();
        messages.add(message);

        OpenAiService service = new OpenAiService("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");
        ChatCompletionRequest chatRequest = ChatCompletionRequest.builder()
                .messages(messages)
                .model("gpt-3.5-turbo")
                .build();

        ChatCompletionResponse chatCompletionResponse = service.createChatCompletionRequest(chatRequest);
        System.out.println(chatCompletionResponse.getChoices().get(0).getMessage().getContent());
    }
}