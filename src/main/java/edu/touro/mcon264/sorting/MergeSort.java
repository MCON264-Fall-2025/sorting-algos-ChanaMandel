package edu.touro.mcon264.sorting;

import java.util.Comparator;
import java.util.Objects;

public class MergeSort implements Sorter {

    @Override
    public <T> void sort(T[] a, Comparator<? super T> comp) {
        Objects.requireNonNull(a, "array must not be null");
        Objects.requireNonNull(comp, "comparator must not be null");

        @SuppressWarnings("unchecked")
        T[] aux = (T[]) new Object[a.length];

        mergeSort(a, aux, 0, a.length - 1, comp);
    }

    private static <T> void mergeSort(T[] a, T[] aux, int lo, int hi, Comparator<? super T> comp) {
        if (lo >= hi) return;

        int mid = lo + (hi - lo)/2;
        mergeSort(a, aux, lo, mid, comp);
        mergeSort(a, aux, mid + 1, hi, comp);
        merge(a, aux, lo, mid, hi, comp);
    }

    private static <T> void merge(T[] a, T[] aux, int lo, int mid, int hi, Comparator<? super T> comp) {
        for (int i = lo; i <= hi; i++) {
            aux[i] = a[i];
        }

        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            if (i > mid){ a[k] = aux[j++];}
            else if (j > hi){ a[k] = aux[i++];}
            else if (comp.compare(aux[i], aux[j]) <= 0) {
                a[k] = aux[i++];
            } else {
                a[k] = aux[j++];
            }
        }
    }
}
