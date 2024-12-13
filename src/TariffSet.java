import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * Represents a custom set of Tariff objects backed by a doubly linked list.
 * Implements the Set interface.
 */
class TariffSet<T extends Tariff> implements Set<T> {
    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> prev;

        Node(E element) {
            this.element = element;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    /**
     * Constructs an empty TariffSet.
     */
    public TariffSet() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Constructs a TariffSet containing a single tariff.
     *
     * @param tariff the tariff to add
     */
    public TariffSet(T tariff) {
        this();
        add(tariff);
    }

    /**
     * Constructs a TariffSet containing all tariffs from a given collection.
     *
     * @param tariffs the collection of tariffs
     */
    public TariffSet(Collection<? extends T> tariffs) {
        this();
        for (T tariff : tariffs) {
            add(tariff);
        }
    }

    /**
     * Adds a tariff to the set if it is not already present.
     *
     * @param tariff the tariff to add
     * @return true if the tariff was added, false if it was already present
     */
    @Override
    public boolean add(T tariff) {
        if (contains(tariff)) {
            return false;
        }
        Node<T> newNode = new Node<>(tariff);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
        return true;
    }

    /**
     * Removes a tariff from the set if it is present.
     *
     * @param o the tariff to remove
     * @return true if the tariff was removed, false otherwise
     */
    @Override
    public boolean remove(Object o) {
        Node<T> current = head;
        while (current != null) {
            if (current.element.equals(o)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Checks if the set contains the specified tariff.
     *
     * @param o the tariff to check for
     * @return true if the tariff is present, false otherwise
     */
    @Override
    public boolean contains(Object o) {
        for (T element : this) {
            if (element.equals(o)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns an iterator over the elements in this set.
     *
     * @return an iterator over the elements in this set
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (current == null) {
                    throw new NoSuchElementException();
                }
                T element = current.element;
                current = current.next;
                return element;
            }
        };
    }

    /**
     * Returns the number of elements in this set.
     *
     * @return the number of elements in this set
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Checks if the set is empty.
     *
     * @return true if the set is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Removes all elements from the set.
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Returns an array containing all elements in this set.
     *
     * @return an array containing all elements in this set
     */
    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int index = 0;
        for (T element : this) {
            array[index++] = element;
        }
        return array;
    }

    /**
     * Returns an array containing all elements in this set;
     * the runtime type of the returned array is that of the specified array.
     *
     * @param a the array into which the elements of this set are to be stored
     * @return an array containing all elements in this set
     */
    @Override
    public <U> U[] toArray(U[] a) {
        if (a.length < size) {
            a = (U[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
        }
        int index = 0;
        Object[] result = a;
        for (T element : this) {
            result[index++] = element;
        }
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    /**
     * Checks if this set contains all elements of the specified collection.
     *
     * @param c the collection to check for containment
     * @return true if this set contains all elements, false otherwise
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Adds all elements of the specified collection to this set.
     *
     * @param c the collection of elements to add
     * @return true if this set changed as a result, false otherwise
     */
    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean modified = false;
        for (T element : c) {
            if (add(element)) {
                modified = true;
            }
        }
        return modified;
    }

    /**
     * Retains only the elements in this set that are contained in the specified collection.
     *
     * @param c the collection containing elements to retain
     * @return true if this set changed as a result, false otherwise
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        Iterator<T> iterator = iterator();
        while (iterator.hasNext()) {
            T element = iterator.next();
            if (!c.contains(element)) {
                iterator.remove();
                modified = true;
            }
        }
        return modified;
    }

    /**
     * Removes all elements in this set that are contained in the specified collection.
     *
     * @param c the collection containing elements to remove
     * @return true if this set changed as a result, false otherwise
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object o : c) {
            if (remove(o)) {
                modified = true;
            }
        }
        return modified;
    }
}