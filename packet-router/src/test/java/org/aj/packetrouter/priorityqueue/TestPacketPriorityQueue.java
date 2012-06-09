package org.aj.packetrouter.priorityqueue;

import static org.junit.Assert.*;

import org.aj.packetrouter.data.Packet;
import org.aj.packetrouter.data.PacketVO;
import org.aj.packetrouter.data.Packet.PacketType;
import org.junit.Test;

/**
 * Tests behavioural correctness of the class
 * @author AJ
 *
 */
public class TestPacketPriorityQueue {

	@Test
	public void testMgmtVsUserPackets() {
		Packet a = new PacketVO("Anish", PacketType.MGMT);
		Packet b = new PacketVO("AJ", PacketType.USER);
		
		PacketPriorityQueue m = new PacketPriorityQueueLockFreeImpl();
		
		//adding user packet first
		m.put(b);
		m.put(a);
		
		//expect mgmt packet to be delivered first
		assertEquals(m.get(), a);
	}
	
	@Test
	public void testLargeVsSmallPackets() {
		Packet a = new PacketVO("AnishJayavant", PacketType.MGMT);
		Packet b = new PacketVO("AJ", PacketType.MGMT);
		
		PacketPriorityQueue m = new PacketPriorityQueueLockFreeImpl();
		
		//adding user packet first
		m.put(b);
		m.put(a);
		
		//expect  packet a to be delivered first as it is larger
		assertEquals(m.get(), a);
	}
	
	@Test
	public void testEqualPriorityPackets() {
		Packet a = new PacketVO("AnishJayavant", PacketType.MGMT);
		Packet b = new PacketVO("ConcurrentSkipListSet", PacketType.MGMT);
		
		PacketPriorityQueue m = new PacketPriorityQueueLockFreeImpl();
		
		//adding user packet first
		m.put(b);
		m.put(a);
		
		//expect packet b to be delivered first as it has been 
		//in the queue for longer
		assertEquals(m.get(), b);
		
		//add b back into the queue
		m.put(b);
		
		//now a will be higher priority as it has been entered first
		assertEquals(m.get(), a);
	}
	
	@Test
	public void testGetRemovesElementFromSet() {
		Packet a = new PacketVO("AnishJayavant", PacketType.MGMT);
		PacketPriorityQueue m = new PacketPriorityQueueLockFreeImpl();
		
		m.put(a);
		assertEquals(m.get(), a);
		//assert that nothing is left in the queue after a call to get
		assertNull(m.get());
	}

}
