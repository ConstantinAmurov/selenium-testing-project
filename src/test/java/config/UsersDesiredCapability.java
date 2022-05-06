package config;

import org.openqa.selenium.remote.DesiredCapabilities;

public class UsersDesiredCapability {

    DesiredCapabilities desiredCapabilities;

    public UsersDesiredCapability() {
        desiredCapabilities = new DesiredCapabilities();
        this.setDefaultCapabilities();
    }

    public DesiredCapabilities getCapabilities() {
        return this.desiredCapabilities;
    }

    private void setDefaultCapabilities() {
        this.desiredCapabilities.setCapability("build", "first build");
        this.desiredCapabilities.setCapability("name", "Selenium Testing Assignment");
        this.desiredCapabilities.setCapability("platform", "Windows 11");
        this.desiredCapabilities.setCapability("browserName", "Chrome");
        this.desiredCapabilities.setCapability("version", "100.0");
        this.desiredCapabilities.setCapability("selenium_version", "2.52.0");
        this.desiredCapabilities.setCapability("timezone", "UTC+02:00");
        this.desiredCapabilities.setCapability("driver_version", "100.0");
        this.desiredCapabilities.setCapability("network", true); // To enable network logs
        this.desiredCapabilities.setCapability("visual", true); // To enable step by step screenshot
        this.desiredCapabilities.setCapability("video", true); // To enable video recording
        this.desiredCapabilities.setCapability("console", true); // To capture console logs
    }
}