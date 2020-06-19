package supporte;

import org.openqa.selenium.WebDriver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LerArquivoObjetos extends Variaveis {
   private List<Variaveis> listaPessoa;


    public LerArquivoObjetos(WebDriver navegador) {
        super(navegador);
    }


    public List<Variaveis> lerArquivoNr(String nrlinha) throws IOException {
        this.setNrlinha(nrlinha);
        Variaveis v = new Variaveis(navegador);
        File file = new File("/home/" + nomepc + "/suhai_perfil/arquivos/" + nrlinha);
        System.out.println(file);
        if (file.exists()) {
            Scanner ler = new Scanner("/home/" + nomepc + "/suhai_perfil/arquivos/" + nrlinha);
            String arquivo = ler.nextLine();
            FileReader arq = new FileReader(arquivo);
            BufferedReader lerArq = new BufferedReader(arq);
            listaPessoa = new ArrayList<Variaveis>();
            v.setNome(lerArq.readLine());
            v.setCpf(lerArq.readLine());
            v.setCepper(lerArq.readLine());
            v.setDat_nasc_c(lerArq.readLine());
            v.setEstado_civ(lerArq.readLine());
            v.setSexo_condu(lerArq.readLine());
            v.setTipo_de_se(lerArq.readLine());
            v.setClasse_bon(lerArq.readLine());
            v.setFranquia(lerArq.readLine());
            v.setAno_modelo(lerArq.readLine());
            v.setZero(lerArq.readLine());
            v.setSuhaimarca(lerArq.readLine());
            v.setSuhaiveic(lerArq.readLine());
            v.setDm(lerArq.readLine());
            v.setDc(lerArq.readLine());
            v.setGrgres(lerArq.readLine());
            v.setGrgtrab(lerArq.readLine());
            v.setGrgescola(lerArq.readLine());
            v.setFatajust(lerArq.readLine());
            v.setComissao(lerArq.readLine());
            v.setUtiliz(lerArq.readLine());
            v.setTipopessoa(lerArq.readLine());
            v.setCpfcond(lerArq.readLine());
            v.setNomecond(lerArq.readLine());
            v.setDatacond(lerArq.readLine());
            v.setSegecond(lerArq.readLine());
            lerArq.readLine();

            listaPessoa.add(v);

        }
        //return v;
        return listaPessoa;

    }
}
