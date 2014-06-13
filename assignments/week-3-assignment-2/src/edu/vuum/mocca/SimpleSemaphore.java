package edu.vuum.mocca;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @class SimpleSemaphore
 * 
 * @brief This class provides a simple counting semaphore
 *        implementation using Java a ReentrantLock and a
 *        ConditionObject (which is accessed via a Condition). It must
 *        implement both "Fair" and "NonFair" semaphore semantics,
 *        just liked Java Semaphores.
 */
public class SimpleSemaphore {
    /**
     * Define a ReentrantLock to protect the critical section.
     */
    // TODO - you fill in here
	final ReentrantLock myLock = new ReentrantLock();
    
	/**
     * Define a Condition that waits while the number of permits is 0.
     */
    // TODO - you fill in here
	Condition noAvailablePermitCondition = null;
	
    /**
     * Define a count of the number of available permits.
     */
    // TODO - you fill in here.  Make sure that this data member will
    // ensure its values aren't cached by multiple Threads..
	volatile int availablePermits; 
	// the fairness of the simpleSemaphore
	private boolean fair=false;
	
	// a waiting list of threads that are waiting on the noAvailablePermitCondition condition
	/* two data structures:
	 * 1. waiting list, for FIFO sequence. Every time, the first thread is removed.
	 * 	 	For double linked list, the tail-appending and head removal are both O(1) time complexity.
	 * 
	 * 2. waiting set, to retrieve any thread. The choice of hashSet is to achieve 
	 * 		O(1) insertion and removal time complexity.
	 * */
	List<Thread> waitingList = null;
	Set<Thread> waitingSet =null;
	
	public SimpleSemaphore(int permits, boolean fair) {
        // TODO - you fill in here to initialize the SimpleSemaphore,
        // making sure to allow both fair and non-fair Semaphore
        // semantics.
    	noAvailablePermitCondition = myLock.newCondition();
    	availablePermits = permits;
    	this.fair = fair;
    	if(fair)
    		waitingList = new LinkedList<Thread>();
    	else
    		waitingSet = new HashSet<Thread>();
    }

    /**
     * Acquire one permit from the semaphore in a manner that can be
     * interrupted.
     */
    public void acquire() throws InterruptedException {
        // TODO - you fill in here.
    	myLock.lock();
    	try{
    		if(fair){
    			//if fair, add to the waiting list
    			waitingList.add(Thread.currentThread());
    			//if fair, the next thread to wake up is the head in the linked list.
    			while(availablePermits == 0 || Thread.currentThread()!=waitingList.get(0)){
    				noAvailablePermitCondition.await();
    			}
    			waitingList.remove(0);
    		}
    		else{
    			//if not fair, add to the waiting set
    			waitingSet.add(Thread.currentThread());
    			// if not fair, the next thread to wake up can be any thread.
    			while(availablePermits == 0){
    				noAvailablePermitCondition.await();
    			}
    			waitingSet.remove(Thread.currentThread());
    		}
    		availablePermits--;
    	}
    	finally{
    		myLock.unlock();
    	}
    	
    }

    /**
     * Acquire one permit from the semaphore in a manner that cannot be
     * interrupted.
     */
    public void acquireUninterruptibly() {
        // TODO - you fill in here.
    	myLock.lock();
    	try{
    		if(fair){
    			//if fair, add to the waiting list
    			waitingList.add(Thread.currentThread());
    			//if fair, the next thread to wake up is the head in the linked list.
    			while(availablePermits == 0 || Thread.currentThread()!=waitingList.get(0)){
    				noAvailablePermitCondition.awaitUninterruptibly();
    			}
    			waitingList.remove(0);
    		}
    		else{
    			//if not fair, add to the waiting set
    			waitingSet.add(Thread.currentThread());
    			// if not fair, the next thread to wake up can be any thread.
    			while(availablePermits == 0){
    				noAvailablePermitCondition.awaitUninterruptibly();
    			}
    			waitingSet.remove(Thread.currentThread());
    		}
    		availablePermits--;
    	}
    	finally{
    		myLock.unlock();
    	}
    }
    

    /**
     * Return one permit to the semaphore.
     */
    void release() {
        // TODO - you fill in here.
    	myLock.lock();
    	try{
    		//increase available permit number
    		availablePermits++;
    		//wake up all the waiting threads
    		noAvailablePermitCondition.signal();
    	}
    	finally{
    		myLock.unlock();
    	}
    }

    /**
     * Return the number of permits available.
     */
    public int availablePermits() {
        // TODO - you fill in here by changing null to the appropriate
        // return value.
        return availablePermits;
    }
}
