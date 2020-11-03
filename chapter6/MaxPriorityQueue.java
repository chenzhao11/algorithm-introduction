import java.util.Arrays;

public class MaxPriorityQueue {

    /**
    * @param size  当前栈中数据的多少
    * 假设数据不超过100个
    * */
        private  int size=0;
        private  int[] arr=new int[100];


   public void insert(int key){

       arr[size]=key;
       size++;
       incress(size-1);
   }
   public int  max(){
        if(size>0){
            return arr[0];}
        return Integer.MIN_VALUE;
    }

    /**
     * @description   将当前的节点下移到正确位置
     * @param position  修改节点的下标
     * @author zhao
     * @updateTime 2020/11/3 19:26
     */
   private void decress(int position){
        int  left=2*position+1;
        int  right=2*position+2;
        int  bigger=arr[position];
        if(left<size-1&&arr[left]>bigger){
            bigger=arr[left];
        }
        if(right<size-1&&arr[right]>bigger){
            bigger=arr[right];
            int mid=arr[position];
            arr[position]=bigger;
            arr[right]=mid;
            decress(right);
        }
        if(bigger==arr[left]){
            int mid=arr[position];
            arr[position]=bigger;
            arr[left]=mid;
            decress(left);
        }
   }
    /**
     * @description 向上比较要是比父元素大交换位置
     */
   private void incress(int position){
     //主要是确定父元素的下标为   (n-1)/2
       int parent=(position-1)/2;
       if(parent>-1&&arr[parent]<arr[position]){
           int mid=arr[parent];
           arr[parent]=arr[position];
           arr[position]=mid;
           incress(parent);
       }
   }
   public void changeKeyValue(int position,int newVlaue){

       int old=arr[position];
       if(newVlaue<old){
           //降低节点的权重，从子节点中选大值替换，叶节点的下标从 n/2开始（向下取整）left=2n+1  right=2n+2
           arr[position]=newVlaue;
           decress(position);
       }else if(newVlaue>old){
           //增加权重，和自己父节点进行比较大的话两者交换位置
           arr[position]=newVlaue;
           incress(position);
       }
       else{
           //节点权重不变
       }
   }

   public int extractMax(){
       int mid=arr[size-1];
       arr[size-1]=arr[0];
       arr[0]=mid;
       size--;
       decress(0);
       return arr[size];
   }


}
