package com.zipcodewilmington.arrayutility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {
    private T[] inputArr;

    public ArrayUtility (T[] inputArr) {
        this.inputArr = inputArr;
    }


    public Integer countDuplicatesInMerge(T[] arrMerge, T mergeVal) {
        List<T> duplicateList = new ArrayList<>();
        duplicateList.addAll(Arrays.asList(arrMerge));
        duplicateList.addAll(Arrays.asList(inputArr));
        return Collections.frequency(duplicateList, mergeVal);
    }

    public T getMostCommonFromMerge(T[] arrMerge) {
        Integer counter = 0;
        List<T> commonList = new ArrayList<>();
        T mostCommonValue = null;
        commonList.addAll(Arrays.asList(arrMerge));
        commonList.addAll(Arrays.asList(inputArr));
        for(T value : commonList){
            Integer current = Collections.frequency(commonList, value);
            if(current > counter){
                counter = current;
                mostCommonValue = value;
            }
        }
        return mostCommonValue;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        List<T>  occurenceList = new ArrayList<>();
        occurenceList.addAll(Arrays.asList(inputArr));
        return Collections.frequency(occurenceList, valueToEvaluate);
    }

    public T[] removeValue(T valueToRemove) {
        int numberOfOccurrences = getNumberOfOccurrences(valueToRemove);
        T[] result = Arrays.copyOf(inputArr, inputArr.length -numberOfOccurrences);
        int resultIndex = 0;
        for (int i = 0; i < inputArr.length; i++) {
            if(inputArr[i] != valueToRemove){
                result[resultIndex] = inputArr[i];
                resultIndex++;
            }
        }
        return result;
    }

}
