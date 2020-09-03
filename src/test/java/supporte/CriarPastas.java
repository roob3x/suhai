package supporte;

import java.io.File;

public class CriarPastas {
    public static File criarPastaArquivos(){
        File pastaarquivos = new File("/home/robertinho/suhai_perfil/arquivos");
        pastaarquivos.mkdir();
        return pastaarquivos;
    }
    public static File criarPastaPdf(){
        File pastaapdf = new File("/home/robertinho/suhai_perfil/pdf");
        pastaapdf.mkdir();
        return pastaapdf;
    }
    public static File criarPastaProntos(){
        File pastaprontos = new File("/home/robertinho/suhai_perfil/prontos");
        pastaprontos.mkdir();
        return pastaprontos;
    }
    public static File criarPastaTxt(){
        File pastatxt = new File("/home/robertinho/suhai_perfil/txt");
        pastatxt.mkdir();
        return pastatxt;
    }
    public static File criarPastaErro(){
        File pastaerro = new File("/home/robertinho/suhai_perfil/erro");
        pastaerro.mkdir();
        return pastaerro;
    }
    public static File criarPastaStatus(){
        File pastaerro = new File("/home/robertinho/suhai_perfil/status");
        pastaerro.mkdir();
        return pastaerro;
    }
    public static File criarPastacotacao(){
        File pastacotacao = new File("/home/robertinho/sompo_rd/cotacao");
        pastacotacao.mkdir();
        return pastacotacao;
    }
    public static File criarPastaimage(){
        File pastaimage = new File("/home/robertinho/suhai_perfil/images");
        pastaimage.mkdir();
        return pastaimage;
    }
}
