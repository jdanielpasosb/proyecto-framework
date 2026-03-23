package com.example.questions;

import com.example.models.PostResponse;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class PostResponseData implements Question<PostResponse> {

    public static PostResponseData value() {
        return new PostResponseData();
    }

    @Override
    public PostResponse answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(PostResponse.class);
    }
}