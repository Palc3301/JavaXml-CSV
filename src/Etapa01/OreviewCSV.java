package Etapa01;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class OreviewCSV {
    public static void main(String[] args) {
        try {
            // Conectar à página da Wikipedia e obter o HTML
            Document doc = Jsoup.connect("https://pt.wikipedia.org/wiki/Oakley,_Inc.").get();

            // Criar um objeto Properties para armazenar os dados
            Properties properties = new Properties();

            // Selecionar os elementos HTML que contêm os dados desejados
            Elements infoRows = doc.select(".infobox tr");

            for (Element row : infoRows) {
                Element th = row.selectFirst("th");
                Element td = row.selectFirst("td");

                if (th != null && td != null) {
                    String chave = th.text();
                    String valor = td.text();

                    properties.setProperty(chave, valor);
                }
            }

            // Gravar as propriedades em um arquivo
            FileOutputStream arquivo = new FileOutputStream("dados_empresa.properties");
            properties.store(arquivo, "Informações da Empresa");
            arquivo.close();

            System.out.println("Dados extraídos e salvos no arquivo de propriedades.");

        } catch (IOException e) {
            System.err.println("Erro ao extrair e gravar dados: " + e.getMessage());
        }
    }
}
