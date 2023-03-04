import java.util.Random;

public class exo {

    static int longTable  = 100000;


    public static void triFusion(int tableau[])
    {
        int longueur=tableau.length;
        if (longueur>0)
        {
            triFusion(tableau,0,longueur-1);
        }
    }

    static void triFusion(int tableau[],int deb,int fin)
    {
        if (deb!=fin)
        {
            int milieu=(fin+deb)/2;
            triFusion(tableau,deb,milieu);
            triFusion(tableau,milieu+1,fin);
            fusion(tableau,deb,milieu,fin);
        }
    }

    private static void fusion(int tableau[],int deb1,int fin1,int fin2)
    {
        int deb2=fin1+1;

        //on recopie les éléments du début du tableau
        int table1[]=new int[fin1-deb1+1];
        for(int i=deb1;i<=fin1;i++)
        {
            table1[i-deb1]=tableau[i];
        }

        int compt1=deb1;
        int compt2=deb2;

        for(int i=deb1;i<=fin2;i++)
        {
            if (compt1==deb2) //c'est que tous les éléments du premier tableau ont été utilisés
            {
                break; //tous les éléments ont donc été classés
            }
            else if (compt2==(fin2+1)) //c'est que tous les éléments du second tableau ont été utilisés
            {
                tableau[i]=table1[compt1-deb1]; //on ajoute les éléments restants du premier tableau
                compt1++;
            }
            else if (table1[compt1-deb1]<tableau[compt2])
            {
                tableau[i]=table1[compt1-deb1]; //on ajoute un élément du premier tableau
                compt1++;
            }
            else
            {
                tableau[i]=tableau[compt2]; //on ajoute un élément du second tableau
                compt2++;
            }
        }
    }

    //create ordered table matriti
    static int[] createTable1() {
        int val = longTable;
        int[] arr = new int[val];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        return arr;
    }

    static int[] createTable2(){
        int val = longTable;
        Random r = new Random();
        int[] arr = new int[val];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(val);

        }
        return arr;
    }

    static int[] createTable3() {
        int val = longTable;
        int[] arr = new int[val];
        for (int i=longTable; i>0; i--) {
            arr[longTable-i] = i;
        }
        return arr;
    }

    // aficher table
    static void printList(int arr[]) {
        System.out.print("table("+arr.length +")=[");
        for (int i = 0; i < 10; i++) {
            System.out.print(arr[i]+",");
        }
        System.out.print(" ...]");
        System.out.println();
        System.out.println("----------------------------------");
    }

    // trie table est afficher le temps execution
    static void printResult(int arr[]){
        // temps au debut execution

        System.out.println("before");
        printList(arr);
        long startTime = System.nanoTime();
        triFusion(arr);
        double TempExecution = System.nanoTime() - startTime;
        System.out.println("after");
        printList(arr);
        // temps a la fin execution

        System.out.println(" execution time millis: " + TempExecution / 100000);
    }

    static void printResultFusion(int arr[]){
        // temps au debut execution

        System.out.println("before");
        printList(arr);
        long startTime = System.nanoTime();
        triFusion(arr);
        double TempExecution = System.nanoTime() - startTime;
        System.out.println("after");
        printList(arr);
        // temps a la fin execution

        System.out.println(" execution time millis: " + TempExecution / 100000);
    }
    public static void main(String[] args) {

        // case 1
        int[] table1 = createTable1();
        printResultFusion(table1);

        //case 2
        int [] table2 = createTable2();
        printResultFusion(table2);

        //case 3
        int[] table3 =createTable3();
        printResultFusion(table3);
    }
}
