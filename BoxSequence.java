import java.io.*;
import java.util.*;

public class BoxSequence {

    private List<double[]> caixas;

    public BoxSequence(String filename) throws IOException{
        caixas = new ArrayList<>();
        readBoxesFromFile(filename);
    }

    //separa as dimensoes em 3 partes e coloca em um vetor de dimensoes
    private void readBoxesFromFile(String filename) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;
        while((line = br.readLine()) != null){
            String[] parts = line.split(" ");
            double[] dimensions = new double[3];
            for (int i = 0; i < 3; i++){
                dimensions[i] = Double.parseDouble(parts[i]);
            }
            caixas.add(dimensions);
        }
        br.close();
    }

    private List<double[]> gerarPermutacoes(double[] caixa){
        List<double[]> permutacoes = new ArrayList<>();
        permutacoes.add(new double[]{caixa[0], caixa[1], caixa[2]});
        permutacoes.add(new double[]{caixa[0], caixa[2], caixa[1]});
        permutacoes.add(new double[]{caixa[1], caixa[2], caixa[0]});
        permutacoes.add(new double[]{caixa[1], caixa[0], caixa[2]});
        permutacoes.add(new double[]{caixa[2], caixa[1], caixa[0]});
        permutacoes.add(new double[]{caixa[2], caixa[0], caixa[1]});

        return permutacoes;
    }

    //verifica se todas as dimensoes da primeira caixa sao menores que a segunda
    private boolean cabeDentro(double[] caixa1, double[] caixa2){
        return caixa1[0] < caixa2[0] && caixa1[1] < caixa2[1] && caixa1[2] < caixa2[2];
    }

    private Digraph builGraph(){
        int numCaixas = caixas.size();
        Digraph graph = new Digraph();
        List<List<double[]>> permutacoes = new ArrayList<>();

        for(double[] caixa: caixas){
            permutacoes.add(gerarPermutacoes(caixa));
        }

        for(int i=0; i < numCaixas; i++){
            List<double[]> permutacoes_i = permutacoes.get(i);
            for(int j=0; j < numCaixas; j++){
                if(i != j){
                    List<double[]> permutacoes_j = permutacoes.get(j); 
                    for(double[] p_i : permutacoes_i){
                        for(double[] p_j : permutacoes_j){
                            if (cabeDentro(p_i, p_j)){
                                graph.addEdge(Integer.toString(i), Integer.toString(j));
                            }
                        }
                    }
                }
            }
        }
        return graph;
    }


    public int findLongestPath() {
        Digraph grafo = builGraph();
        LongestPathDFS lpd = new LongestPathDFS(grafo);
        return lpd.encontrarCaminhoMaisLongo();
    }

    public static void main(String[] args) {
        try {
            BoxSequence bs = new BoxSequence("caixas.csv");
            int caminhoMaisLongo = bs.findLongestPath();
            System.out.println("O comprimento do caminho mais longo é: " + caminhoMaisLongo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
