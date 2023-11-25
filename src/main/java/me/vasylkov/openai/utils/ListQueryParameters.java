package me.vasylkov.openai.utils;

public class ListQueryParameters
{

    private int limit;
    private String order;
    private String after;
    private String before;

    public ListQueryParameters(int limit, String order, String after, String before)
    {
        this.limit = limit;
        this.order = order;
        this.after = after;
        this.before = before;
    }

    public ListQueryParameters()
    {

    }
    public static ListQueryParametersBuilder builder()
    {
        return new ListQueryParametersBuilder();
    }

    public int getLimit()
    {
        return limit;
    }

    public void setLimit(int limit)
    {
        this.limit = limit;
    }

    public String getOrder()
    {
        return order;
    }

    public void setOrder(String order)
    {
        this.order = order;
    }

    public String getAfter()
    {
        return after;
    }

    public void setAfter(String after)
    {
        this.after = after;
    }

    public String getBefore()
    {
        return before;
    }

    public void setBefore(String before)
    {
        this.before = before;
    }

    public static class ListQueryParametersBuilder
    {
        private int limit;
        private String order;
        private String after;
        private String before;

        public ListQueryParametersBuilder limit(int limit)
        {
            this.limit = limit;
            return this;
        }

        public ListQueryParametersBuilder order(String order)
        {
            this.order = order;
            return this;
        }

        public ListQueryParametersBuilder after(String after)
        {
            this.after = after;
            return this;
        }

        public ListQueryParametersBuilder before(String before)
        {
            this.before = before;
            return this;
        }

        public ListQueryParameters build()
        {
            return new ListQueryParameters(limit, order, after, before);
        }
    }
}
