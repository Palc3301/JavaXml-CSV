package Atvd01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PersistenciaPropiedades {
    public static void main(String[] args) {
        Properties propeidades = new Properties();
        propeidades.setProperty("usuario", "Pedro");
        propeidades.setProperty("senha", "secreta");

        try {
            FileOutputStream arquivo = new FileOutputStream("config.properties");
            propeidades.store(arquivo,"Configurações de usuário");

            arquivo.close();
            System.out.println("Propiedades gravadas com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao gravar propriedades: " + e.getMessage());
        }
    }
}
