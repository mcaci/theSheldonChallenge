/**
 * 
 */
package app;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import app.gameSession.GameSession;
import app.gameSession.HUMvsCPU.GUI_HUMvsAI_GS;
import app.gameSession.HUMvsCPU.HUMvsAI_GS;

/**
 * @author nikiforos
 *
 */
public class AppWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5039545804352803948L;

	private GameSession gs;
	/**
	 * @throws HeadlessException
	 */
	public AppWindow() throws HeadlessException {
//		// put the name on the title
//		setTitle("Simple example");
//		// set size of the window
//		setSize(300, 200);
//		// set window to center
//		setLocationRelativeTo(null);
//		// close when 'x' pressed
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		initUI();
		gs = new GUI_HUMvsAI_GS();
		gs.startGame();
	}

	/**
	 * @param arg0
	 */
	public AppWindow(GraphicsConfiguration arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @throws HeadlessException
	 */
	public AppWindow(String arg0) throws HeadlessException {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public AppWindow(String arg0, GraphicsConfiguration arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}
	
	public final void initUI() {

       JPanel panel = new JPanel();
       getContentPane().add(panel);

       // this line means I'll have to set the position of objects
       panel.setLayout(null);
//	   panel.setToolTipText("A Panel container");

       JButton rockButton = new JButton("Pietra");
       rockButton.setBounds(30, 20, 80, 30);
       rockButton.setToolTipText("Seleziona Pietra");
       rockButton.addActionListener(new ButtonListener());
//       rockButton.addActionListener(new ActionListener() {
//    	   
//    	   @Override
//           public void actionPerformed(ActionEvent event) {
//               System.exit(0);
//    	   }
//		
//       });
       // finishing to add the button
       panel.add(rockButton);
       
       JButton scissorButton = new JButton("Forbice");
       scissorButton.setBounds(30, 60, 80, 30);
       scissorButton.setToolTipText("Seleziona Forbice");
       scissorButton.addActionListener(new ButtonListener());
//       scissorButton.addActionListener(new ActionListener() {
//    	   
//    	   @Override
//           public void actionPerformed(ActionEvent event) {
//               System.exit(0);
//    	   }
//		
//       });
       // finishing to add the button
       panel.add(scissorButton);

       JButton paperButton = new JButton("Carta");
       paperButton.setBounds(30, 100, 80, 30);
       paperButton.setToolTipText("Seleziona Carta");
//	   paperButton.addActionListener(new ActionListener() {
//	    	   
//	   		@Override
//       		public void actionPerformed(ActionEvent event) {
//       			System.exit(0);
//       		}
//			
//	       });
       paperButton.addActionListener(new ButtonListener());
       // finishing to add the button
       panel.add(paperButton);
       
       setTitle("Quit button");
       setSize(300, 200);
       setLocationRelativeTo(null);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
	
	class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JButton o = (JButton) e.getSource();
            String label = o.getText();
            System.out.println(label);
        }
    }
	       
	public static void main(String[] args) throws InterruptedException, InvocationTargetException {
		
        SwingUtilities.invokeAndWait(new Runnable() {
        	
            public void run() {
                AppWindow gameWindow = new AppWindow();
                gameWindow.setVisible(true);
            }
        } );
        
    }

}
