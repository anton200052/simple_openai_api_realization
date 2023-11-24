package org.example;


import org.example.openai.OpenAiController;
import org.example.openai.assistanst.Assistant;
import org.example.openai.assistanst.AssistantsManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

        AssistantsManager manager = AssistantsManager.builder()
                .instructions("You are a personal math tutor. Write and run code to answer math questions.")
                .name("Math Tutor")
                .model("gpt-4")
                .build();

        Assistant assistant = controller.createAssistant(manager);
        System.out.println(assistant);

        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)))
        {
            String str;

            while (!(str = bufferedReader.readLine()).equals("next"))
            {

            }
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }

        AssistantsManager manager2 = AssistantsManager.builder()
                .instructions("1")
                .name("New Name")
                .build();

        Assistant assistant2 = controller.modifyAssistant(assistant.getId(), manager2);
        System.out.println(assistant2);
    }
}