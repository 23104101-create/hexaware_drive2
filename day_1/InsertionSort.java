import java.util.*;

public class InsertionSort {
    public static void sort(int[] arr) {

        int n = arr.length;

        for(int i = 1; i < n; i++) {

            int temp = arr[i];
            int j = i;
            while(j>0 && arr[j-1] > temp) {

                arr[j] = arr[j-1];
                j--;
            }

            arr[j] = temp;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sort(arr);
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }
}