package org.avs.linq.collections.generic;

import org.avs.collections.IEnumerate;

public interface IEnumerable<T> extends IEnumerate{
	IGenEnumerator<T> GetEnumerator();
}
