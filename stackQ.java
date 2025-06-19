import java.util.LinkedList;
import java.util.Queue;

public class stackQ {
    public static Queue<Integer> q1= new LinkedList<>();
    public static Queue<Integer> q2=new LinkedList<>();

   public static void Enqueue(int data){
    q2.add(data);
     while(!q1.isEmpty()){
        q2.add(q1.poll());

     };
     while(q2!=null){
        q1.add(q2.poll());
     }
   }

   public static void PrintQ() {
    while(q1!=null){
        System.out.println(q1.peek());
    }
   }
}
