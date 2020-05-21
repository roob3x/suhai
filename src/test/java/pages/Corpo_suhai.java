package pages;

import org.openqa.selenium.WebDriver;
import supporte.BasePage;

public class Corpo_suhai extends BasePage {
    public Corpo_suhai(WebDriver navegador) {
        super(navegador);
    }
    public DadosSegurado MetodosDadosSegurado(){
        return new DadosSegurado(navegador);
    }
    public DadosProponente MetodoDadosProponente(){
        return new DadosProponente(navegador);
    }
    public DadosVeiculo MetodoDadosVeiculo(){
        return new DadosVeiculo(navegador);
    }
    public PerguntaQuestionario MetodoPerguntaQuestionario(){
        return new PerguntaQuestionario(navegador);
    }
    public Imprimir MetodoImprimir(){
        return new Imprimir(navegador);
    }
}
