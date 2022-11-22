import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> mas = new ArrayList<>(Arrays.asList(2,3,7,1,9,12,4));
        //mas.sort(null);
        mas = selectionSort(mas);
        System.out.println(mas);
        System.out.println(binarySearch(45, mas));
    }

    public static int binarySearch(Integer x, List<Integer> mas) {
        int low = 0;
        int high = mas.size()-1;
        int mid = -1;

        while (low <= high) {
            mid = (high + low) / 2;
            Integer fromMas = mas.get(mid);

            if (fromMas == x) {
                return mid;
            }
            if (fromMas > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return Integer.valueOf(-1);
    }

    public static List<Integer> selectionSort(List<Integer> mas) {
        for (int i = 0; i < mas.size(); ++i) {
            int min = i;//expected index of minimum
            //finding minimum from j
            for (int j = i; j < mas.size(); j++) {
                if (mas.get(j) < mas.get(min)) {
                    min = j;
                }
            }
            //replace i and min
            if (min != i) {
                mas.set(min, mas.get(min)+mas.get(i));
                mas.set(i, mas.get(min)-mas.get(i));
                mas.set(min, mas.get(min)-mas.get(i));
            }
        }
        return mas;
    }
}