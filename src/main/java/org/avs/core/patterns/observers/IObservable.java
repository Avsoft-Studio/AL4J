package org.avs.core.patterns.observers;

import java.util.Collection;
import java.util.Set;

/**
 * Give the signature of the method notify for the observable in order 
 * to respect the design pattern Observer
 * @implNote Respect the design pattern Observer
 * @implSpec We add the possibility to notify just a few part of the observers
 * @author Daeron (Avsoft Studio)
 * @since 1.0
 * @version 1.0
 */
public interface IObservable extends Set<IObserver>{

    /**
     * 
     * @param index
     * @return
     * @since 1.0
     */
    IObserver removeObserver(int index);
    
	/**
     * Notify all the <code>IObserver</code> of the list given if these last
     * are in the list of the <code>IObservable</code>
     * @param observers The list of observers to notify
     * @implSpec Don't notify the <code>IObserver</code> if this last
     * aren't in the list of the <code>IObservable</code>
     * @since 1.0
     */
    default void notifierHalf(Collection<? extends IObserver> observers) {
    	for(IObserver io: observers) {
    		if(this.contains(io)) {
    			io.notifier();
    		}
    	}
    }
    
    /**
     * Notify all the observers of the different changement made
     * by the observable
     * @since 1.0
     */
    default void notifierAll() {
    	for(IObserver io: this) { 
    		io.notifier(); 
    	} //TODO - Check for parallelStream - Do Benchmark to see the difference and also tests
    }

    /**
     * Add an IObserver to the list of the IObservable
     * @param observer IObserver to add in the list
     * @since 1.0
     */
    default boolean addObserver(IObserver observer) { return this.add(observer); }
    
    default boolean addObserver(IEObserver observer) {
    	return this.add(observer) && observer.add(this);
    }

    /**
     * 
     * @param observers
     * @since 1.0
     */
    default boolean addObservers(Collection<? extends IObserver> observers) { return this.addAll(observers); }
    
    default boolean addIEObservers(Collection<? extends IEObserver> observers) { 
    	boolean result = true;
		for(IEObserver io: observers) {
			result = result && addObserver(io);
		}
		return result;
    }

    /**
     * 
     * @param observer
     * @return
     * @since 1.0
     */
    default boolean removeObserver(IObserver observer) { return this.remove(observer); }
    
    default boolean removeObserver(IEObserver observer) { return this.remove(observer) && observer.remove(this); }

    /**
     * 
     * @param observers
     * @return
     * @since 1.0
     */
    default boolean removeObservers(Collection<? extends IObserver> observers) { return this.removeAll(observers); }
    
    default boolean removeIEObservers(Collection<? extends IEObserver> observers) { 
    	boolean result = true;
		for(IEObserver io : observers) {
			result = result && removeObserver(io);
		}
		return result; 
    }
}
