package Atvd01;

import java.io.*;

public class PersistenciaBinaria {
    public static void main(String[] args) {
        Maromba maromba = new Maromba("Pedro", 21);

        try {
            FileOutputStream arquivo = new FileOutputStream("dados.bin");
            ObjectOutputStream escritor = new ObjectOutputStream(arquivo);
            escritor.writeObject(maromba);
            escritor.close();
            arquivo.close();
            System.out.println("Objeto gravado com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao gravar objeto: " + e.getMessage());;
        }
    }
}

class Maromba implements Serializable {
    String nome;
    int idade;

    public Maromba(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
}