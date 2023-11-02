import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchForBookTest {
    public WebDriver driver;

    @BeforeAll
    public static void setDriver() {
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeEach
    public void setup() {
        driver = new FirefoxDriver();
    }

    @Test
    public void searchForPressman() {
        Actions act = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        String originalWindow = driver.getWindowHandle();
        driver.manage().window().setSize(new Dimension(1680,1025));

        /*
        Por algún motivo, Selenium no puede localizar el botón "Ir al Catálogo" (MoveTargetOutOfBoundsException).
        Intenté varias cosas para solucionarlo, pero parecería que el problema está en la incompatibilidad de versiones
        entre el driver Gecko y Selenium.

        // Ir a um.edu.ar/biblioteca/
        driver.get("https://um.edu.ar/biblioteca/");
        WebElement catalogueLink = driver.findElement(By.xpath("//a[@data-hover=\"Ir al Catálogo\"]"));
        wait.until(ExpectedConditions.visibilityOf(catalogueLink));
        act.click(catalogueLink).perform();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        // Cambiar a la nueva pestaña abierta, una vez cargada
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        */

        // Escribir "Ingeniería del Software [...]" en el buscador y realizar un print por pantalla de encontrarse el libro deseado.
        driver.get("https://biblioteca.um.edu.ar/?_gl=1*1cjptmj*_ga*OTI4MDkwMjEuMTY5Njg1NTQzMg..*_ga_S845M31WNT*MTY5ODcwNzk2OS42LjAuMTY5ODcwNzk3MC4wLjAuMA..*_ga_5HD6DC6SNB*MTY5ODcwNzk2OS43LjAuMTY5ODcwNzk3MC4wLjAuMA..*_ga_90T32KTHPN*MTY5ODcwNzk2OS44LjAuMTY5ODcwNzk2OS4wLjAuMA..&_ga=2.112838151.2021113404.1698697356-92809021.1696855432");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("translControl1")));
        driver.findElement(By.id("translControl1")).sendKeys("Ingeniería del Software Pressman");
        WebElement searchButton = driver.findElement(By.id("searchsubmit"));
        act.moveToElement(searchButton).perform();
        act.click(searchButton).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title_summary_60481")));
        driver.findElement(By.linkText("INGENIERIA DEL SOFTWARE")).click();

        System.out.println("El libro 'Ingeniería del Software' ha sido encontrado en la biblioteca.");
    }

    @AfterEach
    public void quit() {
        driver.quit();
    }
}
