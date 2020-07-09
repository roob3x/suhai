package supporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class web {
    public static WebDriver createFirefox() {
        System.setProperty("webdriver.gecko.driver", "C:\\drivers\\geckodriver.exe");
        WebDriver navegador = new FirefoxDriver();
        navegador.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        navegador.get("https://www.hdi.com.br/hdidigital/");
        navegador.manage().window().maximize();
        return navegador;

    }


    public static WebDriver createChrome(){
        System.setProperty("webdriver.chrome.driver", "/home/robertinho/drivers/chromedriver");
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        navegador.get("http://suhaiseguradoracotacao.com.br/login");
        navegador.manage().window().maximize();
        return navegador;

    }
}
