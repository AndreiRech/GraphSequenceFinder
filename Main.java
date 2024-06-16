public class Main {
    public static void main(String[] args) {
        maiorCaminho();
    }

    private static Box [] criaCaixas() {
        Box[] caixas = {
            new Box(991, 443, 126),
            new Box(733, 281, 710),
            new Box(910, 720, 218),
            new Box(743, 512, 162),
            new Box(988, 955, 720),
            new Box(680, 603, 649),
            new Box(336, 326, 615),
            new Box(566, 764, 487),
            new Box(680, 579, 148),
            new Box(629, 222, 697)
        };
        return caixas;
    }

    private static Digraph criaDigrafo() {
        Digraph digraph = new Digraph();
        Box[] caixas = criaCaixas();

        for(int i=0; i<caixas.length; i++) {
            for(int j=0; j<caixas.length; j++) {
                if(i != j && caixas[i].fitInto(caixas[j])) {
                    digraph.addEdge(String.valueOf(i), String.valueOf(j));
                }
            }
        }

        return digraph;
    }

    private static void maiorCaminho() {
        Digraph digraph = criaDigrafo();
        DFS dfs = new DFS(digraph, "0");

        // Precisamos pensar em um jeito de fazer isso :(
        // Provavelmente vai ser algo parecido com as Árvores de Caminho Mínimo
        // Talvez usar um Dijkstra mas ao invez de peso das arestas, o distTo[] seria quantos nodos até o pai
        // Ai só inverteriamos o resultado, pegando o pior não o melhor

        // System.out.println(digraph.toDot());
    }
}
