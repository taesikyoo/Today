package src.ch02_list;

import java.util.NoSuchElementException;

public class ArrListImpl<E> implements ArrList<E> {

    private E a[]; // 리스트의 항목들을 저장할 배열
    private int size; // 리스트의 항목 수

    public ArrListImpl() {
        a = (E[]) new Object[1]; // 최초로 1개의 원소를 가진 배열 생성
        size = 0;
    }

    @Override
    public E peek(int k) { // k번째 항목을 리턴, 단순히 읽기만 한다.
        if (size == 0)
            throw new NoSuchElementException(); // underflow 경우에 프로그램 정지
        return a[k];
    }

    @Override
    public void insertLast(E newItem) { // 가장 뒤에 새 항목 삽입
        if (size == a.length)
            resize(2 * a.length);
        a[size++] = newItem;
    }

    @Override
    public void insert(E newItem, int k) { // 새 항목을 k-1번째 항목 다음에 삽입
        if (size == a.length)
            resize(2 * a.length);
        for (int i = size - 1; i >= k; i--) {
            a[i + 1] = a[i];
        }
        a[k] = newItem;
        size++;
    }

    public void resize(int newSize) { // 배열 크기 조절
        Object[] t = new Object[newSize];
        for (int i = 0; i < size; i++) {
            t[i] = a[i];
        }
        a = (E[]) t;
    }

    @Override
    public E delete(int k) { // k번째 항목 삭제
        if (isEmpty()) throw new NoSuchElementException();
        E item = a[k];
        for (int i = k; i < size; i++) {
            a[i] = a[i + 1]; // 한 칸씩 앞으로 이동
        }
        size--;
        if (size > 0 && size == a.length / 4)
            resize(a.length / 2);
        return item;
    }


    public boolean isEmpty() {
        return size == 0;
    }
}
