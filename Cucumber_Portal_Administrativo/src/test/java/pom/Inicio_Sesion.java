package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Random;

public class Inicio_Sesion  extends  BasePage {


    private String TitleHomePage = "Admin Console - Login de usuario";
    private String TitleAdminConsole = "Admin Console - Admin Console";
    private By Usuario    =  By.cssSelector("input[name='username']");
    private By Contrasena =  By.cssSelector("input[name='password']");
    private By click      =  By.cssSelector("input[class='btn btn-success']");
    private String User = "ABERNAL";
    private String Pass = "XaaIZe";
    private   String file = System.getProperty("user.dir") + "/Capturas/IncioSeccion"+ new Random().nextInt() +".png";


    public Inicio_Sesion(WebDriver driver) {
        super(driver);

    }

    public  String TitleHomePage ()
    {
        return TitleHomePage;
    }
    public  String TitleConsole ()
    {
        return TitleAdminConsole ;
    }

    public  void FormularioInicioSesion() throws IOException {
        Input(Usuario,User);
        Input(Contrasena,Pass);
       // takeScreenShot(file);
        Click(click);

    }



}
