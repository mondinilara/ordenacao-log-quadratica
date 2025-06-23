import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

/**
 * "Ordenação Log-Quadrática Garantida" - Θ(n² * log n)
 *
 * Base: Selection Sort mais um laço de atraso logarítmico é executado a cada
 * comparação.
 *
 * @author Lara Mondini Martins / Denise Araujo Santos
 * @version 1.0
 * @since 2025-06-20
 */
public class OrdenacaoLogQuadratica {

    /**
     * Ordena um array com complexidade Θ(n² * log n). Selection Sort + laço de
     * atraso logarítmico.
     * 
     * @param array O array a ser ordenado.
     */
    public static void ordenacaoLogQuadraticaGarantida(float[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        int n = array.length;
        final int espera = (int) (Math.log(n) / Math.log(2)) + 1;

        for (int i = 0; i < n - 1; i++) {
            int indiceDoMinimo = i;

            for (int j = i + 1; j < n; j++) {

                for (int k = 0; k < espera; k++) {
                    AtomicLong dummyCounter = new AtomicLong(0);
                    dummyCounter.incrementAndGet();
                }

                if (array[j] < array[indiceDoMinimo]) {
                    indiceDoMinimo = j;
                }
            }

            troca(array, i, indiceDoMinimo);
            System.out.println(array[i]);
        }
        System.out.println(array[n - 1]);
    }

    private static void troca(float[] array, int i, int j) {
        float temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * Lê um array de floats de um arquivo, onde cada linha contém um número
     * em formato de ponto flutuante. Linhas não numéricas são ignoradas.
     * 
     * @param nomeArquivo
     * @return Um array de floats lidos do arquivo.
     * @throws RuntimeException se ocorrer um erro ao ler o arquivo.
     */
    public static float[] lerArrayDeArquivo(String nomeArquivo) {
        List<Float> numeros = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                try {
                    numeros.add(Float.parseFloat(linha.trim()));
                } catch (NumberFormatException e) {
                    System.err.println("Aviso: Ignorando linha não-numérica: '" + linha + "'");
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + nomeArquivo);
            e.printStackTrace();
            throw new RuntimeException("Erro ao ler o arquivo: " + nomeArquivo, e);
        }

        float[] array = new float[numeros.size()];
        for (int i = 0; i < numeros.size(); i++) {
            array[i] = numeros.get(i);
        }

        return array;
    }

    /**
     * Escreve um array de floats em um arquivo, onde cada número é
     * escrito em uma linha separada. Se o arquivo já existir, ele será
     * substituído.
     * 
     * @param array
     * @param nomeArquivo
     */
    public static void escreverArrayParaArquivo(float[] array, String nomeArquivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (float valor : array) {
                bw.write(String.valueOf(valor));
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + nomeArquivo);
            e.printStackTrace();
            throw new RuntimeException("Erro ao escrever no arquivo: " + nomeArquivo, e);
        }
    }

    /**
     * Gera um array de floats aleatórios garantindo que a ordenação funcione com
     * todos os tipos de valores.
     * 
     * @param tamanho
     * @return Um array de floats aleatórios.
     */
    public static float[] randomArray(int tamanho) {
        float[] array = new float[tamanho];
        Random random = new Random();

        for (int i = 0; i < tamanho; i++) {
            float value;
            do {
                value = Float.intBitsToFloat(random.nextInt());
            } while (!Float.isFinite(value));

            array[i] = value;
        }
        return array;
    }

    /**
     * Gera um array de floats aleatórios garantindo que a ordenação funcione com
     * todos os tipos de valores.
     * 
     * @param tamanho
     * @return Um array de floats aleatórios.
     */
    public static float[] randomArrayInterval(int tamanho, float ini, float fim) {
        if (ini >= fim) {
            throw new IllegalArgumentException("O valor inicial deve ser menor que o valor final.");
        }

        float[] array = new float[tamanho];
        Random random = new Random();

        for (int i = 0; i < tamanho; i++) {
            float value;
            do {
                value = ini + random.nextFloat() * (fim - ini);
            } while (!Float.isFinite(value));

            array[i] = value;
        }
        return array;
    }

    /**
     * Verifica se um array de floats está ordenado em ordem crescente.
     * Se encontrar uma desordem, imprime a desordem encontrada.
     * 
     * @param array O array a ser verificado.
     * @return true se o array estiver ordenado, false caso contrário.
     */
    public static boolean isSorted(float[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                System.out.println("Desordem encontrada: " + array[i] + " > " + array[i + 1]);
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Erro. Use: java OrdenacaoLogQuadratica <arquivo_de_entrada>");
            return;
        }

        // escreverArrayParaArquivo(randomArray(40), args[0]);
        ordenacaoLogQuadraticaGarantida(lerArrayDeArquivo(args[0]));
    }
}