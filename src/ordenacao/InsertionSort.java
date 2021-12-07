package ordenacao;

/**
 *
 * @author rafaela.passos
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class InsertionSort {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String GREEN_BOLD = "\033[1;32m";

    private int[] vetor;
    private String caminhoArquivo;

    public InsertionSort(String arquivo){
        this.caminhoArquivo = arquivo;
    }

    //TODO CALCULAR TEMPO
    int aux, j;
    public void insertionSort(){
        ArrayList<String> valores = converteArquivoVetor();
        atribuirValoresVetor(valores);
        for(int i = 1; i < vetor.length; i++){
            aux = vetor[i];
            j = i - 1;
            while(j >= 0 && vetor[j] > aux){
                vetor[j+1] = vetor[j];
                j--;
            }
            vetor[j+1] = aux;
        }
        mostrarVetor();
        gerarArquivoOrdenadoInsertion();
    }

    private void gerarArquivoOrdenadoInsertion() {
        try {
            /*
             Criação do arquivoOrdenado
             */
            File arquivoOrdenado = new File("numerosOrdenadoInsertion.txt");

            /*
             Criando arquivoOrdenado com tamanho específico
             */
            RandomAccessFile rafArquivo = new RandomAccessFile(arquivoOrdenado, "rw");

            int i = 0;
            while (i < this.vetor.length) {
                String valor = this.vetor[i] + " ";
                rafArquivo.writeBytes(valor);
                System.out.println(rafArquivo.getFilePointer());
                i++;
            }


            rafArquivo.close();
            System.out.println("Arquivo gerado com sucesso!"+ GREEN_BOLD + " ✅ " + ANSI_RESET);

        } catch (IOException ioException) {
            System.out.println("Ouve um erro ao tentar gerar o arquivo: "+ ioException.getMessage());
        }

    }

    public void mostrarVetor(){
        for (int i = 0; i < vetor.length; i++) {
            System.out.println("O valor no indice " + i + "º é: " + vetor[i]);
        }
    }

    public int[] getVetor() {
        return vetor;
    }

    public void setVetor(int[] vetor) {
        this.vetor = vetor;
    }

    private ArrayList<String> converteArquivoVetor(){
        ArrayList<String> listaValores = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))){
            String linhaArquivo = br.readLine();

            while (linhaArquivo != null){
                listaValores.addAll(Arrays.asList(linhaArquivo.split(" ")));
                linhaArquivo = br.readLine();
            }

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado");
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return listaValores;
    }

    private int[] atribuirValoresVetor(ArrayList<String> valores){
        this.vetor = new int[valores.size()];
        for (int i = 0; i < valores.size(); i++) {
            this.vetor[i] = Integer.parseInt(valores.get(i));
        }
        return this.vetor;
    }
}