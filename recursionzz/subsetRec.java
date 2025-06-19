package recursionzz;

public class subsetRec {

    public static void Subset(String str, String ans, int i){
        if(i==str.length()){
            if(ans.length()==0){
                System.out.println("null");
            }
            else{
                System.out.println(ans);
            }
            return;
            
            
        }

        Subset(str, ans+str.charAt(i), i+1);
        Subset(str, ans, i+1);
    }

    public static void main(String args[]){
        String str="abc";
        Subset(str, "", 0);
        } 
}
