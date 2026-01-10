package Recursion;

public class power {
    public static void main(String[] args) {
        System.out.println(power(5,3));
    }
    public static int power(int n,int m){
        if(n==0)return 1;
        else{
            return m*power(n-1,m);
        }
    }
}
