package recursionzz;
public class lassroom {

    public static void changeArr(int arr[],int i,int val){
     if(i==arr.length){
        PrintArr(arr);
        return;
     }
        arr[i]=val;
        changeArr(arr, i+1, val+1);
        arr[i]=arr[i]-2;
    }

    public static void PrintArr(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }
    public static void main(String args[]){
        int arr[]=new int[5];
        changeArr(arr, 0, 1);
        PrintArr(arr);


    }
    
}
