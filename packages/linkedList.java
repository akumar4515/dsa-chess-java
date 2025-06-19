package packages;

public class linkedList {

    public class Node{
        int data;
        Node next;

        public Node(int data){
            this.data=data;
            this.next=null;            
        }
    }

    Node head;
    Node tail;

    public void addFirst(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=tail=newNode;
            return;
        }
        
        newNode.next=head;
        head=newNode;
    }

    public void addLast(int data){
        Node newNode=new Node(data);
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        tail=newNode;
        temp.next=newNode;
    }
    public void addIn(int data,int idx){
        Node newNode=new Node(data);
        Node temp=head;

        if(idx==0){
            addFirst(data);
            return;
        }
        int i=0;
        while(i!=idx-1){
            temp=temp.next;
            i++;

        }

     newNode.next=temp.next;
     temp.next=newNode;
    }


    public void updateVal(int data,int idx){
        Node temp=head;
        if(idx==0){
            head.data=data;
            return;
        }
        int i=0;
        while(i!=idx){
            temp=temp.next;
            i++;
        }
        temp.data=data;
    }

    public void updateList(int cur,int idx){
        Node prev=null;
        Node curr=head;
        int i=0;
        while(i!=cur){
            if(i==0){
                prev=head;
                curr=curr.next;
            }
            else{
                curr=curr.next;
                prev=prev.next;

            }
           
            i++;
        }
        prev.next=curr.next;

            int j=0;
            Node prevNode=null;
            Node idxNode=head;
            while(j!=idx){
                if(j==0){
                    prevNode=head;
                    idxNode=idxNode.next;
                    
                }
                else{
                    idxNode=idxNode.next;
                    prevNode=prevNode.next;
                    
    
                }
               
                j++;
            }
            curr.next=prevNode.next;
            prevNode.next=curr;
    }




    public void printlnLL(){
        Node temp=head;

        while(temp!=null){
            System.out.print(temp.data+" --> ");
            temp=temp.next;
        }
        System.out.println("null");
    }
    
}
