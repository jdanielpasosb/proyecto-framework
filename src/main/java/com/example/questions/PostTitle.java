package com.example.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class PostTitle implements Question<String> {

    public static PostTitle value() {
        return new PostTitle();
    }

    @Override
    public String answeredBy(Actor actor) {
        return SerenityRest.lastResponse()
                .jsonPath()
                .getString("title");
    }
}