import java.util.Arrays;

public class MyStack {
    private Object[] stack;
    private int topOfStack = 0;

    public MyStack(int capacity) {
        this.stack = new Object[capacity];
    }

    public void push(Object obj) {
        if (topOfStack >= stack.length) increaseCapacity();
        stack[topOfStack] = obj;
        topOfStack++;
    }

    public Object pop() {
        Object element = null;
        if (topOfStack != 0) {
            topOfStack--;
            element = stack[topOfStack];
            stack[topOfStack] = null;
        }
        return element;
    }

    public Object peek() {
        Object element = null;
        if (topOfStack != 0) {
            element = stack[topOfStack - 1];
        }
        return element;
    }

    public void increaseCapacity() {
        Object[] oldStack = stack;
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
}

