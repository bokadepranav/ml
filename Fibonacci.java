public class Fibonacci {

    //non recursive way
    public static void non_rec_fibo(int n) {
        int num1 = 0;
        int num2 = 1;
        int num3;
        int count = 0;
        while(count < n) {
            System.out.print(num1 + " ");
            num3 = num1 + num2;
            num1 = num2;
            num2 = num3;
            count++;
        }
    }
    //recursive way
    public static int rec_fibo(int n) {
        if(n==0 || n==1) {
            // System.out.print(n + " ");
            return n;
        }
        int ans = rec_fibo(n-1)+rec_fibo(n-2);
        
        return ans;
    }
    public static void main(String args[]) {
        non_rec_fibo(8);
        System.out.println();
        for(int i=0 ; i<8 ; i++) {
            System.out.print(rec_fibo(i) + " ");
        }
    }
}