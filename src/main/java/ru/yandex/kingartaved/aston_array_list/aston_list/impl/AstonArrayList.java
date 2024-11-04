package ru.yandex.kingartaved.aston_array_list.aston_list.impl;

import ru.yandex.kingartaved.aston_array_list.aston_list.AstonList;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class AstonArrayList<E> implements AstonList<E> {

    private static final int INITCAPACITY = 5;

    private E[] values;

    private int countOfElements = 0;

    @SuppressWarnings("unchecked")
    public AstonArrayList() {
        this.values = (E[]) new Object[INITCAPACITY];
    }

    @SuppressWarnings("unchecked")
    public AstonArrayList(int capacity) {
        this.values = (E[]) new Object[capacity];
    }

    @SuppressWarnings("unchecked")
    public AstonArrayList(Collection<? extends E> c) {
        if (c == null) {
            throw new NullPointerException("Коллекция не должна быть null");
        } else {
            this.values = (E[]) new Object[c.size()];
            System.arraycopy(c.toArray(), 0, this.values, 0, c.size());
            countOfElements = c.size();
        }
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index >= values.length) {
            throw new IndexOutOfBoundsException("индекс : " + index + ", фактический размер: " + countOfElements);
        }

        if (countOfElements == values.length) {
            addCapacity();
        }

        if (values[index] == null) {
            values[index] = element;
            countOfElements++;
        } else {
            System.arraycopy(values, index, values, index + 1, countOfElements - index);
            values[index] = element;
            countOfElements++;
        }
    }

    @Override
    public void addAll(Collection<? extends E> c) {
        if (c == null || c.isEmpty()) {
            return;
        }

        E[] temp = values;
        int newCountOfElements = countOfElements + c.size();

        while (newCountOfElements > values.length) {
            addCapacity();
        }

        System.arraycopy(temp, 0, values, 0, countOfElements);
        System.arraycopy(c.toArray(), 0, values, countOfElements, c.size());
        countOfElements = newCountOfElements;
    }

    @Override
    public void clear() {
        for (int i = 0; i < countOfElements; i++) {
            values[i] = null;
        }
        countOfElements = 0;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= countOfElements) {
            throw new IndexOutOfBoundsException("индекс : " + index + ", фактический размер: " + countOfElements);
        }
        return values[index];
    }

    @Override
    public boolean isEmpty() {
        return countOfElements == 0;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E remove(int index) {
        if (index < 0 || index >= countOfElements) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        E deletingElement = values[index];
        E[] temp = values;
        values = (E[]) new Object[temp.length - 1];
        System.arraycopy(temp, 0, values, 0, index);
        int countOfElementsAfterIndex = temp.length - index - 1;
        System.arraycopy(temp, index + 1, values, index, countOfElementsAfterIndex);
        countOfElements--;
        return deletingElement;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < countOfElements; i++) {
            if (values[i].equals(o)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public void sort(Comparator<? super E> c) {
        if (countOfElements == 0) {
            return;
        }
        Arrays.sort(values, 0, countOfElements, c);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < countOfElements; i++) {
            sb.append(values[i]);
            if (i < countOfElements - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public int size() {
        return countOfElements;
    }

    @SuppressWarnings("unchecked")
    private void addCapacity() {
        values = (E[]) new Object[values.length + values.length / 2 + 1];
    }

}
