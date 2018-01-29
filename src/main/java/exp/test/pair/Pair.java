package exp.test.pair;

import java.util.AbstractMap.SimpleEntry;

public class Pair<K, V> extends SimpleEntry<K, V> {

	private static final long serialVersionUID = -8326600855329979524L;

	public Pair(K key, V value) {
		super(key, value);
	}

}
