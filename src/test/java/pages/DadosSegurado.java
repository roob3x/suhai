package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import supporte.Variaveis;
import supporte.LerArquivoObjetos;
import supporte.PegarNrCotacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class DadosSegurado extends Variaveis {


    public DadosSegurado(WebDriver navegador) {
        super(navegador);
    }

    public DadosSegurado DigitaCpfNome(List<Variaveis> lista) throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(navegador, 10);
        cpf = lista.get(0).getCpf();
        nome = lista.get(0).getNome();
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
        return this;
    }

    public Corpo_suhai PreencheDadosSegurado(List<Variaveis>lista) throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(navegador, 10);

        existenrcotacao = PegarNrCotacao.VerificaCotacao();
        if (existenrcotacao == false) {
            DigitaCpfNome(lista);

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

        return new Corpo_suhai(navegador);
    }
}
