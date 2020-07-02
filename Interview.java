package interview;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import java.util.Map;

public class Interview {

    static Scanner console = new Scanner(System.in);

    public static void linkedList() {
        // LinkedList Dup Removal
        LinkedList LL = new LinkedList();

        System.out.println("Linked List Duplicate Removal" + "\n-----------------"
                + "\nPlease type a series of items into the list (be sure to include duplicates)."
                + "\nWhen complete, please enter \"q\" into the console to end input." + "\n" + "-------------------");

        System.out.print("Entry: ");
        String str = console.nextLine();
        while (!str.equals("q")) {
            LL.add(str);
            System.out.print("Entry: ");
            str = console.nextLine();
        }

        System.out.println("\nAcquired Linked List:" + "\n-------------------");
        System.out.println(LL.toString());

        System.out.println("\nLinked List Duplicate Removal Processing" + "\n-------------------");
        for (int i = 0; i < LL.size(); i++) {
            for (int j = i + 1; j < LL.size(); j++) {
                if (LL.get(i).equals(LL.get(j))) {
                    LL.remove(j);
                    System.out.println(LL.toString());
                    if (i != 0) {
                        i--;
                    }
                }
            }
        }
        System.out.println("\nLinked List After Duplicate Removal" + "\n-----------------");
        System.out.println(LL.toString());
    }

    public static void stackedQueue() {
        // StackedQueue
        StackedQueue main = new StackedQueue();
        StackedQueue temp = new StackedQueue();

        System.out.println("StackedQueue" + "\n-----------------" + "\nPlease type a series of items into the queue."
                + "\nWhen complete, please enter \"q\" into the console to end input." + "\n" + "-------------------");

        System.out.print("Entry: ");
        String str = console.nextLine();
        while (!str.equals("q")) {
            if (main.empty()) {
                main.enqueue(str);
            } else {
                while (!main.empty()) {
                    temp.enqueue(main.dequeue());
                }
                main.enqueue(str);
                while (!temp.empty()) {
                    main.enqueue(temp.dequeue());
                }
            }
            System.out.print("Entry: ");
            str = console.nextLine();
        }

        System.out.println("");

        int count = 1;
        System.out.println("Queue Entries" + "\n-------------------");
        while (!main.empty()) {

            System.out.println(count + ". " + main.dequeue());
            count++;
        }

    }

    public static void largestSmallest() {
        BST<Integer> BST = new BST<Integer>();
        int count = 0;

        System.out.println("Largest Smallest Item" + "\n-----------------"
                + "\nPlease enter the items you wish to insert into the tree."
                + "\nWhen complete, enter \"q\" into the console."
                + "\n(If you wish to have a tree generated for you, please enter \"treeGen\"" + " into the console)."
                + "\n-----------------");

        System.out.print("Entry: ");
        String answer = console.nextLine();

        while (!answer.equals("q")) {
            if (answer.equals("treeGen") && count > 0) {
                System.err.println("A tree is already being made!");
                System.out.println("Please continue entering items into the tree.");

                System.out.print("Entry: ");
                answer = console.nextLine();
                break;
            } else if (answer.equals("treeGen") && count == 0) {
                BST.add(115);
                BST.add(200);
                BST.add(45);
                BST.add(27);
                BST.add(105);
                BST.add(99);
                BST.add(32);
                BST.add(1200);
                BST.add(1784);
                BST.add(1);
                BST.add(77);
                BST.add(114);
                BST.add(113);
                BST.add(77);

                System.out.println("--Tree Generation Complete--\n");
                answer = "q";
            } else {
                try {
                    int num = Integer.parseInt(answer);
                    BST.add(num);
                } catch (NumberFormatException e) {
                    System.err.println("This is not an integer!");
                    System.out.println("Please try again and enter an integer into the console.");

                    System.out.print("Entry: ");
                    answer = console.nextLine();
                    break;
                }

                count++;
                System.out.print("Entry: ");
                answer = console.nextLine();
            }
        }

        System.out.println("\nTree Display" + "\n-----------------" + "\n" + BST.toString() + "-----------------");

        System.out.println("\nLargest Smallest Item" + "\n-----------------");

        int biggest = BST.largestSmall();
        if (BST.root.left.item >= biggest) {
            System.out.println("\t" + biggest);
            System.out.println("(This is the root " + "\nof the left-hand tree)." + "\n-----------------");
        } else {
            System.out.println(
                    "\n" + biggest + " was the largest small number " + "wihin the tree." + "\n-----------------");
        }
    }

