package supporte;

import org.openqa.selenium.WebDriver;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class PegarNrArquivo extends  BasePage{
    public PegarNrArquivo(WebDriver navegador) {
        super(navegador);
    }

    public static List<String> getList(List<String> numlinha) throws IOException {
        File[] files = new File("/home/robertinho/suhai_perfil/arquivos/").listFiles();
//If this pathname does not denote a directory, then listFiles() returns null.
        try {
            for (File file : files) {
                if (file.isFile()) {
                    numlinha.add(file.getName());
                }
            }
        }
        catch (Exception e){
            String msg = "Acabaram os arquivos!";
            JOptionPane.showMessageDialog(null,msg);
        }
        return numlinha;
    }
}
