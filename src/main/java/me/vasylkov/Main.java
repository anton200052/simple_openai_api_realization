package me.vasylkov;


import me.vasylkov.openai.OpenAiController;
import me.vasylkov.openai.files.OpenAiFile;
import me.vasylkov.openai.files.OpenAiFileCreator;

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


        OpenAiFileCreator fileCreator = OpenAiFileCreator.builder()
                .purpose("assistants")
                .filePath("1.txt")
                .build();

        OpenAiFile file = controller.uploadOpenAiFile(fileCreator);
        System.out.println(file.getFilename());
    }
}