
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	int[] test={1,15,32,9,8,5,19};
    Integer[] test1= {1,15,32,9,8,5,19};
        Main t=new Main();
        System.out.println(Arrays.toString(t.bubbleSort(test)));
        System.out.println(Arrays.toString(t.selectionSort(test)));
        System.out.println(Arrays.toString(t.insertionSort(test)));
        System.out.println(t.mergeSort(test1));

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
