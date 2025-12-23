package edu.touro.mcon264.sorting;

import java.util.Comparator;
import java.util.Objects;

public class InsertionSort implements Sorter {

    @Override
    public <T> void sort(T[] a, Comparator<? super T> comp) {
        Objects.requireNonNull(a, "array cannot be null");
        Objects.requireNonNull(comp, "comparator cannot be null");

            int n = a.length;
            for (int i = 1; i < n;i++) {
                T key = a[i];
                int j = i - 1;

                while (j >= 0 && comp.compare(a[j], key) > 0) {
                    a[j + 1] = a[j];
                    j --;
                }
                a[j + 1] = key;
        }

    }
}
