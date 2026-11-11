
import java.util.*;

class HashTable {

    static class Node {
        String key;
        Node next;

        Node(String key) {
            this.key = key;
            next = null;
        }
    }

    Node[] table;
    int size;

    HashTable(int capacity) {
        table = new Node[capacity];
        size = capacity;
    }

    // Calculate hash index
    int hash(String key) {
        return Math.floorMod(key.hashCode(), size);
    }

    // Insert SKU
    void insert(String key) {
        int index = hash(key);

        Node newNode = new Node(key);
        newNode.next = table[index];
        table[index] = newNode;
    }

    // Search SKU
    boolean search(String key) {
        int index = hash(key);

        Node temp = table[index];

        while (temp != null) {
            if (temp.key.equals(key)) {
                return true;
            }
            temp = temp.next;
        }

        return false;
    }
}

public class SKUHashing {

    public static void main(String[] args) {

        // Demonstrate collision
        HashTable ht = new HashTable(10);

        String sku1 = "SKU-100";
        int index = ht.hash(sku1);

        String sku2 = "";

        // Find another SKU with the same bucket
        for (int i = 101; ; i++) {
            String temp = "SKU-" + i;

            if (ht.hash(temp) == index) {
                sku2 = temp;
                break;
            }
        }

        System.out.println("CUSTOM HASH TABLE");

        ht.insert(sku1);
        ht.insert(sku2);

        System.out.println(sku1 + " bucket: " + index);
        System.out.println(sku2 + " bucket: " + ht.hash(sku2));

        System.out.println("Collision handled using chaining");

        System.out.println("Search " + sku1 + ": " + ht.search(sku1));
        System.out.println("Search " + sku2 + ": " + ht.search(sku2));

        // Compare lookup time for 100000 SKUs

        int n = 100000;

        HashTable custom = new HashTable(200003);
        HashMap<String, Integer> map = new HashMap<>();

        String[] skus = new String[n];

        // Insert 100000 SKUs
        for (int i = 0; i < n; i++) {

            skus[i] = "SKU-" + i;

            custom.insert(skus[i]);
            map.put(skus[i], i);
        }

        // Warm up both implementations
        for (int r = 0; r < 2; r++) {
            for (String sku : skus) {
                custom.search(sku);
                map.containsKey(sku);
            }
        }

        // Custom Hash Table lookup
        long start1 = System.nanoTime();

        int count1 = 0;

        for (int r = 0; r < 5; r++) {
            for (String sku : skus) {
                if (custom.search(sku)) {
                    count1++;
                }
            }
        }

        long end1 = System.nanoTime();

        // Built-in HashMap lookup
        long start2 = System.nanoTime();

        int count2 = 0;

        for (int r = 0; r < 5; r++) {
            for (String sku : skus) {
                if (map.containsKey(sku)) {
                    count2++;
                }
            }
        }

        long end2 = System.nanoTime();

        double customTime = (end1 - start1) / 1_000_000.0;
        double mapTime = (end2 - start2) / 1_000_000.0;

        System.out.println("\nLOOKUP COMPARISON");
        System.out.println("Total SKUs: " + n);
        System.out.println("Successful custom lookups: " + count1);
        System.out.println("Successful HashMap lookups: " + count2);

        System.out.println("Custom Hash Table time: "
                + customTime + " ms");

        System.out.println("HashMap time: "
                + mapTime + " ms");
    }
}
