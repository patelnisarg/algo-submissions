class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int leftPtr = 0;
        int rightPtr = s.length() - 1;
        while(leftPtr < rightPtr){
            System.out.println("leftPtr: " + leftPtr + " rightPtr: " + rightPtr);
            while(!Character.isLetterOrDigit(s.charAt(leftPtr)) && leftPtr < rightPtr){
                leftPtr++;
            }
            while(!Character.isLetterOrDigit(s.charAt(rightPtr)) && rightPtr > leftPtr){
                rightPtr--;
            }
            if(s.charAt(leftPtr) != s.charAt(rightPtr)){
                return false;
            }
            leftPtr++;
            rightPtr--;
        }
        return true;
    }
}
