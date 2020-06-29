package seleniumgluecode.Test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import seleniumgluecode.TestBase;

public class Test_ModuloTraslados extends TestBase {



    @Given("^validar el saldo de la tarjeta \"([^\"]*)\" antes de realizar el  proceso$")
    public void validar_el_saldo_de_la_tarjeta_antes_de_realizar_el_proceso(String Tarjeta) throws Throwable {

        RegistroUnico.EnviarTarjeta(Tarjeta);

    }

    @Given("^La empresa  con tipo de identificacion \"([^\"]*)\" y numero \"([^\"]*)\" debe estar creada$")
    public void la_empresa_con_tipo_de_identificacion_y_numero_debe_estar_creada(String Tipo, String Numero) throws Throwable {

        Inicio_Sesion.FormularioInicioSesion();
        Assert.assertTrue(RegistroUnico.Ingresar(Tipo,Numero));

    }

    @When("^Seleccionar tipo de traslado \"([^\"]*)\"$")
    public void seleccionar_tipo_de_traslado(String TipoT) throws Throwable {
              RegistroUnico.TipoTraslado(TipoT);
    }

    @When("^Llenar formulario de registro Unico diligenciando los siguientes campos  Motivo \"([^\"]*)\" Numero cuenta \"([^\"]*)\" Monto \"([^\"]*)\"$")
    public void llenar_formulario_de_registro_Unico_diligenciando_los_siguientes_campos_Motivo_Numero_cuenta_Monto(String Motivo, String Cuenta, String Monto) throws Throwable {

        RegistroUnico.LlenarFormulario(Motivo,Cuenta,Monto);
    }

    @Then("^Mensaje informativo de traslado$")
    public void mensaje_informativo_de_traslado() throws Throwable {

    }

    @Then("^Consultar datos con fechas inicial \"([^\"]*)\" y fecha final \"([^\"]*)\" validando que el registro sea Exitoso$")
    public void consultar_datos_con_fechas_inicial_y_fecha_final_validando_que_el_registro_sea_Exitoso(String arg1, String arg2) throws Throwable {

    }

    @Then("^validar nuevamente el saldo de la tarjeta$")
    public void validar_nuevamente_el_saldo_de_la_tarjeta() throws Throwable {

    }




}
