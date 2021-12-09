package ordenacao;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort{

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String GREEN_BOLD = "\033[1;32m";

    private int[] vetor;
    private int[] vetorAux;
    private String caminhoArquivo;

    public MergeSort(String arquivo) {
        this.caminhoArquivo = arquivo;
    }

    public MergeSort (){

    }

    public int[] getVetorAux() {
        return vetorAux;
    }

    public void setVetorAux(int[] vetorAux) {
        this.vetorAux = vetorAux;
    }

    public int[] getVetor() {
        return vetor;
    }

    public void setVetor(int[] vetor) {
        this.vetor = vetor;
    }


    public void mergeSortCrescente(int[] vetor, int[] vetorAux, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSortCrescente(vetor, vetorAux, inicio, meio);
            mergeSortCrescente(vetor, vetorAux, meio + 1, fim);
            intercalarCrescente(vetor, vetorAux, inicio, meio, fim);
        }
    }


    private void intercalarCrescente(int[] vetor, int[] vetorAux, int inicio, int meio, int fim) {
        for (int k = inicio; k <= fim; k++)
            vetorAux[k] = vetor[k];

        int i = inicio;
        int m = meio + 1;
        for (int k = inicio; k <= fim; k++) {
            if (i > meio) vetor[k] = vetorAux[m++];
            else if (m > fim) vetor[k] = vetorAux[i++];
            else if (vetorAux[i] < vetorAux[m]) vetor[k] = vetorAux[i++];
            else vetor[k] = vetorAux[m++];
        }
    }

    public void ordenar() {
        ArrayList<String> listaNumeros = converteArquivoVetor();
        atribuirValoresVetor(listaNumeros);
        int[] vetorAux = new int[this.vetor.length];
        setVetorAux(vetorAux);
        setVetor(this.vetor);
        mergeSortCrescente(this.vetor, getVetorAux(), 0, this.vetor.length - 1);
        gerarArquivoOrdenadoMerge();
    }

    private void gerarArquivoOrdenadoMerge() {
        try {
            /*
             Criação do arquivoOrdenado
             */
            File arquivoOrdenado = new File(this.caminhoArquivo+"OrdenadoMerge.txt");

            /*
             Criando arquivoOrdenado com tamanho específico
             */
            RandomAccessFile rafArquivo = new RandomAccessFile(arquivoOrdenado, "rw");

            int i = 0;
            while (i < this.vetor.length) {
                String valor = this.vetor[i] + " ";
                rafArquivo.writeBytes(valor);
                i++;
            }


            rafArquivo.close();
            System.out.println("Arquivo gerado com sucesso!"+ GREEN_BOLD + " ✅ " + ANSI_RESET);

        } catch (IOException ioException) {
            System.out.println("Ouve um erro ao tentar gerar o arquivo: "+ ioException.getMessage());
        }

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