import arquivo.GerarArquivo;
import ordenacao.InsertionSort;
import ordenacao.MergeSort;

import java.io.FileReader;

public class GerarOrdenarArquivoMain {
    public static void main(String[] args) {
        //GerarArquivo.numerosDesordenados(102300);

        //GerarArquivo.numerosOrdemCrescente(20);

        //GerarArquivo.numerosOrdemDecrescente(15);

        InsertionSort ordenarArquivo = new InsertionSort("numerosOrdemDecrescente15.txt");
        ordenarArquivo.insertionSort();



    }
}
