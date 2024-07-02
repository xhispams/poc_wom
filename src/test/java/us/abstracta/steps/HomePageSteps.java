package us.abstracta.steps;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import us.abstracta.pages.CheckOutPage;
import us.abstracta.pages.FactibilityPage;
import us.abstracta.pages.HomePage;
import us.abstracta.config.DependencyInjector;

public class HomePageSteps {
    private Page page;
    private HomePage homePage;
    private FactibilityPage factibilityPage;
    private CheckOutPage checkOutPage;

    public HomePageSteps() {
        this.page = DependencyInjector.getPage("chromium");  // Cambia "chromium" por el navegador deseado
        this.homePage = new HomePage(page);
        this.factibilityPage = new FactibilityPage(page);
        this.checkOutPage = new CheckOutPage(page);
    }

    @Given("estoy en la página principal de WOM")
    public void estoy_en_la_pagina_principal_de_wom() {
        homePage.navigate();
    }
}