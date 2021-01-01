package src.VC;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import src.Event.UserInterface;

/** Classe represents a Frame.
 * @author Arthur, Kamel, Lahcene, Maxence
 */
public class Frame extends JFrame implements MouseListener{
	
	/** Userinterface for the puzzle. */
	protected UserInterface userInterface;
	
	/** Interface graphique size. */
	protected int length,width;

	/**@param userInterface qui prends un puzzle avec sa taille.
	 * @param length represents Length of the window.
	 * @param width represents Width of the window.
	 */
	public Frame(UserInterface userInterface,int length,int width){
		
		/** Initialization of attributs*/
		this.userInterface = userInterface;
		this.addMouseListener(this);
		this.setTitle("JEU DE PUZZLE");
		this.length = length;
		this.width = width;
		this.add(userInterface);
		/** To resize the window*/
		this.setPreferredSize(new Dimension(length,width));
		
		/** Give Max and Min size for our window*/
		this.setMaximumSize(new Dimension(1650,1080));
		this.setMinimumSize(new Dimension(this.length*105,this.length*111));
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/** Responsible of listening when the user
	 * click she make the move.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		userInterface.getPuzzle().move(e.getX()/100,e.getY()/100);
		userInterface.getPuzzle().printGrid();
	}
	
	/** TODO Auto-generated method stub*/
	@Override
    public void mousePressed(MouseEvent e) {
    }
	
    /** TODO Auto-generated method stub*/
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    
    /** TODO Auto-generated method stub*/
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    
    /** TODO Auto-generated method stub*/
    @Override
    public void mouseExited(MouseEvent e) {
    }


}
