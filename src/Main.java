import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        //Graph graph = new Graph("C:\\Users\\talha\\Documents\\TP3_Final\\src\\graphe-100.txt");
        Graph graph = new Graph(0.01,100000);
        long start2 = System.currentTimeMillis();
        Dijkstra.dijkstraPriorityQueue(graph, 0);
        long end2 = System.currentTimeMillis();
        long start3 = System.currentTimeMillis();
        Dijkstra.dijkstraArray(graph, 0);
        long end3 = System.currentTimeMillis();
        System.out.println((end3 - start3)/1000.0 + "s\n");
        System.out.println((end2 - start2)/1000.0 + "s\n");

        /*Writer file = new FileWriter("FloydWarchallDikstrat.dat");

        for (double i = 0.001; i < 1; i = i + 0.001) {
            Graph graph = new Graph(i,100);

            chrono.restart();
            FloydWarshall.floydWarchallDikstrat(graph);
            chrono.stop();
            file.write(i + " " + chrono.getElapsedTime() + "\n");
        }
        file.close();*/

        //System.out.println(graph.toString());
        //System.out.println("Dijkstra avec tableau : " + Arrays.toString(Dijkstra.dijkstraArray(graph, 0)) + "\n");
        //System.out.println("Plus court chemin entre 0 et 99 : " + Floyd.floydWarchallDijkstra(graph)[99][0] + "\n");
        //System.out.println("Dijkstra avec priority Queue : " + Arrays.toString(Dijkstra.dijkstraPriorityQueue(graph, 0)) + "\n");
        //System.out.println("Floyd Warchall :\n" + Floyd.floydToString(Floyd.floydWarchall(graph)));
        //System.out.println("Floyd Warchall et Dijkstra :\n" + Floyd.floydToString(Floyd.floydWarchallDijkstra(graph)));
    }
}
