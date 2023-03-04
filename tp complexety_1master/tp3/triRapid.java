
public class triRapid
{
    static int partition(int[] arr, int low, int high)
    {
        int pivot = arr[low];
        int i = low - 1, j = high + 1;

        while (true) {
// البحث عن العنصر الموجود في أقصى اليسار أكبر
// من أو يساوي المحور
            do {
                i++;
            } while (arr[i] < pivot);

//البحث عن العنصر الموجود في أقصى اليمين أصغر
// من أو يساوي المحور
            do {
                j--;
            } while (arr[j] > pivot);


            if (i >= j)
                return j;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
// swap(arr[i], arr[j]);
        }
    }


    static void triRapide(int[] arr, int low, int high)
    {
        if (low < high) {

            int pi = partition(arr, low, high);

            triRapide(arr, low, pi);
            triRapide(arr, pi + 1, high);
        }
    }


    static void AfficherTableau(int[] arr, int n)
    {
        for (int i = 0; i < 10; i++)
            System.out.print(" ..." + arr[i]);
        System.out.println();
    }

}
