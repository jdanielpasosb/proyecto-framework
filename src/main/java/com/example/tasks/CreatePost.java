package com.example.tasks;

import com.example.models.PostRequest;
import com.example.utils.Constants;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class CreatePost implements Task {

    private PostRequest request;

    public CreatePost(PostRequest request) {
        this.request = request;
    }

    public static CreatePost withData(PostRequest request) {
        return new CreatePost(request);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        SerenityRest.given()
                .contentType("application/json")
                .log().all()
                .baseUri(Constants.API_URL)
                .body(request)
                .when()
                .post("/posts")
                .then()
                .log().all();
    }
}