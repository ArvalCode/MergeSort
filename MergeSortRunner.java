
import java.util.Arrays;

public class MergeSort {
    private static int passCount;

    public static void mergeSort(Comparable[] list) {
        passCount = 0;
        mergeSort(list, 0, list.length);

    }

    public static void mergeSort(Comparable[] stuff, int front, int end) {
        int mid = (front + end) / 2;
        if (mid == front)
            return;

        mergeSort(stuff, front, mid);

        mergeSort(stuff, mid, end);

        merge(stuff, front, end);
        System.out.println("pass " + passCount + " " + Arrays.toString(stuff));
        passCount += 1;
    }

    public static void merge(Comparable[] stuff, int front, int end) {
        int dif = end - front, index = 0;
        Comparable[] stuffClone = new Comparable[dif];
        int start = front, mid = (front + end) / 2, saveMid = mid;

        while (start < saveMid && mid < end) {
            if (stuff[start].compareTo(stuff[mid]) < 0)
                stuffClone[index++] = stuff[start++];
            else
                stuffClone[index++] = stuff[mid++];
        }

        while (start < saveMid)
            stuffClone[index++] = stuff[start++];

        while (mid < end)
            stuffClone[index++] = stuff[mid++];

        for (int k = 0; k < dif; k++)
            stuff[front + k] = stuffClone[k];
    }

}
