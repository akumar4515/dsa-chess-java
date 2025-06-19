package packages;

public class arrayQueue {
    static int arr[];
    static int size;
    static int rear;

    public arrayQueue(int size){
       arr=new int[size];
       this.size=size;
       rear= -1;
    };


    public static boolean isEmpty(){
        return rear==-1;
    }


    public static void add(int data){
        if(rear==size-1){
            System.out.println("queue is full");
            return;
        }
        rear=rear+1;
        arr[rear]=data;

    }

    public static int peek(){
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return arr[0];
    };
    
    public static void remove(){
        for(int i=0;i<rear;i++){
            arr[i]=arr[i+1];
        }
        rear--;

    }

    public static void printArr(){
        if(isEmpty()){
            System.out.println("empty arr");
        }
        int i=0;
        while(i<arr.length){
            System.out.println(arr[i]);
            i++;
        }
    }
    
}
