package org.example;


import com.networknt.schema.ValidationMessage;
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

public class CommentsTest extends BaseTests {
    @Test
    public void getComments() throws IOException {
        GetCommentsMethod getCommentsMethod = new GetCommentsMethod();
        String response = getCommentsMethod.callAPI();
        List <ValidationMessage> errors= super.validatePayload(response, "getCommentsTemplate");
        Assert.assertTrue(errors.isEmpty());
    }

    @Test
    public void getComment() throws IOException{
        GetCommentMethod getCommentMethod = new GetCommentMethod();
        String response = getCommentMethod.callAPI();
        List <ValidationMessage> errors= super.validatePayload(response, "getCommentTemplate");
        Assert.assertTrue(errors.isEmpty());
    }

    @Test
    public void postComment() throws IOException {
        PostCommentMethod postCommentMethod = new PostCommentMethod();
        String response = postCommentMethod.callAPI();
        List <ValidationMessage> errors= super.validatePayload(response, "postCommentTemplate");
        Assert.assertTrue(errors.isEmpty());
    }

    @Test
    public void putComment() throws IOException {
        PutCommentMethod putCommentMethod = new PutCommentMethod();
        String response = putCommentMethod.callAPI();
        List <ValidationMessage> errors= super.validatePayload(response, "putCommentTemplate");
        Assert.assertTrue(errors.isEmpty());
    }

    @Test
    public void deleteComment() throws IOException {
        DeleteCommentMethod deleteCommentMethod = new DeleteCommentMethod();
        int responseCode = deleteCommentMethod.callAPI();
        Assert.assertEquals(responseCode,204);
    }
}
