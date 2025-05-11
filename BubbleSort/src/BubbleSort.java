public class BubbleSort {
    private static void sort(int[] arr) {
        int size = arr.length;
        int temp;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Unsorted array");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        sort(arr);

        System.out.println("Sorted array");
        for (int i : arr) {
            System.out.print(i + " ");
        }

    }

}
