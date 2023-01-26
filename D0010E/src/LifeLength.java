public class LifeLength {
    public static void main(String args[]){
        int a0 = Integer.parseInt(args[0]);
        //int n = Integer.parseInt(args[1]);
        for (int i = 1; i <= 42; i++) {
            int y = iterLifeLength(i);
            System.out.println(intsToString(i, y));
        }
        //System.out.println(iterateF(3,5));
        //System.out.println(iterateF(42,3));
        //System.out.println(iterateF(1,3));
        //System.out.println("f1=" + f1(a0) + " f2=" + f2 (a0) + " f4=" + f4(a0) + " f8=" + f8(a0) + " f16=" + f16(a0) + " f32=" + f32(a0));
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
