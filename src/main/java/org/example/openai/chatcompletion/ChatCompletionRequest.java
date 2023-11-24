package org.example.openai.chatcompletion;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.openai.apiobjects.Message;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChatCompletionRequest
{
    @JsonProperty("model")
    private String model;
    @JsonProperty("messages")
    private List<Message> messages;

    public ChatCompletionRequest(String model, List<Message> messages)
    {
        this.model = model;
        this.messages = messages;
    }

    public static ChatRequestBuilder builder()
    {
        return new ChatRequestBuilder();
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public List<Message> getMessages()
    {
        return messages;
    }

    public void setMessages(List<Message> messages)
    {
        this.messages = messages;
    }

    public static class ChatRequestBuilder
    {
        private String model;

        private List<Message> messages;

        public ChatRequestBuilder model(String model)
        {
            this.model = model;
            return this;
        }

        public ChatRequestBuilder messages(List<Message> messages)
        {
            this.messages = messages;
            return this;
        }
        public ChatCompletionRequest build()
        {
            return new ChatCompletionRequest(this.model, this.messages);
        }
    }
}
