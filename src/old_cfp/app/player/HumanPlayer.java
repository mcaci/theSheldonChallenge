package app.player;

import gameSession.E2Players;
import gameSession.EMossa;
import java.util.Scanner;

public class HumanPlayer extends Player {

	String id;
	int punteggio;
	boolean win;

	public HumanPlayer(E2Players p) {
		super(p);
	}

	public EMossa chooseMove() {
		int scelta = 0;
		System.out.print("Scegli una mossa: [\"1\" = CARTA; \"2\" = FORBICE; \"3\" = PIETRA] --> ");
		Scanner in = new Scanner(System.in);
		do{
			scelta = in.nextInt() - 1;
		} while ((scelta < 0) || (scelta > 2));
		System.out.println();
		return EMossa.values()[scelta];
	}
}
