package supporte;

import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GerenciaErro extends BasePage{
    public GerenciaErro(WebDriver navegador) {
        super(navegador);
    }

    public static PrintWriter CriarArquivoErro() throws IOException {
        FileWriter arq = new FileWriter("/home/robertinho/suhai_perfil/status/erro.txt");
        PrintWriter gravarArq = new PrintWriter(arq);
        gravarArq.flush();
        gravarArq.close();
        return gravarArq;
    }
    public static boolean VerificaErro(){
        boolean existeerro;
        File file = new File("/home/robertinho/suhai_perfil/status/erro.txt");
        if(file.exists() && file.isFile()){
            return existeerro=true;
        }
        else
        {
            return existeerro=false;
        }
    }
    public static File DeletarArquivoerro(){
        File deletarerro = new File("/home/robertinho/suhai_perfil/status/erro.txt");
        if(deletarerro.exists() && deletarerro.isFile()) {
            deletarerro.delete();
        }
        return deletarerro;
    }
}
