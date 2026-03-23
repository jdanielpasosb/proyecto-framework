package com.example.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class InventoryPage {

    public static final Target PRODUCT_TITLE = Target.the("titulo de productos")
            .located(By.className("title"));
}