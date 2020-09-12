package javapp.tsc.GUI.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import core.tsc.AppCore;
import core.tsc.persistency.exception.WriteNotSupportedException;
import core.tsc.persistency.file.xml.DOMOptionManager;
import core.tsc.persistency.file.xml.XMLOptionManager;

public final class ExitGameListener implements ActionListener {

	public ExitGameListener() {}
	
	@Override
	public void actionPerformed(final ActionEvent arg0) {
		// TODO: add a "are you sure?" dialog box
		
		final XMLOptionManager optManager = new DOMOptionManager();
		try {
			optManager.writeOptions(AppCore.getInstance().getData());
		} catch (WriteNotSupportedException e) {
			e.printStackTrace();
		}
		
		System.out.println("EXITING GAME");
		System.exit(0);
	}

}
