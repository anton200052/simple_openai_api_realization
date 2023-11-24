package org.example.openai.assistanst;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.openai.apiobjects.Tool;

import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AssistantsManager
{
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

    public AssistantsManager(String instructions, String name, List<Tool> tools, String model)
    {
        this.instructions = instructions;
        this.name = name;
        this.tools = tools;
        this.model = model;
    }

    public AssistantsManager()
    {
    }

    public static AssistantsManagerBuilder builder()
    {
        return new AssistantsManagerBuilder();
    }

    public String getInstructions()
    {
        return instructions;
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

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public static class AssistantsManagerBuilder
    {
        private String instructions;
        private String name;
        private List<Tool> tools;
        private String model;

        public AssistantsManagerBuilder instructions(String instructions)
        {
            this.instructions = instructions;
            return this;
        }

        public AssistantsManagerBuilder name(String name)
        {
            this.name = name;
            return this;
        }

        public AssistantsManagerBuilder tools(List<Tool> tools)
        {
            this.tools = tools;
            return this;
        }

        public AssistantsManagerBuilder model(String model)
        {
            this.model = model;
            return this;
        }

        public AssistantsManager build()
        {
            return new AssistantsManager(instructions, name, tools, model);
        }
    }
}
