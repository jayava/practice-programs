package org.aj.packetrouter.data;

/**
 * @author AJ
 * represents a data packet
 */
public interface Packet {
	
	/**
	 * enum to represent packet
	 * size
	 * @author AJ
	 *
	 */
	public enum PacketSize {
		SMALL(1),
		LARGE(2);
		
		private PacketSize(int priority) {
			this.sizePriority = priority;
		}

		private final int sizePriority;

		public int getSizePriority() {
			return sizePriority;
		}
		
	}
	
	/**
	 * enum to represent the packet type
	 * @author AJ
	 *	
	 */
	public enum PacketType {
		USER(1),
		MGMT(2);
		
		private PacketType(int priority) {
			this.typePriority = priority;
		}

		private final int typePriority;

		public int getTypePriority() {
			return typePriority;
		}
	}
	
	/**
	 * 
	 * @return the unique ID of this 
	 * packet
	 */
	long getPacketId();
	
	/**
	 * 
	 * @return the raw data of the packet
	 */
	String getRawData(); 
	
	
	
	/**
	 * 
	 * @return the type of the packet
	 */
	PacketType getPacketType();
	
	/**
	 * 
	 * @return whether packet is small or large
	 */
	PacketSize getPacketSize();
}
