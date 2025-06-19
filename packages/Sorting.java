package packages;

public class Sorting {
    int arr[];
    int idx;
    int n;

    public Sorting(int arr[],int idx){
        this.arr=arr;
        this.idx=idx;
        this.n=arr.length-1;
    };
    public void BubbleSort(){
        if(n==0){
            printArr();
            return;
        };

        if(idx==n){
            idx=0;
            n--;
            BubbleSort();
            return;
        };

        if(arr[idx]>arr[idx+1]){
            int temp=arr[idx];
            arr[idx]=arr[idx+1];
            arr[idx+1]=temp;
        };

        idx++;
        BubbleSort();
    };

    public void MergeSort(int si, int ei){  //O(nlogn) time com && O(n) space com
        if(si>=ei){
            return;
        }
        int mid=si+(ei-si)/2;


        MergeSort(si,mid);
        MergeSort(mid+1,ei);

        merge(si,ei,mid);
    };

    public void merge(int si,int ei,int mid){
        int n1=mid-si+1;
        int n2=ei-mid;

        int temp1[]=new int[n1];
        int temp2[]=new int[n2];

        for (int i = 0; i < n1; i++) {
            temp1[i] = arr[si + i];
        }
        for (int j = 0; j < n2; j++) {
            temp2[j] = arr[mid + 1 + j];
        }
        

        int i=0; int j=0; int k=si;

        while(i<n1 && j<n2){
            if(temp1[i]<=temp2[j]){
                arr[k]=temp1[i];
                i++;
            }
            else{
                arr[k]=temp2[j];
                j++;
            }

            k++;
        }

            while(i<n1){
                arr[k]=temp1[i];
                i++;
                k++;

            }
            while(j<n2){
                arr[k]=temp2[j];
                j++;
                k++;

            }
        };


        public void SelectionSort(){
            if(n<=0){
                return;
            }

            if(idx==n){
                idx=0;
                SelectionSort();
            }

            if(arr[idx]>arr[idx+1]){
                int temp=arr[idx];
                arr[idx]=arr[idx+1];
                arr[idx+1]=temp;
            }

            idx++;

            while(idx<n){
                SelectionSort();
            }
            n--;
            

        }





 
    public void printArr() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
