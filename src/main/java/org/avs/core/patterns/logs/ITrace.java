package org.avs.core.patterns.logs;

import java.util.List;
import java.util.function.Predicate;

import org.avs.core.tuples.Couple;

/**
 * This interfaces is here to give the possibility to save the log trace into
 * an specific object that implements this interface
 * @author Avanzino Aurelien
 * @since 15/08/2021
 * @version 1.0
 * @param <Couple> Object that represent the trace with code and description
 * @see Avsoft.Object.Teams.Couple
 */
public interface ITrace<T> {
	
	int size();
	
	boolean isEmpty();
	
	/**
	 * Remove all the trace contained in the object
	 * @since 15/08/2021
	 */
	void removeTrace();
	
	/**
	 * Add a trace in the list contained in the object
	 * @since 15/08/2021
	 */
	boolean addTrace(T trace);
	
	/**
	 * Get the traces in a string format
	 * @return A String that contains the traces in the format : Code - Description
	 * @since 15/08/2021
	 */
	String traceToString();
	
	/**
	 * Give the trace at the position given
	 * @param i index of the trace
	 * @return Couple that represent the trace at the position given
	 */
	T getTrace(int i);
	
	/**
	 * Give all the trace saved in the current object in function of the specific code
	 * @param lvl - LogLevel Code of the traces
	 * @return A List<Couple>
	 */
	List<T> getTraces(Predicate<? super T> predicate);
}
