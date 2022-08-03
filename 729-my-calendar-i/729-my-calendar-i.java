class MyCalendar {
    
    TreeMap<Integer, Integer> calendar;
    public MyCalendar() {
        this.calendar = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Integer prev = calendar.floorKey(start);
        Integer next = calendar.ceilingKey(start);
        if((prev == null || calendar.get(prev) <= start) && (next == null || end<= next) ){
            calendar.put(start,end);
            return true;
        }
        return false;
    }
}
//Time complexity: O(nlogn)
//Space complexity: O(n)

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
/*If we maintained our events in sorted order, we could check whether an event could be booked in 
O(logN) time (where N is the number of events already booked) by binary searching for where the 
event should be placed. We would also have to insert the event in our sorted structure.We need a data structure that keeps elements sorted and supports fast insertion. In Java, a TreeMap is the perfect candidate.
we will have a TreeMap where the keys are the start of each interval, and the values are the ends of those intervals.
When inserting the interval [start, end), we check if there is a conflict on each side with neighboring 
intervals: we would like calendar.get(prev)) <= start <= end <= next for the booking to be valid (or for prev or next to be null respectively.)*/