package src.ch02_list;

import java.util.NoSuchElementException;

public class DoublyLinkedListImpl<E> implements DoublyLinkedList<E> {

    protected DNode head, tail;
    protected int size;

    public DoublyLinkedListImpl() {
        head = new DNode(null, null, null); // tail이 아직 null이라 사용 불가능
        tail = new DNode(null, head, null);
        head.setNext(tail);
        size = 0;
    }

    @Override
    public void insertBefore(DNode p, E newItem) {
        DNode t = p.getPrevious();
        DNode newNode = new DNode(newItem, t, p);
        p.setPrevious(newNode);
        t.setNext(newNode);
        size++;
    }

    @Override
    public void insertAfter(DNode p, E newItem) {
        DNode t = p.next;
        DNode newNode = new DNode(newItem, p, t);
        t.setPrevious(newNode);
        p.setNext(newNode);
        size++;
    }

    @Override
    public void delete(DNode x) {
        if (x == null) throw new NoSuchElementException();
        DNode f = x.getPrevious();
        DNode r = x.getNext();
        f.setNext(r);
        r.setPrevious(f);
        size--;
    }

    public static class DNode<E> {

        private E item;
        private DNode previous;
        private DNode next;

        public DNode(E item, DNode previous, DNode next) {
            this.item = item;
            this.previous = previous;
            this.next = next;
        }

        public E getItem() {
            return item;
        }

        public void setItem(E item) {
            this.item = item;
        }

        public DNode getPrevious() {
            return previous;
        }

        public void setPrevious(DNode previous) {
            this.previous = previous;
        }

        public DNode getNext() {
            return next;
        }

        public void setNext(DNode next) {
            this.next = next;
        }
    }
}
