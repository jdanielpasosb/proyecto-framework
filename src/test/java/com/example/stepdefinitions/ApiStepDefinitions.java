package com.example.stepdefinitions;

import com.example.models.PostRequest;
import com.example.questions.PostTitle;
import com.example.questions.ResponseCode;
import com.example.questions.UserNameFromResponse;
import com.example.tasks.CreatePost;
import com.example.tasks.GetUser;
import io.cucumber.java.en.*;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

public class ApiStepDefinitions {

    private PostRequest request;

    @When("se consulta el usuario con id {int}")
    public void getUser(int id) {
        theActorInTheSpotlight().attemptsTo(GetUser.withId(id));
    }

    @When("se crea un post con titulo {string} y contenido {string}")
    public void createPost(String title, String body) {

        request = new PostRequest(title, body, 1);

        theActorInTheSpotlight().attemptsTo(
                CreatePost.withData(request)
        );
    }

    @Then("el código de respuesta debe ser {int}")
    public void validateStatus(int status) {
        theActorInTheSpotlight().should(
                seeThat(ResponseCode.was(), equalTo(status))
        );
    }

    @Then("el nombre del usuario debe ser {string}")
    public void validateUserName(String name) {
        theActorInTheSpotlight().should(
                seeThat(UserNameFromResponse.value(), equalTo(name))
        );
    }

    @Then("el post creado debe coincidir con los datos enviados")
    public void validatePost() {
        theActorInTheSpotlight().should(
                seeThat(PostTitle.value(), equalTo(request.getTitle()))
        );
    }
}