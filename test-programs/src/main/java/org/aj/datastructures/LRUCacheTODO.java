/**
 * Jan 29, 2012
 * org.aj.datastructures
 */
package org.aj.datastructures;

/**
 * @author AJ
 *
 */
class LRUCacheTODO {
	
	private static class CacheEntry<K,V> {
		
		private final K key;
		private final V value;
		private volatile long lastAccessedNanos;
		
		private CacheEntry(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
