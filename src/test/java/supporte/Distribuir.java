package supporte;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Distribuir {
    private String nomevm;
    private static File pastaarquivos;
    private static File pastaapdf;
    private static File pastaprontos;
    private static File pastatxt;
    private static File pastaerro;
    private static File pastastatus;
    private static File pastacotacao;
    private static File pastaimage;
    private static PrintWriter gravarArq;
    private boolean existenrcotacao;

    public void distribuirArquivos() throws IOException {
        File destpastamae = new File("/home/robertinho/suhai_perfil");
        destpastamae.mkdir();
        pastaarquivos = CriarPastas.criarPastaArquivos();
        pastaapdf = CriarPastas.criarPastaPdf();
        pastaprontos = CriarPastas.criarPastaProntos();
        pastatxt = CriarPastas.criarPastaTxt();
        pastaerro = CriarPastas.criarPastaErro();
        pastastatus = CriarPastas.criarPastaStatus();
        pastacotacao = CriarPastas.criarPastacotacao();
        pastaimage = CriarPastas.criarPastaimage();


        existenrcotacao = GerenciaNrCotacao.VerificaCotacao();
        if (existenrcotacao == false) {
            //diretorio de onde vai copiar a pasta mae
            File sourcefreenaspastamae = new File("/run/user/1000/gvfs/smb-share:server=freenas.local,share=arquivosgerais/E/LABSEG/apolice/result/SUHAI/PRONTOS/mover");
            //diretorio de onde vai copiar a pasta na vm
            destpastamae = new File("/home/robertinho/ferramentas/mover");
            destpastamae.mkdir();
            FileUtils.copyDirectory(sourcefreenaspastamae, destpastamae);
        }

        //cria arquivo com o nome da vm caso nao exista
        gravarArq = PegarNomeVm.criarNomeVM();
        //ler o nome da vm
        nomevm = PegarNomeVm.nomeVm(nomevm);
        /// caminho de onde ira pegar os arquivos
        File diretorio = new File("/run/user/1000/gvfs/smb-share:server=freenas.local,share=arquivosgerais/E/LABSEG/apolice/result/SUHAI/PRONTOS/distribuir/" + nomevm + "/");
        File destino = new File("/home/robertinho/suhai_perfil/arquivos/");
//distribui os arquivos para a vm
        if (diretorio.exists()) {
            FileUtils.copyDirectory(diretorio, destino);
            FileUtils.deleteDirectory(diretorio);
        }

        if (existenrcotacao == false) {
            File directoryresumo = new File("/run/user/1000/gvfs/smb-share:server=freenas.local,share=arquivosgerais/E/LABSEG/apolice/result/SUHAI/PRONTOS/cotacao/");
            File destresumo = new File("/home/robertinho/suhai_perfil/cotacao/");
            destresumo.mkdir();
            FileUtils.copyDirectory(directoryresumo, destresumo);
        }

        File directoryimage = new File("/run/user/1000/gvfs/smb-share:server=freenas.local,share=arquivosgerais/E/LABSEG/apolice/result/suhai/PRONTOS/images/");
        File destimage = new File("/home/robertinho/suhai_perfil/images/");
        destimage.mkdir();
        FileUtils.copyDirectory(directoryimage, destimage);
    }
}
