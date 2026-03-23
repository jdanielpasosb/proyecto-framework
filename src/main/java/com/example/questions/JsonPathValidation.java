package com.example.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class JsonPathValidation implements Question<String> {

    private String path;

    public JsonPathValidation(String path) {
        this.path = path;
    }

    public static JsonPathValidation field(String path) {
        return new JsonPathValidation(path);
    }

    @Override
    public String answeredBy(Actor actor) {
        return SerenityRest.lastResponse()
                .jsonPath()
                .getString(path);
    }
}