package arquivo;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class GerarArquivo {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String GREEN_BOLD = "\033[1;32m";

    private static int gerarNumeroAleatorio() {
        return (int) (Math.random() * 100000);
    }

    public static void numerosDesordenados(long tamanhoEmBytes) {
        try {

            /*
             Criação do arquivo
             */
            File arquivo = new File("numerosDesordenados"+tamanhoEmBytes+".txt");

            /*
             Criando arquivo com tamanho específico
             */
            RandomAccessFile rafArquivo = new RandomAccessFile(arquivo, "rw");
            rafArquivo.setLength(tamanhoEmBytes);

            do {
                String valor = gerarNumeroAleatorio() + " ";
                rafArquivo.writeBytes(valor);
                System.out.println(rafArquivo.getFilePointer());
            } while (rafArquivo.getFilePointer() < tamanhoEmBytes);

            rafArquivo.close();
            System.out.println("Arquivo gerado com sucesso!"+ GREEN_BOLD + " ✅ " + ANSI_RESET);

        } catch (IOException ioException) {
            System.out.println("Ouve um erro ao tentar gerar o arquivo: "+ ioException.getMessage());
        }

    }


}
