package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import supporte.BasePage;
import supporte.GerenciaErro;
import supporte.LerArquivo;

import java.io.IOException;

public class DadosVeiculo extends BasePage {
    public DadosVeiculo(WebDriver navegador) {
        super(navegador);
    }

    public DadosVeiculo AnoFabriModeloZeroKM() throws InterruptedException, IOException {
        existerro = GerenciaErro.VerificaErro();
        if (existerro == false) {
            try {
                list = LerArquivo.getList(list);
                ano_modelo = list.get(9);
                suhaiveic = list.get(12);

                if(suhaiveic.contains("XMAX 250 ABS")){
                    ano_modelo = "2021";
                }

                Thread.sleep(1000);
                navegador.findElement(By.xpath("//select[@name=\"tAnoFabricacao\"]")).sendKeys(Keys.END);
                Thread.sleep(500);
                navegador.findElement(By.xpath("//select[@name=\"tAnoFabricacao\"]")).sendKeys(Keys.ENTER);
                Thread.sleep(500);
                navegador.findElement(By.xpath("//select[@name=\"tAnoFabricacao\"]")).sendKeys(ano_modelo);
                Thread.sleep(1000);
                navegador.findElement(By.xpath("//select[@name=\"tAnoModelo\"]")).sendKeys(ano_modelo);
                Thread.sleep(1000);
                navegador.findElement(By.xpath("//select[@name=\"tAnoModelo\"]")).sendKeys(ano_modelo);
                Thread.sleep(1000);

            } catch (Exception e) {
                criaarquivoerro = GerenciaErro.CriarArquivoErro();
            }
        }

        return this;
    }

    public DadosVeiculo MarcaModeloVeicUtiliz() throws InterruptedException, IOException {
        existerro = GerenciaErro.VerificaErro();
        if (existerro == false) {
            try {
                list = LerArquivo.getList(list);
                suhaimarca = list.get(11);
                suhaiveic = list.get(12);
                if (suhaimarca.contains("HD")) {
                    suhaimarca = "HONDA";
                }
                if (suhaiveic.contains("Dafra - Citycom S 300i")) {
                    suhaiveic = "Citycom S 300i";
                }
                if (suhaiveic.contains("CBR 1000 RR Fireblade")) {
                    suhaiveic = "CBR 1000 RR Fire Blade";
                }
                if (suhaiveic.contains("TIGER 1200 XC EXPLORER")) {
                    suhaiveic = "TIGER 1200XC EXPLORER";
                }
                if (suhaiveic.contains("CVO STREET GLIDE FLHXSE")) {
                    suhaiveic = "CVO STREET GLIDE FXSBSE";
                }
                if (suhaiveic.contains("MULTISTRADA 1200 S Pikes Peak")) {
                    suhaiveic = "MultiStrada 1200 S  Touring 1198cc";
                }
                if (suhaiveic.contains("HERITAGE SOFTAIL CLASSIC FLSTC")) {
                    suhaiveic = "HERITAGE SOFTAIL Classic";
                }
                if (suhaiveic.contains("G 650 GS SERT�O")) {
                    suhaiveic = "G 650 GS SERTÃO";
                }
                if (suhaiveic.contains("MULTISTRADA 1200 S 1198cc")) {
                    suhaiveic = "MultiStrada 1200 S 1198 cc";
                }
                if (suhaiveic.contains("FAT BOY FLSTF")) {
                    suhaiveic = "FAT BOY";
                }

                utiliz = list.get(20);
                Thread.sleep(1000);
                //apaga campo marca suhai
                navegador.findElement(By.xpath("//div[@class=\" inner-addon right-addon\"]//input[@name=\"tMarca\"]")).clear();
                Thread.sleep(1000);
                //preenche marca
                navegador.findElement(By.xpath("//div[@class=\" inner-addon right-addon\"]//input[@name=\"tMarca\"]")).sendKeys(suhaimarca);
                Thread.sleep(1000);
                //da tab para carregar a marca
                navegador.findElement(By.xpath("//div[@class=\" inner-addon right-addon\"]//input[@name=\"tMarca\"]")).sendKeys(Keys.TAB);

                //apaga campo modelo suhai
                navegador.findElement(By.xpath("//div[@class=\"form-group\"]//input[@name=\"tVeiculo\"]")).clear();
                Thread.sleep(1000);
                //preenche modelo
                navegador.findElement(By.xpath("//div[@class=\"form-group\"]//input[@name=\"tVeiculo\"]")).sendKeys(suhaiveic);
                Thread.sleep(1000);
                //da tab para carregar o modelo
                navegador.findElement(By.xpath("//div[@class=\"form-group\"]//input[@name=\"tVeiculo\"]")).sendKeys(Keys.TAB);
                Thread.sleep(1000);
//preenche combustivel
                navegador.findElement(By.xpath("//div[@ng-class=\"{'has-error' : form.tCombustivel.$invalid && form.$submitted}\"]//select[@name=\"tCombustivel\"]")).sendKeys("gasolina");

//preenche utilizacao veiculo
                Thread.sleep(1000);
                navegador.findElement(By.xpath("//div[@ng-class=\"{'has-error' : form.tUtilizacao.$invalid && form.$submitted}\"]//select[@name=\"tUtilizacao\"]")).sendKeys(Keys.HOME);
                Thread.sleep(500);
                /**
                 if (utiliz.contains("Ex")|| utiliz.contains("EX")){
                 navegador.findElement(By.xpath("//div[@ng-class=\"{'has-error' : form.tUtilizacao.$invalid && form.$submitted}\"]//select[@name=\"tUtilizacao\"]")).sendKeys("exc");
                 }
                 */
                navegador.findElement(By.xpath("//div[@ng-class=\"{'has-error' : form.tUtilizacao.$invalid && form.$submitted}\"]//select[@name=\"tUtilizacao\"]")).sendKeys("part");


                Thread.sleep(500);
                navegador.findElement(By.xpath("//div[@ng-class=\"{'has-error' : form.tUtilizacao.$invalid && form.$submitted}\"]//select[@name=\"tUtilizacao\"]")).sendKeys(Keys.TAB);

            } catch (Exception e) {
                criaarquivoerro = GerenciaErro.CriarArquivoErro();
            }
        }
        return this;
    }

