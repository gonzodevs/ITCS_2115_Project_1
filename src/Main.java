
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	Integer[] test={19, 12, 19, 12, 8};
    Integer[] test1= {1,15,32,9,8,5,19};
        Main t=new Main();
        //System.out.println(Arrays.toString(t.bubbleSort(test)));//working
        //System.out.println(Arrays.toString(t.selectionSort(test)));//working
        //System.out.println(Arrays.toString(t.insertionSort(test)));//working
        //System.out.println(Arrays.toString(t.mergeSort(test)));//working
        //System.out.println(Arrays.toString(t.quickSort(test)));//working

    }
   public Integer[] bubbleSort(Integer[] arr){
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

   public Integer[] mergeSort(Integer[] in){
      ArrayList<Integer> arr=mergeS(in);
       Integer[] result= new Integer[arr.size()];
       for (int i = 0; i <arr.size() ; i++) {
           result[i]=arr.get(i);
       }
       return result;

   }
    //recursively sort each array
    public ArrayList<Integer> mergeS(Integer[] in){
        ArrayList arr=new ArrayList();
        //copy array to arraylist
        for (int i = 0; i <in.length; i++) {
            arr.add(in[i]);
        }
        //base case
        if(arr.size()<=1)
            return arr;

        ArrayList left=new ArrayList();
        ArrayList right=new ArrayList();

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
        left=mergeS((Integer[]) left.toArray(new Integer[left.size()]));
        right=mergeS((Integer[]) right.toArray(new Integer[right.size()]));

        //merge sorted sublists
        return merge(left,right);

    }
    //merge arrays back
    public ArrayList<Integer> merge(ArrayList<Integer> left,ArrayList<Integer> right){
        ArrayList sorted=new ArrayList();

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




}
