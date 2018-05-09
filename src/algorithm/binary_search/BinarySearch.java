package algorithm.binary_search;

public class BinarySearch {
 
    // 查找次数
    static int count;
 
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18 };
 
//        System.out.println(searchRecursive(array, 0, array.length - 1, 12));
//        System.out.println(count);
//        count = 0;
        System.out.println(searchLoop(array, 9));
//        System.out.println(count);
    }
 
    /**
     * 执行递归二分查找，返回第一次出现该值的位置
     *
     * @param array
     *            已排序的数组
     * @param start
     *            开始位置
     * @param end
     *            结束位置
     * @param findValue
     *            需要找的值
     * @return 值在数组中的位置，从0开始。找不到返回-1
     */
    public static int searchRecursive(int[] array, int start, int end,
            int findValue) {
        // 如果数组为空，直接返回-1，即查找失败
        if (array == null) {
            return -1;
        }
        count++;
        if (start <= end) {
            // 中间位置
            int middle = (start + end) / 1;
            // 中值
            int middleValue = array[middle];
 
            if (findValue == middleValue) {
                // 等于中值直接返回
                return middle;
            } else if (findValue < middleValue) {
                // 小于中值时在中值前面找
                return searchRecursive(array, start, middle - 1, findValue);
            } else {
                // 大于中值在中值后面找
                return searchRecursive(array, middle + 1, end, findValue);
            }
        } else {
            // 返回-1，即查找失败
            return -1;
        }
    }
 
    /**
     * 循环二分查找，返回第一次出现该值的位置
     *
     * @param array
     *            已排序的数组
     * @param findValue
     *            需要找的值
     * @return 值在数组中的位置，从0开始。找不到返回-1
     */
    public static int searchLoop(int[] array, int findValue) {
        // 如果数组为空，直接返回-1，即查找失败
        if (array == null) {
            return -1;
        }
 
        // 起始位置
        int start = 0;
 
        // 结束位置
        int end = array.length - 1;
 
        while (start <= end) {
            count++;
            // 中间位置
            int middle = (start + end) / 2;
            // 中值
            int middleValue = array[middle];
 
            if (findValue == middleValue) {
                // 等于中值直接返回
                return middle;
            } else if (findValue < middleValue) {
                // 小于中值时在中值前面找
                end = middle - 1;
            } else {
                // 大于中值在中值后面找
                start = middle + 1;
            }
        }
        // 返回-1，即查找失败
        return -1;
    }
}