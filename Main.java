public class Main {
    public static void main(String[] args) {
        // List<String> Lista = new LinkedList<>();

        SimplyLinkedList<Integer> test = new SimplyLinkedList<>();
        test.add(1);
        test.add(5);
        test.add(9);

        for (int i = 0; i < test.size; i++) {
            System.out.println(test.get(i));
        }
        System.out.println();

        test.addIn(2, 2);
        System.out.println(test.get(3));
        test.update(1, 7);
        System.out.println(test.get(1));
        test.remove(0);
        System.out.println();

        for (int i = 0; i < test.size; i++) {
            System.out.println(test.get(i));
        }
        System.out.println();

        test.clear();

        test.add(9);
        for (int i = 0; i < test.size; i++) {
            System.out.println(test.get(i));
        }
    }
}
