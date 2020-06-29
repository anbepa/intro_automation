package pom.Clientes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.BasePage;

import java.util.ArrayList;

public class Datos_Beneficiario extends BasePage {

    private By Select_Nuevo_Tipo_identificacion_Beneficiario = By.cssSelector("select[id='TipoId']>option");
    private By Input_Nuevo_Numero_identificacion = By.cssSelector("input[type='text'][id='dni']");
    private By Input_Direccion = By.cssSelector("input[type='text'][id='direccionA']");
    private String Lo_SubMenu_DatosBeneficiario = "document.querySelector(\"li[id='442']>a\").click();";
    private By Select_Tipo_identificacion = By.cssSelector("select[id='bdbDocumentType']>option");
    private By Input_Numero_identificacion = By.cssSelector("input[type='text'][id='field']");
    private By Click_Consultar = By.cssSelector("input[type='submit'][class='btn btn-success btn-block'][value='Consultar']");
    private By ValicacionExitosaBeneficiario = By.cssSelector("input[id='cedulaBeneficiaroDisabled']");
    private By Click_Cambiar_Datos = By.cssSelector("button[id='createParam']");
    private String Click_Comfirmar = "document.querySelector(\"button[type='submit'][class='btn btn-success']\").click();";
    private ArrayList<String> els = new ArrayList<String> ();
    private String Lo_SubMenu_ConsultaCliente = "document.querySelector(\"li[id='443']>a\").click();";
    private By Input_Fecha_Inicial = By.cssSelector("input[id='fechaInicial']");
    private By Input_Fecha_Final = By.cssSelector("input[id='fechaFinal']");
    private String Click_ComfirmarConsulta = "document.querySelector(\"button[id='createParam']\").click();";
    private By Click_Comfirmar1 = By.cssSelector("button[type='submit'][class='btn btn-success']");




    public boolean Buscar_Dato_Beneficiario(String FechaI,String FechaF) throws InterruptedException {
        JavascriptExecutor(Lo_SubMenu_ConsultaCliente);
        Input(Input_Fecha_Inicial,FechaI);
        Input(Input_Fecha_Final,FechaF);
        JavascriptExecutor(Click_ComfirmarConsulta);
        Boolean a = Buscar_Dato_Beneficiario(els,3,8,6);
        return a;
    }



    public void LlenarFormularioBeneficiario( String Tipo, String Numero, String Celular) throws InterruptedException
    {

        els.add(Numero);
        els.add(Celular);
        Espera(Input_Direccion);
        SelectDropdownList(Select_Nuevo_Tipo_identificacion_Beneficiario,Tipo);
        Input(Input_Nuevo_Numero_identificacion,Numero);
        Input(Input_Direccion,Celular);
        Click(Click_Cambiar_Datos);
       // JavascriptExecutor(Click_Comfirmar);
        Espera(Click_Comfirmar1);
        Click(Click_Comfirmar1);
    }


    public void SubMenu_DatosBeneficiario(String Tipo, String Numero) throws InterruptedException {
        JavascriptExecutor(Lo_SubMenu_DatosBeneficiario);
        SelectDropdownList(Select_Tipo_identificacion, Tipo);
        Input(Input_Numero_identificacion, Numero);
        Click(Click_Consultar);

    }

    public String ValidarEdicionExitosaBeneficiario() {
        String Comparar = ObtenerAtributos(ValicacionExitosaBeneficiario, "value");
        System.out.print(Comparar);
        return Comparar;
    }


    public Datos_Beneficiario(WebDriver driver) {
        super(driver);
    }
}
