/**
 * 
 */
package javapp.tsc.core;

import javapp.tsc.mediation.MoveLabelUpdater;
import javapp.tsc.mediation.ScoreLabelUpdater;
import javapp.tsc.mediation.playerGR.PlayerRoundMediator;
import javapp.tsc.mediation.playerGUI.PlayerGUIMediator;

/**
 * 
 * 
 * @author nikiforos
 * 
 */
public final class IntercomCore {

	private ScoreLabelUpdater gsCom;
	private MoveLabelUpdater grCom;
	private PlayerGUIMediator p1Com;
	private PlayerGUIMediator p2Com;
	private PlayerRoundMediator pgrCom;

	// public static boolean surrenderFlag = false;

	/**
	 * private constructor following the Singleton pattern
	 */
	private IntercomCore() {
		this.setGsCom(new ScoreLabelUpdater());
		this.setGrCom(new MoveLabelUpdater());
		this.setP1Com(new javapp.tsc.mediation.playerGUI.OneWaySynchroMediator());
		this.setP2Com(new javapp.tsc.mediation.playerGUI.OneWaySynchroMediator());
		this.setPGRCom(new javapp.tsc.mediation.playerGR.OneWaySynchroMediator());
	}

	/**
	 * class holder for the Singleton pattern
	 */
	private static class IntercomCoreHolder {
		public static final IntercomCore core = new IntercomCore();
	}

	public static final IntercomCore getInstance() {
		return IntercomCoreHolder.core;
	}

	@Override
	public final String toString() {
		return super.toString();
	}

	public final void setGsCom(ScoreLabelUpdater guiCom) {
		this.gsCom = guiCom;
	}

	public final ScoreLabelUpdater getGsCom() {
		return gsCom;
	}

	public final void setGrCom(MoveLabelUpdater grCom) {
		this.grCom = grCom;
	}

	public final MoveLabelUpdater getGrCom() {
		return grCom;
	}

	/**
	 * @param p1Com
	 *            the p1Com to set
	 */
	public final void setP1Com(PlayerGUIMediator p1Com) {
		this.p1Com = p1Com;
	}

	/**
	 * @return the p1Com
	 */
	public final PlayerGUIMediator getP1Com() {
		return p1Com;
	}

	/**
	 * @param p2Com
	 *            the p2Com to set
	 */
	public final void setP2Com(PlayerGUIMediator p2Com) {
		this.p2Com = p2Com;
	}

	/**
	 * @return the p2Com
	 */
	public final PlayerGUIMediator getP2Com() {
		return p2Com;
	}

	public final void setPGRCom(PlayerRoundMediator pgrCom) {
		this.pgrCom = pgrCom;

	}

	public final PlayerRoundMediator getPGRCom() {
		return pgrCom;
	}
}