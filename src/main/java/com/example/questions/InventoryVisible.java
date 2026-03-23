package com.example.questions;

import com.example.userinterfaces.InventoryPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class InventoryVisible implements Question<String> {

    public static InventoryVisible displayed() {
        return new InventoryVisible();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(InventoryPage.PRODUCT_TITLE).answeredBy(actor);
    }
}