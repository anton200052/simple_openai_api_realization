package me.vasylkov.openai.apiobjects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message
{
    @JsonProperty("role")
    private String role;
    @JsonProperty("content")
    private String content;

    public Message()
    {

    }
    public Message(String role, String content)
    {
        this.role = role;
        this.content = content;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }
}
