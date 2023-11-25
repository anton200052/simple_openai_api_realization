package me.vasylkov.openai.files;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OpenAiFile
{
    @JsonProperty("id")
    private String id;
    @JsonProperty("bytes")
    private int bytes;
    @JsonProperty("created_at")
    private int createdAt;
    @JsonProperty("filename")
    private String filename;
    @JsonProperty("object")
    private String object;
    @JsonProperty("purpose")
    private String purpose;

    public OpenAiFile()
    {

    }

    public OpenAiFile(String id, int bytes, int createdAt, String filename, String object, String purpose)
    {
        this.id = id;
        this.bytes = bytes;
        this.createdAt = createdAt;
        this.filename = filename;
        this.object = object;
        this.purpose = purpose;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public int getBytes()
    {
        return bytes;
    }

    public void setBytes(int bytes)
    {
        this.bytes = bytes;
    }

    public int getCreatedAt()
    {
        return createdAt;
    }

    public void setCreatedAt(int createdAt)
    {
        this.createdAt = createdAt;
    }

    public String getFilename()
    {
        return filename;
    }

    public void setFilename(String filename)
    {
        this.filename = filename;
    }

    public String getObject()
    {
        return object;
    }

    public void setObject(String object)
    {
        this.object = object;
    }

    public String getPurpose()
    {
        return purpose;
    }

    public void setPurpose(String purpose)
    {
        this.purpose = purpose;
    }
}
