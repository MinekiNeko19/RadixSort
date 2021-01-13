public class Radix {
    public static int nth(int n, int col) {
        int temp = (int)Math.pow(10, col);
        return (n % (temp*10) - n%temp)/temp;
    }

    public static int length(int n) {
        return (int)(Math.log10(n) + 1);
    }

    public static void merge(SortableLinkedList original, SortableLinkedList[] buckets) {
        for (int i = 0; i < buckets.length; i++) {
            original.extend(buckets[i]);
        }
    }

    public static void radixSortSimple(SortableLinkedList data) {
        SortableLinkedList[] buckets = new SortableLinkedList[10];
        int longest = 0;
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new SortableLinkedList();
        }
        for (int i = 0; data.size() != 0;i++) {
            buckets[nth(data.get(0),0)].add(data.get(0));
            if (length(data.get(0)) > longest) longest = length(data.get(0));
            data.remove(0);
        }
        // bucketPrint(buckets);
        // System.out.println(data.toString());
        merge(data,buckets);
        // bucketPrint(buckets);
        // System.out.println(data.toString());
        
        for (int i = 0; longest != i; i++) {
            for (int j = 0; data.size() != 0; j++) {
                buckets[nth(data.get(0),i)].add(data.get(0));
                data.remove(0);
            }
            // bucketPrint(buckets);
            merge(data,buckets);
            // System.out.println(data.toString());
        }       
    }

    public static void radixSort(SortableLinkedList data) {
        SortableLinkedList negatives = new SortableLinkedList();
        SortableLinkedList positives = new SortableLinkedList();SortableLinkedList[] buckets = new SortableLinkedList[10];
        int longest = 0;
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new SortableLinkedList();
        }

        for (int i = 0; data.size() != 0; i++) {
            int current = data.get(0);
            if (current < 0) {
                negatives.add(-current);
                current = -current;
            } else {
                positives.add(current);
            }
            if (longest < length(current)) {
                longest = length(current);
            }
            data.remove(0);
        }

        radixSortSimple(negatives);   radixSortSimple(positives);
        for (int i = negatives.size()-1; i > 0; i--) {
            data.add(-negatives.get(i));
        }
        for (int i = 0; i < positives.size(); i++) {
            data.add(positives.get(i));
        }
    }

    private static void bucketPrint(SortableLinkedList[] b) {
        for (int i = 0; i < b.length; i++) {
            System.out.println("Bucket " + i + b[i].toString());
        }
    }

    public static void main(String[] args) {
        // System.out.println(nth(1234567890,15));
        // System.out.println(length(1234567890));

        // testing merge
        // MyLinkedList[] b = new MyLinkedList[10];
        // for (int i = 0; i < b.length; i++) {
        //     b[i] = new MyLinkedList();
        // }
        // MyLinkedList a = new MyLinkedList();
        // b[5].add("50"); b[4].add("41"); b[1].add("11"); b[1].add("12"); b[4].add("42");
        // b[3].add("32"); b[3].add("32"); b[2].add("23"); b[3].add("34"); b[4].add("44");
        // b[3].add("34"); b[8].add("87"); b[7].add("77"); b[5].add("58"); b[0].add("8");

        // merge(a,b);
        // System.out.println(a.toString());
        // bucketPrint(b);

        // testing radixSortSimple
        // SortableLinkedList b = new SortableLinkedList();
        // b.add(32); b.add(32); b.add(23); b.add(34); b.add(44);
        // b.add(50); b.add(41); b.add(11); b.add(12); b.add(42);
        // b.add(34); b.add(87); b.add(77); b.add(58); b.add(8);
        // radixSortSimple(b);

        // testing radixSort
        // SortableLinkedList b = new SortableLinkedList();
        // b.add(32); b.add(-32); b.add(23); b.add(34); b.add(44);
        // b.add(-50); b.add(41); b.add(11); b.add(12); b.add(-42);
        // b.add(34); b.add(87); b.add(77); b.add(-58); b.add(8);
        // radixSort(b);
        // System.out.println(b.toString());
    }
}
