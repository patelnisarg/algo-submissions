class Solution {
    public int evalRPN(String[] tokens) {
        Deque<String> stack = new ArrayDeque<>();
        Set<String> operators = Set.of("+", "-", "/", "*");
        for (String token : tokens) {
            // System.out.println("token is: " + token);
            if (!operators.contains(token)) {
                stack.addFirst(token);
            } else {
                int firstNumber = Integer.valueOf(stack.removeFirst());
                // System.out.println("firstNumber is: " + firstNumber);
                int secondNumber = Integer.valueOf(stack.removeFirst());
                // System.out.println("secondNumber is: " + secondNumber);
                int newNumber = 0;
                if (token.equals("-")) {
                    newNumber = secondNumber - firstNumber;
                } else if (token.equals("+")) {
                    newNumber = firstNumber + secondNumber;
                } else if (token.equals("*")) {
                    newNumber = firstNumber * secondNumber;
                } else {
                    newNumber = secondNumber / firstNumber;
                }
                // System.out.println("newNumber is: " + newNumber);
                stack.addFirst(String.valueOf(newNumber));
            }
            // System.out.println("stack is: " + stack);
            // System.out.println('\n');
        }

        return Integer.valueOf(stack.peekFirst());
    }
}
