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
    private static  WebDriver navegador;
    private String segmento;
    private String nrlinha;
    private PrintWriter gravarArq;
    private File deletarerro;
    private  String nrlinha1;
    private static List<String> numlinha = new ArrayList<String>();
    private static List<String> list = new ArrayList<String>();
    private static List<String> nmpdf = new ArrayList<String>();

    private boolean existelogar;
    private static String nomevm;
    private static PrintWriter gravarArq1;
    private String caminhomoverarquivo;



    private static File pastaarquivos;
    private static File pastaapdf;
    private static File pastaprontos;
    private static File pastatxt;
    private static File pastaerro;
    private static File pastastatus;
    private static File pastacotacao;
    private static File pastaimage;

     @BeforeClass
    public static void criarpastinha() throws IOException {
        File destpastamae = new File("/home/robertinho/suhai_perfil");
        destpastamae.mkdir();
        pastaarquivos = CriarPastas.CriarPastaArquivos();
        pastaapdf = CriarPastas.CriarPastaPdf();
        pastaprontos = CriarPastas.CriarPastaProntos();
        pastatxt = CriarPastas.CriarPastaTxt();
        pastaerro = CriarPastas.CriarPastaErro();
        pastastatus = CriarPastas.CriarPastaStatus();
        pastacotacao = CriarPastas.CriarPastacotacao();
        pastaimage = CriarPastas.CriarPastaimage();



        //diretorio de onde vai copiar a pasta mae
        File sourcefreenaspastamae = new File("/run/user/1000/gvfs/smb-share:server=freenas.local,share=arquivosgerais/Macro certa/selenium/outros/ferramentas");
        //diretorio de onde vai copiar a pasta na vm
        destpastamae = new File("/home/robertinho/ferramentas");
        destpastamae.mkdir();
        FileUtils.copyDirectory(sourcefreenaspastamae, destpastamae);

        //cria arquivo com o nome da vm caso nao exista
        gravarArq1 = PegarNomeVm.CriarNomeVM();
        //ler o nome da vm
        nomevm = PegarNomeVm.NomeVm(nomevm);
        // caminho de onde ira pegar os arquivos
        File diretorio = new File("/run/user/1000/gvfs/smb-share:server=freenas.local,share=arquivosgerais/E/LABSEG/apolice/result/SUHAI/PRONTOS/distribuir/" + nomevm + "/");
        File destino = new File("/home/robertinho/suhai_perfil/arquivos/");
//distribui os arquivos para a vm
        if (diretorio.exists()) {
            FileUtils.copyDirectory(diretorio, destino);
            FileUtils.deleteDirectory(diretorio);
        }

        File directoryresumo = new File("/run/user/1000/gvfs/smb-share:server=freenas.local,share=arquivosgerais/E/LABSEG/apolice/result/SUHAI/PRONTOS/cotacao/");
        File destresumo = new File("/home/robertinho/suhai_perfil/cotacao/");
        destresumo.mkdir();
        FileUtils.copyDirectory(directoryresumo,destresumo);
        File directoryimage = new File("/run/user/1000/gvfs/smb-share:server=freenas.local,share=arquivosgerais/E/LABSEG/apolice/result/suhai/PRONTOS/images/");
        File destimage = new File("/home/robertinho/suhai_perfil/images/");
        destimage.mkdir();
        FileUtils.copyDirectory(directoryimage,destimage);


    }

    @Before
    public void setUp() throws IOException, FindFailed, InterruptedException {
        deletarerro = GerenciaErro.DeletarArquivoerro();
        navegador = web.createChrome();
        gravarArq = GerenciaLogar.CriarArquivoLogar();

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


            existelogar = GerenciaLogar.VerificaLogar();
            if (existelogar == true) {
                new LoginForPage(navegador)
                        .LogarSite(listateste);
            }
            new Corpo_suhai(navegador)
                    .MetodoDadosProponente()
                    .TipoPessoa(listateste)
                    .PreencheNomeCpfProponente(listateste)
                    .PreencheSexoDatNascEstCivil(listateste)
                    .MetodoDadosVeiculo()
                    .AnoFabriModeloZeroKM(listateste)
                    .MarcaModeloVeicUtiliz(listateste)
                    .TipoSeguro(listateste)
                    .InserirCepeComissao(listateste)
                    .MetodoPerguntaQuestionario()
                    .RespostaQuestionario(listateste)
                    .MetodoImprimir()
                    .Calcular()
                    .ClicaImprimir(listateste)
                    .VerificaSeCalculou(listateste)
                    .PegarNrCotacao()
                    .VerificaRelogar();

            numlinha.removeAll(numlinha);


        }
    }

    @After
    public void recolherArquivos() throws IOException {

        // caminhomoverarquivo = LerArquivosDiretorio.CaminhoRecolherArquivo(caminhomoverarquivo);
        Scanner ler = new Scanner("/home/robertinho/ferramentas/mover/suhai_perfil/CaminhoMoverArquivo.txt");
        String nome1 = ler.nextLine();
        FileReader arq = new FileReader(nome1);
        BufferedReader LerArquivo = new BufferedReader(arq);
        caminhomoverarquivo = LerArquivo.readLine();


        File directory = new File("/home/robertinho/suhai_perfil/");


        File arquivos = new File(directory + "/arquivos/");
        File pdf = new File(directory + "/pdf/");
        File prontos = new File(directory + "/prontos/");


        File destArquivos = new File(caminhomoverarquivo + "/arquivos/");
        destArquivos.mkdir();
        File destPDF = new File(caminhomoverarquivo + "/pdf/");
        destPDF.mkdir();
        File destProntos = new File(caminhomoverarquivo + "/prontos/");
        destProntos.mkdir();


        File dest1 = new File("/home/robertinho/suhai_perfil/vmlinuxbackup");
        FileUtils.deleteDirectory(dest1);
        dest1.mkdir();

        File arquivosbackup = new File(dest1 + "/arquivos");
        arquivosbackup.delete();
        arquivosbackup.mkdir();
        File pdfbackup = new File(dest1 + "/pdf");
        pdfbackup.delete();
        pdfbackup.mkdir();
        File prontosbackup = new File(dest1 + "/prontos");
        prontosbackup.delete();
        prontosbackup.mkdir();

        File errobackup = new File(dest1 + "/erro");
        errobackup.delete();
        errobackup.mkdir();


//copia para o freenas
        FileUtils.copyDirectory(arquivos, destArquivos);
        FileUtils.copyDirectory(pdf, destPDF);
        FileUtils.copyDirectory(prontos, destProntos);
        //copia o backup para a vm
        FileUtils.copyDirectory(arquivos, arquivosbackup);
        FileUtils.copyDirectory(pdf, pdfbackup);
        FileUtils.copyDirectory(prontos, prontosbackup);


        FileUtils.deleteDirectory(arquivos);
        FileUtils.deleteDirectory(pdf);
        FileUtils.deleteDirectory(prontos);


        arquivos.mkdir();
        pdf.mkdir();
        prontos.mkdir();

    }
    @AfterClass
    public static void FecharNavegador(){
         navegador.quit();
    }


}
