package us.abstracta.pages;
import us.abstracta.pages.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.Assert.assertEquals;

public class FactibilityPage extends BasePage {

    private Page page;

    public FactibilityPage(Page page) {
        super(page);
        this.page = page;
    }

    // Método para verificar el título de la página de factibilidad
    public void titleFactibilityPage() {
        page.waitForTimeout(5000);
        assertThat(page).hasTitle(Pattern.compile("Revisa factibilidad y cobertura"));
    }

    // Método para hacer clic en la opción de 600MB para revisar la factibilidad
    public void clickOpcion600MB() {
        page.click("text=Revisar Factibilidad");
    }

    // Método para llenar el formulario de factibilidad con datos
    public void sedespliegayllenaformulario() {
        page.locator("css=#city_in_modal").click();
        page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText("MAIPÚ")).click();

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

    // Método para validar que la aplicación haya procesado los datos ingresados
    public void laAplicacionValidaDatosIngresados() {
        String texto_validando_datos = "xpath=//p[contains(text(),'ESTAMOS VALIDANDO TUS DATOS')]";
        String actualText = page.textContent(texto_validando_datos);
        assertEquals("ESTAMOS VALIDANDO TUS DATOS", actualText);
    }
    public void clickMenuHogar() {
        page.click("text=Hogar");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("Screenshot.png")));
    }
    public void clickSubMenuReviseFactibilidad() {
        page.getByText("Revisa Factibilidad").click();
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("Screenshot2.png")));
    }
}