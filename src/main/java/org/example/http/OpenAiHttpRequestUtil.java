package org.example.http;

import com.fasterxml.jackson.databind.JsonNode;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.example.json.JsonUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OpenAiHttpRequestUtil
{
    public static JsonNode createPostRequest(String jsonBody, String apiUrl, String apiKey)
    {
        try(CloseableHttpClient client = HttpClients.createDefault())
        {
            HttpPost httpPost = new HttpPost(apiUrl);

            httpPost.setHeader("Content-Type", "application/json");
            httpPost.setHeader("Authorization", "Bearer " + apiKey);

            httpPost.setEntity(new StringEntity(jsonBody));

            HttpResponse response = client.execute(httpPost);

            HttpEntity entity = response.getEntity();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(entity.getContent()));

            String line;
            StringBuilder content = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null)
            {
                content.append(line).append("\n ");
            }

            if (response.getStatusLine().getStatusCode() == 200)
            {
                return JsonUtil.parse(content.toString());
            }

            throw new IOException();
        }
        catch (IOException e)
        {
            System.out.println("Error");;
            return null;
        }
    }
}
