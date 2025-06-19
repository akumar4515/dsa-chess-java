package packages;

public class searching {
    int arr[];
    int n;
    int i;
    public searching(int arr[]){
        this.arr=arr;
        this.n=arr.length-1;
        this.i=0;
    };

    public void LinearSearch(int el){
        if(i==n){
            System.out.println("element not found");
            return;
        }

        while(i<n){
            if(arr[i]==el){
                System.out.print("Element "+el+" "+"found at index: "+i);
                return;
            }
            i++;
        }

    }

    
}
