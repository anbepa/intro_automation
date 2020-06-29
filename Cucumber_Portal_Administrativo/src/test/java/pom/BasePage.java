package pom;

import cucumber.api.DataTable;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.util.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.font.DelegatingShape;

public class BasePage {

    private WebDriver driver ;
    private String MeEcontro = "";
    private String  Almacena;
    //private ArrayList<String> AlmacenaTextoModulos= new ArrayList<String>();
    private ArrayList<String>  AlmacenaTextoModulos = new ArrayList<String> ();
    private ArrayList<String>  AlmacenarTodosTextosPagina = new ArrayList<String> ();
    private String Almacena2;
    private ArrayList<String> Alm2 = new ArrayList<String>();
    private By Select_Tipo_identificacion = By.cssSelector("select[id='bdbDocumentType']>option");
    private ArrayList<String> op = new ArrayList<String> ();









    public  BasePage(WebDriver driver)
    {
        this.driver = driver;
    }


    public  String    ObtenerAtributos( By Localizador,String Atributo)
    {
        return driver.findElement(Localizador).getAttribute(Atributo);
    }

    public  Boolean   ElementoEditable( By Localizador)
    {
        return driver.findElement(Localizador).isEnabled();
    }

    public  WebElement   FindElements( By cadena )
    {
      return driver.findElement(cadena);
    }

    public  void takeScreenShot(String filewithPath ) throws IOException {
       TakesScreenshot srcShot = (TakesScreenshot) driver;
       File srcFile = srcShot.getScreenshotAs(OutputType.FILE);
       File destFile = new File(filewithPath);
        FileUtils.copyFile(srcFile,destFile);
    }

