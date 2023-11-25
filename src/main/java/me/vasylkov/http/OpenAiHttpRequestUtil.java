package me.vasylkov.http;

import com.fasterxml.jackson.databind.JsonNode;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import me.vasylkov.json.JsonUtil;
import me.vasylkov.openai.files.OpenAiFileCreator;
import me.vasylkov.openai.utils.OpenAIServiceType;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class OpenAiHttpRequestUtil
{
    public static JsonNode sendHttpRequest(String jsonBody, String apiUrl, String apiKey, OpenAIServiceType serviceType, HttpRequestType httpRequestType, OpenAiFileCreator fileCreator)
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
                if (fileCreator != null)
                {
                    String filePath = fileCreator.getFilePath();
                    String purpose = fileCreator.getPurpose();
                    MultipartEntityBuilder builder = MultipartEntityBuilder.create();
                    builder.addTextBody("purpose", purpose, ContentType.TEXT_PLAIN);

                    File file = new File(filePath);
                    builder.addPart("file", new FileBody(file));
                    HttpEntity multipart = builder.build();
                    ((HttpPost) httpRequest).setEntity(multipart);
                }
                else
                {
                    ((HttpPost) httpRequest).setEntity(new StringEntity(jsonBody));
                }
            }
            else if (httpRequestType.equals(HttpRequestType.DELETE))
            {
                httpRequest = new HttpDelete(apiUrl);
            }
            else
            {
                throw new IllegalArgumentException("Unsupported HTTP method: " + httpRequestType);
            }

            httpRequest.setHeader("Authorization", "Bearer " + apiKey);

            if (!serviceType.equals(OpenAIServiceType.FILE))
            {
                httpRequest.setHeader("Content-Type", "application/json");
            }

            if (serviceType.equals(OpenAIServiceType.ASSISTANT))
            {
                httpRequest.setHeader("OpenAI-Beta", "assistants=v1");
            }

            // For debug:
            System.out.println("ApiUrl\n");
            System.out.println(apiUrl + "\n");
            System.out.println("Request:\n");
            System.out.println(jsonBody + "\n");
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
        return sendHttpRequest(jsonBody, apiUrl, apiKey, serviceType, HttpRequestType.POST, null);
    }

    public static JsonNode sendFilePostRequest(String jsonBody, String apiUrl, String apiKey, OpenAIServiceType serviceType, OpenAiFileCreator fileCreator)
    {
        return sendHttpRequest(jsonBody, apiUrl, apiKey, serviceType, HttpRequestType.POST, fileCreator);
    }

    public static JsonNode sendGetRequest(String apiUrl, String apiKey, OpenAIServiceType serviceType)
    {
        return sendHttpRequest(null, apiUrl, apiKey, serviceType, HttpRequestType.GET,  null);
    }

    public static JsonNode sendDeleteRequest(String apiUrl, String apiKey, OpenAIServiceType serviceType)
    {
        return sendHttpRequest(null, apiUrl, apiKey, serviceType, HttpRequestType.DELETE, null);
    }
}
