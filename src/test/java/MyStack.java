
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyStack<T> implements Iterable<T> {
    private T[] stack;
    private int topOfStack = 0;

    public MyStack(T[] stack) {
        this.stack = stack;
    }

    public void push(T obj) {
        if (topOfStack >= stack.length) increaseCapacity();
        stack[topOfStack] = obj;
        topOfStack++;
    }

    public T pop() {
        T element = null;
        if (topOfStack != 0) {
            topOfStack--;
            element = (T) stack[topOfStack];
            stack[topOfStack] = null;
        }
        return element;
    }

    public T peek() {
        T element = null;
        if (topOfStack != 0) {
            element = stack[topOfStack - 1];
        }
        return element;
    }

    public void increaseCapacity() {
        T[] oldStack = stack;
        int newCapacity = stack.length * 3 / 2 + 1;
        stack = Arrays.copyOf(oldStack, newCapacity);
    }

    @Override
    public String toString() {
        StringBuilder stackStr = new StringBuilder("");
        for (int i = 0; i < topOfStack; i++) {
            stackStr.append(((i != 0) ? "," : "") + stack[i].toString());
        }
        return "MyStack{" + stackStr + '}';
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentElement = topOfStack-1;

            @Override
            public boolean hasNext() {
                return (currentElement > 0) && (topOfStack != 0);
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return stack[currentElement--];
            }
        };
    }


}

