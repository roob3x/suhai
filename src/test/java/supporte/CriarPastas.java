package supporte;

import java.io.File;

public class CriarPastas {
    public static File CriarPastaArquivos(){
        File pastaarquivos = new File("/home/robertinho/suhai_perfil/arquivos");
        pastaarquivos.mkdir();
        return pastaarquivos;
    }
    public static File CriarPastaPdf(){
        File pastaapdf = new File("/home/robertinho/suhai_perfil/pdf");
        pastaapdf.mkdir();
        return pastaapdf;
    }
    public static File CriarPastaProntos(){
        File pastaprontos = new File("/home/robertinho/suhai_perfil/prontos");
        pastaprontos.mkdir();
        return pastaprontos;
    }
    public static File CriarPastaTxt(){
        File pastatxt = new File("/home/robertinho/suhai_perfil/txt");
        pastatxt.mkdir();
        return pastatxt;
    }
    public static File CriarPastaErro(){
        File pastaerro = new File("/home/robertinho/suhai_perfil/erro");
        pastaerro.mkdir();
        return pastaerro;
    }
    public static File CriarPastaStatus(){
        File pastaerro = new File("/home/robertinho/suhai_perfil/status");
        pastaerro.mkdir();
        return pastaerro;
    }
    public static File CriarPastacotacao(){
        File pastacotacao = new File("/home/robertinho/sompo_rd/cotacao");
        pastacotacao.mkdir();
        return pastacotacao;
    }
    public static File CriarPastaimage(){
        File pastaimage = new File("/home/robertinho/suhai_perfil/images");
        pastaimage.mkdir();
        return pastaimage;
    }
}
