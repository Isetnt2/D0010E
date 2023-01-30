package labb1;

import java.sql.SQLOutput;
import java.util.Scanner;

public class LifeLength {
    public static void main(String args[]){
        int n = Integer.parseInt(args[0]);
        switch (n){
            case 1:
                printTask1(Integer.parseInt(args[1]));
                break;
            case 2:
                printTask2(Integer.parseInt(args[1]));
                break;
            case 3:
                printTask3();
                break;
            case 4:
                printTask4();
                break;
            case 6:
                printTask6();
                break;
            default:
                System.out.println("Felaktigt värde på n");
                break;
        }

    }

    public static void printTask1(int a0){
        System.out.println(f1(a0));
    }
    public static void printTask2(int a0){
        System.out.println("f1=" + f1(a0) + " f2=" + f2 (a0) + " f4=" + f4(a0) + " f8=" + f8(a0) + " f16=" + f16(a0) + " f32=" + f32(a0));
    }
    public static void printTask3(){
        Scanner sc = new Scanner(System.in);
        int a0 = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(iterateF(a0, n));
    }
    public static void printTask4() {
        System.out.println(iterateF(3,5));
        System.out.println(iterateF(42,3));
        System.out.println(iterateF(1,3));
    }
    public static void printTask6(){
        for (int i = 1; i <= 15; i++) {
            int y = iterLifeLength(i);
            System.out.println(intsToString(i, y));
        }
    }
    public static int f1(int a0){
        if(a0 == 1){
            return a0;
        } else if (a0%2 == 0){
            return a0/2;
        } else{
            return 3*a0+1;
        }
    }

    public static int f2(int a0){
        return f1(f1(a0));
    }
    public static int f4(int a0){
        return f2(f2(a0));
    }
    public static int f8(int a0){
        return f4(f4(a0));
    }
    public static int f16(int a0){
        return f8(f8(a0));
    }
    public static int f32(int a0){
        return f16(f16(a0));
    }

    public static int iterateF(int a0, int n){
        for (int i = 0; i < n; i++) {
            a0 = f1(a0);
        }
        return a0;
    }

    public static int iterLifeLength(int a0){
        int n = a0;
        int nIter = 0;
        do {
            n = f1(n);
            nIter++;
        } while (n != 1);
            return nIter;
    }

    public static int recLifeLength(int a0){
        if(a0 == 1){
            return 0;
        } else{
            return 1 + recLifeLength(f1(a0));
        }
    }
    public static String intsToString(int X, int Y){
        return ("The life length of " + X + " is " + Y +".");
    }
}
