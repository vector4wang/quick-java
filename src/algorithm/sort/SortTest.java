package algorithm.sort;

/**
 * @author vector
 * @date: 2018/12/4 0004 10:07
 * http://blog.damonare.cn/2016/12/20/%E5%8D%81%E5%A4%A7%E7%BB%8F%E5%85%B8%E6%8E%92%E5%BA%8F%E7%AE%97%E6%B3%95%E6%80%BB%E7%BB%93%EF%BC%88javascript%E6%8F%8F%E8%BF%B0%EF%BC%89/
 * https://mp.weixin.qq.com/s/b1T4yFGf98z4Zqe0cMrbrg
 */
public class SortTest {
    public static void main(String[] args) {
        int arr[] = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        long s = System.nanoTime();
        //        bubbleSort(arr);
        //        selectionSort(arr);
//		insertionSort(arr);
//        shellSort(arr);
//        mergeSort(arr, 0, arr.length - 1);
        heapSort(arr);

        long e = System.nanoTime();
        print(arr, (e - s) / 1000_000);

    }

    /**
     * 堆排序
     * https://www.cnblogs.com/chengxiao/p/6129630.html
     * 1、将无序列数组构建成一个堆，根据升序或降序需求选择大顶堆(每个结点的值都大于或等于其左右孩子结点的值)或小顶堆(每个结点的值都小于或等于其左右孩子结点的值)
     * 2、将末尾元素摘出来与堆顶元素交换，末尾元素即当前堆结构中的最大的元素
     * 3、重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序
     *
     * @param arr
     */
    private static void heapSort(int[] arr) {
        // 1、构建大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr, i, arr.length);
        }

        //2.调整堆结构+交换堆顶元素与末尾元素
        for(int j=arr.length-1;j>0;j--){
            swap(arr,0,j);//将堆顶元素与末尾元素进行交换
            adjustHeap(arr,0,j);//重新对堆进行调整
        }

    }

    /**
     * 交换元素
     * @param arr
     * @param a
     * @param b
     */
    private static void swap(int[] arr, int a, int b) {
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /**
     * 调整大顶堆
     *
     * @param arr
     * @param i
     * @param length
     */
    private static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];//先取出当前元素i
        for (int j = i * 2 + 1; j < length; j = j * 2 + 1) {//从i结点的左子结点开始，也就是2i+1处开始
            if (j + 1 < length && arr[j] < arr[j + 1]) {//如果左子结点小于右子结点，k指向右子结点
                j++;
            }
            if (arr[j] > temp) {//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[j];
                i = j;
            }else{
                break;
            }
        }
        arr[i] = temp;//将temp值放到最终的位置
    }

    /**
     * 归并排序
     * 把长度为n的输入序列分成两个长度为n/2的子序列；
     * 对这两个子序列分别采用归并排序；
     * 将两个排序好的子序列合并成一个最终的排序序列。
     *
     * @param arr
     * @param L
     * @param R
     */
    private static void mergeSort(int[] arr, int L, int R) {
        //如果只有一个元素，那就不用排序了
        if (L == R) {
            return;
        }
//取中间的数，进行拆分
        int M = (L + R) / 2;
        //左边的数不断进行拆分
        mergeSort(arr, L, M);
        //右边的数不断进行拆分
        mergeSort(arr, M + 1, R);
        //合并
        merge(arr, L, M + 1, R);
    }

    /**
     * @param arr
     * @param L   指向数组第一个元素
     * @param M   指向数组分隔的元素
     * @param R   指向数组最后的元素
     */
    private static void merge(int[] arr, int L, int M, int R) {
        //左边的数组的大小
        int leftArr[] = new int[M - L];
        //右边的数组大小
        int rightArr[] = new int[R - M + 1];
//往这两个数组填充数据
        for (int i = L; i < M; i++) {
            leftArr[i - L] = arr[i];
        }
        for (int i = M; i < R; i++) {
            rightArr[i - M] = arr[i];
        }

        int i = 0, j = 0;
        // arrays数组的第一个元素
        int k = L;

        //比较这两个数组的值，哪个小，就往数组上放
        while (i < leftArr.length && j < rightArr.length) {
//谁比较小，谁将元素放入大数组中,移动指针，继续比较下一个
            if (leftArr[i] < rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
                k++;
            } else {
                arr[k] = rightArr[j];
                j++;
                k++;
            }
        }
//如果左边的数组还没比较完，右边的数都已经完了，那么将左边的数抄到大数组中(剩下的都是大数字)
        while (i < leftArr.length) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < rightArr.length) {
            arr[k] = rightArr[j];
            k++;
            j++;
        }
    }


    /**
     * 希尔排序又叫缩小增量排序
     * 选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
     * 按增量序列个数k，对序列进行k 趟排序；
     * 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
     *
     * @param arr
     */
    private static void shellSort(int[] arr) {
        int number = arr.length / 2;
        int i, j, temp;
        while (number >= 1) {
            for (i = number; i < arr.length; i++) {
                temp = arr[i];
                j = i - number;
                while (j >= 0 && arr[j] > temp) {
                    arr[j + number] = arr[j];
                    j = j - number;
                }
                arr[j + number] = temp;
            }
            number = number / 2;
        }

    }

    /**
     * 插入排序
     * 从第一个元素开始，该元素可以认为已经被排序；
     * 取出下一个元素，在已经排序的元素序列中从后向前扫描；
     * 如果该元素（已排序）大于新元素，将该元素移到下一位置；
     * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
     * 将新元素插入到该位置后；
     * 重复步骤2~5。
     * <p>
     * 最好手动操作下
     *
     * @param arr
     */
    private static void insertionSort(int[] arr) {
        int len = arr.length;
        int preIndex, current;
        for (int i = 1; i < len; i++) {
            preIndex = i - 1;
            current = arr[i];
            while (preIndex >= 0 && arr[preIndex] > current) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
    }

    /**
     * 选择排序
     * 初始状态：无序区为R[1..n]，有序区为空；
     * 第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R(i..n）。
     * 该趟排序从当前无序区中-选出关键字最小的记录 R[k]，将它与无序区的第1个记录R交换，使R[1..i]和R[i+1..n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；
     * n-1趟结束，数组有序化了。
     *
     * @param arr
     */
    private static void selectionSort(int[] arr) {
        int minIndex, temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    /**
     * 冒泡排序
     * 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
     * 针对所有的元素重复以上的步骤，除了最后一个；
     * 重复步骤1~3，直到排序完成。
     *
     * @param
     */
    private static void bubbleSort(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }


    private static void print(int[] newArr, long millisecond) {
        for (int i : newArr) {
            System.out.print(i + ", ");
        }
        System.out.print("耗时: " + millisecond);
        System.out.println();
    }
}
