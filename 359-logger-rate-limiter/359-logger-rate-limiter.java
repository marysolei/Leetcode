class Logger {
    HashMap<String, Integer> hmap;
    public Logger() {
        hmap = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!hmap.containsKey(message)){
            hmap.put(message, timestamp);
            return true;
        }else {
            int oldTimestamp = hmap.get(message);
            if(timestamp -oldTimestamp>= 10) {
                hmap.put(message, timestamp);
                return true;
            }else return false;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
/*The idea is that we keep a hashtable/dictionary with the message as key, and its timestamp as the value. The hashtable keeps all the unique messages along with the latest timestamp that the message was printed.*/