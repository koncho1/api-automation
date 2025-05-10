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
        GetUsersMethod getUsersMethod = new GetUsersMethod();
        String response = getUsersMethod.callAPI();
        List <ValidationMessage> errors= super.validatePayload(response, "getUsersTemplate");
        Assert.assertTrue(errors.isEmpty());

    }

    @Test
    public void getUser() throws IOException {
        GetUserMethod getUserMethod = new GetUserMethod();
        String response = getUserMethod.callAPI();
        List <ValidationMessage> errors= super.validatePayload(response, "getUserTemplate");
        Assert.assertTrue(errors.isEmpty());
    }

    @Test void postUser() throws IOException {
        PostUserMethod postUserMethod = new PostUserMethod();
        String response = postUserMethod.callAPI();
        List <ValidationMessage> errors= super.validatePayload(response, "postUserTemplate");
        Assert.assertTrue(errors.isEmpty());
    }

    @Test
    public void putUser() throws IOException {
        PutUserMethod putUserMethod = new PutUserMethod();
        String response = putUserMethod.callAPI();
        List <ValidationMessage> errors= super.validatePayload(response, "putUserTemplate");
        Assert.assertTrue(errors.isEmpty());
    }

    @Test
    public void deleteUser() throws IOException {
        DeleteUserMethod deleteUserMethod = new DeleteUserMethod();
        int responseCode = deleteUserMethod.callAPI();
        Assert.assertEquals(responseCode,204);
    }
}
