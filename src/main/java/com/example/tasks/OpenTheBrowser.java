package com.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class OpenTheBrowser implements Task {

    private String url;

    public OpenTheBrowser(String url) {
        this.url = url;
    }

    public static OpenTheBrowser at(String url) {
        return new OpenTheBrowser(url);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(url));
    }
}