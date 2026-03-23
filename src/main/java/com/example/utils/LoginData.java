package com.example.utils;

import java.util.List;
import java.util.Map;

public class LoginData {

    public static List<Map<String, String>> getLoginData() {
        return ExcelReader.getData(
                "src/test/resources/data/login.xlsx",
                "login"
        );
    }
}