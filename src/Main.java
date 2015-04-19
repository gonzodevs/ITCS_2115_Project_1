import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	int[] test={1,15,32,9,8,5,19};
        Main t=new Main();
        System.out.println(Arrays.toString(t.bubbleSort(test)));
        System.out.println(Arrays.toString(t.selectionSort(test)));
        System.out.println(Arrays.toString(t.insertionSort(test)));

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
    public int [] mergeSort(int[] arr){
        //not implemented

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
