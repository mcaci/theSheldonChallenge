/**
 * 
 */
package app;

import java.net.MalformedURLException;

import app.core.Core;

import player.Player;
import player.AI.AIPlayer;
import exception.NoPlayerNameException;
import exception.UnknownRuleException;

/**
 * @author nikiforos
 *
 */
public final class MainApp {

	/**
	 * @param args
	 * @throws NoPlayerNameException 
	 */
	public static void main(String[] args) throws MalformedURLException {
		
		Core c = Core.getInstance();
		System.out.println(c);
		
		Player p = null;
		try {
			p = new AIPlayer("", null);
		} catch (NoPlayerNameException e) {
//				e.printStackTrace();
		} catch (UnknownRuleException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		} finally {
			
			// there's no going here, exceptions force exit
			System.err.println("using \"PLAYER\" as name... ");
			try {
				p = new AIPlayer("PLAYER", null);
			} catch (NoPlayerNameException e) {
				// e.printStackTrace();
			} catch (UnknownRuleException e) {
				// e.printStackTrace();
			}
		} 

		System.err.println("ciao " + p.getId());
		
//        Icon icon = new ImageIcon("img/sheldon/ultimateSmileGif.gif");
//        JLabel label = new JLabel(icon);
// 
//        JFrame f = new JFrame("Animation");
//        f.getContentPane().add(label);
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        f.pack();
//        f.setLocationRelativeTo(null);
//        f.setVisible(true);
	}

}
