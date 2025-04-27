// time complexity of linear search is O(n) and binary search is O(log n)

public class LinearAndBinarySearch {

    private static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
    // Binary Search requires the array to be sorted in assending order
    private static int binarySearch(int arr[], int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int target = 5;

        // Linear Search
        int linearResult = linearSearch(arr, target);
        if (linearResult == -1) {
            System.out.println("Element not found in the array using Linear Search.");
        } else {
            System.out.println("Element found at index: " + linearResult + " using Linear Search.");
        }

        // Binary Search
        int binaryResult = binarySearch(arr, target);
        if (binaryResult == -1) {
            System.out.println("Element not found in the array using Binary Search.");
        } else {
            System.out.println("Element found at index: " + binaryResult + " using Binary Search.");
        }
    }

}
