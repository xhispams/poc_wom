package us.abstracta.pages;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Paths;
import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.Assert.assertEquals;

public class FactibilityPage extends BasePage {

    public FactibilityPage(Page page) {
        super(page);
    }

    public void titleFactibilityPage() {
        waitForTimeout(5000);
        assertThat(page).hasTitle(Pattern.compile("Revisa factibilidad y cobertura"));
    }

    public void clickOpcion600MB() {
        page.click("text=Revisar Factibilidad");
    }

    public void sedespliegayllenaformulario() {
        // Método para llenar el formulario de factibilidad con datos

        page.locator("css=#city_in_modal").click();
        page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText("MAIPÚ")).click();
        //page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText("MAIPÚ")).click();

        // Ingresar Dirección y seleccionar dirección
        fillInputField("#street_in_modal", "Rafael Riesco Bernales 667");
        page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText("RAFAEL RIESCO BERNALES 667")).click();

        // Ingresar RUT, Email y Teléfono
        fillInputField("#rut_number_in_modal", "12345678-5");
        fillInputField("#email_in_modal", "test_poc_wom@gmail.com");
        fillInputField("#phone_number_in_modal", "912341234");

        // Presionar Botón
        page.click("xpath=//button[@type='button']");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("Screenshot3.png")));

    }
    public void laAplicacionValidaDatosIngresados() {
        String textoValidandoDatos = "xpath=//p[contains(text(),'ESTAMOS VALIDANDO TUS DATOS')]";
        String actualText = getTextContent(textoValidandoDatos);
        assertEquals("ESTAMOS VALIDANDO TUS DATOS", actualText);
    }
    }

