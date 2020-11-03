import java.util.Arrays;

public class FastSort {
    /**
     * @description  进行快排的关键程序，将待排序数组分成两部分例如左边小（小于等于还不会破坏相等的顺序），右边大
     * 排序从小到大
     * @param arr
     * @param p 待排序区间左边起始点
     * @param r 待排序区间右边结束点
     * @author zhao
     * @updateTime 2020/11/3 20:47
     * @return: int 当前的数在数组中的正确位置
     */
    private static int partition(int[] arr,int p,int r){
            //第一次写成了-1  注意！！！！！！！
            int j = p-1;
            int target = arr[r];
            for (int i = p; i < r; i++) {
                if (arr[i] <= target) {
                    //遇到小的就通过j指针移到前面来
                    int mid = arr[i];
                    j++;
                    arr[i] = arr[j];
                    arr[j] = mid;
                }
            }
            //循环结束时间j+1的位置就是当前target的正确位置
            int mid = arr[r];
            arr[r] = arr[j + 1];
            arr[j + 1] = mid;
            return j + 1;

    }
    private static  void fastSort(int[] arr,int p,int r){
        if(p<r){
            int j=partition(arr,p,r);
            fastSort(arr,p,j-1);
            fastSort(arr,j+1,r);
        }

    }
    public static   void main(String[] args){
        int [] a={0,3,2,3,6,2,656,5,22,623,2};
        fastSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));

    }


}
