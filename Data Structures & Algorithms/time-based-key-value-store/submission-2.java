/**
* Each key can have multiple values at different timestamp 
* We want to retrieve the key's value at a certain timestamp 
*/
class Pair {
    int timestamp; 
    String value;

    public Pair(int timestamp, String value){
        this.timestamp = timestamp;
        this.value = value;
    }
}
class TimeMap {
    Map<String, List<Pair>> collection;

    public TimeMap() {
        collection = new HashMap<>();        
    }
    
    public void set(String key, String value, int timestamp) {
        collection.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(timestamp, value));
        return;
    }
    
    public String get(String key, int timestamp) {
        if(!collection.containsKey(key)) return "";

        List<Pair> pairs = collection.get(key);
        // if(pairs.size() == 0) return "";
        // else if (pairs.size() == 1) return pairs.get(0).value;
        // else {
        int left = 0, right = pairs.size() - 1;
        while(left <= right){
            int mid = left + ((right - left) / 2);

            if(pairs.get(mid).timestamp == timestamp){
                return pairs.get(mid).value;
            } else if(pairs.get(mid).timestamp < timestamp){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if(right >= 0 && right < pairs.size()){
            return pairs.get(right).value;
        }
        return "";
        // }

    }
}
