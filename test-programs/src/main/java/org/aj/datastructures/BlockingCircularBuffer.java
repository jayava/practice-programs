package org.aj.datastructures;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingCircularBuffer {

	private static final int MAX_SIZE = 10;
	private final Object[] buffer;
	private int readPos = 0, writePos = 0;
	private final Lock bufferSyncLock = new ReentrantLock();
	private final Condition full = bufferSyncLock.newCondition();
	private final Condition empty = bufferSyncLock.newCondition();

	public BlockingCircularBuffer() {
		buffer = new Object[MAX_SIZE];
	}

	public boolean isEmpty() {
		boolean bRet = false;
		try {
			bufferSyncLock.lock();
			if (isBufferEmpty())
				bRet = true;
			else
				bRet = false;
		} finally {
			bufferSyncLock.unlock();
		}
		return bRet;
	}

	public boolean isFull() {
		boolean bRet = false;
		try {
			bufferSyncLock.lock();
			if (isBufferFull())
				bRet = true;
		} finally {
			bufferSyncLock.unlock();
		}
		return bRet;
	}

	public void write(Object o) {
		try {
			bufferSyncLock.lock();
//			System.out.println("Thread :" + Thread.currentThread().getName()
//					+ " is writing object :" + o + " the buffer at position :"
//					+ writePos);
			// invoke await in a while loop - if not enough as 
			// it might lead to inconsistent states
			while (isBufferFull()) {
//				System.out.println("Buffer is full.. will need to wait");
				full.await();
			}
//			System.out.println("Thread " + Thread.currentThread().getName() + 
//					" acquired lock on a buffer that is not full");
//			// lock acquired and circbuffer is not full
			//Step 1: Write the object into the buffer
			buffer[writePos] = o;
			//Step 2: Calculate the new value of writePos
			if(writePos == MAX_SIZE -1)
				writePos = 0; // reset to zero as this is a circular buffer
			else
				++writePos;
			// Write complete - now signal the threads waiting on an empty circular buffer.
			empty.signal();
			
		} catch (InterruptedException e) {
			System.out.println("Thread :" + Thread.currentThread().getName()
					+ " was interrupted");
			e.printStackTrace();
		} finally {
			bufferSyncLock.unlock();
		}
	}
	
	public Object read(){
		Object retObj = null;
		try {
			//Lock the buffer
			bufferSyncLock.lock();
//			System.out.println("Thread :" + Thread.currentThread().getName()
//					+ " is reading object from the buffer at position :"
//					+ readPos);
			while(isBufferEmpty()){
				System.out.println("Buffer empty - must wait");
				empty.await();
			}
			// acquired lock on a nonempty buffer
//			System.out.println("Thread " + Thread.currentThread().getName() + 
//					" acquired lock on a buffer that is not empty");
//			//Step 1: read the object from the buffer
			retObj = buffer[readPos];
			// Step 2: calculate readPos
			if(readPos == MAX_SIZE -1)
				readPos = 0; // reset to zero as this is a circular buffer
			else
				++readPos;
			// read complete - now signal the threads waiting on a full circular buffer.
			full.signal();
			
		} catch (InterruptedException e) {
			System.out.println("Thread :" + Thread.currentThread().getName()
					+ " was interrupted");
			e.printStackTrace();
		} finally {
			bufferSyncLock.unlock();
		}
		
		return retObj;
	}

	/**
	 * To be called from a proper sychronized context do not expose
	 * 
	 * @return
	 */
	private boolean isBufferFull() {
		return ((writePos - readPos + 1) % MAX_SIZE == 0);
	}

	/**
	 * To be called from a proper sychronized context do not expose
	 * 
	 * @return
	 */
	private boolean isBufferEmpty() {
		return (readPos == writePos);
	}
}
