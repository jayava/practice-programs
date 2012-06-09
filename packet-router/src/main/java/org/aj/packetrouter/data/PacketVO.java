package org.aj.packetrouter.data;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 
 * @author AJ simple vo for a packet. Wraps over string packet data
 */
public class PacketVO implements Packet {

	/**
	 * packet ID generator
	 */
	private static final AtomicLong idgen = new AtomicLong(1);

	private static final int SMALL_PACKET_LIMIT = 10;

	private final long packetId;
	private final String rawData;
	private final PacketSize size;
	private final PacketType type;

	public PacketVO(String rawData, PacketType type) {
		this.rawData = rawData;
		// assumption: if packet raw data is
		// greater than 10 then
		// it is a big packet
		if (rawData.length() > SMALL_PACKET_LIMIT)
			size = PacketSize.LARGE;
		else
			size = PacketSize.SMALL;

		this.type = type;
		packetId = idgen.incrementAndGet();
	}

	@Override
	public String getRawData() {
		return rawData;
	}

	@Override
	public PacketType getPacketType() {
		return type;
	}

	@Override
	public PacketSize getPacketSize() {
		return size;
	}

	@Override
	public long getPacketId() {
		return packetId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (packetId ^ (packetId >>> 32));
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
		PacketVO other = (PacketVO) obj;
		if (packetId != other.packetId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PacketVO [packetId=" + packetId + ", rawData=" + rawData
				+ ", size=" + size + ", type=" + type + "]";
	}
	
	
}
