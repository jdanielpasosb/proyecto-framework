package com.example.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ResponseBody implements Question<String> {

    public static ResponseBody content() {
        return new ResponseBody();
    }

    @Override
    public String answeredBy(Actor actor) {
        return SerenityRest.lastResponse().getBody().asString();
    }
}