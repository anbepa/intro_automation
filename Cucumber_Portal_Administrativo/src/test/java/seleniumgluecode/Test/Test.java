package seleniumgluecode.Test;


import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import seleniumgluecode.TestBase;

import java.util.List;


public class Test extends TestBase {



   @Given("^El usuario \"([^\"]*)\" debe estar creado en la funcion Usuarios$")
    public void Preecondicion(String Usuario) throws Throwable {
        //Inicio_Sesion.FormularioInicioSesion();
        Funcion_Usuario.ValidarCreacionUsuario(Usuario);
        Assert.assertEquals(Funcion_Usuario.Validar(),Usuario);
    }

    @When("^Editar el campo Estado \"([^\"]*)\"$")
    public void Accion(String Estados) throws Throwable {
        Funcion_Usuario.Editar();
        Funcion_Usuario.EdiDropdownListtar(Estados);
    }

    @Then("^Mensaje informativo$")
    public void Resultado() throws Throwable {

        Assert.assertEquals(Funcion_Usuario.ValidarEdicionExitosa(),"Actualizacion de datos exitosa");
    }

    @Then("^No debe permitir el ingreso$")
    public void Resultado1() throws Throwable {
        Funcion_Usuario.Cerrar();
        Inicio_Sesion.FormularioInicioSesion();
        Assert.assertEquals(Funcion_Usuario.ValidarInactividad(),Funcion_Usuario.ValidarInactividad());

    }

 //CREACION DE PERFIL

    @Given("^El perfil con  \"([^\"]*)\"  no debe estar creado en la funcion perfiles$")
    public void el_perfil_con_no_debe_estar_creado_en_la_funcion_perfiles(String Perfil) throws Throwable {
        Inicio_Sesion.FormularioInicioSesion();
        Funcion_Perfiles.ValidarCreacionUsuario(Perfil);
        Assert.assertNotEquals(Funcion_Perfiles.Validar(),Perfil);
    }

    @When("^llenar el formulario de creacion con codigo \"([^\"]*)\" y Nombre de  perfil \"([^\"]*)\" gurdando los cambios$")
    public void llenar_el_formulario_de_creacion_con_codigo_y_Nombre_de_perfil_gurdando_los_cambios(String Codigo, String Perfil) throws Throwable {
        Funcion_Perfiles.LlenarFormularioCreacion(Codigo,Perfil);

    }


    @Then("^Mensaje informativo de  creacion  exitosa$")
    public void mensaje_informativo_de_creacion_exitosa() throws Throwable {
       Funcion_Perfiles.SacarPerfil();
       Assert.assertEquals(Funcion_Perfiles.ValidarEdicionExitosa(),"Se creo el perfil " +Funcion_Perfiles.SacarPerfil()+","+" no olvide asignarle los accesos");
    }

//DAR ACCESOS A FERFIL

 /*  @Given("^El perfil  \"([^\"]*)\"   debe estar creado en la funcion Accesos$")
    public void el_perfil_debe_estar_creado_en_la_funcion_Accesos(String Usuario) throws Throwable {

        Inicio_Sesion.FormularioInicioSesion();
        Funcion_Accesos.ValidarCreacionUsuario(Usuario);
       // Assert.assertEquals(Funcion_Perfiles.Validar(Usuario),Usuario);

    }

    @When("^Asociar funciones \"([^\"]*)\" con modulo padre$")
    public void asociar_funciones_con_modulo_padre_s(DataTable table) throws Throwable {


     //  Funcion_Accesos.AsignarAcciones(Modulo);
    }*/

    @When("^Asociar funciones a cada perfil$")
    public void asociar_funciones_Modulo_con_modulo_padre(DataTable table) throws Throwable {

        //Inicio_Sesion.FormularioInicioSesion();
        //Funcion_Accesos.ValidarCreacionUsuario(Usuario);
        // Assert.assertEquals(Funcion_Perfiles.Validar(Usuario),Usuario);
        Funcion_Accesos.AsignarAcciones(table);


    }

    //CAMBIAR PERFILA A USUARIO

    @Given("^El usuario \"([^\"]*)\" debe estar creado en la funcion Usuarios y el perfil \"([^\"]*)\" debe estar creado$")
    public void el_usuario_debe_estar_creado_en_la_funcion_Usuarios_y_el_perfil_debe_estar_creado(String Usuario, String Perfil) throws Throwable {
        //Inicio_Sesion.FormularioInicioSesion();
        Funcion_Accesos.ExtraerTextosAcceso(Perfil);
        Funcion_Usuario.ValidarCreacionUsuario(Usuario);
        Assert.assertEquals(Funcion_Usuario.Validar(),Usuario);
    }

    @When("^Editar el campo Perfil \"([^\"]*)\" y guardar la edicion$")
    public void editar_el_campo_Perfil_y_guardar_la_edicion(String Perfil) throws Throwable {

        Funcion_Usuario.Editar();
        Funcion_Usuario.EditDropdownListPefil(Perfil);
    }

    @Then("^Mensaje informativo de   modificacion$")
    public void mensaje_informativo_de_modificacion_exitosa() throws Throwable {
       Assert.assertEquals(Funcion_Usuario.ValidarEdicionExitosa(),"Actualizacion de datos exitosa");
    }

    @Then("^Solo debe permitir el acceso de acuerdo al nuevo perfil$")
    public void solo_debe_permitir_el_acceso_de_acuerdo_al_nuevo_perfil() throws Throwable {
        Assert.assertTrue(Funcion_Accesos.ExtraerTextosModuloPadre2());
        //Funcion_Accesos.ExtraerTextosModuloPadre2();

    }








}
