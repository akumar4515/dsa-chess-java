package packages;

public class doubleLinked {

    class Node{
        int data;
        Node next;
        Node prev;

        Node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }

    }

    Node head=null;
    Node tail=null;

    public void addFromStart(int data){
        Node newNode=new Node(data);
        Node temp=head;
        if(head==null){
            head=tail=newNode;
        }
        else{
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=newNode;
            tail=newNode;
            newNode.prev=temp;

        }
    };

    public void addFromEnd(int data){
        Node newNode=new Node(data);
        Node  temp=tail;
        if(tail==null){
            head=tail=newNode;
        }
        else{
            while(temp.prev!=null){
                temp=temp.prev;
            }
            temp.prev=newNode;
            head=newNode;
            newNode.next=temp;

        }
    }




    public void printStartList(){
        Node temp=head;

        while(temp.next!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println(temp.data);
        System.out.println(temp.prev.data);
    };


    public void printEndList(){
        Node temp=tail;

        while(temp.prev!=null){
            System.out.print(temp.data+" ");
            temp=temp.prev;
        }
        System.out.println(temp.data);
        System.out.println(temp.next.data);
    };


    
}
