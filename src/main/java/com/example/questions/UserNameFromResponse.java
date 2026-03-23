package com.example.questions;

import com.example.models.UserResponse;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class UserNameFromResponse implements Question<String> {

    public static UserNameFromResponse value() {
        return new UserNameFromResponse();
    }

    @Override
    public String answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(UserResponse.class).getName();
    }
}