    public DadosVeiculo TipoSeguro() throws InterruptedException, IOException {
        existerro = GerenciaErro.VerificaErro();
        if (existerro == false) {
            try {
                list = LerArquivo.getList(list);
                tipo_de_se = list.get(6);
                classe_bon = list.get(7);
                zero = list.get(10);


                Thread.sleep(1000);
                //seg novo
                navegador.findElement(By.xpath("//div[@class=\"form-group\"]//select[@name=\"tTipoSeguro\"]")).sendKeys(Keys.HOME);
                if (tipo_de_se.contains("RENO")) {
                    navegador.findElement(By.xpath("//div[@class=\"form-group\"]//select[@name=\"tTipoSeguro\"]")).sendKeys(Keys.END);
                }
                navegador.findElement(By.xpath("//div[@class=\"form-group\"]//select[@name=\"tTipoSeguro\"]")).sendKeys(Keys.TAB);
                Thread.sleep(1000);
                if (tipo_de_se.contains("RENO")) {
                    navegador.findElement(By.xpath("//div[@class=\"col-sm-1 col-md-1 col-lg-1\"]//select[@name=\"tBonus\"]")).sendKeys(Keys.HOME);
                    Thread.sleep(500);
                    navegador.findElement(By.xpath("//div[@class=\"col-sm-1 col-md-1 col-lg-1\"]//select[@name=\"tBonus\"]")).sendKeys(classe_bon);
                    Thread.sleep(500);
                    navegador.findElement(By.xpath("//div[@class=\"col-sm-1 col-md-1 col-lg-1\"]//select[@name=\"tBonus\"]")).sendKeys(Keys.TAB);

                }

                if (zero.contains("S")) {
                    System.out.println("vou tentar colocar zero km");
                    Pattern btnzerokm = new Pattern("/home/robertinho/suhai_perfil/images/zerokm.png");
                    Screen screen = new Screen();
                    screen.click(btnzerokm);

                }
            } catch (Exception e) {
                criaarquivoerro = GerenciaErro.CriarArquivoErro();

            }
        }
        return this;
    }

    public Corpo_suhai InserirCepeComissao() throws InterruptedException, IOException {
        existerro = GerenciaErro.VerificaErro();
        if (existerro == false) {
            try {
                list = LerArquivo.getList(list);
                cep = list.get(2);
                comissao = list.get(19);
                //preenche comissao
                navegador.findElement(By.xpath("//div[@ng-class=\"{'has-error' : form.tFatorComissao.$invalid && form.$submitted}\"]//select[@name=\"tFatorComissao\"]")).click();
                Thread.sleep(500);
                navegador.findElement(By.xpath("//div[@ng-class=\"{'has-error' : form.tFatorComissao.$invalid && form.$submitted}\"]//select[@name=\"tFatorComissao\"]")).sendKeys(Keys.HOME);
                Thread.sleep(500);
                navegador.findElement(By.xpath("//div[@ng-class=\"{'has-error' : form.tFatorComissao.$invalid && form.$submitted}\"]//select[@name=\"tFatorComissao\"]")).sendKeys(comissao);
                Thread.sleep(500);
                navegador.findElement(By.xpath("//div[@ng-class=\"{'has-error' : form.tFatorComissao.$invalid && form.$submitted}\"]//select[@name=\"tFatorComissao\"]")).sendKeys(Keys.ENTER);
                //preenche cep
                Thread.sleep(1000);
                navegador.findElement(By.xpath("//div[@class=\"col-sm-2 col-md-2 col-lg-2\"]//input[@ng-model=\"calculo.itens[calculo.nr_Item - 1].nr_CepPernoite\"]")).clear();
                Thread.sleep(500);
                navegador.findElement(By.xpath("//div[@class=\"col-sm-2 col-md-2 col-lg-2\"]//input[@ng-model=\"calculo.itens[calculo.nr_Item - 1].nr_CepPernoite\"]")).sendKeys(cep);
                Thread.sleep(500);
                navegador.findElement(By.xpath("//div[@class=\"col-sm-2 col-md-2 col-lg-2\"]//input[@ng-model=\"calculo.itens[calculo.nr_Item - 1].nr_CepPernoite\"]")).sendKeys(Keys.TAB);
                Thread.sleep(1000);

                try {
                    WebElement elementorastreador = navegador.findElement(By.xpath("//select[@ng-options=\"i.id_TipoInstalacaoAntiFurto as i.ds_Descricao for i in tipoInstalacaoAntiFurtoFiltrado\"]"));
                    if (elementorastreador.isEnabled()) {
                        elementorastreador.sendKeys("d");
                    }
                } catch (Exception e) {

                }
            } catch (Exception e) {
                criaarquivoerro = GerenciaErro.CriarArquivoErro();
            }
        }
        return new Corpo_suhai(navegador);
    }
}
