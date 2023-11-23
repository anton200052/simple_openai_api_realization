package org.example.openai.assistanst;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.openai.apiobjects.Tool;

import java.util.List;

public class AssistantsCreator
{
    @JsonProperty("instructions")
    private String instructions;
    @JsonProperty("name")
    private String name;
    @JsonProperty("tools")
    private List<Tool> tools;
    @JsonProperty("model")
    private String model;

    public AssistantsCreator(String instructions, String name, List<Tool> tools, String model)
    {
        this.instructions = instructions;
        this.name = name;
        this.tools = tools;
        this.model = model;
    }

    public AssistantsCreator()
    {
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

    // Внутренний статический класс Builder
    public static class AssistantsCreatorBuilder
    {
        private String instructions;
        private String name;
        private List<Tool> tools;
        private String model;

        public AssistantsCreatorBuilder instructions(String instructions)
        {
            this.instructions = instructions;
            return this;
        }

        public AssistantsCreatorBuilder name(String name)
        {
            this.name = name;
            return this;
        }

        public AssistantsCreatorBuilder tools(List<Tool> tools)
        {
            this.tools = tools;
            return this;
        }

        public AssistantsCreatorBuilder model(String model)
        {
            this.model = model;
            return this;
        }

        public AssistantsCreator build()
        {
            return new AssistantsCreator(instructions, name, tools, model);
        }
    }
}
