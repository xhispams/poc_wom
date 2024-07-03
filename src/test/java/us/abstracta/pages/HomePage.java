package us.abstracta.pages;

import com.microsoft.playwright.Page;

public class HomePage extends BasePage {

    private String menuHogar = "text=Hogar";

    public HomePage(Page page) {
        super(page);
    }

    public void clickMenuHogar() {
        clickElement(menuHogar);
    }

    public void clickSubMenuReviseFactibilidad() {
        clickElement("text=Revisa Factibilidad");
    }

    public void navigateToHomePage() {
        navigateTo("https://www.wom.cl/");
    }
}