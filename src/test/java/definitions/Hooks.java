package definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Hooks {
    protected static WebDriver driver;
    public final static int TIMEOUT = 5;
    private static final String ALLURE_RESULTS_DIR = "allure-results";
    @Before
    public void setUp() {
        createAllureEnvironment();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));

    }

    @After
    public void tearDown(Scenario scenario) {
        try {
            String screenshotName = scenario.getName();
            if (scenario.isFailed()) {
                TakesScreenshot ts = (TakesScreenshot) driver;
                byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "img/png", screenshotName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }

    private void createAllureEnvironment() {
        try {
            File directory = new File(ALLURE_RESULTS_DIR);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            File envFile = new File(ALLURE_RESULTS_DIR + "/environment.properties");
            FileWriter writer = new FileWriter(envFile);

            writer.write("Browser=Chrome\n");
            writer.write("Browser.Version=" + "Chrome" + "\n");
            writer.write("OS=" + System.getProperty("os.name") + "\n");
            writer.write("OS.Version=" + System.getProperty("os.version") + "\n");
            writer.write("Test.Environment=QA\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}