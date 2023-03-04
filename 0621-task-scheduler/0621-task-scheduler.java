class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        int[] freq = new int[26];
        for(char t: tasks) freq[t-'A']++;
        Arrays.sort(freq);
        
        int fMax = freq[25];
        int idleTime = (fMax-1)*n;
        
        for(int i= freq.length-2; i>=0 && idleTime>0 ; i--){
            idleTime -= Math.min(fMax-1, freq[i]);
        }
        idleTime = Math.max(idleTime,0);
        return idleTime+tasks.length;
    }
}

/*Algorithm

The maximum number of tasks is 26.an array frequencies of 26 elements to keep the frequency of each task.
Iterate over the input array and store the frequency of task A at index 0, the frequency of task B at index 1, etc.

Sort the array and retrieve the maximum frequency f_max. This frequency defines the max possible idle time: idle_time = (f_max - 1) * n.

Pick the elements in the descending order one by one. At each step, decrease the idle time by min(f_max - 1, f) where f is a current frequency. Remember, that idle_time is greater or equal to 0.

Return busy slots + idle slots: len(tasks) + idle_time.*/