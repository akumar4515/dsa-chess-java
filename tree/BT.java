
package tree;

public class BT {
    int idx=-1;  
    Node root;  
    class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data=data;
        }
    }

    Node createTree(int [] tree){
        idx++;
        if(idx>=tree.length ||tree[idx]==0){
            return null;
        }
        Node newNode=new Node(tree[idx]);
        newNode.left=createTree(tree);
        newNode.right=createTree(tree);
        return newNode;

    };

    void printTree(Node root){
        if(root==null) return;
        printTree(root.left);
        System.out.print(root.data+" ");
        printTree(root.right);

    };

    boolean isElementPresent(Node root,int data){
        if(root==null) return false;

        if(root.data==data) return true;

        if(root.data>data){
            return isElementPresent(root.left,data);

        }
        else{
            return isElementPresent(root.right,data);
        }

    }




    public static void main(String args[]){
        int [] data={1,2,3,0,0,4,5,0,6,0,0,7,0,0};
        BT tree=new BT();
       tree.root= tree.createTree(data);
        System.out.println("Inorder Traversal of the tree:");
        tree.printTree(tree.root);
        System.out.println();

        
        System.out.println(tree.isElementPresent(tree.root, 9));


    }
    
}
