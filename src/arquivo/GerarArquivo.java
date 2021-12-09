package arquivo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class GerarArquivo {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String GREEN_BOLD = "\033[1;32m";

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

    public static void numerosOrdemCrescente(long tamanhoEmBytes){
        try{
            /*
             Criação do arquivo
             */
            File arquivo = new File("numerosOrdemCrescente"+tamanhoEmBytes+".txt");

            /*
             Criando arquivo com tamanho específico
             */
            RandomAccessFile rafArquivo = new RandomAccessFile(arquivo, "rw");
            rafArquivo.setLength(tamanhoEmBytes);

            int valor = 0;
            do {
                String texto = valor + " ";
                rafArquivo.writeBytes(texto);
                System.out.println(rafArquivo.getFilePointer());
                valor++;
            } while (rafArquivo.getFilePointer() < tamanhoEmBytes);

            rafArquivo.close();
            System.out.println("Arquivo gerado com sucesso!"+ GREEN_BOLD + " ✅ " + ANSI_RESET);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    public static void numerosOrdemDecrescente(long tamanhoEmBytes){
        try{
            /*
             Criação do arquivo
             */
            File arquivo = new File("numerosOrdemDecrescente"+tamanhoEmBytes+".txt");

            /*
             Criando arquivo com tamanho específico
             */
            RandomAccessFile rafArquivo = new RandomAccessFile(arquivo, "rw");
            rafArquivo.setLength(tamanhoEmBytes);

            int valor = 500000;
            do {
                String texto = valor + " ";
                rafArquivo.writeBytes(texto);
                System.out.println(rafArquivo.getFilePointer());
                valor--;
            } while (rafArquivo.getFilePointer() < tamanhoEmBytes);

            rafArquivo.close();
            System.out.println("Arquivo gerado com sucesso!"+ GREEN_BOLD + " ✅ " + ANSI_RESET);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }


}
