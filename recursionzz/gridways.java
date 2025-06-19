package recursionzz;

public class gridways {

    public static int grid(int i,int j,int m,int n){
        if(i==m-1 &&j==n-1){
            return 1;
        }
        if(i==m || j==n){
            return 0;
        }

        int w1=grid(i+1, j, m, n);
        int w2=grid(i, j+1, m, n);
        return w1+w2;
    }

    public static void main(String args[]){
        int m=3;
        int n=3;
        System.out.println(grid(0, 0, m, n));

    }
    
}
