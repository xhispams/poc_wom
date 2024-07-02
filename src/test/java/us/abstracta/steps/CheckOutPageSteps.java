package us.abstracta.steps;

import com.microsoft.playwright.Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import us.abstracta.config.DependencyInjector;
import us.abstracta.pages.CheckOutPage;

public class CheckOutPageSteps {
    private CheckOutPage checkOutPage;
    private Page page;

    // Constructor sin argumentos
    public CheckOutPageSteps() {
        this.page = DependencyInjector.getPage("chromium");  // Cambia "chromium" por el navegador deseado
        this.checkOutPage = new CheckOutPage(page);
    }

    @And("si los datos son válidos, procede a llenar formulario de datos personales")
    public void si_los_datos_son_validos_procede_a_llenar_formulario_de_datos_personales() {
        checkOutPage.sipasolavalidacionpasoallenardatospersonales();
    }

    @When("se agenda la instalación de fibra óptica con éxito")
    public void se_agenda_la_instalacion_de_fibra_optica_con_exito() {
        checkOutPage.agendolainstalacion();
    }

    //@And("el usuario llena el formulario con sus datos")
    //public void el_usuario_llena_el_formulario_con_sus_datos() {
    //    checkOutPage.confirmoSolicitud();
    //}

    @Then("confirmo solicitud")
    public void confirmoSolicitud() {
        checkOutPage.confirmoSolicitud();
    }
}