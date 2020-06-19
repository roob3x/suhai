package supporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

import java.io.File;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Variaveis {
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
    protected String dat_nasc_c;
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
    protected String nomepc="robertinho";


    public Variaveis(WebDriver navegador) {
        this.navegador = navegador;

    }
    // WebDriverWait wait = new WebDriverWait(navegador, 10);

    public Variaveis(RemoteWebDriver navegador, URL url, SessionId session_id, String excluircotacao, String corretor, String segmento,
                     String fazercotnova, String nrcotacao, String pegarcotacao, String cpf, String nome, String fipe,
                     String ano_modelo, String zero, String tipo_de_se, String congenere, String classe_bon, String sinistro,
                     String cep, String cepper, String dirige25, String sexo25, String idade25, String grgres, String grgtrab,
                     String grgescola, String utiliz, String franquia, String fatajust, String dm, String dc, String appmorte,
                     String ass24, String creser, String dmo, String vidro, String vigencia, String comissao, String temphab,
                     String cpfcond, String nomecond, String datacond, String sexo_condu, String estado_civ, String nrlinha
            , String is, PrintWriter criaarquivoerro, boolean existerro, String tipopessoa, String suhaimarca, String suhaiveic
    , boolean existenrcotacao, PrintWriter gravarArq, File deletararqlogar, File deletarerro,String nomepc,
                     String dat_nasc_c) {
        this.navegador = navegador;
        this.url = url;
        this.session_id = session_id;
        this.excluircotacao = excluircotacao;
        this.corretor = corretor;
        this.segmento = segmento;
        this.fazercotnova = fazercotnova;
        this.nrcotacao = nrcotacao;
        this.pegarcotacao = pegarcotacao;
        this.setCpf(cpf);
        this.setNome(nome);
        this.setFipe(fipe);
        this.setAno_modelo(ano_modelo);
        this.setZero(zero);
        this.setTipo_de_se(tipo_de_se);
        this.setCongenere(congenere);
        this.setClasse_bon(classe_bon);
        this.setSinistro(sinistro);
        this.setCep(cep);
        this.setCepper(cepper);
        this.setDirige25(dirige25);
        this.setSexo25(sexo25);
        this.setIdade25(idade25);
        this.setGrgres(grgres);
        this.setGrgtrab(grgtrab);
        this.setGrgescola(grgescola);
        this.setUtiliz(utiliz);
        this.setFranquia(franquia);
        this.setFatajust(fatajust);
        this.setDm(dm);
        this.setDc(dc);
        this.setAppmorte(appmorte);
        this.setAss24(ass24);
        this.setCreser(creser);
        this.setDmo(dmo);
        this.setVidro(vidro);
        this.setComissao(comissao);
        this.setTemphab(temphab);
        this.setCpfcond(cpfcond);
        this.setNomecond(nomecond);
        this.setDatacond(datacond);
        this.setSexo_condu(sexo_condu);
        this.setEstado_civ(estado_civ);
        this.is = is;
        this.criaarquivoerro = criaarquivoerro;
        this.existerro = existerro;
        this.farolauxiliar = farolauxiliar;
        this.setTipopessoa(tipopessoa);
        this.setSuhaimarca(suhaimarca);
        this.setSuhaiveic(suhaiveic);
        this.existenrcotacao = existenrcotacao;
        this.gravarArq = gravarArq;
        this.deletararqlogar = deletararqlogar;
        this.deletarerro = deletarerro;
        this.nomepc = nomepc;
        this.dat_nasc_c = dat_nasc_c;


    }

    public static List<String> getNumlinha() {

        return numlinha;
    }

    public static void setNumlinha(List<String> numlinha) {

        Variaveis.numlinha = numlinha;
    }

    public static List<String> getList() {

        return list;
    }

    public static void setList(List<String> list) {

        Variaveis.list = list;
    }

    public static List<String> getNmpdf() {

        return nmpdf;
    }

    public static void setNmpdf(List<String> nmpdf) {

        Variaveis.nmpdf = nmpdf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCepper() {
        return cepper;
    }

    public void setCepper(String cepper) {
        this.cepper = cepper;
    }

    public String getFranquia() {
        return franquia;
    }

    public void setFranquia(String franquia) {
        this.franquia = franquia;
    }

    public String getAno_modelo() {
        return ano_modelo;
    }

    public void setAno_modelo(String ano_modelo) {
        this.ano_modelo = ano_modelo;
    }

    public String getZero() {
        return zero;
    }

    public void setZero(String zero) {
        this.zero = zero;
    }

    public String getFipe() {
        return fipe;
    }

    public void setFipe(String fipe) {
        this.fipe = fipe;
    }

    public String getTipo_de_se() {
        return tipo_de_se;
    }

    public void setTipo_de_se(String tipo_de_se) {
        this.tipo_de_se = tipo_de_se;
    }

    public String getClasse_bon() {
        return classe_bon;
    }

    public void setClasse_bon(String classe_bon) {
        this.classe_bon = classe_bon;
    }

    public String getSinistro() {
        return sinistro;
    }

    public void setSinistro(String sinistro) {
        this.sinistro = sinistro;
    }

    public String getCongenere() {
        return congenere;
    }

    public void setCongenere(String congenere) {
        this.congenere = congenere;
    }

    public String getDm() {
        return dm;
    }

    public void setDm(String dm) {
        this.dm = dm;
    }

    public String getDc() {
        return dc;
    }

    public void setDc(String dc) {
        this.dc = dc;
    }

    public String getComissao() {
        return comissao;
    }

    public void setComissao(String comissao) {
        this.comissao = comissao;
    }

    public String getFatajust() {
        return fatajust;
    }

    public void setFatajust(String fatajust) {
        this.fatajust = fatajust;
    }

    public String getAntifurto() {
        return antifurto;
    }

    public void setAntifurto(String antifurto) {
        this.antifurto = antifurto;
    }

    public String getUtiliz() {
        return utiliz;
    }

    public void setUtiliz(String utiliz) {
        this.utiliz = utiliz;
    }

    public String getTiporesid() {
        return tiporesid;
    }

    public void setTiporesid(String tiporesid) {
        this.tiporesid = tiporesid;
    }

    public String getAss24() {
        return ass24;
    }

    public void setAss24(String ass24) {
        this.ass24 = ass24;
    }

    public String getCreser() {
        return creser;
    }

    public void setCreser(String creser) {
        this.creser = creser;
    }

    public String getVidro() {
        return vidro;
    }

    public void setVidro(String vidro) {
        this.vidro = vidro;
    }

    public String getGrgres() {
        return grgres;
    }

    public void setGrgres(String grgres) {
        this.grgres = grgres;
    }

    public String getGrgtrab() {
        return grgtrab;
    }

    public void setGrgtrab(String grgtrab) {
        this.grgtrab = grgtrab;
    }

    public String getGrgescola() {
        return grgescola;
    }

    public void setGrgescola(String grgescola) {
        this.grgescola = grgescola;
    }

    public String getDmo() {
        return dmo;
    }

    public void setDmo(String dmo) {
        this.dmo = dmo;
    }

    public String getAppmorte() {
        return appmorte;
    }

    public void setAppmorte(String appmorte) {
        this.appmorte = appmorte;
    }

    public String getResid25() {
        return resid25;
    }

    public void setResid25(String resid25) {
        this.resid25 = resid25;
    }

    public String getIdade25() {
        return idade25;
    }

    public void setIdade25(String idade25) {
        this.idade25 = idade25;
    }

    public String getSexo25() {
        return sexo25;
    }

    public void setSexo25(String sexo25) {
        this.sexo25 = sexo25;
    }

    public String getDirige25() {
        return dirige25;
    }

    public void setDirige25(String dirige25) {
        this.dirige25 = dirige25;
    }

    public String getSexo_condu() {
        return sexo_condu;
    }

    public void setSexo_condu(String sexo_condu) {
        this.sexo_condu = sexo_condu;
    }

    public String getSegecond() {
        return segecond;
    }

    public void setSegecond(String segecond) {
        this.segecond = segecond;
    }

    public String getCond_princ() {
        return cond_princ;
    }

    public void setCond_princ(String cond_princ) {
        this.cond_princ = cond_princ;
    }

    public String getNomecond() {
        return nomecond;
    }

    public void setNomecond(String nomecond) {
        this.nomecond = nomecond;
    }

    public String getCpfcond() {
        return cpfcond;
    }

    public void setCpfcond(String cpfcond) {
        this.cpfcond = cpfcond;
    }

    public String getEstado_civ() {
        return estado_civ;
    }

    public void setEstado_civ(String estado_civ) {
        this.estado_civ = estado_civ;
    }

    public String getDatacond() {
        return datacond;
    }

    public void setDatacond(String datacond) {
        this.datacond = datacond;
    }

    public String getTemphab() {
        return temphab;
    }

    public void setTemphab(String temphab) {
        this.temphab = temphab;
    }

    public String getBlindagem() {
        return blindagem;
    }

    public void setBlindagem(String blindagem) {
        this.blindagem = blindagem;
    }

    public String getNrlinha() {
        return nrlinha;
    }

    public void setNrlinha(String nrlinha) {
        this.nrlinha = nrlinha;
    }

    public String getTipopessoa() {
        return tipopessoa;
    }

    public void setTipopessoa(String tipopessoa) {
        this.tipopessoa = tipopessoa;
    }

    public String getSuhaimarca() {
        return suhaimarca;
    }

    public void setSuhaimarca(String suhaimarca) {
        this.suhaimarca = suhaimarca;
    }

    public String getSuhaiveic() {
        return suhaiveic;
    }

    public void setSuhaiveic(String suhaiveic) {
        this.suhaiveic = suhaiveic;
    }

    public String getDat_nasc_c() {
        return dat_nasc_c;
    }

    public void setDat_nasc_c(String dat_nasc_c) {
        this.dat_nasc_c = dat_nasc_c;
    }
}
