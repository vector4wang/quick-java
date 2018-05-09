package algorithm.binary_search;

/**
 * @Author: wangxc
 * @GitHub: https://github.com/vector4wang
 * @CSDN: http://blog.csdn.net/qqhjqs?viewmode=contents
 * @BLOG: http://vector4wang.tk
 * @wxid: BMHJQS
 * 自己就白板实现的二分法查找，思想已get
 */
public class TestMain {
    public static void main(String[] args) {
        int key = 14;
        int start,end,mid = 0;
        int[] array = { 1, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18 };

        start = 0;
        end = array.length-1;
        System.out.println("start  end    mid ");
        while(start <= end){
            mid = (end-start)/2 + start;
            if(array[mid]>key){
                end = mid - 1;
            }else if(array[mid]<key){
                start = mid + 1;
            }else{
                break;
            }
            System.out.println(start + "      " + end + "      " + mid);
        }
        System.out.println("position: " + mid);


    }
}
