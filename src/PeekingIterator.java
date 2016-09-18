import java.util.Iterator;

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> iterator;
    private Integer top;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (top == null) {
            top = this.iterator.next();
        }
        return top;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext() || top != null;
    }

    @Override
    public Integer next() {
        int toReturn = peek();
        top = null;
        return toReturn;
    }
}