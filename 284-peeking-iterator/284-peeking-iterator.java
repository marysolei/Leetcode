// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

import java.util.NoSuchElementException;

class PeekingIterator implements Iterator<Integer> {
    
    Iterator<Integer> iter;
    Integer peekedValue = null;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iter = iterator;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        
        //if there is not any peeked value yet, get one and store it
        if(peekedValue == null){
            if(!iter.hasNext()) throw new NoSuchElementException();
            peekedValue = iter.next();
        }
        return peekedValue;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    //check if we have a value 
        if(peekedValue != null){
            Integer res = peekedValue;
            peekedValue = null;
            return res;
        }
        if(!iter.hasNext()) throw new NoSuchElementException();
        return iter.next();
	}
	
	@Override
	public boolean hasNext() {
	    return peekedValue != null || iter.hasNext();
	}
}

//Time and space complexity: O(1) for all methods 

/*From Leetcode: Each time we call .next(...), a value is returned from the Iterator. If we call .next(...) again, a new value will be returned. This means that if we want to use a particular value multiple times, we had better save it.
Our .peek(...) method needs to call .next(...) on the Iterator. But because .next(...) will return a different value next time, we need to store the value we peeked so when .next(...) is called we return the correct value.*/
