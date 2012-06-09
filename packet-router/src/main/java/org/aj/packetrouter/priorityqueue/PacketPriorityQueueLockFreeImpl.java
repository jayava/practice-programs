package org.aj.packetrouter.priorityqueue;

import java.util.concurrent.ConcurrentSkipListSet;

import org.aj.packetrouter.data.Packet;

/**
 * Lock-free implementation of the packet priority queue Uses lock-free
 * {@link ConcurrentSkipListSet} to maintain elements in sorted order based on
 * priority. The elements with highest priority will appear at the head of the
 * queue
 * 
 * @author AJ
 * 
 */
public class PacketPriorityQueueLockFreeImpl implements PacketPriorityQueue {

	/**
	 * Represents an entry into the prio queue Record the entry time so that a
	 * tie can be broken based on the time when a packet was entered. Packets
	 * with equal priority will
	 * 
	 * @author AJ
	 * 
	 */
	private static class PacketEntry implements Comparable<PacketEntry> {
		private final Packet underlyingPacket;
		private final long queueEntryTime;

		private PacketEntry(Packet underlyingPacket) {
			this.underlyingPacket = underlyingPacket;
			this.queueEntryTime = System.nanoTime();
		}

		@Override
		public int compareTo(PacketEntry that) {
			// compare type first
			if (this.underlyingPacket.getPacketType().getTypePriority() > that.underlyingPacket
					.getPacketType().getTypePriority()) {
				return -1;
			} else if (this.underlyingPacket.getPacketType().getTypePriority() < that.underlyingPacket
					.getPacketType().getTypePriority()) {
				return 1;
			}

			// type is same, now compare size
			if (this.underlyingPacket.getPacketSize().getSizePriority() > that.underlyingPacket
					.getPacketSize().getSizePriority()) {
				return -1;
			} else if (this.underlyingPacket.getPacketSize().getSizePriority() < that.underlyingPacket
					.getPacketSize().getSizePriority()) {
				return 1;
			}

			// size and type are both same - use entry time as tiebreaker
			if (this.queueEntryTime < that.queueEntryTime) {
				// packet with lower entry time should go to the
				// head of the queue so return -1
				return -1;
			} else if (this.queueEntryTime > that.queueEntryTime) {
				return 1;
			}

			// everything is equal so return 0.
			return 0;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime
					* result
					+ ((underlyingPacket == null) ? 0 : underlyingPacket
							.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			PacketEntry other = (PacketEntry) obj;
			if (underlyingPacket == null) {
				if (other.underlyingPacket != null)
					return false;
			} else if (!underlyingPacket.equals(other.underlyingPacket))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "PacketEntry [underlyingPacket=" + underlyingPacket
					+ ", queueEntryTime=" + queueEntryTime + "]";
		}
	}

	private final ConcurrentSkipListSet<PacketEntry> prioQueue = new ConcurrentSkipListSet<>();

	@Override
	public boolean put(Packet input) {
		PacketEntry p = new PacketEntry(input);
		return prioQueue.add(p);
	}

	@Override
	public Packet get() {
		PacketEntry ret = prioQueue.pollFirst();
		return ret == null ? null : ret.underlyingPacket;
	}

}
