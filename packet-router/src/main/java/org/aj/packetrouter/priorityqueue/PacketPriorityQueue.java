package org.aj.packetrouter.priorityqueue;

import org.aj.packetrouter.data.Packet;

/**
 * 
 * @author AJ
 * Interface that represents a 
 * packet priority queue.
 */
public interface PacketPriorityQueue {

	/**
	 * Inserts the packet in the
	 * apt position
	 * @param input
	 * @return true if the packet was added
	 * and was not present previously 
	 * in the set
	 */
	boolean put(Packet input);
	
	/**
	 * retrieves the packet
	 * with highest priority
	 * @return
	 */
	Packet get();
}
