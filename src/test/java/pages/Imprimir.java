package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import supporte.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Imprimir extends BasePage {
    public Imprimir(WebDriver navegador) {
        super(navegador);
    }

    public Imprimir Calcular() throws InterruptedException, IOException {
        existerro = GerenciaErro.VerificaErro();
        if (existerro == false) {
            try {
                Thread.sleep(1000);
                navegador.findElement(By.id("btnCalcular")).click();
            } catch (Exception e) {
                criaarquivoerro = GerenciaErro.CriarArquivoErro();
            }
        }
        return this;
    }

    public Imprimir ClicaImprimir() throws InterruptedException, FindFailed, IOException {
        existerro = GerenciaErro.VerificaErro();
        if (existerro == false) {
            try {
                numlinha = PegarNrArquivo.getList(numlinha);
                nrlinha = numlinha.get(0);
                //System.out.println(numlinha);
                String nrlinha1 = nrlinha;
                nrlinha1 = nrlinha1.replace(".txt", "");
                nrlinha1 = nrlinha1.replace(".TXT", "");
                WebDriverWait wait = new WebDriverWait(navegador, 10);
                //espera ate que o elemento de clicar para imprimir esteja visivel
                try {
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class=\"btn btn-primary\"]//span[@class=\"fa fa-print\"]")));
                    navegador.findElement(By.xpath("//button[@class=\"btn btn-primary\"]//span[@class=\"fa fa-print\"]")).click();
                } catch (Exception e) {
                    criaarquivoerro = GerenciaErro.CriarArquivoErro();
                }
                Thread.sleep(2000);
                try {
                    //pega a pagina q do calculo
                    ArrayList<String> tabs2 = new ArrayList<String>(navegador.getWindowHandles());
                    //navegador.switchTo().window(tabs2.get(0));
                    navegador.switchTo().window(tabs2.get(1));

                } catch (Exception e) {
                    System.out.println("fail");
                }
                Thread.sleep(2000);

                Pattern ArrowUpPreImprimir = new Pattern("/home/robertinho/suhai_perfil/images/ArrowUpPreImprimir.png");
                Pattern iconedownload = new Pattern("/home/robertinho/suhai_perfil/images/iconedownload.png");
                Pattern salvarpdf = new Pattern("/home/robertinho/suhai_perfil/images/salvarpdf.png");


                Screen screen = new Screen();
                screen.click(ArrowUpPreImprimir);
                Thread.sleep(500);
                screen.click(iconedownload);
                Thread.sleep(5000);
                screen.type(Key.DELETE);
                //System.out.println(nrlinha);
                Thread.sleep(1000);
                /**
                 screen.type("/home/robertinho/suhai_perfil/pdf/");
                 Thread.sleep(1000);
                 int y = 0;
                 while (y <= 4) {
                 screen.type(Key.BACKSPACE);
                 y++;
                 }
                 screen.type(nrlinha1+".pdf");
                 */
                screen.type(Key.BACKSPACE);
                Thread.sleep(500);
                screen.type(Key.END);
                Thread.sleep(1000);
                int y = 0;
                while (y <= 4) {
                    screen.type(Key.BACKSPACE);
                    y++;
                }
                Thread.sleep(500);

                //screen.type("/home/robertinho/suhai_perfil/pdf/" + nrlinha1 + ".pdf");
                screen.type("/home/robertinho/suhai_perfil/pdf/" + nrlinha1 + ".pdf");

                Thread.sleep(1000);
                screen.click(salvarpdf);
//cria arquivo txt para validar se o arquivo calculou
                FileWriter arq = new FileWriter("/home/robertinho/suhai_perfil/txt/" + nrlinha);
                PrintWriter gravarArq = new PrintWriter(arq);
                gravarArq.flush();
                gravarArq.close();
                Thread.sleep(2000);

                int x = 0;
                while (x <= 3) {
                    screen.type(Key.ESC);
                    x++;
                }


                try {
                    //pega a pagina q do calculo
                    ArrayList<String> tabs2 = new ArrayList<String>(navegador.getWindowHandles());
                    //navegador.switchTo().window(tabs2.get(0));
                    navegador.switchTo().window(tabs2.get(1));
                    navegador.close();
                    navegador.switchTo().window(tabs2.get(0));

                } catch (Exception e) {
                    System.out.println("fail");
                }

            } catch (Exception e) {
                criaarquivoerro = GerenciaErro.CriarArquivoErro();
            }
        }
        return this;
    }

    public Imprimir VerificaSeCalculou() throws IOException, InterruptedException {
        existerro = GerenciaErro.VerificaErro();
        if (existerro == false) {
            try {
                list = LerArquivo.getList(list);
                nome = list.get(0);
                numlinha = PegarNrArquivo.getList(numlinha);
                File filearquivo = new File("/home/robertinho/suhai_perfil/arquivos/" + nrlinha);
                File filetxt = new File("/home/robertinho/suhai_perfil/txt/" + nrlinha);
                if (filetxt.exists() && filetxt.isFile()) {
                    //           System.out.println("arquivo processado");
                    if (filetxt.exists() && filetxt.isFile()) {
                        filearquivo.renameTo(new File("/home/robertinho/suhai_perfil/prontos/" + nrlinha));
                        numlinha.removeAll(numlinha);
                        list.clear();
                    }
                    filearquivo.delete();
                    filetxt.delete();
                    numlinha.indexOf(numlinha);
                    //list = LerArquivo.getList(numlinha);
                    numlinha = LerArquivo.getList(numlinha);

                    //System.out.println(nrlinha);
                    nrlinha = numlinha.get(0);
                    if (nrlinha.contains(nome)) {
                        //System.out.println("contem nome no nrlinha vou tentar tratar");
                        numlinha.removeAll(numlinha);
                        nrlinha = null;
                        //System.out.println("entrei para colocar novamente o nome pdf");
                        numlinha = PegarNrArquivo.getList(numlinha);
                        numlinha.removeAll(numlinha);
                        numlinha.indexOf(numlinha);
                        Thread.sleep(2000);

                    }


                }
            } catch (Exception e) {
                criaarquivoerro = GerenciaErro.CriarArquivoErro();
            }
        }
        return this;
    }
    public Imprimir PegarNrCotacao() throws IOException {
        existerro = GerenciaErro.VerificaErro();
        if(existerro == false){
            existenrcotacao = GerenciaNrCotacao.VerificaCotacao();
            if(existenrcotacao == false) {
                try {
                    WebElement elementocotacao = navegador.findElement(By.xpath("//h1[contains( text(), 'Cotação de Seguro')]"));
                    nrcotacao = elementocotacao.getText();
                    nrcotacao = nrcotacao.replace("Cotação de Seguro - Nº: ", "");
                    nrcotacao = nrcotacao.replace("/2020", "");
                    FileWriter arq = new FileWriter("/home/robertinho/suhai_perfil/cotacao/nrcotacao.txt");
                    PrintWriter gravarArq = new PrintWriter(arq);
                    gravarArq.println(nrcotacao);
                    gravarArq.flush();
                    gravarArq.close();
                }
                catch (Exception e){
                    criaarquivoerro = GerenciaErro.CriarArquivoErro();
                }
            }


        }
        return this;
    }

    public Corpo_suhai VerificaRelogar() throws IOException {
        File fileerro = new File("/home/robertinho/suhai_perfil/status/erro.txt");
        if (fileerro.exists() && fileerro.isFile()) {
            gravarArq = GerenciaLogar.CriarArquivoLogar();
            fileerro.delete();
            navegador.get("http://suhaiseguradoracotacao.com.br/login");
        }
        return new Corpo_suhai(navegador);
    }
}
