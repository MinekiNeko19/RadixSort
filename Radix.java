public class Radix {
    public static int nth(int n, int col) {
        int temp = (int)Math.pow(10, col);
        return (n % (temp*10) - n%temp)/temp;
    }

    public static int length(int n) {
        return (int)(Math.log10(n) + 1);
    }

    public static void merge(MyLinkedList original, MyLinkedList[] buckets) {
        
    }

    private static void bucketPrint(MyLinkedList[] b) {
        for (int i = 0; i < b.length; i++) {
            System.out.println("Bucket " + i + b[i].toString());
        }
    }

    public static void main(String[] args) {
        // System.out.println(nth(1234567890,15));
        // System.out.println(length(1234567890));

        MyLinkedList[] b = new MyLinkedList[10];
        for (int i = 0; i < b.length; i++) {
            b[i] = new MyLinkedList();
        }
        MyLinkedList a = new MyLinkedList();
        a.add("50"); a.add("41"); a.add("11"); a.add("12"); a.add("42");
        a.add("32"); a.add("32"); a.add("23"); a.add("34"); a.add("44");
        a.add("34"); a.add("87"); a.add("77"); a.add("58"); a.add("8");

        merge(a,b);
        System.out.println(a.toString());
        // bucketPrint(b);
    }
}
