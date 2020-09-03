package pages;

import org.openqa.selenium.WebDriver;
import supporte.Variaveis;

public class Corpo_suhai extends Variaveis {
    public Corpo_suhai(WebDriver navegador) {
        super(navegador);
    }
    public DadosSegurado metodosDadosSegurado(){

        return new DadosSegurado(navegador);
    }
    public DadosProponente metodoDadosProponente(){

        return new DadosProponente(navegador);
    }
    public DadosVeiculo metodoDadosVeiculo(){

        return new DadosVeiculo(navegador);
    }
    public PerguntaQuestionario metodoPerguntaQuestionario(){
        return new PerguntaQuestionario(navegador);
    }
    public Imprimir metodoImprimir(){

        return new Imprimir(navegador);
    }
}