    public static void perm() {
        boolean loop = true;
        System.out.println("Permutation" + "\n-----------------"
                + "\nPlease enter \"file\" if you would like to enter a file name."
                + "\nOr enter \"other\" to enter strings manually." + "\n-------------------");

        System.out.print("Entry: ");
        String answer = console.nextLine().toLowerCase();
        while (loop) {
            if (answer.equals("file")) {
                System.out.print("\nPlease enter the file names: " + "\nEntry: ");
                String firstFile = console.nextLine() + ".txt";

                System.out.print("Entry: ");
                String secondFile = console.nextLine() + ".txt";

                if (permVal(firstFile, secondFile)) {
                    loop = false;
                }
            } else if (answer.equals("other")) {
                System.out.print("\nPlease enter the String names: " + "\nEntry: ");
                String firstStr = console.nextLine();

                System.out.print("Entry: ");
                String secondStr = console.nextLine();

                permVal(firstStr, secondStr);
                loop = false;
            }
        }
    }

    public static boolean permVal(String first, String second) {
        ArrayList<String> x = new ArrayList<>();
        ArrayList<String> y = new ArrayList<>();

        boolean ans = false;

        if (first.contains(".txt") && second.contains(".txt")) {
            try {
                Scanner reader = new Scanner(new File("src\\files\\" + first));
                String lineOne = reader.nextLine();

                reader = new Scanner(new File("src\\files\\" + second));
                String lineTwo = reader.nextLine();

                String[] a = lineOne.split("(?!^)");
                String[] b = lineTwo.split("(?!^)");

                for (String str : a) {
                    x.add(str);
                }

                for (String str : b) {
                    y.add(str);
                }

                Collections.sort(x);
                Collections.sort(y);

                if (x.equals(y)) {
                    System.out.println("\nThese Strings are permutations!" + "\n----------------------------------"
                            + "\n\t" + x.toString() + "\n\t" + y.toString());
                    ans = true;
                } else {
                    System.out.println("\nThese Strings are not permutations!" + "\n----------------------------------"
                            + "\n\t" + x.toString() + "\n\t" + y.toString());
                }
            } catch (FileNotFoundException e) {
                System.err.println("\nThis file was not found.");
                System.out.println("Please try again and use an available file name.");
            }
        }

        else {

            String[] a = first.split("(?!^)");
            String[] b = second.split("(?!^)");

            for (String str : a) {
                x.add(str);
            }

            for (String str : b) {
                y.add(str);
            }

            Collections.sort(x);
            Collections.sort(y);

            if (x.equals(y)) {
                System.out.println("\nThese Strings are permutations!" + "\n----------------------------------" + "\n\t"
                        + x.toString() + "\n\t" + y.toString());
                ans = true;
            } else {
                System.out.println("\nThese Strings are not permutations!" + "\n----------------------------------"
                        + "\n\t" + x.toString() + "\n\t" + y.toString());
            }
        }

        return ans;
    }

    public static void header() {
        System.out.println(
                "----------------------------" + "\n||||||||||||||||||||||||||||" + "\n|||||   .:WELCOME:.    |||||"
                        + "\n||||||||||||||||||||||||||||" + "\n----------------------------" + "\n");
    }

    public static void main(String[] args) throws FileNotFoundException {
        String str = "";
        int count = 0;
        header();

        do {
            if (count > 0) {
                System.out.println("\n\t\t.: Main Menu :.");
            }

            System.out.println("What Interview Question did you want to start with?"
                    + "\n\t1. Linked List Duplicate Removal" + "\n\t2. StackedQueue" + "\n\t3. Largest Smallest Item"
                    + "\n\t4. Permutation" + "\n\t5. Quit");

            System.out.print("\nEntry: ");
            str = console.nextLine().toLowerCase();

            System.out.println("");

            switch (str) {
                case "1":
                    linkedList();
                    count++;
                    break;
                case "2":
                    stackedQueue();
                    count++;
                    break;
                case "3":
                    largestSmallest();
                    count++;
                    break;
                case "4":
                    perm();
                    count++;
                    break;
                case "5":
                case "q":
                case "quit":
                    str = "q";
                    break;
                default:
                    System.err.println("This is an invalid entry: Try again.");
            }
        } while (!str.equals("q"));

    }

}
