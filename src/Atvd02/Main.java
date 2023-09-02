package Atvd02;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        /*Document doc = Jsoup.connect("https://pt.wikipedia.org/wiki/F%C3%B3rmula_1").get();

        System.out.println(doc);*/
        //System.out.println(doc.getElementsByTag("p"));
        //System.out.println(doc.getElementsContainingOwnText("o verde para as equipes inglesas, "));

       Document doc = Jsoup.connect("https://pt.wikipedia.org/wiki/Avatar_(filme)").get();

        Elements titles = doc.select("h1, h2, h3, h4, h5, h6");

        //.eachText obtem uma lista de textos dos elementos de título
        List<String> titlesList = titles.eachText();

        Path outputPath = Paths.get("titulos_da_pagina.txt");
        Files.write(outputPath, titlesList);

        System.out.println("Títulos extraídos e salvos em " + outputPath);
    }
}
