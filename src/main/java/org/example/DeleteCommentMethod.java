package org.example;

import org.apache.hc.client5.http.classic.methods.HttpDelete;
import org.apache.hc.client5.http.classic.methods.HttpUriRequest;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.HttpResponse;

import java.io.IOException;

public class DeleteCommentMethod {

    public int callAPI() throws IOException{
        HttpUriRequest request = new HttpDelete("https://gorest.co.in/public/v2/comments/147190?access-token=5d034ab1ba63642fd87b6ff1133eb5fbadad18da23c7c44bbe1f857e25b733b7");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
        return httpResponse.getCode();
    }
}
