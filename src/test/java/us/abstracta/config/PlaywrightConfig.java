package us.abstracta.config;

import com.microsoft.playwright.*;

public class PlaywrightConfig {

    private static Playwright playwright = Playwright.create();

    public static Page createChromiumPage() {
        Browser chromiumBrowser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
        return chromiumBrowser.newPage();
    }

    public static Page createFirefoxPage() {
        Browser firefoxBrowser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(true));
        return firefoxBrowser.newPage();
    }

    public static Page createWebkitPage() {
        Browser webkitBrowser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(true));
        return webkitBrowser.newPage();
    }
}
