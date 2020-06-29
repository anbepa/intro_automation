package pom.Clientes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.BasePage;

import java.util.ArrayList;

public class Migraciones extends BasePage {


    private String Lo_SubMenu_UnidadNegocio = "document.querySelector(\"li[id='448']>a\").click();";
    private String Lo_SubMenu_Convenio = "document.querySelector(\"li[id='449']>a\").click();";


    private By Select_Tipo_identificacion = By.cssSelector("select[id='bdbDocumentType']>option");
    private By Input_Numero_identificacion = By.cssSelector("input[type='text'][id='field']");
    private By Input_Unidad_Negocio = By.cssSelector("input[type='text'][id='codigo']");

    private By Click_Consultar = By.cssSelector("input[type='submit'][class='btn btn-success btn-block'][value='Consultar']");
    private By Select_Numero_Cuenta = By.cssSelector("select[id='cuentaChange']>option");
    private By Select_Convenio_Actual = By.cssSelector("select[id='valorCActual']>option");
    private By Select_Convenio_Nuevo = By.cssSelector("select[id='valorCNuevo']>option");


    private By Click_Cambiar_Datos = By.cssSelector("button[id='createParam']");
    private String Click_Comfirmar = "document.querySelector(\"button[type='submit'][class='btn btn-success']\").click();";

    private String Lo_SubMenu_ConsultaCliente = "document.querySelector(\"li[id='445']>a\").click();";
    private By Input_Fecha_Inicial = By.cssSelector("input[id='fechaInicial']");
    private By Input_Fecha_Final = By.cssSelector("input[id='fechaFinal']");
    private String Click_ComfirmarConsulta = "document.querySelector(\"button[id='createParam']\").click();";
    private ArrayList<String> els = new ArrayList<String> ();
    private By Select_Consulta_Migracion = By.cssSelector("select[id='maestroClientesTebca']>option[value='162']");
    private By Select_Consulta_Migraciones = By.cssSelector("select[id='maestroClientesTebca']>option");


    public boolean Consultas(String Empresa, String FechaI,String FechaF) throws InterruptedException {
        JavascriptExecutor(Lo_SubMenu_ConsultaCliente);
        //Click(Select_Consulta_Migracion);
        SelectDropdownList(Select_Consulta_Migraciones, Empresa);
        Input(Input_Fecha_Inicial,FechaI);
        Input(Input_Fecha_Final,FechaF);
        JavascriptExecutor(Click_ComfirmarConsulta);
        Boolean a = Buscar_Dato_Beneficiario(els,2,6,1);
        // Boolean a = Buscar_Datos_Basico(els);
        return a;
    }


    public void SubMenu_UnidadNegocio(String Tipo, String Numero) throws InterruptedException {
        JavascriptExecutor(Lo_SubMenu_UnidadNegocio);
        SelectDropdownList(Select_Tipo_identificacion, Tipo);
        Input(Input_Numero_identificacion, Numero);
        Click(Click_Consultar);

    }

    public void SubMenu_Convenio(String Tipo, String Numero) throws InterruptedException {
        JavascriptExecutor(Lo_SubMenu_Convenio);
        SelectDropdownList(Select_Tipo_identificacion, Tipo);
        Input(Input_Numero_identificacion, Numero);
        Click(Click_Consultar);

    }


    public void FormularioUnidad(String NumeroCuenta, String Unidad) throws InterruptedException {
        els.add(Unidad);
        SelectDropdownList(Select_Numero_Cuenta, NumeroCuenta);
        Input(Input_Unidad_Negocio, Unidad);
        JavascriptExecutor(Click_Comfirmar);
    }

    public void FormularioConvenio(String ConvenoA, String ConvinoN) throws InterruptedException {

        Thread.sleep(1000);
        SelectDropdownList(Select_Convenio_Actual, ConvenoA);
        Thread.sleep(1000);
        SelectDropdownList(Select_Convenio_Nuevo,ConvinoN);
        JavascriptExecutor(Click_Comfirmar);
    }




    public Migraciones(WebDriver driver) {
        super(driver);
    }
}
