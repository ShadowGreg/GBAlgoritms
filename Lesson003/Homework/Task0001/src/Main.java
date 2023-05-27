public class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.push(2);
        list.push(4);
        list.push(8);
        list.push(10);

        System.out.println("Исходный список:");
        list.printList(list.head);

        list.reverse();

        System.out.println("\nРазвёрнутый список:");
        list.printList(list.head);

    }
}