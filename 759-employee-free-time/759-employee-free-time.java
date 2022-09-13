/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
    
        List<Interval> result = new ArrayList<>();
        //check for null input 
        if(schedule == null || schedule.size() == 0) return result;
        
        PriorityQueue<Interval> minHeap = new PriorityQueue<>((a, b) -> a.start != b.start? a.start - b.start: a.end - b.end);
        
        
        for(List<Interval> list : schedule){
            for(Interval interval : list) minHeap.add(interval);
        }
        
        if(minHeap.isEmpty()) return result;
        Interval pre = minHeap.poll();
        
        while(!minHeap.isEmpty()){
            Interval curr = minHeap.poll();
            if(pre.end < curr.start) result.add(new Interval(pre.end, curr.start));
            else {
                curr.start = Math.min(curr.start, pre.start);
                curr.end = Math.max(curr.end, pre.end);
            }
            pre = curr;
        }
        return result;  
    }
}