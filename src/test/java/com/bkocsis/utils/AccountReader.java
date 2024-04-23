package com.bkocsis.utils;

import com.bkocsis.data.Account;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;


public class AccountReader {

    String filePath;

    public AccountReader() {
        this.filePath = "src/test/resources/credentials.json";
    }

    public Account readAccountFromFile() {

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.readValue(new File(filePath), Account.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
