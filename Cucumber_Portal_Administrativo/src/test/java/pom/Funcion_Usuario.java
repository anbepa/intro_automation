package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Funcion_Usuario extends  BasePage
{

    private By ClickAdmintrativo    =  By.cssSelector("li[id='Administrativo']>a[role= 'button']");
    private By Accesos    =  By.cssSelector("li[id = '472'] > a");
    private By Funciones    =  By.cssSelector("li[id = '501'] > a");
    private By ModuloPrincipales  =  By.cssSelector("li[id = '481'] > a");
    private By Usuarios  =  By.cssSelector("li[id = '470'] > a");
    private By ConsultarUsuario  =  By.cssSelector("input[id = 'idConsult']");
    private By ClickConsultaUsuario  =  By.cssSelector("div[class='col-md-2'] >button[class='btn btn-success btn-block'][type='submit']");
    private By ValidacionUsuario  =  By.cssSelector("tr[role='row'][class='odd']>td[tabindex='0']");
    private By ClickEditar  =  By.cssSelector("span[class='dtr-data']>a[href='#editarUsuario'][role='button'][aria-controls='editarUsuario'] > button[type = 'submit'][class='btn btn-success btn-block']");
    private By Estado  =  By.cssSelector("select[id='userStatusEdit']>option");
    private By Perfilamiento  =  By.cssSelector("select[id='roleEdit'] > option");
    private By ValidacionEdicion =  By.cssSelector("div[class='alert alert-success alert-dismissible fade show']");
    private By  Primer_Nombre =  By.cssSelector("input[id='firstNameEdit']");
    private By  Segundo_Nombre =  By.cssSelector("input[id='middleNameEdit']");
    private By  Primer_Apellido =  By.cssSelector("input[id='lastNameEdit']");
    private By  Segundo_Apellido =  By.cssSelector("input[id='surNameEdit']");
    private By  Documento =  By.cssSelector("input[id='nationalIdEdit']");
    private By  Usuario_red =  By.cssSelector("input[id='idEdit']");
    private By  Guardar_Edicion2 =  By.cssSelector("button[type='submit'][class='btn btn-success'][onclick='formSummit()']");
    private By  Guardar_Edicion =  By.cssSelector("button[id='editUser']");
    private By CerrarSeccion  =  By.cssSelector("a[class= 'btn btn-success navbar-btn']");
    private By AlertaInicioSeccion  =  By.cssSelector("div[class= 'alert alert-danger alert-dismissible fade show']");
    private By  TextodeModulos =  By.cssSelector("ul[id='menuItems']>li[id]>a[role='button']>span");





    public  void Cerrar() {
        Click(CerrarSeccion);
    }


        public  void LlenarFormlario(String PrimerNo,String SegundoNo,String PrimeerAp,String SegundoAp,String Documents) {

        Input(Primer_Nombre,PrimerNo);
        Espera(Segundo_Nombre);
        Input(Segundo_Nombre,SegundoNo);
        Espera(Primer_Apellido);
        Input(Primer_Apellido,PrimeerAp);
        Espera(Segundo_Apellido);
        Input(Segundo_Apellido,SegundoAp);
        Espera(Documento);
        Input(Documento,Documents);
        Espera(Guardar_Edicion);
        Click(Guardar_Edicion);

    }


        public  void Editar()  {
        Espera(ValidacionUsuario);
        Click(ValidacionUsuario);
        Espera(ClickEditar);
        Click(ClickEditar);


    }


    public  void EdiDropdownListtar(String Estados) {
        Espera(Estado);
        SelectDropdownList(Estado,Estados);
        Espera(Guardar_Edicion);
        Click(Guardar_Edicion);
        Espera(Guardar_Edicion2);
        Click(Guardar_Edicion2);

    }


    public  void EditDropdownListPefil(String Perfil) {

        Espera(Perfilamiento);
        SelectDropdownList(Perfilamiento,Perfil);
        Espera(Guardar_Edicion);
        Click(Guardar_Edicion);
        Espera(Guardar_Edicion2);
        Click(Guardar_Edicion2);

    }

        public void ValidarCreacionUsuario(String User)
        {

            Click(ClickAdmintrativo);
            Espera(Usuarios);
            Click(Usuarios);
            Espera(ConsultarUsuario);
            Input(ConsultarUsuario,User);
            Espera(ClickAdmintrativo);
            Click(ClickConsultaUsuario);

        }


    public String Validar()
    {
        String Comparar =  ObtenerTextos(ValidacionUsuario);
        return Comparar;
    }

    public String ValidarEdicionExitosa()
    {
        String Comparar =  ObtenerTextos(ValidacionEdicion);
        return Comparar;
    }

    public String ValidarAccesoPerfil()
    {
        String Comparar =  ObtenerTextos(TextodeModulos);
        return Comparar;
    }

    public WebElement ValidarInactividad()
    {

       return FindElements(AlertaInicioSeccion);
    }



    public Funcion_Usuario(WebDriver driver) {
        super(driver);
    }
}
