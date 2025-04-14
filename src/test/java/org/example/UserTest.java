package org.example;

import com.networknt.schema.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.hc.client5.http.ClientProtocolException;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.*;
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.client5.http.impl.classic.BasicHttpClientResponseHandler;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;


public class UserTest extends BaseTests
{
    @Test
    public void getUsers() throws IOException {
        HttpClient client = HttpClients.createDefault();
        HttpUriRequest request=new HttpGet("https://gorest.co.in/public/v2/users");
        String response = client.execute(request, new BasicHttpClientResponseHandler());
        List <ValidationMessage> errors= super.validatePayload(response, "getUsersTemplate");
        Assert.assertTrue(errors.isEmpty());

    }

    @Test
    public void getUser() throws IOException {
        HttpClient client = HttpClients.createDefault();
        HttpUriRequest request = new HttpGet("https://gorest.co.in/public/v2/users/7826549");
        String response= client.execute(request, new BasicHttpClientResponseHandler());
        List <ValidationMessage> errors= super.validatePayload(response, "getUserTemplate");
        Assert.assertTrue(errors.isEmpty());
    }

    @Test void postUser() throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("https://gorest.co.in/public/v2/users?access-token=5d034ab1ba63642fd87b6ff1133eb5fbadad18da23c7c44bbe1f857e25b733b7");
        List<NameValuePair> params = new ArrayList<NameValuePair>(2);
        params.add(new BasicNameValuePair("name", "John Doe"));
        params.add(new BasicNameValuePair("email", RandomStringUtils.random(8,true,false) + "@gmail.com"));
        params.add(new BasicNameValuePair("gender", "male"));
        params.add(new BasicNameValuePair("status", "active"));
        httpPost.setEntity(new UrlEncodedFormEntity(params));
        String response= client.execute(httpPost, new BasicHttpClientResponseHandler());
        List <ValidationMessage> errors= super.validatePayload(response, "postUserTemplate");
        Assert.assertTrue(errors.isEmpty());
    }

    @Test
    public void putUser() throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPut httpPut = new HttpPut("https://gorest.co.in/public/v2/users/7826537?access-token=5d034ab1ba63642fd87b6ff1133eb5fbadad18da23c7c44bbe1f857e25b733b7");
        List<NameValuePair> params = new ArrayList<NameValuePair>(2);
        params.add(new BasicNameValuePair("name", "John Doe"));
        params.add(new BasicNameValuePair("email", RandomStringUtils.random(8,true,false) + "@gmail.com"));
        params.add(new BasicNameValuePair("gender", "male"));
        params.add(new BasicNameValuePair("status", "active"));
        httpPut.setEntity(new UrlEncodedFormEntity(params));
        String response= client.execute(httpPut, new BasicHttpClientResponseHandler());
        List <ValidationMessage> errors= super.validatePayload(response, "putUserTemplate");
        Assert.assertTrue(errors.isEmpty());
    }

    @Test
    public void deleteUser() throws IOException {
        HttpUriRequest request = new HttpDelete("https://gorest.co.in/public/v2/users/7826536?access-token=5d034ab1ba63642fd87b6ff1133eb5fbadad18da23c7c44bbe1f857e25b733b7");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
        Assert.assertEquals(httpResponse.getCode(),204);
    }
}
