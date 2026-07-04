class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> brackets = new HashMap<>() {
            {
                put('}', '{');
                put(')', '(');
                put(']', '[');
            }
        };
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            // if open bracket -- add it to the map
            if (!brackets.containsKey(ch)) {
                stack.addFirst(ch);
            } else {
                if (stack.peekFirst() != brackets.get(ch)) {
                    return false;
                }
                stack.removeFirst();
            }
        }

        return stack.isEmpty();
    }
}
