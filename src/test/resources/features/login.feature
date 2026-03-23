@ui
Feature: Login en SauceDemo

  Scenario: Login exitoso con credenciales validas
    Given que el usuario abre la pagina de SauceDemo
    When ingresa usuario "standard_user" y contraseña "secret_sauce"
    Then debería ver el inventario de productos


  Scenario: Login fallido con credenciales invalidas
    Given que el usuario abre la pagina de SauceDemo
    When ingresa usuario "locked_out_user" y contraseña "wrong_password"
    Then debería ver un mensaje de error