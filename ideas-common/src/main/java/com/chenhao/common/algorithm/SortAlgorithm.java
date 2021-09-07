package com.chenhao.common.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: chenhao
 * @date: 2021-7-14 13:33
 */
public class SortAlgorithm {
    /**
     * 冒泡排序
     *
     * @param sourceList
     * @return
     */
    public static List<Integer> bubblesSort(List<Integer> sourceList) {
        Integer[] integers=bubblesSortArray(sourceList.toArray(new Integer[0]));
        return Arrays.asList(integers);
    }


    /**
     * 数组的冒泡排序
     *
     * @param sourceArray
     * @return
     */
    public static Integer[] bubblesSortArray(Integer[] sourceArray) {
        Long startTime=System.currentTimeMillis();
        for (int i = 0; i < sourceArray.length - 1; i++) {
            for (int k = i + 1; k < sourceArray.length; k++) {
                int temp;
                if (sourceArray[i] > sourceArray[k]) {
                    temp = sourceArray[i];
                    sourceArray[i] = sourceArray[k];
                    sourceArray[k] = temp;
                }
            }
        }
        System.out.println("排序耗时:"+(System.currentTimeMillis()-startTime)+"ms");
        return sourceArray;
    }
}
