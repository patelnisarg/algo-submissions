class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> brackets = Map.of(
            ']', '[',
            ')', '(',
            '}', '{'
        );
        Deque<Character> stack = new ArrayDeque<>();
        for(char ch : s.toCharArray()){
            // if open bracket add to the stack 
            if(!brackets.containsKey(ch)){
                stack.addFirst(ch);
            } else {
                if(!stack.isEmpty() && stack.peekFirst() == brackets.get(ch)){
                    stack.removeFirst();
                    continue;
                }
                return false;
            } 
        }

        return stack.isEmpty();
    }
}
