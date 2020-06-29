package pom.Clientes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.BasePage;

import java.util.ArrayList;

public class Gestion_Cuentas extends BasePage {

    private String Lo_SubMenu_Gestion = "document.querySelector(\"li[id='447']>a\").click();";
   // private By Lo_SubMenu_Gestion = By.cssSelector("li[id='447']>a");
    private By Select_Tipo_identificacion = By.cssSelector("select[id='bdbDocumentType']>option");
    private By Select_Tipo_Cuenta = By.cssSelector("select[id='tipoCuenta1']>option");

    private By Input_Numero_identificacion = By.cssSelector("input[type='text'][id='field']");
    private By Select_Convenios = By.cssSelector("select[id='bdbProduct']>option");
    private By Click_Consultar = By.cssSelector("input[type='submit'][class='btn btn-success btn-block'][value='Consultar']");
    private By Input_Cuenta = By.cssSelector("input[id='nCuentaPrincipal']");
    private By Click_Cambiar_Datos = By.cssSelector("button[id='createParam']");
    private String Click_Comfirmar = "document.querySelector(\"button[type='submit'][class='btn btn-success']\").click();";
    private By ValicacionExitosaBeneficiario = By.cssSelector("input[id='cuentalOld']");
    private String Lo_SubMenu_ConsultaCliente = "document.querySelector(\"li[id='444']>a\").click();";
    private By Input_Fecha_Inicial = By.cssSelector("input[id='fechaInicial']");
    private By Input_Fecha_Final = By.cssSelector("input[id='fechaFinal']");
    private String Click_ComfirmarConsulta = "document.querySelector(\"button[id='createParam']\").click();";
    private ArrayList<String> els = new ArrayList<String> ();






    public boolean SubMenu_Datos_Basicos(String FechaI,String FechaF) throws InterruptedException {
        JavascriptExecutor(Lo_SubMenu_ConsultaCliente);
        Input(Input_Fecha_Inicial,FechaI);
        Input(Input_Fecha_Final,FechaF);
        JavascriptExecutor(Click_ComfirmarConsulta);
        Boolean a = Buscar_Dato_Beneficiario(els,3,3,1);
        // Boolean a = Buscar_Datos_Basico(els);
        return a;
    }




    public void SubMenu_GestioCuentas(String Tipo, String Numero,String Convenio) throws InterruptedException {

        JavascriptExecutor(Lo_SubMenu_Gestion);
        SelectDropdownList(Select_Tipo_identificacion, Tipo);
        Input(Input_Numero_identificacion, Numero);
        SelectDropdownList(Select_Convenios, Convenio);
        Click(Click_Consultar);

    }

    public void Cambiar_Cuentas(String Cuenta, String Tipo) throws InterruptedException
    {
        els.add(Cuenta);
        els.add(Tipo);
        Espera(Input_Cuenta);
        Input(Input_Cuenta,Cuenta);
        Espera(Select_Tipo_Cuenta);
        SelectDropdownList(Select_Tipo_Cuenta,Tipo);
        Click(Click_Cambiar_Datos);
        JavascriptExecutor(Click_Comfirmar);

    }

    public String ValidarEdicionExitosaBeneficiario() {
        String Comparar = ObtenerAtributos(ValicacionExitosaBeneficiario, "value");
        return Comparar;
    }


    public Gestion_Cuentas(WebDriver driver) {
        super(driver);
    }
}