    public void   JavascriptExecutor( String cadena) throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(3500);
        js.executeScript(cadena);
        Thread.sleep(3500);
    }



    public void Espera (By elements)
     {
         WebDriverWait wait = new WebDriverWait(driver, 140);
         wait.until(ExpectedConditions.elementToBeClickable(elements));
     }


    public  void Input(By elementos, String Texto) {
        driver.findElement(elementos).clear();
        driver.findElement(elementos).sendKeys(Texto);

    }

    public  String ObtenerTextos(By elementos) {
     String Obtener =  driver.findElement(elementos).getText();
     return Obtener;
    }



    public void Esperar (WebElement elements)
    {
        WebDriverWait wait = new WebDriverWait(driver, 120);
        wait.until(ExpectedConditions.elementToBeClickable(elements));
    }

    public  void Click(By elementos)
    {
        driver.findElement(elementos).click();
    }


    public  void SelectDropdownList(By elementos,String Estados)
    {
        List<WebElement> options = driver.findElements(elementos);
        for(int i = 0 ; i < options.size();i++)
        {
            if ( options.get(i).getText().equals(Estados) )
            {
                options.get(i).click();
            }
        }

    }

    public void AsociarFunciones( ) throws InterruptedException {
        List<WebElement> options = driver.findElements(By.cssSelector("table[id='allModules']> tbody > tr[role='row']>td[class ='sorting_1']"));
        List<WebElement> Mod =     driver.findElements(By.cssSelector("table[id='allModules']> tbody > tr[role='row']>td>button[type='submit']"));

        for( int i=0; i < options.size();i++)
        {

                //Esperar(Mod.get(i));
                Mod.get(i).click();


        }

    }

    public void Siguiente()
    {
        Esperar(driver.findElement(By.cssSelector("div[id= 'allModules_paginate'] > ul[class='pagination']>li[id='allModules_next']")));
        driver.findElement(By.cssSelector("div[id= 'allModules_paginate'] > ul[class='pagination']>li[id='allModules_next']")).click();

    }

    public void Atras()
    {
        Esperar(driver.findElement(By.cssSelector("div[id= 'allModules_paginate'] > ul[class='pagination']>li[id='allModules_previous']")));
        driver.findElement(By.cssSelector("div[id= 'allModules_paginate'] > ul[class='pagination']>li[id='allModules_previous']")).click();

    }
    public  void Siguiente2()
    {
        Esperar(driver.findElement(By.cssSelector("div[id= 'allModules_paginate'] > ul[class='pagination']>li[id='allModules_next']")));
        driver.findElement(By.cssSelector("div[id= 'selfModules_paginate'] > ul[class='pagination']>li[id='selfModules_next']")).click();

    }




    public  Boolean Repetir(String Modulo)
    {
        Boolean a = false;
        List<WebElement> options = driver.findElements(By.cssSelector("table[id='allModules']> tbody > tr[role='row']>td[class ='sorting_1']"));
        for(int i=0;i<options.size();i++)
        {
            Esperar(options.get(i));
            if ( options.get(i).getText().equals(Modulo) )
            {
                a = true;
            }
        }
        return a;
    }


    public  void AccionSeleccionarFunciones(String Modulo) throws InterruptedException {


        List<WebElement> options = driver.findElements(By.cssSelector("table[id='allModules']> tbody > tr[role='row']>td[class ='sorting_1']"));
        for(int i = 0 ; i < options.size();i++)
        {
            if ( options.get(i).getText().equals(Modulo) )
            {
                Asociar(Modulo);
            }
            else
                {
                    Siguiente();
                }

        }


    }

        public boolean Asociar(String Modulo) throws InterruptedException {

            List<WebElement> Od = driver.findElements(By.cssSelector("div[id= 'allModules_paginate'] > ul[class='pagination']>li"));
            boolean el = false;
            for(int i=1;i<Od.size()-1;i++)
            {

                    Thread.sleep(3000);
                //    AsociarFunciones(Modulo);
                    Thread.sleep(3000);
                    Siguiente();
                    Thread.sleep(2000);
            }

           return el;
    }

    //////////////
    public  void Prueba() throws InterruptedException
    {



        List<WebElement> options = driver.findElements(By.cssSelector("table[id='allModules']> tbody > tr[role='row']>td[class ='sorting_1']"));
        List<WebElement> Mod =     driver.findElements(By.cssSelector("table[id='allModules']> tbody > tr[role='row']>td>button[type='submit']"));
        List<WebElement> Od = driver.findElements(By.cssSelector("div[id= 'allModules_paginate'] > ul[class='pagination']>li"));

            for (int j=0;j<Mod.size();j++)
            {
               Esperar(Mod.get(j));
                Mod.get(j).click();
            }
           // Siguiente();



        /*for(int i=1;i<Od.size()-1;i++)
        {
            Atras();
        }*/

        //AsociarFunciones();


    }

    ///////////////




    public  void BuscarFunciones(By Siguientes) throws InterruptedException {

        List<WebElement> Od = driver.findElements(Siguientes);
        for(int i=1;i<Od.size()-1;i++)
        {

                Thread.sleep(2000);
                ExtraerFunciones();
                Thread.sleep(2000);
                Siguiente2();
                Thread.sleep(2000);
        }


    }


    public ArrayList<String>  ExtraerFunciones()
    {

        List<WebElement> options = driver.findElements(By.cssSelector("table[id='selfModules']> tbody > tr[role='row']>td:nth-child(3)"));
        List<WebElement> options2 = driver.findElements(By.cssSelector("table[id='selfModules']> tbody > tr[role='row']>td:nth-child(2)"));
        for(int i = 0 ; i < options.size();i++)
        {



               if (!options2.get(i).getText().equals("Sin asignar"))
                {
                    Almacena = options.get(i).getText();
                    AlmacenaTextoModulos.add(Almacena);
                }

        }
        return  AlmacenaTextoModulos;
    }

    public  ArrayList<String>   ObtenerTextosLink() {

        List<WebElement> opc = driver.findElements(By.cssSelector("span"));
        for(int i = 0 ; i < opc.size();i++)
        {
            if (!opc.get(i).getAttribute("innerText").equals("ABERNAL") && !opc.get(i).getAttribute("innerText").equals("© 2019 NovoPayment Inc. All rights reserved.") && !opc.get(i).getAttribute("innerText").equals("Dashboard"))
            {
                Almacena2 = opc.get(i).getAttribute("innerText");
                AlmacenarTodosTextosPagina.add(Almacena2);
            }


        }
        System.out.print(AlmacenarTodosTextosPagina);
        return AlmacenarTodosTextosPagina;
    }


   public boolean Comparar()
    {
        boolean var = false;
        int f = 0;
        Set<String> hashSet = new HashSet<String>(AlmacenarTodosTextosPagina);
        AlmacenarTodosTextosPagina.clear();
        AlmacenarTodosTextosPagina.addAll(hashSet);

        for(int i = 0; i< AlmacenaTextoModulos.size(); i++){ //Itera elementos del primer ArrayList
            for(int j = 0; j< AlmacenarTodosTextosPagina.size(); j++){//Itera elementos del segundo ArrayList
                if(AlmacenaTextoModulos.get(i).equals(AlmacenarTodosTextosPagina.get(j))){ //Compara si los valores son iguales.
                    f++;
                   System.out.println("Elemento del array  " + AlmacenaTextoModulos.get(i) + ", posición: " + i + "  es igual a el elemento del array " +AlmacenarTodosTextosPagina.get(j)+ "en la posición: " + j);
                }
            }
        }

        if (f == AlmacenaTextoModulos.size())
        {
            System.out.println(f);
             var = true;

        }





        return var;
    }




    public  void Imprimir2()
    {

        Set<String> hashSet = new HashSet<String>(AlmacenarTodosTextosPagina);
        AlmacenarTodosTextosPagina.clear();
        AlmacenarTodosTextosPagina.addAll(hashSet);
        System.out.print(AlmacenarTodosTextosPagina);
    }




    public  void Imprimir()
    {
        System.out.print(AlmacenaTextoModulos);
    }






    public String ValidacionPerfil(By elementos, String Estados)
    {
        String Texto = "";
        List<WebElement> options = driver.findElements(elementos);
        for(int i = 0 ; i < options.size();i++)
        {
            if ( options.get(i).getText().equals(Estados) )
            {
                 Texto =  options.get(i).getText();
            }
        }
       return Texto;
    }


    public boolean Buscar_Datos_Basicos(List<String> els) throws InterruptedException {
        List<WebElement> options = driver.findElements(By.cssSelector("table[id='dtBasicExample']>tbody>tr[role='row']"));
        Boolean b = true;
        for (int y = 0 ; y < options.size();y++) {
            List<WebElement> options2 = options.get(y).findElements(By.cssSelector("td"));
            int f = 0;
            for (int j = 0; j < els.size(); j++) {
                //System.out.print(op);
                for (int k = 3; k < options2.size() - 3; k=k+4) {
                    if (els.get(j).equals(options2.get(k).getAttribute("innerText"))) {
                        op.add(options2.get(k).getAttribute("innerText"));
                       // System.out.print(op.get(k));
                        f++;
                    }
                }
                if(f == els.size()) {
                    b=false;
                    System.out.print( "Numero Nuevo: "+ els.get(0) + "Razon Social: " + els.get(1) + "Direccion Nueva: " +els.get(2) + "Sede: " +els.get(3));

                }
            }
            if (b==false) {
                System.out.print( "Se encontro en la Columna: " +y);
                break;
            }
        }
        return b;
    }

    public boolean Buscar_Datos_Basico(List<String> els) throws InterruptedException {
        List<WebElement> options = driver.findElements(By.cssSelector("ul[class='pagination'] >li"));
        int i = 2;
        boolean bandera = true;
        while( (i<options.size()-2) && bandera) {
           bandera = Buscar_Datos_Basicos(els);
           if (bandera==true) {
               driver.findElement(By.cssSelector("div[id= 'dtBasicExample_paginate'] > ul[class='pagination']>li[id='dtBasicExample_next']")).click();
           }
           System.out.print(bandera);
           i++;
        }
        return bandera;
    }


    public boolean Buscar_Datos_Beneficiario(List<String> els,int indice1,int indice2,int indice3) throws InterruptedException {
        List<WebElement> options = driver.findElements(By.cssSelector("table[id='dtBasicExample']>tbody>tr[role='row']"));
        Boolean b = true;
        for (int y = 0 ; y < options.size();y++) {
            List<WebElement> options2 = options.get(y).findElements(By.cssSelector("td"));
            int f = 0;
            for (int j = 0; j < els.size(); j++) {
                //System.out.print(op);
                for (int k = indice1; k < options2.size()-indice2; k=k+indice3) {
                    if (els.get(j).equals(options2.get(k).getAttribute("innerText"))) {
                        op.add(options2.get(k).getAttribute("innerText"));
                        // System.out.print(op.get(k));
                        f++;
                    }
                }
                if(f == els.size()) {
                    b=false;
                    //System.out.print( "Numero Nuevo: "+ els.get(0) + "Celular Nuevo: " + els.get(1));

                }
            }
            if (b==false) {
                System.out.print( "Se encontro en la Columna: " +y);
                break;
            }
        }
        return b;
    }

    public boolean Buscar_Dato_Beneficiario(List<String> els,int indice1,int indice2,int indice3) throws InterruptedException {
        List<WebElement> options = driver.findElements(By.cssSelector("ul[class='pagination'] >li"));
        int i = 2;
        boolean bandera = true;
        while( (i<options.size()-2) && bandera) {
            bandera = Buscar_Datos_Beneficiario(els,indice1,indice2,indice3);
            if (bandera==true) {
                driver.findElement(By.cssSelector("div[id= 'dtBasicExample_paginate'] > ul[class='pagination']>li[id='dtBasicExample_next']")).click();
            }
            System.out.print(bandera);
            i++;
        }
        return bandera;
    }







    public void Asociar_Funciones(DataTable table) throws InterruptedException {

        By ClickAdmintrativo    =  By.cssSelector("li[id='Administrativo']>a[role= 'button']");
        By Accesos    =  By.cssSelector("li[id = '472'] > a");
        By ConsultarPerfil    =  By.cssSelector("input[id='roleName']");
        By ClickConsultaPerfil    =  By.cssSelector("div[class='col-md-4']>button[type='submit']");
        By ClickBotonAccion    =  By.cssSelector("table[id='listaConsulta']>tbody>tr>td>form>button[type='submit']");
        By ClickPaginacion    =  By.cssSelector("div[id= 'selfModules_paginate'] > ul[class='pagination']>li");
        List<List<String>> rows = table.asLists(String.class);
        List<List<String>> SinCabezera = rows.subList(1,rows.size());

        for (List<String>  row : SinCabezera) {

            Click(ClickAdmintrativo);
            Espera(Accesos);
            Click(Accesos);
            Espera(ConsultarPerfil );
            Input(ConsultarPerfil ,row.get(0));
            Espera(ClickConsultaPerfil );
            Click(ClickConsultaPerfil );
            Espera(ClickBotonAccion);
            Click(ClickBotonAccion);
            BuscarFunciones(ClickPaginacion);
            String   SeleccionarTodo = "function Seleccionar(Modulo){var ep = document.querySelectorAll(\"div[id= 'allModules_paginate'] > ul[class='pagination']>li\");for(var i = 1 ; i<ep.length-1;i++){var els = document.querySelectorAll(\"table[id='allModules']> tbody > tr[role='row']>td>button[type='submit']\");var er = document.querySelector(\"div[id= 'allModules_paginate'] > ul[class='pagination']>li[id='allModules_next']\");var eq = document.querySelectorAll(\"table[id='allModules']> tbody > tr[role='row']>td[class ='sorting_1']\");for(var j = 0 ; j<els.length;j++){if((eq[j].innerText == Modulo)){els[j].click();}}er.click();}}"
                    +"Seleccionar("+"\""+row.get(1)+"\""+")";
            JavascriptExecutor(SeleccionarTodo);
            System.out.println("nombre " +row.get(0));
        }
    }

    }
