public class SelectionSort {
    public static void sort (int[] arr) {
        int size = arr.length;
        int minIndex,temp;

        for (int i = 0; i< size-1; i++) {
            minIndex = i;
            for (int j = i +1; j<size ;j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            temp = arr[minIndex];
            arr[minIndex] = arr[i]; 
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 64, 34, 25, 12, 22, 11, 90 };
        System.out.println("Unsorted array");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        SelectionSort.sort(arr);
        System.out.println("Sorted array by Selection Sort");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
