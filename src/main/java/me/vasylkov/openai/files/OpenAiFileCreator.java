package me.vasylkov.openai.files;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OpenAiFileCreator
{
    @JsonProperty("purpose")
    private String purpose;
    @JsonProperty("filePath")
    private String filePath;

    public OpenAiFileCreator(String purpose, String filePath)
    {
        this.purpose = purpose;
        this.filePath = filePath;
    }

    public OpenAiFileCreator()
    {

    }

    public static OpenAiFileCreatorBuilder builder()
    {
        return new OpenAiFileCreatorBuilder();
    }

    public String getPurpose()
    {
        return purpose;
    }

    public void setPurpose(String purpose)
    {
        this.purpose = purpose;
    }

    public String getFilePath()
    {
        return filePath;
    }

    public void setFilePath(String filePath)
    {
        this.filePath = filePath;
    }

    public static class OpenAiFileCreatorBuilder
    {
        private String purpose;

        private String filePath;

        public OpenAiFileCreator build()
        {
            return new OpenAiFileCreator(purpose, filePath);
        }

        public OpenAiFileCreatorBuilder purpose(String purpose)
        {
            this.purpose = purpose;
            return this;
        }

        public OpenAiFileCreatorBuilder filePath(String filePath)
        {
            this.filePath = filePath;
            return this;
        }
    }
}
