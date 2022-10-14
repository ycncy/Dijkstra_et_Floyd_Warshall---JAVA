import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Graph {

    Top[] tops;

    public Graph(double density, int nbrTop){
        int nbrArc, top1, top2;
        double weight;

        this.tops = new Top[nbrTop];

        for (int i = 0; i < nbrTop; i++){
            tops[i] = new Top(i);
        }

        nbrArc = (int) ((nbrTop * (nbrTop - 1)) * density);

        while (nbrArc != 0) {
            top1 = new Random().nextInt(tops.length);
            top2 = new Random().nextInt(tops.length);
            weight = Math.round((Math.random() * 10.0) / 10.0);

            if (top1 != top2 && !tops[top1].isNeighbor(tops[top2])){
                tops[top1].addNeighbors(new Arc(tops[top1], tops[top2], weight));
                nbrArc--;
            }
        }
    }

    public Graph(String DIR){
        int nbrVertex;

        File file = new File(DIR);

        try {
            Scanner sc = new Scanner(file);

            nbrVertex = sc.nextInt();
            this.tops = new Top[nbrVertex];

            for (int i = 0; i<nbrVertex;i++){
                tops[i] = new Top(i);
            }
            while (sc.hasNextLine()) {
                int beginVertex = sc.nextInt();
                int endVertex = sc.nextInt();
                int wheight = sc.nextInt();

                tops[beginVertex].addNeighbors(new Arc(tops[beginVertex],tops[endVertex],wheight));
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        String result = "";
        for (Top top : tops) {
            result += top + "\n";
        }
        return result;
    }
}


