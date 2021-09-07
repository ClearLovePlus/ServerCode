package com.chenhao.common.algorithm;

import java.util.*;

/**
 * @description:
 * @author: chenhao
 * @date: 2021-7-14 13:17
 */
public class ListUtils {
    /**
     * 按指定顺序和是否去重合并两个列表
     * @param var1
     * @param var2
     * @param distinct
     * @return
     */
    public static List<Integer> mergeListWithSort(List<Integer> var1,List<Integer> var2,Boolean distinct){
        Long startTime=System.currentTimeMillis();
        if(var1.isEmpty()&&var2.isEmpty()){
            return null;
        }
        if(var1.isEmpty()){
            return var2;
        }
        if(var2.isEmpty()){
            return var1;
        }
        List<Integer> result=new ArrayList<>(var1.size()+var2.size());
        result.addAll(var1);
        result.addAll(var2);
        //去重，利用hashSet去重
        if(distinct){
            Set<Integer> filterSet=new HashSet<>(result);
            result.clear();
            result.addAll(filterSet);
        }
        //排序
         result=SortAlgorithm.bubblesSort(result);
        System.out.println("列表合并排序耗时:"+(System.currentTimeMillis()-startTime)+"ms");
        return result;
    }

    public static void main(String[] args) {
        Integer[] var1=new Integer[]{4,12,4,6,1,3,2};
        Integer[] var2=new Integer[]{4,3,8,9,0};
        List<Integer> list1=Arrays.asList(var1);
        List<Integer> list2=Arrays.asList(var2);
        List<Integer> list3 = ListUtils.mergeListWithSort(list1, list2, true);
        List<Integer> list4 = ListUtils.mergeListWithSort(list1, list2, false);
        System.out.println(list3);
        System.out.println(list4);
    }
}
