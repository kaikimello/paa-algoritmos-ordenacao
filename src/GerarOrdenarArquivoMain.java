import arquivo.GerarArquivo;
import ordenacao.InsertionSort;
import ordenacao.MergeSort;

import java.io.FileReader;

public class GerarOrdenarArquivoMain {
    public static void main(String[] args) {
        //GerarArquivo.numerosDesordenados(104857600);

        //GerarArquivo.numerosOrdemCrescente(20);

        //GerarArquivo.numerosOrdemDecrescente(15);

/*        InsertionSort ordenarArquivo = new InsertionSort("numerosDesordenados104857600.txt");
        ordenarArquivo.insertionSort();*/

        MergeSort ordenarArquivoMerge = new MergeSort("numerosDesordenados104857600.txt");
        ordenarArquivoMerge.ordenar();

        //TODO FUNÇÃO DO TEMPO E GERAR OS ARQUIVOS E TESTAR E MODIFICAR NOME DO ARQUIVO GERADO ORDENADO
    }
}
