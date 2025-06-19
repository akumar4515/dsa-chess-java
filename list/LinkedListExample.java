package list;
import java.util.*;

 class LinkedListExample<T> {
    Node<T> head;

    class Node<T>{
        T data;
        Node<T> next;
        Node(T data){
            this.data=data;
            this.next=null;
        }
    }
    Boolean isEmpty(){
        Node<T> current=head;
        if(current==null){
            return true;
        }
        return false;
    }
     void AddFirst(T data){
        Node<T> newNode=new Node<T>(data);
        if(isEmpty()){
            head=newNode;
           
        }
         else{
                newNode.next=head;
                head=newNode;
         }

    };

    void AddLast(T data){
        Node<T> newNode=new Node<T>(data);
        if(isEmpty()){
            head=newNode;
        }
        else{
            Node<T> current=head;
            while(current.next!=null){
                current=current.next;
            }
            current.next=newNode;
        }
    }

    void printList(){
        Node<T> current=head;
        while(current!=null){
            System.out.println(current.data);
            current=current.next;
        }
    }


    public static void main(String[] args) {
    LinkedListExample<Integer> list = new LinkedListExample<>();
    list.AddFirst(1);
    list.AddFirst(2);
    list.AddLast(3);
    list.printList();
    }
}
