package com.example.tasks;

import com.example.userinterfaces.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Login implements Task {

    private String user;
    private String password;

    public Login(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public static Login withCredentials(String user, String password) {
        return new Login(user, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LoginPage.USERNAME, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(user).into(LoginPage.USERNAME),

                WaitUntil.the(LoginPage.PASSWORD, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(password).into(LoginPage.PASSWORD),

                WaitUntil.the(LoginPage.LOGIN_BUTTON, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(LoginPage.LOGIN_BUTTON)
        );
    }
}