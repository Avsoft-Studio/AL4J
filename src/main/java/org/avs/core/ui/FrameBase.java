package org.avs.core.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Toolkit;

public abstract class FrameBase extends JFrame implements Runnable, IFrameBase{
    private static final long serialVersionUID = -6492481484973934111L;
    private static final Toolkit toolkitbase = Toolkit.getDefaultToolkit();
    private JPanel container;

    public FrameBase(){ this(-1, -1, ""); }

    public FrameBase(int width, int height){ this(width, height, ""); }

    public FrameBase(int width, int height, String windowTile){
        super(windowTile);
        Dimension taille = toolkitbase.getScreenSize();
        setPreferredSize(new Dimension(width != -1 ? width : taille.width/2, height != -1 ? height : taille.height/2));       
        setLocation(taille.width/4,taille.height/4);
        container = new JPanel();
        container.setLayout(null);
        setContentPane(container);
    }
    
    /***************************Override Methods*************************************/
    
    @Override
    public void setIconImage(String url){ setIconImage(toolkitbase.createImage(url)); }

    @Override
    public void showFrame(){ pack(); setVisible(true); }
    
    @Override
    public void closeFrame(){ dispose(); setVisible(false); }

    @Override
    public void run() { showFrame(); }
}

