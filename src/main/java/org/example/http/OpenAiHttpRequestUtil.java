package org.example.http;

import com.fasterxml.jackson.databind.JsonNode;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.example.json.JsonUtil;
import org.example.openai.apiobjects.OpenAIServiceType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OpenAiHttpRequestUtil
{
    public static JsonNode sendHttpRequest(String jsonBody, String apiUrl, String apiKey, OpenAIServiceType serviceType, HttpRequestType httpRequestType)
    {
        try (CloseableHttpClient client = HttpClients.createDefault())
        {
            HttpRequestBase httpRequest;
            if (httpRequestType.equals(HttpRequestType.GET))
            {
                httpRequest = new HttpGet(apiUrl);
            }
            else if (httpRequestType.equals(HttpRequestType.POST))
            {
                httpRequest = new HttpPost(apiUrl);
                ((HttpPost) httpRequest).setEntity(new StringEntity(jsonBody));
            }
            else
            {
                throw new IllegalArgumentException("Unsupported HTTP method: " + httpRequestType);
            }

            httpRequest.setHeader("Content-Type", "application/json");
            httpRequest.setHeader("Authorization", "Bearer " + apiKey);
            if (serviceType.equals(OpenAIServiceType.ASSISTANTS))
            {
                httpRequest.setHeader("OpenAI-Beta", "assistants=v1");
            }

            // For debug:
            System.out.println("Request:\n");
            System.out.println(jsonBody);
            System.out.println("\n");
            System.out.println("Response:\n");


            HttpResponse response = client.execute(httpRequest);
            HttpEntity entity = response.getEntity();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(entity.getContent()));
            String line;
            StringBuilder content = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null)
            {
                content.append(line).append("\n ");
            }

            return JsonUtil.parse(content.toString());

        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static JsonNode sendPostRequest(String jsonBody, String apiUrl, String apiKey, OpenAIServiceType serviceType)
    {
        return sendHttpRequest(jsonBody, apiUrl, apiKey, serviceType, HttpRequestType.POST);
    }

    public static JsonNode sendGetRequest(String apiUrl, String apiKey, OpenAIServiceType serviceType)
    {
        return sendHttpRequest(null, apiUrl, apiKey, serviceType, HttpRequestType.GET);
    }
}
