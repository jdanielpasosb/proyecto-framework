package com.example.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.actions.Enter;

public class EnterText implements Interaction {

    private String text;
    private Target target;

    public EnterText(String text, Target target) {
        this.text = text;
        this.target = target;
    }

    public static EnterText into(Target target, String text) {
        return new EnterText(text, target);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(text).into(target));
    }
}