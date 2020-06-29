package seleniumgluecode.Test;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import seleniumgluecode.TestBase;

public class Test_ModuloClientes extends TestBase {


    /* Realizar cambios generales y verificar en la consulta*/

   @Given("^La empresa \"([^\"]*)\" \"([^\"]*)\" debe existir$")
    public void la_empresa_debe_existir(String Tipo,String Numero) throws Throwable {
        Inicio_Sesion.FormularioInicioSesion();
        Cambios_Basicos.SubMenu_DatosCliente(Tipo,Numero);
        Assert.assertEquals(Cambios_Basicos.ValidarEdicionExitosaCliente(),Numero);

    }

    @When("^Modificar la razón social \"([^\"]*)\" el tipo \"([^\"]*)\" y número de identificación \"([^\"]*)\"$")
    public void modificar_la_razón_social_el_tipo_y_número_de_identificación(String Razon, String Tipo,String Numero) throws Throwable {

        Cambios_Basicos.LlenarFormularioCliente1(Razon,Tipo,Numero);
    }

    @When("^Modificar dirección \"([^\"]*)\" y correo electronico  \"([^\"]*)\"  e ingresar sedes \"([^\"]*)\"$")
    public void modificar_dirección_y_correo_electronico_e_ingresar_sedes(String Direccion, String Correo,String Sedes) throws Throwable {

         Cambios_Basicos.LlenarFormularioCliente2(Direccion,Correo,Sedes);
    }

    @Then("^Mensaje informativo de  modificacion  exitosa$")
    public void mensaje_informativo_de_modificacion_exitosa() throws Throwable {

        Assert.assertEquals(Cambios_Basicos.ValidarEdicion(),"Se actualizaron los datos del ciente correctamente");

    }

    @Then("^Consultar datos con fecha inicial \"([^\"]*)\" y fecha final \"([^\"]*)\" deben estar registrados$")
    public void consultar_datos_con_fecha_inicial_y_fecha_final_los_deben_estar_registrados(String FechaI, String FechaF) throws Throwable {
               Cambios_Basicos.SubMenu_Datos_Basicos(FechaI,FechaF);
    }


    @Given("^La empresa con  tipo  \"([^\"]*)\" y  numero \"([^\"]*)\" debe estar creada$")
    public void la_empresa_con_tipo_y_numero_debe_estar_creada(String Tipo, String Numero) throws Throwable {

        Inicio_Sesion.FormularioInicioSesion();
        Datos_Beneficiario.SubMenu_DatosBeneficiario(Tipo,Numero);
       // Assert.assertEquals(Datos_Beneficiario.ValidarEdicionExitosaBeneficiario(),Numero);
    }

    @When("^Modificar el tipo \"([^\"]*)\" y numero de identificacion \"([^\"]*)\" y el numero de celular \"([^\"]*)\"$")
    public void modificar_el_tipo_y_numero_de_identificacion_y_el_numero_de_celular(String Tipo, String Numero, String Celular) throws Throwable {
        Datos_Beneficiario.LlenarFormularioBeneficiario(Tipo,Numero,Celular);
    }

    @Then("^Mensaje informativo de  modificacion beneficiario$")
    public void mensaje_informativo_de_modificacion_beneficiario() throws Throwable {

       Assert.assertEquals(Cambios_Basicos.ValidarEdicion(),"Beneficiario modificado con exito");


    }

    @Then("^Consultar datos con fechas inicial \"([^\"]*)\" y fecha final \"([^\"]*)\" deben estar registrados$")
    public void consultar_datos_con_fechas_inicial_y_fecha_final_deben_estar_registrados(String Fechaa, String Fechab) throws Throwable {
        Datos_Beneficiario.Buscar_Dato_Beneficiario(Fechaa,Fechab);
    }




    @Given("^La empresa con  tipo  \"([^\"]*)\" y  numero \"([^\"]*)\"  y convenio \"([^\"]*)\" debe existir$")
    public void la_empresa_con_tipo_y_numero_y_convenio_debe_existir(String Tipo, String Numero, String Convenio) throws Throwable {
        Inicio_Sesion.FormularioInicioSesion();
        Gestion_Cuentas.SubMenu_GestioCuentas(Tipo,Numero,Convenio);


    }

    @When("^Modificar la  cuenta primaria  por una nueva cuenta \"([^\"]*)\" seleccionando un tipo de cuenta \"([^\"]*)\"$")
    public void modificar_la_cuenta_primaria_por_una_nueva_cuenta_seleccionando_un_tipo_de_cuenta(String Cuenta, String Tipo) throws Throwable {
         Gestion_Cuentas.Cambiar_Cuentas(Cuenta,Tipo);
    }

    @Then("^Mensaje informativo de  modificacion cuenta$")
    public void mensaje_informativo_de_modificacion_cuenta() throws Throwable {

       Assert.assertEquals(Cambios_Basicos.ValidarEdicion(),"Actualización exitosa");

    }

