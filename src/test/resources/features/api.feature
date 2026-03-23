@api
Feature: API JSONPlaceholder

  Scenario: Obtener usuario existente
    When se consulta el usuario con id 1
    Then el código de respuesta debe ser 200
    And el nombre del usuario debe ser "Leanne Graham"

  Scenario: Crear post correctamente
    When se crea un post con titulo "test" y contenido "body test"
    Then el código de respuesta debe ser 201
    And el post creado debe coincidir con los datos enviados