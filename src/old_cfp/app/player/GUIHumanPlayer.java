package app.player;

import gameSession.E2Players;
import gameSession.EMossa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class GUIHumanPlayer extends Player implements ActionListener {
	
	private String mossa;

	public GUIHumanPlayer(E2Players p) {
		super(p);
		this.setMossa(new String("CARTA"));
	}

	public EMossa chooseMove() {
		return EMossa.string2mossa(this.getMossa());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton o = (JButton) e.getSource();
        this.setMossa(o.getText());
        chooseMove();
	}

	private void setMossa(String mossa) {
		this.mossa = mossa;
	}

	private String getMossa() {
		return mossa;
	}
}
