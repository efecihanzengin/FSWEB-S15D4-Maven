package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WorkintechList<E> extends ArrayList<E> {
    @Override
    public boolean add(E e) {
        if (!this.contains(e)) {
            return super.add(e);
        }
        return false;
    }

    @Override
    public void add(int index, E element) {
        if (!this.contains(element)) {
            super.add(index, element);
        }
    }

    public void sort() {
        try {
            Collections.sort((List<Comparable>) this);
        } catch (ClassCastException e) {
            System.err.println("Sıralama hatası: Listedeki elemanlar Comparable olmalı veya aynı türden olmalı.");
        } catch (Exception e) {
            System.err.println("Beklenmedik bir sıralama hatası oluştu.");
        }
    }

    @Override
    public boolean remove(Object o) {
        boolean removed = super.remove(o);
        if (removed) {
            this.sort();
        }
        return removed;
    }

    @Override
    public E remove(int index) {
        E removedElement = super.remove(index);
        this.sort();
        return removedElement;
    }
}
