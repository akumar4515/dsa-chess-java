import packages.arrayQueue;
import packages.llQueue;

public class queue {
    public static void main(String args[]){
        arrayQueue q=new arrayQueue(5);
        llQueue q2=new llQueue();


        q2.add(10);
        q2.add(11);
        q2.add(12);
        System.out.println(q2.peek());
        q2.remove();
        System.out.println(q2.peek());

    }
    
}
