import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> mas = new ArrayList<>(Arrays.asList(2,3,7,1,9,12,4));
        System.out.println(mas);
        quickSort(mas);
        System.out.println(mas);
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

    public static int recursArraySum(List<Integer> mas) {
        if (mas.size()==1) {
            return mas.get(0);
        } else return mas.get(mas.size()-1)+recursArraySum(mas.subList(0,mas.size()-1));
    }

    public static int recursArraySize(List<Integer> mas) {
        if (mas.size() > 1) {
            return 1+recursArraySize(mas.subList(0,mas.size()-1));
        } else {
            return 1;
        }
    }

    public static int searchArrayMax(List<Integer> mas) {
        if (mas.size()==2)
            return mas.get(0) > mas.get(1) ? mas.get(0) : mas.get(1);
        int submax = searchArrayMax(mas.subList(1, mas.size()));
        return mas.get(0) > submax ? mas.get(0) : submax;
    }

    public static void quickSort(List<Integer> mas) {
        if (mas.size() >= 2) {
            int pivot = 0;
            for (int i = 1; i < mas.size(); ++i) {
                if (mas.get(i) < mas.get(pivot)) {
                    Integer tmp = mas.get(i);
                    mas.remove(i);
                    mas.add(0, tmp);
                    ++pivot;
                }
            }
            quickSort(mas.subList(0, pivot));
            quickSort(mas.subList(pivot+1, mas.size()));
        }
    }
}