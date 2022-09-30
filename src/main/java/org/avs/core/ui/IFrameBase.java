package org.avs.core.ui;

public interface IFrameBase {
	/**
	 * Change l'icone de la barre
	 * 
	 * @param url
	 */
	void setIconImage(String url);

	/**
	 * affiche la fenetre sur l'ecran
	 */
	void showFrame();

	/**
	 * dispose et ferme la fenetre
	 */
	void closeFrame();
}
