package me.vasylkov.openai.utils;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ListedObjects<T>
{
    @JsonProperty("object")
    private String object;
    @JsonProperty("data")
    private List<T> data;
    @JsonProperty("first_id")
    private String firstId;
    @JsonProperty("last_id")
    private String lastId;
    @JsonProperty("has_more")
    private boolean hasMore;

    public ListedObjects(String object, List<T> data, String firstId, String lastId, boolean hasMore)
    {
        this.object = object;
        this.data = data;
        this.firstId = firstId;
        this.lastId = lastId;
        this.hasMore = hasMore;
    }

    public ListedObjects()
    {

    }

    public String getObject()
    {
        return object;
    }

    public void setObject(String object)
    {
        this.object = object;
    }

    public List<T> getData()
    {
        return data;
    }

    public void setData(List<T> data)
    {
        this.data = data;
    }

    public String getFirstId()
    {
        return firstId;
    }

    public void setFirstId(String firstId)
    {
        this.firstId = firstId;
    }

    public String getLastId()
    {
        return lastId;
    }

    public void setLastId(String lastId)
    {
        this.lastId = lastId;
    }

    public boolean isHasMore()
    {
        return hasMore;
    }

    public void setHasMore(boolean hasMore)
    {
        this.hasMore = hasMore;
    }
}
