package org.example;

import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpUriRequest;
import org.apache.hc.client5.http.impl.classic.BasicHttpClientResponseHandler;
import org.apache.hc.client5.http.impl.classic.HttpClients;

import java.io.IOException;

public class GetUsersMethod {

    public String callAPI() throws IOException {
        HttpClient client = HttpClients.createDefault();
        HttpUriRequest request=new HttpGet("https://gorest.co.in/public/v2/users");
        String response = client.execute(request, new BasicHttpClientResponseHandler());
        return response;
    }
}
