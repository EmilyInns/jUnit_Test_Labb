public class Calculator {

    Calculator(){}

    public int add(int n1, int n2){
        return n1+n2;
    }

    public int add(int[] n){
        int sum = 0;
        for (int num:n) {
            sum += num;
        }
        return sum;
    }

    public boolean guessFavouriteNumber(int guess){
        return guess == getFavouriteNumber();
    }

    private int getFavouriteNumber(){
        return 21;
    }

    public int subtract(int n1, int n2) {
        return n1-n2;
    }

    public int subtract(int[] n){
        int difference = n[0];
        for (int i = 1; i<n.length; i++) {
            difference -= n[i];
        }
        return difference;
    }

    public int multiply(int n1, int n2) {
        return n1*n2;
    }

    public int multiply(int[] n){
        int product = n[0];
        for (int i = 1; i<n.length; i++) {
            product *= n[i];
        }
        return product;
    }

    public int divide(int n1, int n2) {
        return n1/n2;
    }

    public int divide(int[] n){
        int quotient = n[0];
        for (int i = 1; i<n.length; i++) {
            quotient /= n[i];
        }
        return quotient;
    }

    public int returnArraySize(int[] n){
        return n.length;
    }


    public String uselessMethod(){
    return "Why did you run this?";
    }

    public void pleaseOnlyEnterFractions(double n) {
        if (n % 1 == 0){ throw new ArithmeticException(); }
        System.out.println("Yay!");
    }
}
