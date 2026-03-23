package com.example.stepdefinitions;

import com.example.questions.InventoryVisible;
import com.example.questions.LoginErrorMessage;
import com.example.tasks.Login;
import com.example.tasks.OpenTheBrowser;
import com.example.tasks.ValidateError;
import com.example.utils.Constants;
import com.example.utils.LoginData;
import io.cucumber.java.en.*;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class LoginStepDefinitions {


    @Given("que el usuario abre la pagina de SauceDemo")
    public void abrirPagina() {
        theActorInTheSpotlight()
                .attemptsTo(OpenTheBrowser.at(Constants.UI_URL));
    }


    @When("ingresa usuario {string} y contraseña {string}")
    public void login(String user, String password) {

        theActorInTheSpotlight().attemptsTo(
                Login.withCredentials(user, password)
        );
    }


    @Then("debería ver el inventario de productos")
    public void validarLogin() {
        theActorInTheSpotlight().should(
                seeThat(InventoryVisible.displayed(), equalTo("Products"))
        );
    }

    @Then("debería ver un mensaje de error")
    public void validarError() {

        theActorInTheSpotlight().should(
                seeThat(
                        LoginErrorMessage.displayed(),
                        containsString("Epic sadface")
                )
        );
    }
}