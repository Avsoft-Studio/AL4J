package org.avs.core.tuples;

/**
 * 
 * @author Avanzino Aur�lien
 * @param <Key>
 * @param <Value>
 */
public class Couple<L,R> {
	private L key;
	private R value;
	
	public Couple(){
		this(null);
	}
	
	public Couple(L key){
		this(key, null);
	}
	
	public Couple(L key, R value){
		this.key = key;
		this.value = value;
	}
	
	public L getLeft() {
		return this.key;
	}
	
	public R getRight() {
		return this.value;
	}
	
	public void setLeft(L key) {
		this.key = key;
	}
	
	public void setRight(R value) {
		this.value = value;
	}
	
	@Override
	public int hashCode() {
		return key.hashCode() ^ value.hashCode();
	}
	
	@Override
	public String toString() {
		return "Key : " + key.toString() + " - Value : " + value.toString(); 
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Couple<?,?>) {
			Couple<?, ?> tuple = (Couple<?, ?>)o;
			if(tuple.hashCode() == this.hashCode()) {
				return tuple.getLeft().hashCode() == this.key.hashCode()
						&& tuple.getRight().hashCode() == this.value.hashCode();
			}
		}
		return false;
	}
}
