package me.vasylkov.openai.assistants;

import com.fasterxml.jackson.annotation.JsonProperty;
import me.vasylkov.openai.apiobjects.Tool;

import java.util.List;
import java.util.Map;

public class Assistant
{
    @JsonProperty("id")
    private String id;
    @JsonProperty("object")
    private String object;
    @JsonProperty("created_at")
    private int createdAt;
    @JsonProperty("instructions")
    private String instructions;
    @JsonProperty("name")
    private String name;
    @JsonProperty("tools")
    private List<Tool> tools;
    @JsonProperty("model")
    private String model;
    @JsonProperty("description")
    private String description;
    @JsonProperty("file_ids")
    private List<String> fileIds;
    @JsonProperty("metadata")
    private Map<String, String> metadata;

    public Assistant(String id, String object, int createdAt, String instructions, String name, List<Tool> tools, String model, String description, List<String> fileIds, Map<String, String> metadata)
    {
        this.id = id;
        this.object = object;
        this.createdAt = createdAt;
        this.instructions = instructions;
        this.name = name;
        this.tools = tools;
        this.model = model;
        this.description = description;
        this.fileIds = fileIds;
        this.metadata = metadata;
    }

    @Override
    public String toString()
    {
        return "Assistant{" + "id='" + id + '\'' + ", object='" + object + '\'' + ", createdAt=" + createdAt + ", instructions='" + instructions + '\'' + ", name='" + name + '\'' + ", tools=" + tools + ", model='" + model + '\'' + ", description='" + description + '\'' + ", fileIds=" + fileIds + ", metadata=" + metadata + '}';
    }

    public Assistant()
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

    public int getCreatedAt()
    {
        return createdAt;
    }

    public void setCreatedAt(int createdAt)
    {
        this.createdAt = createdAt;
    }

    public String getInstructions()
    {
        return instructions;
    }

    public void setInstructions(String instructions)
    {
        this.instructions = instructions;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<Tool> getTools()
    {
        return tools;
    }

    public void setTools(List<Tool> tools)
    {
        this.tools = tools;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public List<String> getFileIds()
    {
        return fileIds;
    }

    public void setFileIds(List<String> fileIds)
    {
        this.fileIds = fileIds;
    }

    public Map<String, String> getMetadata()
    {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata)
    {
        this.metadata = metadata;
    }
}
