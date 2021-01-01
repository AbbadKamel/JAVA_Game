package src.Event;

import src.Model.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

/** Classe represents a Interface.
 * @author Arthur, Kamel, Lahcene, Maxence
 */
public class UserInterface extends JPanel implements UpdatePuzzle{

	/** Puzzle Model with Lines and Columns. */
	private Puzzle puzzle;
	private int N,M;

	/**@param puzzle the model puzzle.
	 * @param N represents number of lines.
	 * @param M represents number of columns.
	 */
	public UserInterface(Puzzle puzzle,int N,int M) {

		/** Initialization of attributs. */
		this.setPuzzle(new Puzzle(N,M));
		this.getPuzzle().addListning(this);
		this.N=N;
		this.M=M;		
	}

	/**Method for moves and paint the grid with a color for each case. */
	@Override
	protected void paintComponent(Graphics g) {
		
		int incrementationLigne1=0;
		int incrementationColonne1=0;
		int incrementationLigne2=35;
		int incrementationColonne2=35;
		super.paintComponent(g);
		/** Set BackGround Color. */
		this.setBackground(Color.WHITE);

		for(int i=0;i<N;i++) {
			incrementationColonne1=0;
			incrementationColonne2=50;
			for(int j=0;j<M;j++) {
			
				int nb=getPuzzle().getGrid()[i][j];
				/** Test if case = 0 it change color to red. */
				if(nb==0) {
				/** Draw each box as a square. */	
				g.drawRect(incrementationLigne1,incrementationColonne1,100,100);
				incrementationColonne1+=100;
				incrementationColonne2+=100;
				}else {
				g.setColor(Color.RED);
				g.fillRect(incrementationLigne1,incrementationColonne1,100,100);
				g.setColor(Color.WHITE);
				g.setFont(getFont().deriveFont(Font.BOLD, 25));
				g.drawRect(incrementationLigne1,incrementationColonne1,100,100);
				g.drawString(Integer.toString(nb),incrementationLigne2,incrementationColonne2);
				incrementationColonne1+=100;
				incrementationColonne2+=100;
				}	
			}
			incrementationLigne1+=100; 
			incrementationLigne2+=100;
		}	
	}
	
	/** Responsible of updating. */
	@Override
	public void updating(Object source) {
		this.repaint();
		this.revalidate();		
	}

	/** Return the puzzle. */
	public Puzzle getPuzzle() {
		return puzzle;
	}

	/**To set the puzzle. */
	public void setPuzzle(Puzzle puzzle) {
		this.puzzle = puzzle;
	}
}
