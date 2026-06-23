class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        String operands = "+-*/";
        for(String token : tokens){
            if(operands.indexOf(token) != -1){
                int firstNumber = stack.removeFirst();
                int secondNumber = stack.removeFirst();
                // System.out.println("first number is: " + firstNumber + " second number is: " + secondNumber);
                if(token.equals("+")){
                    stack.addFirst(firstNumber + secondNumber);
                } else if(token.equals("-")) {
                    stack.addFirst(secondNumber - firstNumber);
                } else if(token.equals("*")){
                    stack.addFirst(firstNumber * secondNumber);
                } else {
                    stack.addFirst(secondNumber / firstNumber);
                }
            } else {
                stack.addFirst(Integer.valueOf(token));
                // System.out.println("adding token to stack: " + Integer.valueOf(token));
            }
            // System.out.println("peek of the stack is: " + stack.peekFirst());
        }

        return stack.peekFirst();
    }
}
