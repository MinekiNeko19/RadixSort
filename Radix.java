public class Radix {
    public static int nth(int n, int col) {
        int temp = (int)Math.pow(10, col);
        return (n % (temp*10) - n%temp)/temp;
    }

    public static int length(int n) {
        return (int)(Math.log10(n));
    }

    // public static void merge(MyLinkedList orginal, MyLinkedList[] buckets) {

    // }

    public static void main(String[] args) {
        System.out.println(nth(1234567890,15));
        System.out.println(length(1234567890));
    }
}
