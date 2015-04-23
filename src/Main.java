
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	int[] test={1,90,3,16,1,15,32,9,8,81,5,19,2};
    Integer[] test1= {1,15,32,9,8,5,19};
        Main t=new Main();
        //System.out.println(Arrays.toString(t.bubbleSort(test)));//working
        //System.out.println(Arrays.toString(t.selectionSort(test)));//working
        System.out.println(Arrays.toString(t.insertionSort(test)));//working
        //System.out.println(t.mergeSort(test1));//working
        //System.out.println(Arrays.toString(t.quickSort(test, 0, test.length - 1)));//working

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
    public int[] quickSort(int[] arr,int low, int high){
        if(low<high)
        {
            int index = partition(arr,low,high);
            quickSort(arr,low,index-1);
            quickSort(arr,index+1,high);
        }
        return arr;
    }

    public int partition(int[] arr,int low,int high){

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

    //recursively sort each array
    public ArrayList<Integer> mergeSort( Integer[] in){
        ArrayList<Integer> arr=new ArrayList<Integer>();
        //copy array to arraylist
        for (int i = 0; i <in.length; i++) {
            arr.add(in[i]);
        }
        //base case
        if(arr.size()<=1)
            return arr;

        ArrayList<Integer> left=new ArrayList<Integer>();
        ArrayList<Integer> right=new ArrayList<Integer>();

        int midpivot=arr.size()/2;

        //populate left side
        for (int i = 0; i < midpivot; i++) {
            left.add(arr.get(i));
        }
        //populate right side
        for (int i = midpivot; i < arr.size(); i++) {
            right.add(arr.get(i));
        }

        //sort left and right recursively
        left=mergeSort(left.toArray(new Integer[left.size()]));
        right=mergeSort(right.toArray(new Integer[right.size()]));

        //merge sorted sublists
        return merge(left,right);

    }
    //merge arrays back
    public ArrayList<Integer> merge(ArrayList<Integer> left,ArrayList<Integer> right){
        ArrayList<Integer> sorted=new ArrayList<Integer>();

        while(!left.isEmpty() && !right.isEmpty()){
            //left list element is less than right, add to sorted array and remove from left list
            if(left.get(0)<=right.get(0)){
                sorted.add(left.get(0));
                left.remove(0);
            }
            else{
                sorted.add(right.get(0));
                right.remove(0);
            }
        }
        if(!left.isEmpty()){
            while(!left.isEmpty()){
                sorted.add(left.get(0));
                left.remove(0);
            }
        }
        if(!right.isEmpty()){
            while(!right.isEmpty()){
                sorted.add(right.get(0));
                right.remove(0);
            }
        }
        return sorted;

    }
    public int[] selectionSort(int[] arr){
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
    public int[] insertionSort(int[] arr){
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




}
