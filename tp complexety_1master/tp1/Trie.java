public class Trie {

    /*Function to sort array using insertion sort*/
    static void tri(int tableau[]) {
        int n = tableau.length;
        for (int i = 1; i < n; ++i) {
            int key = tableau[i];
            int j = i - 1;
            while (j >= 0 && tableau[j] > key) {
                tableau[j + 1] = tableau[j];
                j = j - 1;
            }
            tableau[j + 1] = key;
        }
    }

    // aficher table
    static void printList(int arr[]) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
        System.out.println("----------------------------------");
    }

    //create ordered table matriti
    static int[] createTable1() {
        int val = 100;
        int[] arr = new int[val];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        return arr;
    }

    // trie table est afficher le temps execution
    static void printResult(int arr[]){
        // temps au debut execution
        long startTime = System.nanoTime();
        System.out.println("before");
        printList(arr);
        tri(arr);
        System.out.println("after");
        printList(arr);
        // temps a la fin execution
        double TempExecution = System.nanoTime() - startTime;
        System.out.println(" execution time millis: " + TempExecution / 100000);
    }

    public static void main(String[] args) {

        int arr[] = createTable1();
        printResult(arr);



    }
}
