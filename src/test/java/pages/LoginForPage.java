package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import supporte.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LoginForPage extends BasePage {
    public LoginForPage(WebDriver navegador) {
        super(navegador);
    }

    public LoginForPage setLogin() throws IOException {
        existerro = GerenciaErro.VerificaErro();
        if(existerro == false) {
       //     try {

                navegador.findElement(By.xpath("//div[@id=\"Login\"]//div[@class=\"form-group\"]//input[@name=\"emailUser\"]")).sendKeys("suhai0046450");
      //      }
     //       catch (Exception e){
        //        criaarquivoerro = GerenciaErro.CriarArquivoErro();
       //     }
        }
        return this;
    }

    public LoginForPage setPassword() {
        navegador.findElement(By.xpath("//form[@name=\"form\"]//input[@type=\"password\"]")).sendKeys("Safe#7813");
        return this;
    }

    public LoginForPage clickLogar() {
        navegador.findElement(By.xpath("//button[contains( text(), 'Entrar')]")).click();
        return this;
    }

    public LoginForPage Cosulta() throws IOException, InterruptedException {
        existerro = GerenciaErro.VerificaErro();
        if(existerro == false) {

            try {
                Thread.sleep(1000);
                //pega a pagina q do calculo
                ArrayList<String> tabs2 = new ArrayList<String>(navegador.getWindowHandles());
                //navegador.switchTo().window(tabs2.get(0));
                navegador.switchTo().window(tabs2.get(1));
                navegador.close();
                navegador.switchTo().window(tabs2.get(0));

            } catch (Exception e) {
                System.out.println("fail aqui");
            }


            try {
                WebDriverWait wait = new WebDriverWait(navegador, 10);
                //espera ate que o elemeto esteja visivel
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"fa fa-bars\"]")));
                //clica na barra de procura
                navegador.findElement(By.xpath("//span[@class=\"fa fa-bars\"]")).click();
                //espera ate que o elemeto esteja visivel

                //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"ng-binding\"]//span[@class=\"glyphicon-black fa fa-bar-chart-o\"]")));
//clica em cotador
                //navegador.findElement(By.xpath("//a[@class=\"ng-binding\"]//span[@class=\"glyphicon-black fa fa-bar-chart-o\"]")).click();
                //espera ate que o elemeto esteja visivel
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"ng-binding\"]//span[@class=\"glyphicon-black fa fa-bar-chart-o\"]")));

                //clica em nova cotacao
                navegador.findElement(By.xpath("//a[@class=\"ng-binding\"]//span[@class=\"glyphicon-black fa fa-bar-chart-o\"]")).click();


                existenrcotacao = PegarNrCotacao.VerificaCotacao();
                if (existenrcotacao == false) {
                    list = LerArquivo.getList(list);
                    cpf = list.get(1);
                    nome = list.get(0);
                    Thread.sleep(1000);
                    try {
                        String originalWindow = navegador.getWindowHandle();
                        for (String handle : navegador.getWindowHandles()) {
                            if (!handle.equals(navegador.getWindowHandles())) {
                                navegador.switchTo().window(handle);
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("fail to open window");
                    }
                    //espera ate que o elemento de cpf esteja visivel
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains( text(), 'CPF/CNPJ:')]")));
                    //digita no campo cpf
                    navegador.findElement(By.xpath("//div[@class=\"col-sm-2 col-md-2 col-lg-2\"]/input[@maxlength=\"14\"]")).clear();
                    Thread.sleep(500);
                    navegador.findElement(By.xpath("//div[@class=\"col-sm-2 col-md-2 col-lg-2\"]/input[@maxlength=\"14\"]")).sendKeys(cpf);
                    Thread.sleep(1000);
                    //digita no campó nome
                    navegador.findElement(By.xpath("//div[@class=\"col-sm-5 col-md-5 col-lg-5\"]//input[@ng-model=\"ds_Nome\"]")).clear();
                    Thread.sleep(500);
                    navegador.findElement(By.xpath("//div[@class=\"col-sm-5 col-md-5 col-lg-5\"]//input[@ng-model=\"ds_Nome\"]")).sendKeys(nome);
                    Thread.sleep(1000);
                    //clica em incluir
                    navegador.findElement(By.xpath("//div[@class=\"wrapper ng-scope\"]//section[@class=\"page search-page ng-scope\"]//button[@class=\"btn btn-default\"]//span[@class=\"fa fa-plus\"]")).click();

                } else {
                    Scanner ler = new Scanner("/home/robertinho/suhai_perfil/cotacao/nrcotacao.TXT");
                    String nome = ler.nextLine();
                    FileReader arq = new FileReader(nome);
                    BufferedReader lerArq = new BufferedReader(arq);
                    nrcotacao = lerArq.readLine();
                    arq.close();
                    //espera ate que o elemento de cpf esteja visivel
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains( text(), 'CPF/CNPJ:')]")));
                    //digita o numero da cotacao
                    navegador.findElement(By.xpath("//div[@class=\"col-sm-1 col-md-1 col-lg-1\"]//input[@ng-model=\"nr_NumeroCalculo\"]")).sendKeys(nrcotacao);
                    Thread.sleep(1000);
                    navegador.findElement(By.xpath("//button[@ng-click=\"getAll(paginaAtual)\"]")).click();
                    //espera ate que o elemento de cpf esteja visivel
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@ui-sref=\"home.content({area:'calculo',action:'edit-calculo',id:item.id_Calculo, subid:null})\"]")));
                    navegador.findElement(By.xpath("//i[@ui-sref=\"home.content({area:'calculo',action:'edit-calculo',id:item.id_Calculo, subid:null})\"]")).click();

                }
            }
            catch (Exception e){
                criaarquivoerro = GerenciaErro.CriarArquivoErro();
            }
        }


        return this;
    }


    public LoginForPage LogarSite() throws IOException, InterruptedException {
        deletararqlogar = GerenciaLogar.DeletarArquivoLogar();
        existerro = GerenciaErro.VerificaErro();
        if(existerro == false) {

            try {

                setLogin()
                        .setPassword()
                        .clickLogar()
                        .Cosulta();
            }
            catch (Exception e){
                criaarquivoerro = GerenciaErro.CriarArquivoErro();
            }

        }

        return this;
    }
}
