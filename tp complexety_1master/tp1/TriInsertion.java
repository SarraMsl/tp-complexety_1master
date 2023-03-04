import java.util.Arrays;
import java.util.Random;

class TriInsertion {
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


        //System.out.println(" execution time millis: " + TempExecution/100000000);
//return " execution time millis: " + TempExecution/100000000 ;
    }


    public static void main(String args[]) {


        //  int arr[] = { 12, 11,13, 5, 6,9,3,122,9,15,55 };
        int val = 1000;
        Random r = new Random();
        int[] arr = new int[val];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(val);

        }

        TriInsertion ob = new TriInsertion();
        ob.tri(arr);


        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
        for (int i = arr.length - 1; i >= 0; i--) {

            //   System.out.print(arr[i] + " ");
        }
        TriInsertion obj = new TriInsertion();
        TriInsertion obj1 = new TriInsertion();


        long startTime = System.nanoTime();
        ob.tri(arr);
        double TempExecution = System.nanoTime() - startTime;
        System.out.println(" execution time millis: " + TempExecution / 100000);
        int[] arr3 = Arrays.copyOf(arr, val);
        obj.tri(arr3);
        for (int i = 0; i < n; ++i) {
            System.out.print(arr3[i] + " ");
        }
        double TempExecution2 = System.nanoTime() - startTime;
        System.out.println("execution time millis: " + TempExecution2 / 100000);
        long startTime1 = System.nanoTime();
        obj1.tri(arr3);
        double TempExecution1 = System.nanoTime() - startTime1;
        System.out.println(" execution time millis: " + TempExecution1 / 100000);
        for (int i = 0; i < n; ++i) {
            System.out.print(arr3[i] + " ");
        }
    }
}