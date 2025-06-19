package packages;

public class llQueue {
    static Node head=null;

    public static class Node{
        int data;
        Node next;

         Node(int data){
            this.data=data;
            this.next=null;
        }

      
        }
        public static boolean isEmpty(){
            return head==null;
        }

        public static void add(int data){
            Node newnode=new Node(data);

            if(isEmpty()){
                newnode.next=null;
                head=newnode; 
            }
            else{
                Node track=head;
                while(track.next!=null){
                    track=track.next;
                }
                newnode.next=null;
                track.next=newnode;

            }
            

            }


            public static int peek(){
                if(isEmpty()){
                    System.out.println("queue is empty");
                }
               
                    return head.data;

               
            };


            public static void remove(){
                head=head.next;
            }
    }

  
    

