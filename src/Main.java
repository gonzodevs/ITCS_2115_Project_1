
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	int[] test={1,15,32,9,8,5,19};
        Main t=new Main();
        System.out.println(Arrays.toString(t.bubbleSort(test)));
        System.out.println(Arrays.toString(t.selectionSort(test)));
        System.out.println(Arrays.toString(t.insertionSort(test)));
        System.out.println(Arrays.toString(t.mergeSort(test)));

    }
   public int[] bubbleSort(int[] arr){
       for (int i = arr.length-1; i > 1; i--) {
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
    public int[] quickSort(int[] arr){
        //not implemented
        return arr;
    }
    //initializer for merge sort
    public int[] mergeSort(int[] arr){
        return mergeSort(arr,0,arr.length-1);
    }
    //recursively sort each array
    public int [] mergeSort(int[] arr,int left,int right){
        if(left<right){
            int pivot=(right+left)/2;
            mergeSort(arr,left,pivot);
            mergeSort(arr,pivot+1,right);
            merge(arr,pivot+1,right);
        }

        return arr;
    }
    //merge arrays back
    public int[] merge(int[] arr, int left, int right){
        if(right-left<2)
            return arr;
       int []tmp=new int[arr.length-1];

        //copy original array into a tmp
        for (int i = left; i <= right ; i++) {
            tmp[i]=arr[i];
        }
        int midpivot=((right+left)/2)+1;
        int leftpivot=left;
        //compare and copy smallest val from tmp back to arr
        while(left<=midpivot && midpivot<=right)
        {
            if(tmp[left]<=tmp[midpivot]){
                arr[left]=tmp[midpivot];
                left++;
            }
            else {
                //out of order therefore must rearrange
                arr[left]=tmp[midpivot];
                midpivot  = midpivot+1;
            }
            leftpivot=leftpivot+1;
        }
        while(left<=midpivot){
            arr[leftpivot]=tmp[left];
            left++;
            leftpivot++;
        }

        return arr;

    }
    public int[] selectionSort(int[] arr){
        for (int i = 0; i <arr.length-1 ; i++) {
            int tmp=i;
            for (int j = i+1; j <arr.length-1 ; j++) {
                if(arr[j]<arr[i])
                {
                    tmp=j;
                    arr[j]=arr[i];
                    arr[i]=tmp;
                }
            }
        }
        return arr;
    }
    public int[] insertionSort(int[] arr){
        for (int i = 1; i <arr.length-1 ; i++) {
            int tmp= arr[i];
            int piv=i;
            while(i>0 && arr[piv-1]>=tmp){
                arr[piv]=arr[piv-1];
                piv--;
            }
            arr[piv]=tmp;
        }
        return arr;
    }




}
