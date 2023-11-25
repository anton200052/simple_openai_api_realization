package me.vasylkov.openai.apiobjects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tool
{
    @JsonProperty("type")
    private String type;

    // Конструктор с аргументами
    public Tool(String type) {
        this.type = type;
    }

    // Пустой конструктор
    public Tool() {
    }

    // Геттеры и сеттеры
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
