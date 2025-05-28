public class Power {
    
    public double myPow(double x, int n) {
        if(n==0){
            return 1;
        }
        int halfPower = (int) (myPow(x,n/2) * myPow(x,n/2));

        if(n%2==1){
            halfPower = (int) (x * halfPower);
        }

        return halfPower;
        
        
    }
    public static void main(String[] args) {
        System.out.println(new Power().myPow(2, 10));
    }
}
