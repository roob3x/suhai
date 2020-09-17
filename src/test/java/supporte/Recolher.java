package supporte;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.Scanner;

public class Recolher {
    private String caminhomoverarquivo;

    public void recolherArquivos() throws IOException {
        // caminhomoverarquivo = LerArquivosDiretorio.CaminhoRecolherArquivo(caminhomoverarquivo);
        Scanner ler = new Scanner("/home/robertinho/ferramentas/mover/recolher.txt");
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
}
