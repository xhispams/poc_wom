package us.abstracta.config;

import com.microsoft.playwright.Page;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;
import org.picocontainer.behaviors.Caching;

public class DependencyInjector {

    private static final MutablePicoContainer container = new DefaultPicoContainer(new Caching());

    static {
        // Agrega instancias de las páginas de Playwright al contenedor
        container.addComponent("chromiumPage", PlaywrightConfig.createChromiumPage());
        container.addComponent("firefoxPage", PlaywrightConfig.createFirefoxPage());
        container.addComponent("webkitPage", PlaywrightConfig.createWebkitPage());
    }

    public static <T> T getInstance(Class<T> clazz) {
        return container.getComponent(clazz);
    }

    public static Page getPage(String browserName) {
        return (Page) container.getComponent(browserName + "Page");
    }
}
