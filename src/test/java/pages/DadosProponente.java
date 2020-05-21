package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import supporte.BasePage;
import supporte.GerenciaErro;
import supporte.LerArquivo;

import java.io.IOException;

public class DadosProponente extends BasePage {
    public DadosProponente(WebDriver navegador) {
        super(navegador);
    }

    public DadosProponente TipoPessoa() throws IOException {
        existerro = GerenciaErro.VerificaErro();
        if (existerro == false) {
            // try {
            WebDriverWait wait = new WebDriverWait(navegador, 10);
            list = LerArquivo.getList(list);
            tipopessoa = list.get(21);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@ng-change=\"changeTipoPessoa();LimpaValorPremio()\"]")));
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//selet[@ng-change=\"changeTipoPessoa();LimpaValorPremio()\"]")));


            navegador.findElement(By.xpath("//select[@ng-change=\"changeTipoPessoa();LimpaValorPremio()\"]")).sendKeys(tipopessoa);
            // }
            //      catch (Exception e){
           // criaarquivoerro = GerenciaErro.CriarArquivoErro();
            //  }
        }
        return this;
    }

    public DadosProponente PreencheNomeCpfProponente() throws IOException, InterruptedException {
        existerro = GerenciaErro.VerificaErro();
        if (existerro == false) {
          //  try {
                WebDriverWait wait = new WebDriverWait(navegador, 10);
                list = LerArquivo.getList(list);
                cpf = list.get(1);
                nome = list.get(0);
                //preenche cpf
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"col-sm-2 col-md-2 col-lg-2\"]//input[@ng-model=\"calculo.proponente.nr_Cpf\"]")));
                Thread.sleep(1000);
                navegador.findElement(By.xpath("//div[@class=\"col-sm-2 col-md-2 col-lg-2\"]//input[@ng-model=\"calculo.proponente.nr_Cpf\"]")).clear();
                Thread.sleep(500);
                navegador.findElement(By.xpath("//div[@class=\"col-sm-2 col-md-2 col-lg-2\"]//input[@ng-model=\"calculo.proponente.nr_Cpf\"]")).sendKeys(cpf);
                Thread.sleep(1000);
                //preenche nome
                navegador.findElement(By.xpath("//div[@class=\"col-sm-4 col-md-4 col-lg-4\"]//input[@ng-model=\"calculo.proponente.ds_Nome\"]")).clear();
                Thread.sleep(500);
                navegador.findElement(By.xpath("//div[@class=\"col-sm-4 col-md-4 col-lg-4\"]//input[@ng-model=\"calculo.proponente.ds_Nome\"]")).sendKeys(nome);
          //  } catch (Exception e) {
          //      criaarquivoerro = GerenciaErro.CriarArquivoErro();

         //   }
        }
        return this;
    }

    public Corpo_suhai PreencheSexoDatNascEstCivil() throws IOException, InterruptedException {

        existerro = GerenciaErro.VerificaErro();
        if (existerro == false) {
            //try {


                WebDriverWait wait = new WebDriverWait(navegador, 10);
                list = LerArquivo.getList(list);
                sexo_condu = list.get(5);
                datacond = list.get(3);
                estado_civ = list.get(4);
                //preenche sexo
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"col-sm-2 col-md-2 col-lg-2\"]//select[@name=\"tGenero\"]")));
                 // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@clss=\"col-sm-2 col-md-2 col-lg-2\"]//select[@name=\"tGenero\"]")));

                Thread.sleep(1000);
                navegador.findElement(By.xpath("//div[@class=\"col-sm-2 col-md-2 col-lg-2\"]//select[@name=\"tGenero\"]")).sendKeys(sexo_condu);
                Thread.sleep(1000);
                //preenche data de nascimento
                navegador.findElement(By.xpath("//div[@class=\"col-sm-1 col-md-1 col-lg-1\"]//input[@ng-model=\"calculo.proponente.dt_Nascimento\"]")).clear();
                Thread.sleep(500);
                navegador.findElement(By.xpath("//div[@class=\"col-sm-1 col-md-1 col-lg-1\"]//input[@ng-model=\"calculo.proponente.dt_Nascimento\"]")).sendKeys(datacond);
                Thread.sleep(1000);
                navegador.findElement(By.xpath("//div[@class=\"col-sm-2 col-md-2 col-lg-2\"]//select[@name=\"tEstadoCivil\"]")).sendKeys(Keys.HOME);
                Thread.sleep(500);
                if (estado_civ.contains("D") || estado_civ.contains("V")) {
                    navegador.findElement(By.xpath("//div[@class=\"col-sm-2 col-md-2 col-lg-2\"]//select[@name=\"tEstadoCivil\"]")).sendKeys("separa");
                } else {
                    navegador.findElement(By.xpath("//div[@class=\"col-sm-2 col-md-2 col-lg-2\"]//select[@name=\"tEstadoCivil\"]")).sendKeys(estado_civ);
                }
                Thread.sleep(1000);
                navegador.findElement(By.xpath("//div[@class=\"col-sm-2 col-md-2 col-lg-2\"]//select[@name=\"tEstadoCivil\"]")).sendKeys(Keys.TAB);

       //     } catch (Exception e) {
    //            criaarquivoerro = GerenciaErro.CriarArquivoErro();

      //      }
        }


        return new Corpo_suhai(navegador);
    }
}
