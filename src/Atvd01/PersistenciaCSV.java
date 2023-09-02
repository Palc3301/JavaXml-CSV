package Atvd01;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersistenciaCSV {
    public static void main(String[] args) {
        List<BodyBuilder> bodyBuilders = new ArrayList<>();
        bodyBuilders.add(new BodyBuilder("Pedro", 21, "Programador"));
        bodyBuilders.add(new BodyBuilder("Gabriel", 22, "Designer"));
        bodyBuilders.add(new BodyBuilder("Breno", 28, "Engenheiro"));

        String arquivoCSV = "bodyBuilders.csv";

        try (FileWriter escritor = new FileWriter(arquivoCSV)) {
            escritor.write("Nome,Idade,Profissão\n");

            // Escrever dados dos fisiculturistas
            for (BodyBuilder bodyBuilder : bodyBuilders) {
                escritor.write(bodyBuilder.getNome() + "," + bodyBuilder.getIdade() + "," + bodyBuilder.getProfissao() + "\n");
            }

            System.out.println("Dados gravados em CSV com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao gravar em CSV: " + e.getMessage());
        }
    }
}

class BodyBuilder {
    private String nome;
    private int idade;
    private String profissao;

    public BodyBuilder(String nome, int idade, String profissao) {
        this.nome = nome;
        this.idade = idade;
        this.profissao = profissao;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getProfissao() {
        return profissao;
    }
}
