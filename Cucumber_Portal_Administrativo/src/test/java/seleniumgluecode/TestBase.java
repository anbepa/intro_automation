package seleniumgluecode;

import org.openqa.selenium.chrome.ChromeDriver;

import pom.Clientes.*;
import pom.Funcion_Accesos;
import pom.Funcion_Perfiles;
import pom.Funcion_Usuario;
import pom.Inicio_Sesion;
import pom.TrasladoSaldo.RegistroUnico;
import seleniumgluecode.Test.Test_ModuloTraslados;

public class TestBase {

    protected ChromeDriver driver = Hooks.getDriver() ;
    protected Inicio_Sesion  Inicio_Sesion  = new  Inicio_Sesion(driver);
    protected Funcion_Usuario Funcion_Usuario  = new  Funcion_Usuario(driver);
    protected Funcion_Perfiles Funcion_Perfiles   = new  Funcion_Perfiles(driver);
    protected Funcion_Accesos Funcion_Accesos   = new  Funcion_Accesos(driver);
    protected Cambios_Basicos Cambios_Basicos  = new  Cambios_Basicos(driver);
    protected Datos_Beneficiario Datos_Beneficiario  = new  Datos_Beneficiario(driver);
    protected Gestion_Cuentas Gestion_Cuentas  = new  Gestion_Cuentas(driver);
    protected Migraciones Migraciones  = new  Migraciones(driver);
    protected Otras_Configuraciones Otras_Configuraciones = new  Otras_Configuraciones(driver);
    protected RegistroUnico RegistroUnico = new  RegistroUnico(driver);












}
