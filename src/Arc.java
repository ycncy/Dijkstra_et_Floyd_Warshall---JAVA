public class Arc implements Comparable<Arc>{

    private final double weight;
    private final Top parent, son;

    public Arc(Top parent, Top son, double weight){
        this.parent = parent;
        this.son = son;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public Top getParent() {
        return parent;
    }

    public Top getSon() {
        return son;
    }

    @Override
    public String toString() {
        return "Arc = {" +
                "parent : " + parent.getId() +
                ", son : " + son.getId() +
                ", wheigt : " + weight +
                '}';
    }

    @Override
    public int compareTo(Arc o) {
        return 0;
    }
}
