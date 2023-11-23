package org.example.openai;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Choice
{
    @JsonProperty("role")
    private int index;
    @JsonProperty("message")
    private Message message;
    @JsonProperty("finish_reason")
    private String finishReason;
    public Choice()
    {

    }

    public Choice(int index, Message message, String finishReason)
    {
        this.index = index;
        this.message = message;
        this.finishReason = finishReason;
    }

    public int getIndex()
    {
        return index;
    }

    public void setIndex(int index)
    {
        this.index = index;
    }

    public Message getMessage()
    {
        return message;
    }

    public void setMessage(Message message)
    {
        this.message = message;
    }

    public String getFinishReason()
    {
        return finishReason;
    }

    public void setFinishReason(String finishReason)
    {
        this.finishReason = finishReason;
    }
}
