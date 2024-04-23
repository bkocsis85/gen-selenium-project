package com.bkocsis.utils.api;

import com.bkocsis.data.User;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class JsonPlaceholderAPI {

    OkHttpClient client = new OkHttpClient();

    public Response getRequest() throws IOException {

        Request request = new Request.Builder()
                .url("https://jsonplaceholder.typicode.com/users")
                .build();

        Call call = client.newCall(request);
        return call.execute();
    }

    public ArrayList<User> getUsers(Response response) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(response.body().string());
        ArrayList<User> users = new ArrayList<>();

        Iterator<JsonNode> elements = rootNode.elements();

        while(elements.hasNext()){
            JsonNode element = elements.next();
            User user = new User();
            user.setName(element.path("name").asText());
            user.setEmail(element.path("email").asText());
            users.add(user);
        }

        return users;
    }
}
