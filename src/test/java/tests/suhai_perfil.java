package tests;

import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import pages.Corpo_suhai;
import pages.LoginForPage;
import supporte.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class suhai_perfil {
    private static WebDriver navegador;
    private String segmento;
    private String nrlinha;
    private PrintWriter gravarArq;
    private File deletarerro;
    private String nrlinha1;
    private static List<String> numlinha = new ArrayList<String>();
    private static List<String> list = new ArrayList<String>();
    private static List<String> nmpdf = new ArrayList<String>();

    private boolean existelogar;


    @BeforeClass
    public static void inicioDistribuir() throws IOException {
        Distribuir distribuir = new Distribuir();
        distribuir.distribuirArquivos();

    }

    @Before
    public void setUp() throws IOException, FindFailed, InterruptedException {
        deletarerro = GerenciaErro.DeletarArquivoerro();
        navegador = web.createChrome();
        gravarArq = GerenciaLogar.criarArquivoLogar();

    }

    @Test
    public void testSuhai() throws IOException, InterruptedException, FindFailed {
        boolean verificaFim = false;
        PegarNrArquivo nrlinha1 = new PegarNrArquivo(navegador);

        while (verificaFim == false) {
            ArrayList<String> listaNr = nrlinha1.carregarArquivos();

            nrlinha = listaNr.get(0);
            LerArquivoObjetos arquivo = new LerArquivoObjetos(navegador);
            List<Variaveis> listateste;
            listateste = arquivo.lerArquivoNr(nrlinha);


            existelogar = GerenciaLogar.verificaLogar();
            if (existelogar == true) {
                new LoginForPage(navegador)
                        .LogarSite(listateste);
            }
            new Corpo_suhai(navegador)
                    .metodoDadosProponente()
                    .tipoPessoa(listateste)
                    .preencheNomeCpfProponente(listateste)
                    .preencheSexoDatNascEstCivil(listateste)
                    .metodoDadosVeiculo()
                    .anoFabriModeloZeroKM(listateste)
                    .marcaModeloVeicUtiliz(listateste)
                    .tipoSeguro(listateste)
                    .inserirCepeComissao(listateste)
                    .metodoPerguntaQuestionario()
                    .respostaQuestionario(listateste)
                    .metodoImprimir()
                    .calcular()
                    .clicaImprimir(listateste)
                    .verificaSeCalculou(listateste)
                    .pegarNrCotacao()
                    .verificaRelogar();

            numlinha.removeAll(numlinha);


        }
    }

    @After
    public void inicioRecolher() throws IOException {
        Recolher recolher = new Recolher();
        recolher.recolherArquivos();


    }

    @AfterClass
    public static void fecharNavegador() {
        navegador.quit();
    }


}
