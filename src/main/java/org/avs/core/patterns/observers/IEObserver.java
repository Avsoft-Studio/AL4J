package org.avs.core.patterns.observers;

import java.util.Collection;
import java.util.Set;

import org.avs.core.patterns.observers.IObservable;
import org.avs.core.patterns.observers.IObserver;

/**
 * Interface which extends the classical observer by giving it a list of
 * <code>IObservable</code> too in order to do specific stuffs in function of
 * the observable
 * 
 * @category Interface
 * @author Daeron (Avsoft Studio)
 * @see IObserver
 * @since 1.0
 * @version 1.0
 */
public interface IEObserver extends IObserver, Set<IObservable>{

	/**
	 * @see IObserver#notifier()
	 * @since 1.0
	 */
	void notifier(IObservable observable);

	/**
	 * @param observable
	 * @since 1.0
	 */
	default boolean addObservable(IObservable observable) {
		return this.add(observable) && observable.add(this);
	}

	/**
	 * @param observables
	 * @since 1.0
	 */
	default boolean addObservables(Collection<? extends IObservable> observables) {
		boolean result = true;
		for(IObservable io: observables) {
			result = result && addObservable(io);
		}
		return result;
	}

	/**
	 * @return True if the <code>IObservables</code> is removed
	 * @since 1.0
	 */
	default boolean removeObservable(IObservable observable) { 
		return this.remove(observable) && observable.remove(this); 
	}

	/**
	 * Remove the list o
	 * @param observables The list of <code>IObservable</code> to remove
	 * @return True if at least, one <code>IObservable</code> is removed from the
	 *         list
	 * @since 1.0
	 */
	default boolean removeObservables(Collection<? extends IObservable> observables) { 
		boolean result = true;
		for(IObservable io : observables) {
			result = result && removeObservable(io);
		}
		return result; 
	}

	/**
	 * Remove the <code>IObservale</code> at the index position of the list
	 * @param index The position of the <code>IObservable</code>
	 * @return The <code>IOservable</code> remove from the list
	 * @since 1.0
	 */
	IObservable removeObservable(int index);
}
