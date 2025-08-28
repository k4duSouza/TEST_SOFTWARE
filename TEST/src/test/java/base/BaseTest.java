package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    private WebDriver driver;

    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com");
        System.out.println("Título: " + driver.getTitle());

        try {
            // Delay de 3 segundos ANTES de clicar no link "Frames"
            Thread.sleep(3000);

            WebElement linkFrames = driver.findElement(By.linkText("Frames"));
            linkFrames.click();

            // Delay de 3 segundos DEPOIS de abrir a página "Frames"
            Thread.sleep(3000);

            // Validação da URL após clicar
            if (driver.getCurrentUrl().contains("/frames")) {
                System.out.println("✅ Smoke Test passou!");
            } else {
                System.out.println("❌ Smoke Test falhou!");
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            // Fecha o navegador ao final
            driver.quit();
        }
    }

    public static void main(String[] args) {
        new BaseTest().setUp();
    }
}
