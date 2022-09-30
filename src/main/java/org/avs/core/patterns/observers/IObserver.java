package org.avs.core.patterns.observers;

/**
 * Describe the structure of a classic observer
 * @implNote Respect the design pattern Observer
 * @implSpec An observer cannot keep in memory the <code>IObservable</code>
 * @author Daeron - Avsoft Studio
 * @since 1.0
 * @version 1.0
 */
public interface IObserver {
    /**
     * Method launch by the different 
     * observable when this last change
     * @since 1.0
     */
    public void notifier();
}
