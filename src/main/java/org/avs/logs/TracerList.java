package org.avs.logs;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.avs.core.patterns.logs.ILogLevel;
import org.avs.core.patterns.logs.ITrace;
import org.avs.core.tuples.Couple;

public class TracerList extends ArrayList<Couple<ILogLevel, CharSequence>> implements ITrace<Couple<ILogLevel, CharSequence>>, AutoCloseable{
	private static final long serialVersionUID = -7435887063026974545L;

	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void removeTrace() {
		// TODO Auto-generated method stub
		
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
