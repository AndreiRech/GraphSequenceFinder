import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        maiorCaminho();
    }

    private static Map<List<Integer>, String> mapFiles() {
        Map<List<Integer>, String> casos = new HashMap<>();
        casos.put(Arrays.asList(10,4), "Exemplo");
        casos.put(Arrays.asList(10,4), "00010");
        casos.put(Arrays.asList(20,5), "00020");
        casos.put(Arrays.asList(50,8), "00050");
        casos.put(Arrays.asList(100,13), "00100");
        casos.put(Arrays.asList(200,18), "00200");
        casos.put(Arrays.asList(300,19), "00300");
        casos.put(Arrays.asList(500,23), "00500");
        casos.put(Arrays.asList(1000,28), "01000");
        //casos.put(Arrays.asList(2000,44), "02000");
        //casos.put(Arrays.asList(5000,61), "05000");
        //casos.put(Arrays.asList(10000,76), "10000");

        return casos;
    }
        
    private static void maiorCaminho() {
        Map<List<Integer>, String> casos = mapFiles();

        casos.forEach((key, value) -> {
            //access file with WINDOWS
            //String filename = "casosT30\\caso" + value + ".txt";
            //acess file with LINUX
            String filename = "casosT30//caso" + value + ".txt";

            long start = System.nanoTime();
            
            Digraph digraph = new Digraph(filename, key.get(0));
            DFS dfs = new DFS(digraph);

            long finish = System.nanoTime();

            double finalTime = (finish - start) / (double) 1000000000;

            System.out.println("\n----- [ CASO " +value +" ] -----");
            System.out.println("-> Valor esperado [ " +key.get(1) +" ]");
            System.out.println("-> Valor encontrado [ " +dfs.longestLenght() +" ]");
            System.out.printf("-> Tempo [ %.3f segundos ]\n", finalTime);
        });
    }
}
