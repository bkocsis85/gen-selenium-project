package com.bkocsis;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.bkocsis.data.User;
import com.bkocsis.utils.api.JsonPlaceholderAPI;
import okhttp3.Response;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.ArrayList;

public class JsonPlaceHolderTest {

    @Test(description = "Verify json placeholder API GET request")
    public void getUsersTest() throws IOException {

        JsonPlaceholderAPI jsonPlaceHolderAPI = new JsonPlaceholderAPI();
        ArrayList<User> users;

        Response response = jsonPlaceHolderAPI.getRequest();

        assertEquals(response.code(), 200);

        users = jsonPlaceHolderAPI.getUsers(response);

        assertTrue(users.get(0).getEmail().contains("@"), "The first e-mail address does not contain '@'");
    }
}
