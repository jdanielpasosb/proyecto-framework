package com.example.stepdefinitions;

import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        OnStage.setTheStage(Cast.ofStandardActors());

        OnStage.theActorCalled("Usuario")
                .can(BrowseTheWeb.with(new ChromeDriver()));
    }
}