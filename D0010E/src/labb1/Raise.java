package labb1;

public class Raise {
    public static int count = 0;
    public static void main(String args[]) {
        for (int i = 1; i <= 15; i++) {
            count = 0;
            System.out.println("RecRaiseHalf x^k = " + recRaiseHalf(1.5, i) + " Count: " + count);
            count = 0;
            System.out.println("RecRaiseOne x^k = " + recRaiseOne(1.5, i) + " Count: " + count);
        }

    }

    public static double recRaiseHalf(double x, int k){
        if(k == 0){
            return 1;
        } else if (k%2 == 0){
            count++;
            double n = recRaiseHalf(x, (int)Math.floor(k/2));
            return n * n;
        } else{
            count++;
            double n = recRaiseHalf(x, (int)Math.floor(k/2));
            return n*n*x;
        }
    }
    public static double recRaiseOne(double x, int k) {
        if (k==0) {
            return 1.0;
        } else {
            count++;
            return x * recRaiseOne(x, k-1);
        }
    }
}
