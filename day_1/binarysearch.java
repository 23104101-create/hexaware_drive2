import java.util.*;
class BinarySearch {
    public static int search(int[] arr, int val) {

        int n = arr.length;
        int b = 0;
        int l = n - 1;

        while (b <= l) {

            int mid = (b + l) / 2;

            if (arr[mid] == val) {
                return mid;
            }
            else if (val < arr[mid]) {
                l = mid - 1;
            }
            else {
                b = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] arg) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int val = sc.nextInt();

        System.out.print(search(arr, val));

        sc.close();
    }
}