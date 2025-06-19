import java.util.Stack;
public class StackDsa {

    public static void pushAtBottom(Stack<Integer> stack, int n){
        if(stack.isEmpty()){
            stack.push(n);
            return;

        }


        int top=stack.pop();
        pushAtBottom(stack, n);
        stack.push(top);
        
    }



    public static void main(String args[]){
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        pushAtBottom(stack, 5);

      while(!stack.isEmpty()){
        System.out.println(stack.peek());
        stack.pop();
      }


    }
    
}
