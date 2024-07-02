package us.abstracta.steps;

import com.microsoft.playwright.Page;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import us.abstracta.pages.CheckOutPage;
import us.abstracta.pages.FactibilityPage;
import us.abstracta.config.DependencyInjector;
import us.abstracta.pages.HomePage;

public class FactibilityPageSteps {
    private Page page;
    private FactibilityPage factibilityPage;

    public FactibilityPageSteps() {
        this.page = DependencyInjector.getPage("chromium");  // Cambia "chromium" por el navegador deseado
        this.factibilityPage = new FactibilityPage(page);

    }


    @When("navego al menú Hogar y selecciono sub menu Revisa factibilidad")
    public void navego_al_menu_Hogar_y_selecciono_sub_menu_Revisa_factibilidad() {
        factibilityPage.clickMenuHogar();
        factibilityPage.clickSubMenuReviseFactibilidad();
    }

    @When("selecciono la opción de 600 MB")
    public void selecciono_la_opcion_de_600_MB() {
        factibilityPage.clickOpcion600MB();
    }

    @Then("se despliega el formulario de factibilidad de fibra óptica")
    public void se_despliega_el_formulario_de_factibilidad_de_fibra_optica() {
        factibilityPage.sedespliegayllenaformulario();
    }

    @Then("la aplicación valida los datos ingresados")
    public void la_aplicacion_valida_los_datos_ingresados() {
        factibilityPage.laAplicacionValidaDatosIngresados();
    }
}