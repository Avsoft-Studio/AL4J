package org.avs.linq;

import org.avs.linq.collections.generic.IEnumerable;

public interface ILookup<TKey, TElement> extends IEnumerable<IGrouping<TKey, TElement>> {
	int count();
	
	boolean containsKey(TKey key);
	
	IEnumerable<TElement> item(TKey key);
}
