package org.avs.helper;

import java.awt.Desktop;
import java.io.File;
import java.net.URI;

public final class DesktopHelper {
	private static final boolean SUPPORTED = Desktop.isDesktopSupported();
	private static final Desktop DESK = Desktop.getDesktop();
	
	public static final boolean tryOpenWebPage(final String url) {
        try {
        	if(SUPPORTED){
                DESK.browse(new URI(url)); 
                return false;
            }
    		return false;
        }catch(Exception e) { return false; }
    }
	
	public static final boolean tryOpenFile(final String url) {
       try {
    	   if(SUPPORTED){
    		   DESK.open(new File(url));
               return true;
           } 
           return false;
       }catch(Exception e) { return false; }
    }

    public static final boolean tryOpenFileEditor(final String url) {
    	try {
    		if(SUPPORTED){
    			DESK.edit(new File(url));
    	        return true;
    		}
    		return false;
    	} catch(Exception e) { return false;}
    }
}
