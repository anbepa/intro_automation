package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Funcion_Perfiles  extends  BasePage{

    private By Perfiles  =  By.cssSelector("li[id = '471'] > a");
    private By ClickAdmintrativo    =  By.cssSelector("li[id='Administrativo']>a[role= 'button']");
    private By ConsultarPerfil  =  By.cssSelector("input[id = 'idConsultar']");
    private By ClickConsultaPerfil  =  By.cssSelector("div[class='col-md-2'] >button[class='btn btn-success btn-block'][type='submit']");
    private By ValidacionUsuario  =  By.cssSelector("table[id='listaConsulta']>tbody>tr>td:nth-child(1)");
    private By BotonCrearPerfil  =  By.cssSelector("a[href='#crear'] >button[type='submit']");
    private By InputPerfil  =  By.cssSelector("input[id='roleName']");
    private By InputDescripcion  =  By.cssSelector("input[id='roleDescription']");
    private By Guardar_Perfil  =  By.cssSelector("button[id='createParam']");
    private By ValidacionEdicion =  By.cssSelector("div[class='alert alert-success alert-dismissible fade show']");
    String Per ;






    public String ValidarEdicionExitosa()
    {
        String Comparar =  ObtenerTextos(ValidacionEdicion);
        return Comparar;
    }

    public void LlenarFormularioCreacion(String Perfil,String Descripcion)
    {
        Click(BotonCrearPerfil);
        Espera(InputPerfil);
        Input(InputPerfil,Perfil);
        Espera(InputDescripcion);
        Input(InputDescripcion,Descripcion);
        Espera(Guardar_Perfil);
        Click(Guardar_Perfil);
        Per=Descripcion;
    }

    public String SacarPerfil()
    {
        return Per;
    }

    public void ValidarCreacionUsuario(String User)
    {

        Click(ClickAdmintrativo);
        Espera(Perfiles);
        Click(Perfiles);
        Espera(ConsultarPerfil);
        Input(ConsultarPerfil,User);
        Espera(ClickConsultaPerfil);
        Click(ClickConsultaPerfil);

    }

    public String Validar()
    {
        //String Comparar =  ValidacionPerfil(ValidacionUsuario,Texto);
        String Comparar = ObtenerTextos(ValidacionUsuario);
        return Comparar;
    }




    public Funcion_Perfiles(WebDriver driver) {
        super(driver);
    }
}
