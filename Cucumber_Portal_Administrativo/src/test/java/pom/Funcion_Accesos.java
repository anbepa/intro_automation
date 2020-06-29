package pom;

import cucumber.api.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Funcion_Accesos extends BasePage {

    private By Accesos    =  By.cssSelector("li[id = '472'] > a");
    private By ClickAdmintrativo    =  By.cssSelector("li[id='Administrativo']>a[role= 'button']");
    private By ConsultarPerfil    =  By.cssSelector("input[id='roleName']");
    private By ClickConsultaPerfil    =  By.cssSelector("div[class='col-md-4']>button[type='submit']");
    private By ClickBotonAccion    =  By.cssSelector("table[id='listaConsulta']>tbody>tr>td>form>button[type='submit']");
    private By ModuloPadre    =   By.cssSelector("table[id='allModules']> tbody > tr[role='row']>td[class ='sorting_1']");
    private By ClickAsociar    =  By.cssSelector("table[id='allModules']> tbody > tr[role='row']>td>button[type='submit']");
    private By ClickSiguiente    =  By.cssSelector("div[id= 'allModules_paginate'] > ul[class='pagination']>li");
    private By ClickSiguiente2    =  By.cssSelector("div[id= 'allModules_paginate'] > ul[class='pagination']>li[id='allModules_next']");
    private String   Javascripts = "var els = document.querySelectorAll(\"div[id= 'allModules_paginate'] > ul[class='pagination']>li\");";
    private By TextosModuloPadre    =   By.cssSelector("table[id='selfModules']> tbody > tr[role='row']>td[class ='sorting_1']");
    private By ClickPaginacion    =  By.cssSelector("div[id= 'selfModules_paginate'] > ul[class='pagination']>li");
    private By ClickDashboard    =   By.cssSelector("ul[id='menuItems']>li[class='active']");
    private String hola = "\"Tarjetas banco\"";
    private  String   SeleccionarTodo = "function Seleccionar(Modulo){var ep = document.querySelectorAll(\"div[id= 'allModules_paginate'] > ul[class='pagination']>li\");for(var i = 1 ; i<ep.length-1;i++){var els = document.querySelectorAll(\"table[id='allModules']> tbody > tr[role='row']>td>button[type='submit']\");var er = document.querySelector(\"div[id= 'allModules_paginate'] > ul[class='pagination']>li[id='allModules_next']\");var eq = document.querySelectorAll(\"table[id='allModules']> tbody > tr[role='row']>td[class ='sorting_1']\");for(var j = 0 ; j<els.length;j++){if((eq[j].innerText == Modulo)){els[j].click();}}er.click();}}"
            +"Seleccionar("+hola+")";

    private  String   SeleccionarTodo2 = "function Seleccionar(Modulo){var ep = document.querySelectorAll(\"div[id= 'allModules_paginate'] > ul[class='pagination']>li\");for(var i = 1 ; i<ep.length-1;i++){var els = document.querySelectorAll(\"table[id='allModules']> tbody > tr[role='row']>td>button[type='submit']\");var er = document.querySelector(\"div[id= 'allModules_paginate'] > ul[class='pagination']>li[id='allModules_next']\");var eq = document.querySelectorAll(\"table[id='allModules']> tbody > tr[role='row']>td[class ='sorting_1']\");for(var j = 0 ; j<els.length;j++){if((eq[j].innerText == Modulo)){els[j].click();}}er.click();}}"
            +"Seleccionar(\"Tarjetas banco\")";

    private   String file = System.getProperty("user.dir") + "/Capturas/Accesos"+ new Random().nextInt() +".png";






    public void CapturarPantalla() throws IOException {
        takeScreenShot(file);
    }


    public void ExtraerTextosAcceso(String User) throws InterruptedException, IOException {
        Click(ClickAdmintrativo);
        Espera(Accesos);
        Click(Accesos);
        Espera(ConsultarPerfil );
        Input(ConsultarPerfil ,User);
        takeScreenShot(file);
        Espera(ClickConsultaPerfil );
        takeScreenShot(file);
        Click(ClickConsultaPerfil );
        Espera(ClickBotonAccion);
        Click(ClickBotonAccion);
        Espera(ClickPaginacion);
        BuscarFunciones(ClickPaginacion);
        takeScreenShot(file);


        // Imprimir();



    }


    public Boolean ExtraerTextosModuloPadre2()
    {
        Click(ClickDashboard);
        ObtenerTextosLink();
        Boolean els = Comparar();
       return els;
    }



        public void ValidarCreacionUsuario(String User) throws InterruptedException, IOException {
        Click(ClickAdmintrativo);
        Espera(Accesos);
        Click(Accesos);
        Espera(ConsultarPerfil );
        Input(ConsultarPerfil ,User);
        Espera(ClickConsultaPerfil );
        Click(ClickConsultaPerfil );
        Espera(ClickBotonAccion);
        Click(ClickBotonAccion);
        takeScreenShot(file);
        BuscarFunciones(ClickPaginacion);


    }

    public void AsignarAcciones(DataTable table) throws InterruptedException {
      /*  Espera(ClickBotonAccion);
        Click(ClickBotonAccion);*/
      /*  Espera(ModuloPadre);
        Espera(ClickAsociar);
        Espera(ClickSiguiente);*/
       //JavascriptExecutor(SeleccionarTodo);


        Asociar_Funciones(table);
        Thread.sleep(3500);
        //JavascriptExecutor(SeleccionarTodo2);

        BuscarFunciones(ClickPaginacion);




    }

    public void FuncionesAsociadas(String Modulo) throws InterruptedException {
        Espera(ClickBotonAccion);
        Click(ClickBotonAccion);
        Espera(ModuloPadre);
        Espera(ClickAsociar);
        Espera(ClickSiguiente);
        Asociar(Modulo);
        BuscarFunciones(ClickPaginacion);


    }



    public Funcion_Accesos(WebDriver driver) {
        super(driver);
    }
}
