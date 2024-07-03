package us.abstracta.steps;

import com.microsoft.playwright.Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import us.abstracta.config.DependencyInjector;
import us.abstracta.pages.HomePage;

public class HomePageSteps {
    private Page page;
    private HomePage homePage;

    public HomePageSteps() {
        this.page = DependencyInjector.getPage("chromium");
        this.homePage = new HomePage(page);
    }

    @Given("estoy en la página principal de WOM")
    public void estoy_en_la_pagina_principal_de_WOM() {
        homePage.navigateToHomePage();
    }

    @When("navego al menú Hogar y selecciono sub menu Revisa factibilidad")
    public void navego_al_menu_Hogar_y_selecciono_sub_menu_Revisa_factibilidad() {
        homePage.clickMenuHogar();
        homePage.clickSubMenuReviseFactibilidad();
    }
}