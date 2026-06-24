class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            int strLen = str.length();
            sb.append(strLen).append('#').append(str);
        }

        return sb.toString();
    }
    // 01 23456 7
    // 5# Hello 5#World
    public List<String> decode(String str) {
        System.out.println(str);
        List<String> output = new ArrayList<>();
        int i = 0;
        while(i < str.length()){
            int part = str.indexOf('#', i);
            int strLen = Integer.parseInt(str.substring(i, part));
            String word = str.substring(part+1, part+strLen+1);
            output.add(word);
            i = part+strLen+1;
        }

        return output;
    }
}
