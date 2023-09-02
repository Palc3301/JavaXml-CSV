package Atvd01;

import java.io.FileWriter;
import java.io.IOException;

public class PersistenciaTexto {

    public static void main(String[] args) throws Exception {
        String conteudo = "Este é um exemplo de persistência em arquivo txt da aula 01";

        try {
            FileWriter escritor = new FileWriter("arquivo.txt");
            escritor.write(conteudo);
            escritor.close();
            System.out.println("Dados gravados com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }
}
