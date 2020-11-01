package chapter6;

import java.util.Arrays;

public class Heapsort {

    public  int[] makeBigHeap(int[] arr) {
        //创建大顶堆，叶子节点再数组的下标 向下取整n/2后面的所有元素
        //从下往上建堆
        int i=arr.length/2-1;
        int length=arr.length;
        while(i>-1){
            mantainBigheap(arr,i,length);
            i--;
        }
        return arr;
    }

    public int[] bigHeapsort(int[] arr) {
        //对传入的数组先建堆再将第一个元素移动到最后一个位置，再将数组的length-1
        makeBigHeap(arr);
        int length=arr.length;
        for(int i=length-1;i>0;i--){
            int mid=arr[0];
            arr[0]=arr[i];
            arr[i]=mid;
            //交换信息过后需要维护,维护数组的范围需要length-1
            mantainBigheap(arr,0,i);
        }
        return  arr;
    }

    public int[] makeMinHeap(int[] arr) {
        int i=arr.length/2-1;
        int length=arr.length;
        while(i>-1){
            mantainMinheap(arr,i,length);
            i--;
        }
        return arr;
    }

    public int[] minHeapsort(int[] arr) {
        makeMinHeap(arr);
        int length=arr.length;
        for(int i=length-1;i>0;i--){
            int mid=arr[0];
            arr[0]=arr[i];
            arr[i]=mid;

            mantainMinheap(arr,0,i);
        }
        return  arr;
    }

    public void mantainBigheap(int[] arr,int position,int arrsize) {
        //根据需要维护的位置对大顶堆进行维护，维护针对其子树
        //左子树是2n+1  右子树 2n+2
        //易错：找的是左右子节点的最大值不是两个递归
        int biggest=arr[position];
        int length=arrsize;
        int leftchild=position*2+1;
        int rightchild=position*2+2;

        if(leftchild<length&&arr[leftchild]>biggest){
            biggest=arr[leftchild];
        }
        if(rightchild<length&&arr[rightchild]>biggest){
            biggest=arr[rightchild];
        }
        int mid=arr[position];
        arr[position]=biggest;
        if(leftchild<length&&biggest==arr[leftchild]){
            arr[leftchild]=mid;
            mantainBigheap(arr,leftchild,length);
        }
        else if(rightchild<length&&biggest==arr[rightchild]){
            arr[rightchild]=mid;
            mantainBigheap(arr,rightchild,length);
        }

    }


    public void mantainMinheap(int[] arr,int position,int arrsize) {

        int minnest=arr[position];
        int length=arrsize;
        int leftchild=position*2+1;
        int rightchild=position*2+2;

        if(leftchild<length&&arr[leftchild]<minnest){
            minnest=arr[leftchild];
        }
        if(rightchild<length&&arr[rightchild]<minnest){
            minnest=arr[rightchild];
        }
        int mid=arr[position];
        arr[position]=minnest;
        if(leftchild<length&&minnest==arr[leftchild]){
            arr[leftchild]=mid;
            mantainMinheap(arr,leftchild,length);
        }
        else if(rightchild<length&&minnest==arr[rightchild]){
            arr[rightchild]=mid;
            mantainMinheap(arr,rightchild,length);
        }

    }
    public static  void main (String[] arrgs){
        Heapsort heapSortimp=new Heapsort();
        int[]a={0,0,0,0,13,22,323,26,6456,26323,23,3131,313,131,313,13,2313,15};
        System.out.println("原数组"+ Arrays.toString(a));
        System.out.println(Arrays.toString(heapSortimp.bigHeapsort(a)));
        System.out.println(Arrays.toString(heapSortimp.minHeapsort(a)));
    }
}
