package us.abstracta.pages;

import com.microsoft.playwright.Page;

public class HomePage extends BasePage {

    private String menuHogar = "text=Hogar";

    public HomePage(Page page) {
        super(page);
    }

    public void navigateToAvailabilityCheck() {
        page.click(menuHogar);
    }

    public void clickSubMenuReviseFactibilidad() {
        page.getByText("Revisa Factibilidad").click();
    }
    public void navigate(){
        page.navigate("https://www.wom.cl/");
    }
}
