package me.vasylkov.openai.utils;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeleteResult
{
    @JsonProperty("id")
    private String id;
    @JsonProperty("object")
    private String object;
    @JsonProperty("deleted")
    private boolean deleted;

    public DeleteResult(String id, String object, boolean deleted)
    {
        this.id = id;
        this.object = object;
        this.deleted = deleted;
    }

    public DeleteResult()
    {

    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getObject()
    {
        return object;
    }

    public void setObject(String object)
    {
        this.object = object;
    }

    public boolean isDeleted()
    {
        return deleted;
    }

    public void setDeleted(boolean deleted)
    {
        this.deleted = deleted;
    }
}
