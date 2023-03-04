package tptheorygraph;


public class Graph
{
    public int sommets;
    public int[][] adjacency_matrix;


    public Graph(int sommets)
    {
        this.sommets = sommets;
        adjacency_matrix = new int[sommets][sommets];
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < sommets; i++) {
            s.append(i + ": ");
            for (int j : adjacency_matrix[i]) {
                s.append(j + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public void inserer(int source, int destination)
    {
        adjacency_matrix[source - 1][destination-1] = 1;
    }

}
