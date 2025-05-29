public class PrintBinary {

    public static void print(int n,int lastDigit,String str ){
        if(n==0){
            System.out.println(str);
            return;
        }

        print(n-1, 0, str+"0");
        if(lastDigit==0){
            print(n-1, 1, str+"1");
            
        }
    }
    public static void main(String[] args) {
        print(3, 0, new String(""));
        
    }
}
