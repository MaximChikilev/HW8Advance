public class Main {
    public static void main(String[] args) {
        MyStack myStack = new MyStack(5);
        for (int i=0;i<=10;i++){
            myStack.push(i);
        }
        System.out.println(myStack);
        System.out.println(myStack.pop());
        System.out.println(myStack);
        System.out.println(myStack.peek());
        System.out.println(myStack);
    }
}
