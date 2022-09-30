package org.avs.linq.collections.generic;

import org.avs.collections.IEnumerator;

public interface IGenEnumerator<T> extends IEnumerator {
	T current();
	
	boolean moveNext();
	
	void reset();
}
