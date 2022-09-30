package org.avs.linq;

import org.avs.linq.collections.generic.IEnumerable;

public interface IOrderedEnumerable<TElement> extends IEnumerable<TElement> {
	//CreateOrderedEnumerable<TKey>(Func<TElement,TKey>, IComparer<TKey>, Boolean)
	//IOrderedEnumerable<TElement> createOrderedEnumerable(Function function, IComparer<TKey, boolean>);
}
