package pom.TrasladoSaldo;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.BasePage;

import java.security.PrivateKey;

public class RegistroUnico extends BasePage {

    private String SubMenu = "document.querySelector(\"li[id='476']>a\").click();";
    private By Select_Tipo_identificacion = By.cssSelector("select[id='comboTipoId']>option");
    private By Input_Numero_identificacion = By.cssSelector("input[type='text'][id='field']");
    private By Click_Consultar = By.cssSelector("input[type='submit'][class='btn btn-success btn-block'][value='Buscar']");
    private By ValidarExistenciaRegistro = By.cssSelector("input[id='tarjeta0']");
    private By SelectMotivo = By.cssSelector("select[id='motivoT0']>option");
    private By SelectCuenta = By.cssSelector("select[id='cuenta0']>option");
    private By InputMonto = By.cssSelector("input[id='montoT0']");
    private By BtnTrasladar = By.cssSelector("button[id='createParam']");
    private By BtnAceptar = By.cssSelector("button[class='btn btn-success']");

    private String RecibirTarjeta;





    private By TrasladoUnico = By.cssSelector("input[id='exampleCheck1']");
    private By TrasladoMasivo = By.cssSelector("input[id='exampleCheck2']");


    public void EnviarTarjeta(String Tarjeta){
        RecibirTarjeta = Tarjeta;

    }


    public Boolean Ingresar(String Tipo, String Numero) throws InterruptedException {
        JavascriptExecutor(SubMenu);
        SelectDropdownList(Select_Tipo_identificacion, Tipo);
        Input(Input_Numero_identificacion, Numero);
        Click(Click_Consultar);
        return ElementoEditable(ValidarExistenciaRegistro);
    }



    public void TipoTraslado(String TipoT) {

        switch (TipoT)
        {
            case "Unico":
                Click(TrasladoUnico);
                break;
            case "Masivo":
                Click(TrasladoMasivo);
                break;

        }

    }

    public void LlenarFormulario(String Motivo,String Cuenta,String Monto) {

        Espera(BtnTrasladar);
        Input(ValidarExistenciaRegistro,RecibirTarjeta);
        SelectDropdownList(SelectMotivo,Motivo);
        SelectDropdownList(SelectCuenta,Cuenta);
        Input(InputMonto,Monto);
        Click(BtnTrasladar);
        Espera(BtnAceptar);
        Click(BtnAceptar);
    }

    public RegistroUnico(WebDriver driver) {
        super(driver);
    }
}
