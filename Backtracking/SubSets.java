

public class SubSets {

    public static void subSets(String str, String ans, int index){
        if(index == str.length()){
            System.out.println(ans);
            return;

        }

        //yes 
        subSets(str, ans+str.charAt(index), index+1);
        //No
        subSets(str, ans, index+1);
    }
    public static void main(String[] args) {
        subSets("abc", "", 0);
        
    }
}
