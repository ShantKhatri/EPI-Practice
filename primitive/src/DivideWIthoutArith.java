public class DivideWIthoutArith {
    public static void main(String[] args) {
        System.out.println(divide(13,3));
    }

    public static long divide(long x, long y){
        long result = 0;
        int power = 32;
        long yPower = y << power;
        while(x>=y){
            while(yPower>x){
                yPower >>>= 1;
                --power;
            }

            result += 1 << power;
            x -= yPower;
        }
        return result;
    }
}
