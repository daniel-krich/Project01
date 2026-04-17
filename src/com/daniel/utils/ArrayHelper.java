package com.daniel.utils;

public class ArrayHelper {
    public static Object[] resizeArray(Object[] arr, int size) {
        Object[] array = new Object[size];
        for(int i = 0; i < size; i++) {
            array[i] = arr[i];
        }
        return array;
    }
}