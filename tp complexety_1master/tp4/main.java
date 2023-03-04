package tptheorygraph;



public class main
{

    static double TempExecution = 0;
    public static void main(String[] args)
    {
        int number_of_vertices = 5;

        Graph g = new Graph(number_of_vertices);

        //input set 2
        g.inserer(2, 1);
        g.inserer(3, 1);
        g.inserer(3, 4);
        g.inserer(2, 4);
        g.inserer(1, 4);
        g.inserer(5, 4);
        System.out.println(g.toString());

        System.out.println("Est puits: "+estPuits(g,2));
        System.out.println("Execution time millis: " + TempExecution / 100000);

    }

    public static boolean estPuits(Graph A, int k)
    {
        long startTime = System.nanoTime();
        for (int j = 0 ; j < A.sommets ; j++)
        {
            if (A.adjacency_matrix[k][j] == 1)
                return false;
            if (A.adjacency_matrix[j][k] == 0 && j != k)
                return false;
        }
         TempExecution = System.nanoTime() - startTime;

        return true;

    }
}

