package tp5;

import java.util.Random;

public class BTree {

    static Node racine;
    static int n=0;

    // add Value to Tree
    public void add(int value) {
        racine = addRecursive(racine, value);
    }

    // Recursive Methode
    private Node addRecursive(Node current, int value) {
        if (current == null) {
            n++;
            return new Node(value);
        }
        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            // value already exists
            return current;
        }
        return current;
    }

    private int findSmallestValue(Node root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

    private Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            // Node to delete found
            if (current.left == null && current.right == null) {
                return null;
            }
            if (current.right == null) {
                return current.left;
            }
            if (current.left == null) {
                return current.right;
            }
            int smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;
        }
        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        current.right = deleteRecursive(current.right, value);
        return current;
    }

    public void delete(int value) {
        racine = deleteRecursive(racine, value);
    }

    //Pre-order traversal visits first the root node, then the left sub-tree, and finally the right sub-tree:
    public void prifix(Node node) {
        if (node != null) {
            System.out.print(" " + node.value);
            prifix(node.left);
            prifix(node.right);
        }
    }

    //add randome values to Tree
    public static BTree createTree(int nb){
        BTree bt =  new BTree();
       while (n<nb){
            bt.add(new Random().nextInt(100));
        }
        return bt;
    }

    public static void main(String[] args) {
        BTree bt =  createTree(100);
        //add  value


        long startTime= System.nanoTime();
        bt.add(999);
        long  endTime= System.nanoTime();

        System.out.println("Time add last element:"+ (endTime-startTime));

        bt.prifix(racine);

        System.out.println();

        startTime= System.nanoTime();
        bt.delete(12);
        endTime= System.nanoTime();

        System.out.println("Time element element "+ (endTime-startTime));
        bt.prifix(racine);
    }
}
