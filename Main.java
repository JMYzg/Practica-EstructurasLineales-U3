public class Main {
    public static void main(String[] args) {
        System.out.println("SINGLY:");
        SinglyLinkedList<Integer> testSingly = new SinglyLinkedList<>();
        testSingly.add(1);
        testSingly.add(5);
        testSingly.add(9);

        for (int i = 0; i < testSingly.size(); i++) {
            System.out.println(testSingly.get(i));
        }
        System.out.println();

        testSingly.addAt(0, 2);
        System.out.println(testSingly.get(1));
        testSingly.update(0, 7);
        System.out.println(testSingly.get(0));
        testSingly.remove(2);
        System.out.println();

        for (int i = 0; i < testSingly.size(); i++) {
            System.out.println(testSingly.get(i));
        }
        System.out.println();

        testSingly.clear();

        testSingly.add(9);
        for (int i = 0; i < testSingly.size(); i++) {
            System.out.println(testSingly.get(i));
        }
        System.out.println(testSingly.size());
        System.out.println();
        System.out.println("DOUBLE:");
// -----------------------------------------------------------------------------
        DoubleLinkedList<Integer> testDouble = new DoubleLinkedList<>();
        testDouble.add(1);
        testDouble.add(5);
        testDouble.add(9);

        for (int i = 0; i < testDouble.size(); i++) {
            System.out.println(testDouble.get(i));
        }
        System.out.println();

        testDouble.addAt(0, 2); // 1, 5, 9 -> 7, 5, 9
        System.out.println(testDouble.get(1));
        testDouble.update(0, 7);
        System.out.println(testDouble.get(0));
        testDouble.remove(2);
        System.out.println();

        for (int i = 0; i < testDouble.size(); i++) {
            System.out.println(testDouble.get(i));
        }
        System.out.println();

        testDouble.clear();

        testDouble.add(9);
        for (int i = 0; i < testDouble.size(); i++) {
            System.out.println(testDouble.get(i));
        }
        System.out.println(testDouble.size());
        System.out.println("CIRCULAR:");
        // -----------------------------------------------------------------------
        CircularLinkedList<Integer> testCircle = new CircularLinkedList<>();
        testCircle.add(1);
        testCircle.add(5);
        testCircle.add(9);

        for (int i = 0; i < testCircle.size(); i++) {
            System.out.println(testCircle.get(i));
        }
        System.out.println();

        testCircle.addAt(0, 2); // 1, 5, 9 -> 7, 5, 9
        System.out.println(testCircle.get(1));
        testCircle.update(0, 7);
        System.out.println(testCircle.get(0));
        testCircle.remove(2);
        System.out.println();

        for (int i = 0; i < testCircle.size(); i++) {
            System.out.println(testCircle.get(i));
        }
        System.out.println();

        testCircle.clear();

        testCircle.add(9);
        for (int i = 0; i < testCircle.size(); i++) {
            System.out.println(testCircle.get(i));
        }
        System.out.println(testCircle.size());
    }
}
