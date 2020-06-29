package seleniumgluecode;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.chrome.ChromeDriver;
import pom.Inicio_Sesion;

public class Hooks  {
    private  static  ChromeDriver driver;
    private  static JavascriptExecutor js =  driver;
    private  static Logger log = Logger.getLogger(Hooks.class);







    @Before("@TrasladoSaldo")
    public void setUp()
    {

        PropertyConfigurator.configure(System.getProperty("user.dir")+"\\Resources\\log.properties");
        System.setProperty("webdriver.chrome.driver","./src/test/resources/chomedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://uat-adminconsole-bdb.novopayment.net/dashboard");
        driver.manage().window().maximize();

    }



    @After()
    public  void tearDown()
    {

        // driver.quit();
        //log.info("Fin Ejecucion");
    }

    public  static  ChromeDriver  getDriver ()

    {
        return  driver;
    }





}
