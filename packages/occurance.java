package packages;

public class occurance {
    int arr[];
    int i;

    public occurance(int arr[]){
        this.arr=arr;
        this.i=0;
    }

    public void FirstOcuurance(int el){
        while(i<=arr.length-1){
            if(arr[i]==el){
                System.out.println("first occurance of element"+" "+el+" "+"found at index: "+i);
                return;
            }
            i++;
        }
        System.out.println("element does not found");
        
    };
    
    
}

