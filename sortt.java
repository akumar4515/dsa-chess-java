import packages.*;
public class sortt {

    public static void main(String args[]){
        int arr[]={2,1,3,420,40,2,10};
        Sorting sort=new Sorting(arr,0);
        occurance occur=new occurance(arr);
        sort.SelectionSort();
        sort.printArr();

        occur.FirstOcuurance(1);
    }
   
    
}
