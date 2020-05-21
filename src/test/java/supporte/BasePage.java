package supporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

import java.io.File;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BasePage {
    public int o;
    protected WebDriver navegador;
    protected URL url;
    protected SessionId session_id;
    protected String excluircotacao;
    protected String corretor;
    protected String segmento;
    protected String fazercotnova;
    protected String nrcotacao;
    protected String pegarcotacao;


    protected String cpf;
    protected String nome;
    protected String cep;
    protected String cepper;
    protected String franquia;
    protected String ano_modelo;
    protected String zero;
    protected String fipe;
    protected String tipo_de_se;
    protected String classe_bon;
    protected String sinistro;
    protected String congenere;
    protected String dm;
    protected String dc;
    protected String comissao;
    protected String fatajust;
    protected String antifurto;
    protected String utiliz;
    protected String tiporesid;
    protected String ass24;
    protected String creser;
    protected String vidro;
    protected String grgres;
    protected String grgtrab;
    protected String grgescola;
    protected String dmo;
    protected String appmorte;
    protected String resid25;
    protected String idade25;
    protected String sexo25;
    protected String dirige25;
    protected String sexo_condu;
    protected String segecond;
    protected String cond_princ;
    protected String nomecond;
    protected String cpfcond;
    protected String estado_civ;
    protected String datacond;
    protected String temphab;
    protected String blindagem;
    protected String is;
    protected String nrlinha;
    protected PrintWriter criaarquivoerro;
    protected PrintWriter gravarArq;
    protected boolean existerro;
    protected String farolauxiliar;
    protected String tipopessoa;
    protected String suhaimarca;
    protected String suhaiveic;
    protected boolean existenrcotacao;
    protected File deletararqlogar;
    protected static List<String> list = new ArrayList<String>();
    protected static List<String> numlinha = new ArrayList<String>();
    protected static List<String> nmpdf = new ArrayList<String>();
    protected  File deletarerro;


    public BasePage(WebDriver navegador) {
        this.navegador = navegador;

    }
    // WebDriverWait wait = new WebDriverWait(navegador, 10);

    public BasePage(RemoteWebDriver navegador, URL url, SessionId session_id, String excluircotacao, String corretor, String segmento,
                    String fazercotnova, String nrcotacao, String pegarcotacao, String cpf, String nome, String fipe,
                    String ano_modelo, String zero, String tipo_de_se, String congenere, String classe_bon, String sinistro,
                    String cep, String cepper, String dirige25, String sexo25, String idade25, String grgres, String grgtrab,
                    String grgescola, String utiliz, String franquia, String fatajust, String dm, String dc, String appmorte,
                    String ass24, String creser, String dmo, String vidro, String vigencia, String comissao, String temphab,
                    String cpfcond, String nomecond, String datacond, String sexo_condu, String estado_civ, String nrlinha
            , String is, PrintWriter criaarquivoerro, boolean existerro, String tipopessoa,String suhaimarca,String suhaiveic
    ,boolean existenrcotacao,PrintWriter gravarArq,File deletararqlogar, File deletarerro) {
        this.navegador = navegador;
        this.url = url;
        this.session_id = session_id;
        this.excluircotacao = excluircotacao;
        this.corretor = corretor;
        this.segmento = segmento;
        this.fazercotnova = fazercotnova;
        this.nrcotacao = nrcotacao;
        this.pegarcotacao = pegarcotacao;
        this.cpf = cpf;
        this.nome = nome;
        this.fipe = fipe;
        this.ano_modelo = ano_modelo;
        this.zero = zero;
        this.tipo_de_se = tipo_de_se;
        this.congenere = congenere;
        this.classe_bon = classe_bon;
        this.sinistro = sinistro;
        this.cep = cep;
        this.cepper = cepper;
        this.dirige25 = dirige25;
        this.sexo25 = sexo25;
        this.idade25 = idade25;
        this.grgres = grgres;
        this.grgtrab = grgtrab;
        this.grgescola = grgescola;
        this.utiliz = utiliz;
        this.franquia = franquia;
        this.fatajust = fatajust;
        this.dm = dm;
        this.dc = dc;
        this.appmorte = appmorte;
        this.ass24 = ass24;
        this.creser = creser;
        this.dmo = dmo;
        this.vidro = vidro;
        this.comissao = comissao;
        this.temphab = temphab;
        this.cpfcond = cpfcond;
        this.nomecond = nomecond;
        this.datacond = datacond;
        this.sexo_condu = sexo_condu;
        this.estado_civ = estado_civ;
        this.is = is;
        this.criaarquivoerro = criaarquivoerro;
        this.existerro = existerro;
        this.farolauxiliar = farolauxiliar;
        this.tipopessoa = tipopessoa;
        this.suhaimarca = suhaimarca;
        this.suhaiveic = suhaiveic;
        this.existenrcotacao = existenrcotacao;
        this.gravarArq = gravarArq;
        this.deletararqlogar = deletararqlogar;
        this.deletarerro = deletarerro;


    }

    public static List<String> getNumlinha() {

        return numlinha;
    }

    public static void setNumlinha(List<String> numlinha) {

        BasePage.numlinha = numlinha;
    }

    public static List<String> getList() {

        return list;
    }

    public static void setList(List<String> list) {

        BasePage.list = list;
    }

    public static List<String> getNmpdf() {

        return nmpdf;
    }

    public static void setNmpdf(List<String> nmpdf) {

        BasePage.nmpdf = nmpdf;
    }

}
