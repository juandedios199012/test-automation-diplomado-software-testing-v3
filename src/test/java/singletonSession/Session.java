package singletonSession;

import factoryDevices.FactoryDevice;
import io.appium.java_client.AppiumDriver;

public class Session {

    private static Session session = null;
    private AppiumDriver driver;

    private Session() {
        driver = FactoryDevice.make("androidCloud").create();
        //driver.hideKeyboard();
    }

    public static Session getInstance() {
        if (session == null)
            session = new Session();

        return session;
    }

    public void closeApp() {
        driver.quit();
        session = null;
    }

    public AppiumDriver getDriver() {
        return driver;
    }
}
