package arrays;

public class MultWithoutArith {

    public static void main(String[] args) {
        System.out.println(multiply(13, 9));
    }

    public static long multiply(long x , long y){
        long sum = 0;
        while(x!=0){
            if((x&1) != 0) {
                sum += y;
            }
            x>>>=1;
            y<<=1;
        }
        return  sum;
    }
}
