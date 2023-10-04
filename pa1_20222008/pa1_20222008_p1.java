public class pa1_20222008_p1 {

    public static class SinglySortedLinkedList<E extends Comparable<E>> {

        private static class Node<E> {
            private E element;
            private Node<E> next;

            public Node(E e, Node<E> n) {
                element = e;
                next = n;
            }

            public E getElement() {
                return element;
            }

            public Node<E> getNext() {
                return next;
            }

            public void setNext(Node<E> n) {
                next = n;
            }
        }

        private Node<E> head = null;
        private int size = 0;

        public void addElement(E e) {
            head = addElementRecursive(head, e);
            size++;
        }

        private Node<E> addElementRecursive(Node<E> current, E e) {
            if (current == null || e.compareTo(current.getElement()) <= 0) {
                return new Node<>(e, current);
            }
            current.setNext(addElementRecursive(current.getNext(), e));
            return current;
        }

        public void removeElement(int x) {
            if (x > size || x <= 0) {
                return;
            }

            if (x == 1) {
                head = head.getNext();
                size--;
                return;
            }

            Node<E> current = head;
            for (int i = 1; i < x - 1; i++) {
                current = current.getNext();
            }

            if (current.getNext() != null) {
                current.setNext(current.getNext().getNext());
                size--;
            }
        }

        public void traverseAndPrint() {
            Node<E> current = head;
            while (current != null) {
                System.out.print(current.getElement() + " ");
                current = current.getNext();
            }
        }

        public E getFirst() {
            if (head == null) return null;
            return head.getElement();
        }
    }

    public static void main(String[] args) {
        SinglySortedLinkedList<Integer> list = new SinglySortedLinkedList();

        int[] elements = {3, 4, 5, 6}; //your own input

        for (int e : elements) {
            list.addElement(e);
        }

        System.out.print("Input: ");
        list.traverseAndPrint();

        int i = 1; //your specific i value
        list.removeElement(i);

        System.out.print("\nResult: ");
        list.traverseAndPrint();

        System.out.println("\n202222008 pa1 p1 " + elements[i - 1] + " " + list.getFirst());
    }
}



