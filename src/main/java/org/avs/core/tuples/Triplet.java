package org.avs.core.tuples;

/**
 * 
 * @author Avanzino Aur�lien
 * @version 1.0
 * @since 15/08/2021
 * @param <L>
 * @param <M>
 * @param <R>
 */
public class Triplet<L,M,R> {
	private L left;
	private M middle;
	private R right;
	
	Triplet(){

	}
	
	Triplet(L left, M middle, R right){
		this.left = left;
		this.middle = middle;
		this.right = right;
	}
	
	public L getLeft() {
		return this.left;
	}
	
	public R getRight() {
		return this.right;
	}
	
	public M getMiddle() {
		return this.middle;
	}
	
	public void setLeft(L key) {
		this.left = key;
	}
	
	public void setRight(R value) {
		this.right = value;
	}
	
	public void setMiddle(M middle) {
		this.middle = middle;
	}
	
	@Override
	public synchronized int hashCode() {
		return left.hashCode() ^ middle.hashCode() ^ right.hashCode();
	}
	
	@Override
	public String toString() {
		return "Left : " + left.toString() + " - Middle : " + middle.toString() + " - Right : " + right.toString(); 
	}
	
	@Override
	public synchronized boolean equals(Object o) {
		if(o instanceof Triplet) {
			Triplet<?, ?, ?> tuple = (Triplet<?, ?, ?>)o;
			return tuple.hashCode() == this.hashCode();
		}
		return false;
	}
}
