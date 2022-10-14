public class Floyd {

    public static double[][] floydWarchall(Graph graph) {
        int graphLength = graph.tops.length;
        double[][] d = new double[graphLength][graphLength];

        for (Top top : graph.tops){
            for (Arc arc : top.neighbors){
                d[arc.getParent().getId()][arc.getSon().getId()] = arc.getWeight();
            }
        }

        for (int i = 0; i < graphLength; i++) {
            for (int j = 0;  j < graphLength; j++) {
                for (int k = 0; k < graphLength; k++) {
                    if (d[j][k] == 0.0) {
                        d[j][k] = Double.POSITIVE_INFINITY;
                    }
                    if (j == k) {
                        d[j][k] = 0.0;
                    }
                    d[j][k] = Math.min(d[j][k],d[j][i] + d[i][k]);
                }
            }
        }
        return d;
    }

    public static double[][] floydWarchallDijkstra(Graph graph){
        int lengthGraph = graph.tops.length;
        double[][] d = new double[lengthGraph][lengthGraph];

        for (Top top : graph.tops){
            for (Arc arc : top.neighbors){
                d[arc.getParent().getId()][arc.getSon().getId()] = arc.getWeight();
            }
        }

        for (int i = 0 ; i < lengthGraph; i++){
            double[] dijkstra = Dijkstra.dijkstraArray(graph, i);
            System.arraycopy(dijkstra, 0, d[i], 0, lengthGraph);
        }
        return d;
    }

    public static String floydToString (double[][] floyd) {
        StringBuilder result = new StringBuilder();

        for (double[] doubles : floyd) {
            for (int j = 0; j < floyd.length; j++) {
                result.append("[").append(doubles[j]).append("]");
            }
            result.append("\n");
        }
        return result.toString();
    }
}
