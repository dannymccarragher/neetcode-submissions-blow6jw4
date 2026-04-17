class TimeMap {

    private Map<String, List<Integer>> timestamps;
    private Map<String, List<String>> values;

    public TimeMap() {
       timestamps = new HashMap<>();
       values = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!timestamps.containsKey(key)){
            timestamps.put(key, new ArrayList<>());
            values.put(key, new ArrayList<>());
        }

        timestamps.get(key).add(timestamp);
        values.get(key).add(value);
    }
    
    public String get(String key, int timestamp) {
        if(!timestamps.containsKey(key)){
            return "";
        };

        String res = "";

        List<Integer> times = timestamps.get(key);
        List<String> vals = values.get(key);

        int left = 0;
        int right = times.size() - 1;

        while(left <= right){

            int mid = left + (right - left / 2);

            if(times.get(mid) == timestamp){
                return vals.get(mid);
            } else if (times.get(mid) < timestamp){
                res = vals.get(mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return res; 
    }
}
