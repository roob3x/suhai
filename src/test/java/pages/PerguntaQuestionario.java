package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Key;
import org.sikuli.script.Screen;
import supporte.Variaveis;
import supporte.GerenciaErro;
import supporte.LerArquivoObjetos;

import java.io.IOException;
import java.util.List;

public class PerguntaQuestionario extends Variaveis {
    public PerguntaQuestionario(WebDriver navegador) {
        super(navegador);
    }

    public Corpo_suhai RespostaQuestionario(List<Variaveis> lista) throws IOException, InterruptedException {
        existerro = GerenciaErro.VerificaErro();
        if (existerro == false) {
            try {
            Screen screen = new Screen();
            WebDriverWait wait = new WebDriverWait(navegador, 10);
            utiliz = lista.get(0).getUtiliz();
            grgres = lista.get(0).getGrgres();
            grgtrab = lista.get(0).getGrgtrab();
            grgescola = lista.get(0).getGrgescola();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[@ng-repeat=\"item in calculo.itens[calculo.nr_Item - 1].questionario\"]//td[@class=\"text-center td-middle col-lg-4\"]//div[@class=\"form-group\"]//select[@ng-model=\"item.id_RespostaPerguntaQuestionario\"]")));
            Thread.sleep(1000);
            System.out.println("antes de colocar guarda veiculo");


            /**
             navegador.findElement(By.xpath("//tr[@ng-repeat=\"item in calculo.itens[calculo.nr_Item - 1].questionario\"]//td[@class=\"text-center td-middle col-lg-4\"]//div[@class=\"form-group\"]//select[@ng-model=\"item.id_RespostaPerguntaQuestionario\"]")).click();
             */
            /**
             int y = 0;
             while (y <= 3) {
             screen.type(Key.TAB);
             y++;
             }
             */
            Thread.sleep(500);
            navegador.findElement(By.xpath("//tr[@ng-repeat=\"item in calculo.itens[calculo.nr_Item - 1].questionario\"]//td[@class=\"text-center td-middle col-lg-4\"]//div[@class=\"form-group\"]//select[@ng-model=\"item.id_RespostaPerguntaQuestionario\"]")).sendKeys(Keys.END);
            Thread.sleep(500);
            navegador.findElement(By.xpath("//tr[@ng-repeat=\"item in calculo.itens[calculo.nr_Item - 1].questionario\"]//td[@class=\"text-center td-middle col-lg-4\"]//div[@class=\"form-group\"]//select[@ng-model=\"item.id_RespostaPerguntaQuestionario\"]")).sendKeys(Keys.HOME);
            Thread.sleep(500);
            if (utiliz.contains("COME")) {
                navegador.findElement(By.xpath("//tr[@ng-repeat=\"item in calculo.itens[calculo.nr_Item - 1].questionario\"]//td[@class=\"text-center td-middle col-lg-4\"]//div[@class=\"form-group\"]//select[@ng-model=\"item.id_RespostaPerguntaQuestionario\"]")).sendKeys(Keys.ARROW_DOWN);
            }
            if (utiliz.contains("Ex")) {
                //          navegador.findElement(By.xpath("//tr[@ng-repeat=\"item in calculo.itens[calculo.nr_Item - 1].questionario\"]//td[@class=\"text-center td-middle col-lg-4\"]//div[@class=\"form-group\"]//select[@ng-model=\"item.id_RespostaPerguntaQuestionario\"]")).sendKeys(Keys.ARROW_DOWN);
            }


            // navegador.findElement(By.xpath("//tr[@ng-repeat=\"item in calculo.itens[calculo.nr_Item - 1].questionario\"]//td[@class=\"text-center td-middle col-lg-4\"]//div[@class=\"form-group\"]//select[@ng-model=\"item.id_RespostaPerguntaQuestionario\"]")).sendKeys(Keys.ARROW_DOWN);
            // navegador.findElement(By.xpath("//tr[@ng-repeat=\"item in calculo.itens[calculo.nr_Item - 1].questionario\"]//td[@class=\"text-center td-middle col-lg-4\"]//div[@class=\"form-group\"]//select[@ng-model=\"item.id_RespostaPerguntaQuestionario\"]")).sendKeys(Keys.ENTER);

/**
            screen.type(Key.TAB);
            Thread.sleep(500);
            screen.type(Key.END);
            Thread.sleep(500);
 */
            //resp residencia
            screen.type(Key.TAB);
            Thread.sleep(500);
            screen.type(Key.END);
            Thread.sleep(500);
            screen.type(Key.HOME);

            if (grgres.contains("N")) {
                screen.type(getGrgres());
            }
            //resp trabalho
            screen.type(Key.TAB);
            Thread.sleep(500);
            screen.type(Key.END);
            Thread.sleep(500);
            screen.type(Key.HOME);
            if (grgtrab.contains("SIM")) {
                screen.type("u");
            } else {
                if (grgtrab.contains("NAO UT") || grgtrab.contains("NAO TR")) {

                } else {
                    screen.type("uu");

                }
            }
            //resp escola
            screen.type(Key.TAB);
            screen.type(Key.END);
            Thread.sleep(500);
            screen.type(Key.HOME);
            if (grgescola.contains("SIM")) {
                screen.type("u");
            } else {
                if (grgescola.contains("NAO UT") || grgescola.contains("NAO EST")) {

                } else {
                    screen.type("uu");

                }
            }
            screen.type(Key.TAB);
            //preenche vendedor
            navegador.findElement(By.xpath("//input[@ng-model=\"calculo.ds_NomeVendedor\"]")).clear();
            Thread.sleep(500);
            navegador.findElement(By.xpath("//input[@ng-model=\"calculo.ds_NomeVendedor\"]")).sendKeys("SAFE PRIME CORRETORA DE SEGUROS EIRELI - ME");
            Thread.sleep(500);
            navegador.findElement(By.xpath("//input[@ng-model=\"calculo.ds_NomeVendedor\"]")).sendKeys(Keys.TAB);

               }
              catch (Exception e){
                   criaarquivoerro = GerenciaErro.CriarArquivoErro();
               }
        }
        return new Corpo_suhai(navegador);
    }
}
