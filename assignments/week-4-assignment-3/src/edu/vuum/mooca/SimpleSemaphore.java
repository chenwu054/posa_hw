package edu.vuum.mooca;

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
	ReentrantLock myLock = null;
    
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
	
	public SimpleSemaphore(int permits, boolean fair) {
        // TODO - you fill in here to initialize the SimpleSemaphore,
        // making sure to allow both fair and non-fair Semaphore
        // semantics.
    	myLock = new ReentrantLock(fair);
		noAvailablePermitCondition = myLock.newCondition();
    	availablePermits = permits;
    }

    /**
     * Acquire one permit from the semaphore in a manner that can be
     * interrupted.
     */
    public void acquire() throws InterruptedException {
        // TODO - you fill in here.
    	myLock.lock();
    	try{
    		while(availablePermits == 0)
    			noAvailablePermitCondition.await();
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
    		while(availablePermits == 0)
    			noAvailablePermitCondition.awaitUninterruptibly();
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
