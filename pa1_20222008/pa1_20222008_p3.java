import java.util.LinkedList;

public class pa1_20222008_p3 {

    public static class LinkedListStack {

        private LinkedList<Character> stack;

        public LinkedListStack() {
            stack = new LinkedList<>();
        }

        public void push(char data) {
            stack.push(data);
        }

        public char pop() {
            return stack.pop();
        }

        public Character peek() {
            return stack.isEmpty() ? null : stack.peek();
        }

        public boolean isEmpty() {
            return stack.isEmpty();
        }
    }

    public static int evalExp(String expression) {
        LinkedListStack valStk = new LinkedListStack();
        LinkedListStack opStk = new LinkedListStack();

        for (int i = 0; i < expression.length(); i++) {
            char token = expression.charAt(i);
            if (Character.isDigit(token)) {
                valStk.push(token);
            } else {
                repeatOps(token, valStk, opStk);
                opStk.push(token);
            }
        }

        repeatOps('$', valStk, opStk);
        return Character.getNumericValue(valStk.pop());
    }

    public static void repeatOps(char refOp, LinkedListStack valStk, LinkedListStack opStk) {
        while (!valStk.isEmpty() && valStk.peek() != null && valStk.peek() != '(' && prec(refOp) <= prec(opStk.peek())) {
            doOp(valStk, opStk);
        }
    }

    public static void doOp(LinkedListStack valStk, LinkedListStack opStk) {
        char x = valStk.pop();
        char y = valStk.pop();
        char op = opStk.pop();

        switch (op) {
            case '+':
                valStk.push((char) (y + x));
                break;
            case '-':
                valStk.push((char) (y - x));
                break;
            case '*':
                valStk.push((char) (y * x));
                break;
            case '/':
                valStk.push((char) (y / x));
                break;
        }
    }

    public static int prec(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        String expression = "2-3+11";
        System.out.println("20222222 pa1 p3 " + evalExp(expression));
    }
}
