package com.example.questions;

import com.example.userinterfaces.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class LoginErrorMessage implements Question<String> {

    public static LoginErrorMessage displayed() {
        return new LoginErrorMessage();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(LoginPage.ERROR_MESSAGE)
                .answeredBy(actor);
    }
}