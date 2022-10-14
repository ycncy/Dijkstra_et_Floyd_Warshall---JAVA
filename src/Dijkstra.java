import java.util.*;

public class Dijkstra {

    private static int extract_Min(int lastIndex, double[] d, Integer[] F){
        double minValue = d[F[0]];
        int index = 0;

        for (int i = 1 ; i< lastIndex; i++){
            if (d[F[i]] < minValue){
                minValue = d[F[i]];
                index = i;
            }
        }

        int temp = F[lastIndex - 1] ;
        F[lastIndex - 1] = F[index];
        F[index] = temp;

        return F[lastIndex - 1];
    }

    public static double[] dijkstraArray(Graph graph , int src){
        int u, maxIndex;

        Integer[] F = new Integer[graph.tops.length];
        double[] d = new double[graph.tops.length];

        for (int i = 0;i < graph.tops.length;i++){
            F[i] = graph.tops[i].getId();
        }
        for (int i = 0; i < graph.tops.length; i++){
            d[i] = Double.POSITIVE_INFINITY;
        }
        d[src] = 0;
        maxIndex = F.length;

        while (maxIndex != 0){
            u = extract_Min(maxIndex, d, F);
            maxIndex--;
            for (Arc i : graph.tops[u].neighbors) {
                if (d[i.getSon().getId()] > d[i.getParent().getId()] + i.getWeight()) {
                    d[i.getSon().getId()] = d[i.getParent().getId()] + i.getWeight();
                }
            }
        }
        return d;
    }

    public static double[] dijkstraPriorityQueue(Graph graph , int src) {
        double[] d = new double[graph.tops.length];
        PriorityQueue<Arc> F = new PriorityQueue<>();
        F.add(new Arc(graph.tops[src], graph.tops[src], 0));

        for (int i = 0; i < graph.tops.length; i++){
            d[i] = Double.MAX_VALUE;
        }

        d[src] = 0.0;

        while (!F.isEmpty()){
            Arc u = F.remove();
            for (Arc arc : graph.tops[u.getParent().getId()].neighbors) {
                if (d[arc.getSon().getId()] > d[arc.getParent().getId()] + arc.getWeight()) {
                    d[arc.getSon().getId()] = d[arc.getParent().getId()] + arc.getWeight();
                    double weight = d[arc.getSon().getId()] + arc.getWeight();
                    F.add(new Arc(arc.getSon(), arc.getParent(), weight));
                }
            }
        }
        return d;
    }
}
