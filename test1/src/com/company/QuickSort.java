package com.company;



import org.junit.Test;

/**
 * @Author Administrator
 * @Date 2021/8/2 5:04
 * @Version 1.0
 */
public class QuickSort {
    public static void main(String[] args) {
        //  System.out.println(new QuickSort().r(10)) ;
        int[] arr = {49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22};
        // Arrays.sort(arr);
        quickSort(arr, 0, arr.length - 1);
        System.out.println("排序后:");
        for (int i : arr) {
            System.out.println(i);
        }
    }


    private static void quickSort(int[] arr, int low, int high) {

        if (low < high) {
            // 找寻基准数据的正确索引
            int index = getIndex(arr, low, high);

            // 进行迭代对index之前和之后的数组进行相同的操作使整个数组变成有序
            //  quickSort(arr, 0, index - 1); //之前的版本，这种姿势有很大的性能问题，谢谢大家的建议
            quickSort(arr, low, index - 1);
            quickSort(arr, index + 1, high);

            //   System.out.println(index+"\t"+low+"\t"+high);
        }

    }

    /**
     * @param arr
     * @param low
     * @param high
     * @return
     * @D lalala
     */
    private static int getIndex(int[] arr, int low, int high) {
        // 基准数据

        int tmp = arr[low];
        while (low < high) {//new Arrays.
            // 当队尾的元素大于等于基准数据时,向前挪动high指针
            while (low < high && arr[high] >= tmp) {
                high--;
            }
            // 如果队尾元素小于tmp了,需要将其赋值给low
            arr[low] = arr[high];
            // 当队首元素小于等于tmp时,向前挪动low指针
            while (low < high && arr[low] <= tmp) {
                low++;
            }
            // 当队首元素大于tmp时,需要将其赋值给high
            arr[high] = arr[low];

        }
        // 跳出循环时low和high相等,此时的low或high就是tmp的正确索引位置
        // 由原理部分可以很清楚的知道low位置的值并不是tmp,所以需要将tmp赋值给arr[low]
        arr[low] = tmp;
        return low; // 返回tmp的正确位置

    }

    @Test
    public void showR() {
        for(int i=1;i<=10;i++){
            System.out.println(r(i));
        }
    }

    public int r(int a) {

        if (a == 1 || a == 2) {
            return 1;
        } else {
            return r(a - 1) + r(a - 2);
        }
    }

}