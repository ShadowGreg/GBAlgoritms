/*
* Самый эффективный алгоритм разворота для двусвязного списка - это алгоритм, который работает за линейное время O(n),
* где n - это количество элементов в списке.

Алгоритм состоит из трех шагов:

1. Инициализация трех указателей: prev, current и next. Указатель prev будет указывать на предыдущий узел, current -
* на текущий узел, а next - на следующий узел.

2. Итеративный проход по списку, при котором каждый узел разворачивается, то есть указатель на следующий узел становится
*  указателем на предыдущий узел, а указатель на предыдущий узел становится указателем на текущий узел.

3. В конце прохода по списку, указатель на последний узел становится указателем на голову списка, а указатель на голову
* списка становится указателем на последний узел.
* */

public class DoublyLinkedList {
    Node head;

    class Node {
        int data;
        Node prev;
        Node next;

        Node(int d) {
            data = d;
        }
    }

    // Метод для разворота списка
    void reverse() {
        Node current = head;
        Node prev = null;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            current.prev = next;
            prev = current;
            current = next;
        }
        head = prev;
    }

    // Метод для добавления элемента в начало списка
    void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        new_node.prev = null;
        if (head != null)
            head.prev = new_node;
        head = new_node;
    }

    // Метод для вывода списка
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
