package supporte;

import java.io.File;

public class GerenciaNrCotacao {
    public static boolean VerificaCotacao(){
        boolean existenrcotacao;
        File file = new File("/home/robertinho/suhai_perfil/cotacao/nrcotacao.txt");
        if(file.exists() || file.isFile()){
            existenrcotacao = true;
        }
        else {
            existenrcotacao = false;
        }
        return  existenrcotacao;
    }
}
