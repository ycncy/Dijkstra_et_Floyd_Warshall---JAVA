import java.util.LinkedList;
public class Top {

    LinkedList<Arc> neighbors;
    private final int id;

    public Top(int id){
        this.neighbors = new LinkedList<>();
        this.id = id;
    }

    public void addNeighbors(Arc arc){
        this.neighbors.add(arc);
    }

    public boolean isNeighbor(Top neighbor){
        for (Arc arc : this.neighbors){
            if (arc.getParent() == this && arc.getSon() == neighbor){
                return true;
            }
        }
        return false;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Sommet : [" +
                "Neighbors : " + neighbors +
                ", ID : " + id +
                ']';
    }
}
