package org.avs.linq;

import org.avs.linq.collections.generic.IEnumerable;

public interface IGrouping<TKey, TElement> extends IEnumerable<TElement> {
	TKey key();
}
