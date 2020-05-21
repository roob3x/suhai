package supporte;

import org.openqa.selenium.WebDriver;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LerArquivo extends BasePage {
    private static List<String> numlinha = new ArrayList<String>();
    private static List<String> list = new ArrayList<String>();


    public LerArquivo(WebDriver navegador) {
        super(navegador);
    }


    public static List<String> getList(List<String> list) throws IOException {


        String directory = "/home/robertinho/suhai_perfil/arquivos/";

        numlinha = PegarNrArquivo.getList(numlinha);
        String nrarquivo = numlinha.get(0);

        File file = new File(directory + nrarquivo);
        if (file.exists() && file.isFile()) {
            Scanner ler = new Scanner(directory + nrarquivo);
            String nome1 = ler.nextLine();

            FileReader arq = new FileReader(nome1);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = lerArq.readLine();
            list.add(linha);
            int i = 0;
            while ((i <= 60) && (linha != null)) {
                //   System.out.printf("%s\n", linha);
                linha = lerArq.readLine();
                list.add(linha);
                i++;
            }


        }
        numlinha.clear();

        return list;
    }

    public static String ChecarTipoSegmento(String segmento) throws IOException {
        Scanner ler = new Scanner("/home/robertinho/suhai/cotacao/RESUMO SUHAI.txt");
        String nome1 = ler.nextLine();
        ArrayList<String> alist1 = new ArrayList<String>();

        FileReader arq = new FileReader(nome1);
        BufferedReader lerArq = new BufferedReader(arq);
        String linha = lerArq.readLine();
        alist1.add(linha);
        int i = 0;
        while ((i <= 45) && (linha != null)) {
            //   System.out.printf("%s\n", linha);
            linha = lerArq.readLine();
            alist1.add(linha);
            i++;
        }

        segmento = alist1.get(1);
        //fazercotnova = alist1.get(9);
        //System.out.println(segmento);
        return segmento;
    }
}
