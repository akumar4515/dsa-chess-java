import java.util.*;

public class Solution{

    public static void main(String args[]){
        int matrix[][]=new int[3][3];
        for(int i=0;i<matrix.length; i++){
            for(int j=0;j<matrix.length;j++){
                if(i==j ||i+j==matrix.length-1){
                    matrix[i][j]=1;
                }
                else{
                    matrix[i][j]=0;
                }

            }
        }

        for(int i=0;i<matrix.length; i++){
            for(int j=0;j<matrix.length;j++){
                System.out.print(matrix[i][j]+" ");

             }
             System.out.println();
        }
    }

}