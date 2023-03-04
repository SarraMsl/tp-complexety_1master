
import java.util.Random;

public class main {


    static int longeur = 1000;
    static public void main(String[] args)
    {
//توليد الجدول
        int[] arr = generateTable();
        int n = arr.length;


// الحالة الأولى pivote last index
        System.out.println("Avant le tri:");
        triRapid.AfficherTableau(arr, n);
        long startTime = System.nanoTime();
        triRapid.triRapide(arr, 0, n - 1);
        double TempExecution = System.nanoTime() - startTime;
        System.out.println("Apres le tri:");
        triRapid.AfficherTableau(arr, n);
        System.out.println("Execution time millis: " + TempExecution / 100000);


        System.out.println("\n\n\n\n");

// الحالة الثانية pivote median

        System.out.println("Avant le tri:");
        triRapid.AfficherTableau(arr, n);
        startTime = System.nanoTime();
        triRapid.triRapide(arr, (n - 1)/2, (n - 1));
        TempExecution = System.nanoTime() - startTime;
        System.out.println("Apres le tri:");
        triRapid.AfficherTableau(arr, n);
        System.out.println("Execution time millis: " + TempExecution / 100000);




    }


    static int[] generateTable() {
        int val = longeur;
        Random r = new Random();
        int[] arr = new int[val];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(val);
        }
        return arr;
    }

}