    @Then("^Consultar datos con fechas inicial \"([^\"]*)\" y fecha final \"([^\"]*)\"$")
    public void consultar_datos_con_fechas_inicial_y_fecha_final(String FechaI, String FechaF) throws Throwable {
       Gestion_Cuentas.SubMenu_Datos_Basicos(FechaI,FechaF);
    }

    @Given("^La empresa a modificar debe existir  y tener asociado un tipo \"([^\"]*)\"  y numero \"([^\"]*)\"$")
    public void la_empresa_a_modificar_debe_existir_y_tener_asociado_un_tipo_y_numero(String Tipo, String Numero) throws Throwable {

        Inicio_Sesion.FormularioInicioSesion();
        Migraciones.SubMenu_UnidadNegocio(Tipo,Numero);

    }

    @When("^Seleccionar numero de cuenta \"([^\"]*)\" y la unidad de negocio nueva \"([^\"]*)\"$")
    public void fd(String Cuenta, String Unidad) throws Throwable {
        Migraciones.FormularioUnidad(Cuenta,Unidad);

    }

    @Then("^Mensaje informativo cambio unidad de negocio$")
    public void mensaje_informativo_cambio_unidad_de_negocio() throws Throwable {
       Assert.assertEquals(Cambios_Basicos.ValidarEdicion(),"Actualización exitosa");

    }

    @Then("^Consultar datos con nombre de la empresa \"([^\"]*)\" fechas inicial \"([^\"]*)\" y fecha final \"([^\"]*)\"$")
    public void consultar_datos_con_nombre_de_la_empresa_fechas_inicial_y_fecha_final(String Empresa, String FechaI, String FechaF) throws Throwable {
       Migraciones.Consultas(Empresa,FechaI,FechaF);
    }


    @Given("^Buscar la Empresa con  tipo \"([^\"]*)\"  y numero \"([^\"]*)\" de identificacion$")
    public void buscar_la_Empresa_con_tipo_y_numero_de_identificacion(String Tipo, String Numero) throws Throwable {
        Inicio_Sesion.FormularioInicioSesion();
        Migraciones.SubMenu_Convenio(Tipo,Numero);
    }

    @When("^Seleccionar Convenio actual \"([^\"]*)\" y convenio nuevo \"([^\"]*)\"$")
    public void seleccionar_numero_de_cuenta_y_la_unidad_de_negocio_nuev(String UndadA, String UnidadN) throws Throwable {
        Migraciones.FormularioConvenio(UndadA,UnidadN);

    }




    @Then("^Mensaje informativo cambio convenio$")
    public void mensaje_informativo_cambio_convenio() throws Throwable {
        Assert.assertEquals(Cambios_Basicos.ValidarEdicion(),"Actualización exitosa");

    }

    @Then("^Consultar dato con nombre de la empresa \"([^\"]*)\" fechas inicial \"([^\"]*)\" y fecha final \"([^\"]*)\"$")
    public void consultar_dato_con_nombre_de_la_empresa_fechas_inicial_y_fecha_final(String Empresa, String FechaI, String FechaF) throws Throwable {
        Migraciones.Consultas(Empresa,FechaI,FechaF);
    }



    @Given("^Seleccionar Empresa \"([^\"]*)\" a  gestionar$")
    public void seleccionar_Empresa_a_gestionar(String Empresa) throws Throwable {
        Inicio_Sesion.FormularioInicioSesion();
        Otras_Configuraciones.SeleccionarEmpresa(Empresa);

    }

    @When("^Seleccionar  tipo conveno \"([^\"]*)\"  y el tipo dispersion \"([^\"]*)\"$")
    public void seleccionar_tipo_conveno_y_el_tipo_dispersion(String Convenio, String Dispersion) throws Throwable {

        Otras_Configuraciones.Formulario_Configuracion_Convenio(Convenio,Dispersion);
    }

    @When("^Seleccionar PGP \"([^\"]*)\"  y Reexpedicion \"([^\"]*)\"$")
    public void seleccionar_PGP_y_Reexpedicion(String Pgp, String Reexpedicion) throws Throwable {
        Otras_Configuraciones.Formulario_Configuracion_Convenio_(Pgp,Reexpedicion);

    }

    @When("^Seleccianar Sede \"([^\"]*)\" y Custodio \"([^\"]*)\"$")
    public void seleccianar_Sede_y_Custodio(String Sede, String Custodio) throws Throwable {

     //   Otras_Configuraciones.Formulario_Datos_Custodio(Sede,Custodio);
    }





    @When("^Diligenciar los siguiente campos  \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" segun custodio seleccioando$")
    public void diligenciar_los_siguiente_campos_segun_custodio_seleccioando(String Tipo, String Numero, String Nombre, String Direccion, String Departamento, String Ciudad, String Telefono) throws Throwable {
        //Otras_Configuraciones.Formulario_Datos_Custodio_(Tipo,Numero,Nombre,Direccion,Departamento,Ciudad,Telefono);

    }


    @Then("^Mensaje  informativo$")
    public void mensaje_informativo() throws Throwable {
        //Assert.assertEquals(Cambios_Basicos.ValidarEdicion(),"Se modificaron los parametros del Custodio con exito. Selecccione una empreza para continuar.");

    }

}
