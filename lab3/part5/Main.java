package part5;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Тест с числами
        Integer[] numbers = {3, 6, 1, 5, 2, 4};
        System.out.println("Before sorting: " + Arrays.toString(numbers));
        Sort.quickSort(numbers);
        System.out.println("After sorting: " + Arrays.toString(numbers));

        // Тест с шоколадом
        Chocolate[] chocolates = {
            new Chocolate("Mars", 50.0),
            new Chocolate("Snickers", 45.0),
            new Chocolate("Twix", 55.0),
            new Chocolate("Bounty", 40.0)
        };
        System.out.println("\nBefore sorting: " + Arrays.toString(chocolates));
        Sort.quickSort(chocolates);
        System.out.println("After sorting: " + Arrays.toString(chocolates));

        // Тест с временем
        Time[] times = {
            new Time(14, 30, 0),
            new Time(9, 45, 0),
            new Time(12, 0, 0),
            new Time(7, 15, 0)
        };
        System.out.println("\nBefore sorting: " + Arrays.toString(times));
        Sort.quickSort(times);
        System.out.println("After sorting: " + Arrays.toString(times));
    }
}

class Chocolate implements Comparable<Chocolate> {
    private String name;
    private double weight;

    public Chocolate(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Chocolate{name='" + name + "', weight=" + weight + "}";
    }

    @Override
    public int compareTo(Chocolate other) {
        return Double.compare(this.weight, other.weight);
    }
}

class Time implements Comparable<Time> {
    private int hour;
    private int minute;
    private int second;

    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    @Override
    public int compareTo(Time other) {
        if (this.hour != other.hour) {
            return Integer.compare(this.hour, other.hour);
        } else if (this.minute != other.minute) {
            return Integer.compare(this.minute, other.minute);
        } else {
            return Integer.compare(this.second, other.second);
        }
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
}

class Sort {
    static <E extends Comparable<E>> void quickSort(E[] array) {
        quickSortHelper(array, 0, array.length - 1);
    }

    private static <E extends Comparable<E>> void quickSortHelper(E[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSortHelper(array, low, pivotIndex - 1);
            quickSortHelper(array, pivotIndex + 1, high);
        }
    }

    private static <E extends Comparable<E>> int partition(E[] array, int low, int high) {
        E pivot = array[low];
        int i = low + 1;

        for (int j = low + 1; j <= high; j++) {
            if (array[j].compareTo(pivot) < 0) {
                swap(array, i, j);
                i++;
            }
        }
        swap(array, low, i - 1);
        return i - 1;
    }

    static <E> void swap(E[] array, int i, int j) {
        E temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
