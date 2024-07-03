package us.abstracta.pages;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitForSelectorState;

import java.nio.file.Paths;
import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.Assert.assertEquals;

public class CheckOutPage {
    private Page page;

    public CheckOutPage(Page page) {this.page = page;}

    public void sipasolavalidacionpasoallenardatospersonales() {
        // Validando Datos para verificar si es el mismo rut y nombre de pagina web
        String texto_validando_datos = "xpath=//span[contains(text(),'Rut: 12.345.678-5')]";
        String actualText = page.textContent(texto_validando_datos);
        assertThat(page).hasTitle(Pattern.compile("WOM | Checkout"));

        // Validar que el texto sea el esperado
        String expectedText = "Rut: 12.345.678-5";  // Reemplaza con el texto esperado
        assertEquals(expectedText, actualText);

        // Paso 1
        // Ingresar Nombres
        String nombres = "css=#firstName";
        page.fill(nombres, "Test POC WOM");

        // Ingresar Apellidos
        String apellidos = "css=#lastName";
        page.fill(apellidos, "WOM POC");

        // Presionar botón
        page.locator("xpath=//button[@type='submit']").click();
    }
    // Paso 2
    public void agendolainstalacion(){

        // Seleccionar Fecha
        page.waitForTimeout(10000);
        ElementHandle primerDiaDisponible = page.querySelector(".datepicker-date:not(.datepicker-disabled)");

        // Seleccionar Hora
        ElementHandle primeraHoraDisponible = page.querySelector(".timepicker-item:not(.timepicker-disabled)");
        // Presionar botón Ir al siguiente paso

        page.locator("xpath=//button[@type='submit']").click();
    }
    public void confirmoSolicitud(){
        //page.locator("xpath=//div[contains(text(),'Finalizar')]");
        //page.locator("css=div.checkoutStepDiv div.divColums:nth-child(3) div.li.toPayInfo:nth-child(1) div.infoDetailCard:nth-child(2) div.li.toPayDetail:nth-child(7) div.confirmDiv.confirmDivLeft div.cardFlexDiv div.flex-container.step-buttons-container button.aws-btn.aws-btn--primary.aws-btn--visible.confirmButton.aws-btn--right span.aws-btn__wrapper span.aws-btn__content span:nth-child(1) > div:nth-child(1)")
        //page.locator("xpath=/html[1]/body[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[5]/div[1]/div[1]/div[3]/div[1]/button[1]/span[1]/span[1]/span[1]/div[1]")
        page.setContent("<div><button>Finalizar </button></div>");
        String cedula = "css=#ci";
        page.fill(cedula, "123123123");
        page.locator("xpath=//span[contains(text(),'Validar')]").click();
        page.locator("xpath=//p[contains(text(),'Validación no fue procesada con éxito')]");
        page.locator("xpath=//div[@class='input-info-module--helpLink--A80yj']").click();
        page.locator("xpath=//p[@class='cardCloseText']").click();
    }


}