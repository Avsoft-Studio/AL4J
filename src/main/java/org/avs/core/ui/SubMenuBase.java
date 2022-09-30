package org.avs.core.ui;

import java.awt.Dimension;
import javax.swing.JMenu;

public abstract class SubMenuBase extends JMenu{
	private static final long serialVersionUID = -5841125624503311052L;
	private static Dimension dimMenuItem;
	
	public SubMenuBase(String name) {
		super(name); dimMenuItem = new Dimension(150,25);
	}
	
	public Dimension getDimMenuItem() { return dimMenuItem; }
	
	public void setDimMenuItem(Dimension dim) { dimMenuItem = dim;}
	
	public abstract void initListeners();
	
	public abstract void initMenuItem();
	
	public abstract void initMouseListeners();
}
