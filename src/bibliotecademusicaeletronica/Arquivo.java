/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecademusicaeletronica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author paulo
 */
public class Arquivo {

    public OutputStream op;
    public OutputStreamWriter osw;
    public BufferedWriter bw = null;

    public InputStream is;
    public InputStreamReader isr;
    public BufferedReader br = null;

    List<String> lista2 = new ArrayList();
    //String[] array = new String[50];
    int contlinha = 0;

    void salvarArquivo(String nome, List<String> lista) throws FileNotFoundException, IOException {
        op = new FileOutputStream("library.txt", true);
        osw = new OutputStreamWriter(op);
        bw = new BufferedWriter(osw);

        bw.write(nome);
        bw.write(" | ");
        bw.write("Gênero: " + lista);
        bw.newLine();
        bw.write("*");
        bw.newLine();
        lista.clear();

        bw.close();
    }

    void buscarArquivo(String genero) throws FileNotFoundException, IOException {

        is = new FileInputStream("library.txt");
        isr = new InputStreamReader(is);
        br = new BufferedReader(isr);

        String line = br.readLine();

        while (line != null) {
            if (line.contains(genero)) {
                System.out.println(line);
            }
            line = br.readLine();
        }
        br.close();
    }

    void encontrarArquivo(String nomeAntigo, String nomeNovo) throws FileNotFoundException, IOException {
        
        File fil2 = new File("library.txt");

        try {
            FileReader fr2 = new FileReader(fil2);
            BufferedReader br2 = new BufferedReader(fr2);

            String linha2 = br2.readLine();
            ArrayList<String> salvar2 = new ArrayList();

            while (linha2 != null) {
                if (linha2.equals(nomeAntigo) == false) {
                    salvar2.add(linha2);
                }
                else{
                    salvar2.add(nomeNovo);
                }
                linha2 = br2.readLine();
            }
            
            br2.close();
            fr2.close();
            FileWriter fw3 = new FileWriter(fil2, true);
            fw3.close();
            
            FileWriter fw4 = new FileWriter(fil2);
            BufferedWriter bw2 = new BufferedWriter(fw4);
            
            for (int i = 0; i < salvar2.size(); i++) {
                bw2.write(salvar2.get(i));
                bw2.newLine();
            }
            bw2.close();
            fw4.close();
            
            
        } catch (IOException ex) {
        }

    }

    void deletarArquivo(String track) {
        File fil = new File("library.txt");

        try {
            FileReader fr = new FileReader(fil);
            BufferedReader br = new BufferedReader(fr);

            String linha = br.readLine();
            ArrayList<String> salvar = new ArrayList();

            while (linha != null) {
                if (linha.equals(track) == false) {
                    salvar.add(linha);
                }
                linha = br.readLine();
            }
            
            br.close();
            fr.close();
            FileWriter fw2 = new FileWriter(fil, true);
            fw2.close();
            
            FileWriter fw = new FileWriter(fil);
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (int i = 0; i < salvar.size(); i++) {
                bw.write(salvar.get(i));
                bw.newLine();
            }
            bw.close();
            fw.close();
            
            
        } catch (IOException ex) {
        }
    }
}
