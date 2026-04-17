class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack();
        for(char ch : s.toCharArray()){
            if(map.containsKey(ch) && !stack.isEmpty() && stack.peek() == map.get(ch)){
                stack.pop();
                continue;
            }
            stack.push(ch);
        }
        return stack.isEmpty();
    }
}
