
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	Integer[] test={6, 9, 6, 16, 4};
    Integer[] test1= {1,15,32,9,8,5,19};
        Main t=new Main();
        System.out.println(Arrays.toString(t.bubbleSort(test)));//working
        //System.out.println(Arrays.toString(t.selectionSort(test)));//working
        //System.out.println(Arrays.toString(t.insertionSort(test)));//working
        //System.out.println(Arrays.toString(t.mergeSort(test)));//working
        //System.out.println(Arrays.toString(t.quickSort(test)));//working

    }
   public Integer[] bubbleSort(Integer[] arr){
       for (int i = arr.length-1; i >= 1; i--) {
           for (int j = 0; j < i; j++) {

           //swapping
           if(arr[j]>=arr[j+1])
           {
               int tmp= arr[j+1];
               arr[j+1]=arr[j];
               arr[j]=tmp;
           }
           }
       }
       return arr;
   }
    public Integer[] quickSort(Integer[] arr){
        return quickSort(arr,0,arr.length-1);
    }
    public Integer[] quickSort(Integer[] arr,Integer low, Integer high){
        if(low<high)
        {
            int index = partition(arr,low,high);
            quickSort(arr,low,index-1);
            quickSort(arr,index+1,high);
        }
        return arr;
    }

    public int partition(Integer[] arr,Integer low,Integer high){

        int pivotval=arr[low];

        int wall=low;
        for (int i = low+1; i <= high; i++) {
            if(arr[i]<=pivotval){
                wall++;
                int s=arr[i];
                arr[i]=arr[wall];
                arr[wall]=s;

            }
        }
        int s=arr[low];
        arr[low]=arr[wall];
        arr[wall]=s;

        return wall;
    }

    public Integer[] selectionSort(Integer[] arr){
        for (int i = 0; i <arr.length-1; i++) {
            int min=i;
            for (int j = i+1; j <arr.length ; j++) {
                if(arr[j]<arr[i])
                {
                    min=j;
                    int tmp=arr[i];
                    arr[i]=arr[min];
                    arr[min]=tmp;
                }
            }
        }
        return arr;
    }
    public Integer[] insertionSort(Integer[] arr){
        for (int i = 1; i <arr.length; i++) {
            int tmp= arr[i];
            int piv=i;
            while(piv>0 && arr[piv-1]>=tmp){
                arr[piv]=arr[piv-1];
                piv--;
            }
            arr[piv]=tmp;
        }
        return arr;
    }
    public Integer[] mergeSort(Integer[] arr){
        if(arr.length==1)
            return arr;
        int lsize= arr.length%2==0? arr.length/2:arr.length/2+1;
        int rsize=arr.length/2;
        //fill left array
        Integer[] left=new Integer[lsize];
        for (int i = 0; i <lsize ; i++) {
            left[i]=arr[i];
        }
        //fill right array
        Integer[] right=new Integer[rsize];
        int index=0;
        for (int i = lsize; i < arr.length; i++) {
            right[index]=arr[i];
            index++;
        }
        left=mergeSort(left);
        right=mergeSort(right);
        return merge(left, right);

    }
    public Integer[] merge(Integer[] left,Integer[] right){
        int leftwall=0;
        int rightwall=0;
        int index=0;
        int size= left.length+right.length;
        Integer[] tmp= new Integer[size];

        while(leftwall!=left.length && rightwall!= right.length){
            if(left[leftwall]>=right[rightwall]){
                tmp[index]=right[rightwall];
                rightwall++;
                index++;
            }
            else{
               tmp[index]=left[leftwall];
                leftwall++;
                index++;
            }
        }

        while(leftwall!=left.length){
            tmp[index]=left[leftwall];
            index++;
            leftwall++;
        }
        while(rightwall!=right.length){
            tmp[index]=right[rightwall];
            index++;
            rightwall++;
        }
        return tmp;
    }





}
