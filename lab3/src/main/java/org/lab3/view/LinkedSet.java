package org.lab3.view;

import org.lab3.model.NeedDrawObject;

import java.util.*;

public class LinkedSet extends AbstractSet<NeedDrawObject> {
    public LinkedSet(Comparator comparator) {
        this.comparator = comparator;
    }

    private static class LinkedElement {
        NeedDrawObject value;

        boolean exists;

        LinkedElement prev;
        LinkedElement next;
    }

    private Map<NeedDrawObject, LinkedElement> map = new HashMap<>();
    private Comparator comparator;

    private LinkedElement placeholder = new LinkedElement();
    private LinkedElement head = placeholder;

    @Override
    public boolean isEmpty() {
        return head == placeholder;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public boolean add(NeedDrawObject e) {
        LinkedElement element = map.putIfAbsent(e, placeholder);

        if (element != null) {
            return false;
        }

        LinkedElement node = head;
        while (!node.equals(placeholder)) {
            if (comparator.compare(e, node.value) > 0) {
                node = node.next;
            } else {
                break;
            }
        }

        if (node.equals(placeholder)) {
            element = placeholder;
            element.exists = true;
            element.value = e;

            placeholder = new LinkedElement();
            placeholder.prev = element;

            element.next = placeholder;
        } else {
            element = new LinkedElement();
            element.exists = true;
            element.value = e;

            node.prev.next = element;
            element.next = node;
            element.prev = node.prev;
            node.prev = element;
        }

        return true;
    }

    @Override
    public boolean remove(Object o) {
        LinkedElement removedElement = map.remove(o);

        if (removedElement == null) {
            return false;
        }

        removeElementFromLinkedList(removedElement);

        return true;
    }

    private void removeElementFromLinkedList(LinkedElement element) {
        element.exists = false;
        element.value = null;

        element.next.prev = element.prev;

        if (element.prev != null) {
            element.prev.next = element.next;
            element.prev = null;
        } else {
            head = element.next;
        }
    }

    @Override
    public Iterator iterator() {
        return new ElementIterator();
    }

    private class ElementIterator implements Iterator {
        LinkedElement next = head;
        LinkedElement current = null;

        LinkedElement findNext() {
            LinkedElement n = next;

            while (!n.exists && n.next != null) {
                next = n = n.next;
            }

            return n;
        }

        @Override
        public boolean hasNext() {
            return findNext().exists;
        }

        @Override
        public NeedDrawObject next() {
            LinkedElement n = findNext();

            if (!n.exists) {
                throw new NoSuchElementException();
            }

            current = n;
            next = n.next;

            return n.value;
        }

        @Override
        public void remove() {
            if (current == null) {
                throw new IllegalStateException();
            }

            if (map.remove(current.value, current)) {
                removeElementFromLinkedList(current);
            } else {
                throw new NoSuchElementException();
            }
        }
    }
}