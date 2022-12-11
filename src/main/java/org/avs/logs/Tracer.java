package org.avs.logs;

import java.lang.reflect.Array;
import java.util.List;
import java.util.function.Predicate;

import org.avs.core.ConstHelper;

import org.avs.core.tuples.Couple;
import org.avs.core.patterns.logs.ILogLevel;
import org.avs.core.patterns.logs.ITrace;

public class Tracer implements ITrace<Couple<ILogLevel, CharSequence>>, AutoCloseable {
	private Couple<ILogLevel, CharSequence>[] traces;
	private int size;
	
	@SuppressWarnings("unchecked")
	public Tracer() {
		this.traces = (Couple<ILogLevel, CharSequence>[]) Array.newInstance(Couple.class ,ConstHelper.DEFAULT_ARRAY_CAPACITY);
		this.size = 0;
	}
	
	public int size() { return size; }

	public boolean isEmpty() { return size == 0; }
	
	public void close() throws Exception {
		this.removeTrace();
		this.traces = null;
	}
	
	public void removeTrace() {
		synchronized(this) {
			final Couple<ILogLevel, CharSequence>[] tab = this.traces;
			for(int to = this.size, i = this.size = 0; i < to; i++) {
				tab[i] = null;
			}
		}	
	}

	public boolean addTrace(Couple<ILogLevel, CharSequence> trace) {
		// TODO Auto-generated method stub
		return false;
	}

	public String traceToString() {
		// TODO Auto-generated method stub
		return null;
	}

	public Couple<ILogLevel, CharSequence> getTrace(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Couple<ILogLevel, CharSequence>> getTraces(Predicate<? super Couple<ILogLevel, CharSequence>> predicate) {
		// TODO Auto-generated method stub
		return null;
	}
}
