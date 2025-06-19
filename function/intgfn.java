package function;

public class intgfn {
    public static int intfncn(int i,int j){
        if(i==3){
            return 1;

        }
        int x=intfncn(i+1, j);
        int y=intfncn(i+1, j);
        return x+y;
    }
    public static void main(String args[]){
        System.out.println(intfncn(0, 2));


    }
    
}
