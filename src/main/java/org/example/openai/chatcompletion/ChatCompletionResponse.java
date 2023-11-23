package org.example.openai.chatcompletion;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.openai.apiobjects.Choice;
import org.example.openai.apiobjects.Usage;

import java.util.List;

public class ChatCompletionResponse
{
    @JsonProperty("id")
    private String id;
    @JsonProperty("object")
    private String object;
    @JsonProperty("created")
    private long created;
    @JsonProperty("model")
    private String model;
    @JsonProperty("system_fingerprint")
    private String systemFingerprint;
    @JsonProperty("choices")
    private List<Choice> choices;
    @JsonProperty("usage")
    private Usage usage;

    public ChatCompletionResponse()
    {

    }

    public ChatCompletionResponse(String id, String object, long created, String model, String systemFingerprint, List<Choice> choices, Usage usage)
    {
        this.id = id;
        this.object = object;
        this.created = created;
        this.model = model;
        this.systemFingerprint = systemFingerprint;
        this.choices = choices;
        this.usage = usage;
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

    public long getCreated()
    {
        return created;
    }

    public void setCreated(long created)
    {
        this.created = created;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public String getSystemFingerprint()
    {
        return systemFingerprint;
    }

    public void setSystemFingerprint(String systemFingerprint)
    {
        this.systemFingerprint = systemFingerprint;
    }

    public List<Choice> getChoices()
    {
        return choices;
    }

    public void setChoices(List<Choice> choices)
    {
        this.choices = choices;
    }

    public Usage getUsage()
    {
        return usage;
    }

    public void setUsage(Usage usage)
    {
        this.usage = usage;
    }
}
