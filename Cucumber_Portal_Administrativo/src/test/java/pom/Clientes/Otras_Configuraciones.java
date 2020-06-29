package pom.Clientes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.BasePage;

import java.util.ArrayList;

public class Otras_Configuraciones extends BasePage {

    private By Select_Empresa  =  By.cssSelector("select[id='customerId']>option");
    private By Select_Convenio = By.cssSelector("select[id='productId']>option");
    private By Select_Configuracion   =  By.cssSelector("select[id='tipoDispersionId']>option");
    private By Select_Pgp   =  By.cssSelector("select[id='pgp']>option");
    private By Select_Reexpedicion   =  By.cssSelector("select[id='reexpedicion']>option");
    private By Select_Sede   =  By.cssSelector("select[id='sedeId']>option");
    private By Select_Custodio   =  By.cssSelector("select[id='custodioLista']>option");
    private By Select_Identificacion   =  By.cssSelector("select[id='documentTypeId']>option");
    private By InputIdentificacion  =  By.cssSelector("input[id='documentNumber']");
    private By InputnCustodio  =  By.cssSelector("input[id='fullName']");
    private By InputDireccion =  By.cssSelector("input[id='address']");
    private By Select_Departamento   =  By.cssSelector("select[id='departamentoId']>option");
    private By Select_Ciudad  =  By.cssSelector("select[id='cityId']>option");
    private By InputTelefono  =  By.cssSelector("input[id='celPhone']");
    private String Click_Configuraciones = "document.querySelector(\"li[id='541']>a\").click();";
    private String Click_Comfirmar = "document.querySelector(\"button[id='createParam']\").click();";
    private String Lo_SubMenu_ConsultaCliente = "document.querySelector(\"li[id='446']>a\").click();";
    private By Input_Fecha_Inicial = By.cssSelector("input[id='fechaInicial']");
    private By Input_Fecha_Final = By.cssSelector("input[id='fechaFinal']");
    private String Click_ComfirmarConsulta = "document.querySelector(\"button[id='createParam']\").click();";
    private ArrayList<String> els = new ArrayList<String> ();


    public boolean Consultas(String Empresa, String FechaI,String FechaF) throws InterruptedException {
        JavascriptExecutor(Lo_SubMenu_ConsultaCliente);
        Input(Input_Fecha_Inicial,FechaI);
        Input(Input_Fecha_Final,FechaF);
        JavascriptExecutor(Click_ComfirmarConsulta);
        Boolean a = Buscar_Dato_Beneficiario(els,2,6,1);
        return a;
    }

    public void Formulario_Configuracion_Convenio(String Convenio, String Dispersion) throws InterruptedException {

        //Espera(Select_Configuracion);
        els.add(Dispersion);
        SelectDropdownList(Select_Convenio, Convenio);
        SelectDropdownList(Select_Configuracion, Dispersion);


    }

    public void Formulario_Configuracion_Convenio_(String Pgp, String Reexpedicion) throws InterruptedException {


        els.add(Pgp);
        els.add(Reexpedicion);
        SelectDropdownList(Select_Pgp,Pgp);
        SelectDropdownList(Select_Reexpedicion,Reexpedicion);
        JavascriptExecutor(Click_Comfirmar);
    }

    public void SeleccionarEmpresa(String Empresa) throws InterruptedException
    {
        JavascriptExecutor(Click_Configuraciones);
        SelectDropdownList(Select_Empresa, Empresa);
    }

    public void Formulario_Datos_Custodio(String Sede, String Custodio) throws InterruptedException
    {
        SelectDropdownList(Select_Sede,Sede);
        Thread.sleep(1000);
        Espera(Select_Custodio);
        SelectDropdownList(Select_Custodio,Custodio);

    }

    public void Formulario_Datos_Custodio_(String Tipo, String Identificacion,String Custodio, String Direccion, String Departamento,String Ciudad , String Telefono) throws InterruptedException
    {
        SelectDropdownList(Select_Identificacion,Tipo);
        Input(InputIdentificacion,Identificacion);
        Input(InputnCustodio,Custodio);
        Input(InputDireccion,Direccion);
        SelectDropdownList(Select_Departamento,Departamento);
        SelectDropdownList(Select_Ciudad,Ciudad);
        Input(InputTelefono,Telefono);
        JavascriptExecutor(Click_Comfirmar);

    }







    public Otras_Configuraciones(WebDriver driver) {
        super(driver);
    }
}
