package com.example.tasks;

import com.example.userinterfaces.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidateError implements Task {

    public static ValidateError messageIsVisible() {
        return new ValidateError();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LoginPage.ERROR_MESSAGE, isVisible())
                        .forNoMoreThan(10).seconds()
        );
    }
}