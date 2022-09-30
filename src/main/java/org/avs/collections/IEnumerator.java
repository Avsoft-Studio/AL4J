package org.avs.collections;

public interface IEnumerator {
	Object current();
	
	void reset();
	
	boolean moveNext();
}
