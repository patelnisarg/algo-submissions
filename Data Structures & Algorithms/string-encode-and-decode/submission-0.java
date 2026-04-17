class Solution {

    public String encode(List<String> strs) {
        StringBuilder encodedStr = new StringBuilder();
        for(String str : strs){
            int strLength = str.length();
            encodedStr.append(strLength).append('#').append(str);
        }
        return encodedStr.length() > 0 ? encodedStr.toString() : "";
    }

    public List<String> decode(String str) {
        List<String> output = new ArrayList<>();
        int i = 0;
        while(i < str.length()){
            System.out.println("i: " + i);
            int j = i;
            while(str.charAt(j) != '#'){
                j++;
            }
            System.out.println("j: " + j);
            int strLength = Integer.parseInt(str.substring(i, j));
            String temp = str.substring(j+1, j+1+strLength);
            output.add(temp);
            i = j+1+strLength;
        }

        return output;
    }
}
