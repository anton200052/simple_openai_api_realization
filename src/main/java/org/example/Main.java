package org.example;


import org.example.openai.OpenAiController;
import org.example.openai.apiobjects.Message;
import org.example.openai.apiobjects.Tool;
import org.example.openai.assistanst.AssistantsCreator;
import org.example.openai.chatcompletion.ChatCompletionRequest;
import org.example.openai.chatcompletion.ChatCompletionResponse;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        OpenAiController controller = new OpenAiController("");

        /*Message message = new Message("user", "Hello!");
        List<Message> messages = new ArrayList<>();
        messages.add(message);

        ChatCompletionRequest chatRequest = ChatCompletionRequest.builder()
                .messages(messages)
                .model("gpt-3.5-turbo-1106")
                .build();
        ChatCompletionResponse chatCompletionResponse = service.createChatCompletionRequest(chatRequest);
        System.out.println(chatCompletionResponse.getChoices().get(0).getMessage().getContent());*/

        AssistantsCreator assistant = new AssistantsCreator.AssistantsCreatorBuilder()
                .instructions("You are a personal math tutor. Write and run code to answer math questions.")
                .name("Math Tutor")
                .tools(List.of(new Tool("code_interpreter")))
                .model("gpt-4")
                .build();
        controller.createAssistant(assistant);

    }
}