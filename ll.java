import packages.doubleLinked;
import packages.linkedList;

public class ll {
    public static void main(String args[]){
        // linkedList list=new linkedList();
        doubleLinked list=new doubleLinked();
        list.addFromStart(0);
        list.addFromStart(1);
        list.addFromStart(2);
        list.addFromEnd(12);
       

        list.printStartList();
        list.printEndList();
    }
    
}
