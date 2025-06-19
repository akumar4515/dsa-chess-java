public class stacks {
    static int top=-1;

    int arr[]=new int[5];
    int size=arr.length-1;

    public void Push(int data){
        arr[++top]=data;
    };

    public int Pop(){
        if(isEmpty()){
            System.out.println("No data present.");
            return-1;
        }
        return arr[top--];
    };

    public int peek(){
        if(isEmpty()){
            System.out.println("No data present.");
            return-1;
        }
        return arr[top];

    }

    public void printStackArr(){
        int i=top;
        while(i>=0){
            System.out.print(arr[i]+"-->");
            i--;
        }

    }



    public boolean isEmpty(){
        return top==-1;
    };
    public static void main(String args[]){
       stacks stack=new stacks();
       stack.Push(1);
       stack.Push(2);
       stack.Push(3);
       stack.Push(4);
    //    stack.printStackArr();
       System.out.println(stack.peek());
       System.out.println(stack.Pop());
       stack.printStackArr();




                
    }
    
}
