package supporte;

import org.openqa.selenium.WebDriver;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PegarNrArquivo extends Variaveis {
    public PegarNrArquivo(WebDriver navegador) {
        super(navegador);
    }

    public ArrayList<String> carregarArquivos() {
        ArrayList<String> listaNrlinha = new ArrayList<String>();

        File[] files = new File("/home/"+nomepc+"/suhai_perfil/arquivos/").listFiles();
        try {
            for (File file : files) {
                listaNrlinha.add(file.getName());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listaNrlinha;
    }

    public void deleteArquivo(String nrtxt) {
        File file = new File("/home/"+nomepc+"/suhai_perfil/arquivos/" + nrtxt);

        if (file.exists() && file.isFile()) {
            boolean i=true;
            while (i){
                if (file.delete()) {
                    i=false;
                }else{
                    System.gc();
                }
            }


        }

    }
}
