package com.example.tasks;

import com.example.utils.Constants;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class GetUser implements Task {

    private int userId;

    public GetUser(int userId) {
        this.userId = userId;
    }

    public static GetUser withId(int userId) {
        return new GetUser(userId);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        SerenityRest.given()
                .log().all()
                .baseUri(Constants.API_URL)
                .when()
                .get("/users/" + userId)
                .then()
                .log().all();
    }
}