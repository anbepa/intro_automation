package pom.Clientes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.BasePage;

import java.util.ArrayList;
import java.util.List;

public class Cambios_Basicos   extends BasePage {

    private By Select_Tipo_identificacion = By.cssSelector("select[id='bdbDocumentType']>option");
    private By Select_Nuevo_Tipo_identificacion = By.cssSelector("select[id='TipoIdnfc']>option");
    private By Select_Sedes = By.cssSelector("select[id='sedeOld']>option");

    private By Input_Numero_identificacion = By.cssSelector("input[type='text'][id='field']");
    private By Input_Nuevo_Numero_identificacion = By.cssSelector("input[type='text'][id='dni']");
    private By Input_Razon_Social = By.cssSelector("input[type='text'][id='razon']");
    private By Input_Direccion = By.cssSelector("input[type='text'][id='direccionA']");
    private By Input_Email = By.cssSelector("input[type='email'][id='emanil']");

    private By Click_Consultar = By.cssSelector("input[type='submit'][class='btn btn-success btn-block'][value='Consultar']");
    private By Click_Cambiar_Datos = By.cssSelector("button[id='createParam']");
    private String Click_Comfirmar = "document.querySelector(\"button[type='submit'][class='btn btn-success']\").click();";



    private String Lo_SubMenu_DatosCliente = "document.querySelector(\"li[id='441']>a\").click();";

    private By AlertDanger = By.cssSelector("div[class='alert alert-danger alert-dismissible fade show']");
    private By ValicacionExitosaCliente = By.cssSelector("input[id='cedulaClienteDisabled']");


    private By ValidacionEdicion =  By.cssSelector("div[class='alert alert-success alert-dismissible fade show']");

    private ArrayList<String> els = new ArrayList<String> ();


    private String Lo_SubMenu_ConsultaCliente = "document.querySelector(\"li[id='443']>a\").click();";
    private By Input_Fecha_Inicial = By.cssSelector("input[id='fechaInicial']");
    private By Input_Fecha_Final = By.cssSelector("input[id='fechaFinal']");
    private String Click_ComfirmarConsulta = "document.querySelector(\"button[id='createParam']\").click();";


    public boolean SubMenu_Datos_Basicos(String FechaI,String FechaF) throws InterruptedException {
        JavascriptExecutor(Lo_SubMenu_ConsultaCliente);
        Input(Input_Fecha_Inicial,FechaI);
        Input(Input_Fecha_Final,FechaF);
        JavascriptExecutor(Click_ComfirmarConsulta);
        Boolean a = Buscar_Dato_Beneficiario(els,3,3,4);
        // Boolean a = Buscar_Datos_Basico(els);
        return a;
    }



    public void SubMenu_DatosCliente(String Tipo, String Numero) throws InterruptedException {

        JavascriptExecutor(Lo_SubMenu_DatosCliente);
        SelectDropdownList(Select_Tipo_identificacion, Tipo);
        Input(Input_Numero_identificacion, Numero);
        Click(Click_Consultar);


    }



    public String ValidarEdicionExitosaCliente() {
        String Comparar = ObtenerAtributos(ValicacionExitosaCliente, "value");
        return Comparar;
    }



    public String ValidarEdicion()
    {
        String Comparar =  ObtenerTextos(ValidacionEdicion);
        return Comparar;
    }

    public void LlenarFormularioCliente1(String RazonSocial,String Tipo, String Numero) {
        els.add(Numero);
        els.add(RazonSocial);
        Espera(Input_Razon_Social);
        SelectDropdownList(Select_Nuevo_Tipo_identificacion, Tipo);
        Input(Input_Nuevo_Numero_identificacion, Numero);
        Input(Input_Razon_Social, RazonSocial);


    }

    public void LlenarFormularioCliente2( String Direccion, String Email, String Sedes) throws InterruptedException {

         els.add(Direccion);
         //els.add(Email);
         els.add(Sedes);
         Espera(Select_Sedes);
         Input(Input_Direccion, Direccion);
         Input(Input_Email, Email);
         SelectDropdownList(Select_Sedes, Sedes);
         Click(Click_Cambiar_Datos);
         JavascriptExecutor(Click_Comfirmar);
     }




    public Cambios_Basicos(WebDriver driver) {
        super(driver);
    }
}
