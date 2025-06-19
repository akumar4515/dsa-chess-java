import java.util.ArrayList;
public class arrayLists {

    public static void main(String args[]){
        ArrayList<Integer> list=new ArrayList<>();
        int i=0;

        while(i<=100){
            list.add(i*2);
            i++;
        }

        list.size();
        
        list.addFirst(100);
        list.addLast(201);

        list.add(1,101);

        list.set(1,10111);
        
        int j=0;
        while(j<=list.size()-1){
            System.out.println(list.get(j));
            j++;
        }

        System.out.println(list.contains(1));

        


    }
    
}