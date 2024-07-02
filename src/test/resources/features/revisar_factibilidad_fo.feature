Feature: Revisar Factibilidad de Fibra Óptica

  Scenario: Usuario revisa si tiene factibilidad de fibra óptica
    Given estoy en la página principal de WOM
    When navego al menú Hogar y selecciono sub menu Revisa factibilidad
    And selecciono la opción de 600 MB
    Then se despliega el formulario de factibilidad de fibra óptica
    And la aplicación valida los datos ingresados
    And si los datos son válidos, procede a llenar formulario de datos personales
    When se agenda la instalación de fibra óptica con éxito
    Then confirmo solicitud