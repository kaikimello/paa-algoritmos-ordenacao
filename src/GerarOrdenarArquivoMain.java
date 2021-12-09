import arquivo.GerarArquivo;
import ordenacao.InsertionSort;
import ordenacao.MergeSort;

import java.io.FileReader;

public class GerarOrdenarArquivoMain {
    public static void main(String[] args) {
        //GerarArquivo.numerosDesordenados(104857600);

        //GerarArquivo.numerosOrdemCrescente(104857600);

        //GerarArquivo.numerosOrdemDecrescente(102300);

        long tempoInicialInsertion = System.currentTimeMillis();

        InsertionSort ordenarArquivo = new InsertionSort("numerosDesordenados104857600.txt");
        ordenarArquivo.insertionSort();

        long tempoFinalInsertion = System.currentTimeMillis();
        long milliInsertionTempo = tempoFinalInsertion - tempoInicialInsertion;
        String tempoExecucaoInsertion = retornaTempo(milliInsertionTempo);

        System.out.println("O tempo de Execução da função Insertion Sort é: " + tempoExecucaoInsertion);

        long tempoInicialMergeSort = System.currentTimeMillis();
        MergeSort ordenarArquivoMerge = new MergeSort("numerosDesordenados104857600.txt");
        ordenarArquivoMerge.ordenar();

        long tempoFinalMergeSort = System.currentTimeMillis();
        long milliMergeTempo = tempoFinalMergeSort - tempoInicialMergeSort;
        String tempoExecucaoMerge = retornaTempo(milliMergeTempo);


        System.out.println("O tempo de Execução da função Merge Sort é: " + tempoExecucaoMerge);

        //TODO MONTAR RELATORIO E TESTAR OS ARQUIVOS
    }

    public static String retornaTempo(long millisSegundosExecucao){
        int segundo = (int) (millisSegundosExecucao / 1000) % 60;
        int minutos = (int) (millisSegundosExecucao / 60000) % 60;
        int horas = (int) (millisSegundosExecucao/ 3600000);

        return String.format("%03d:%02d:%02d", horas, minutos, segundo);
    }
}
