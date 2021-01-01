package src.VC;

import java.util.ArrayList;
import src.Event.UpdatePuzzle;

/** Classe represents a PuzzleListener.
 * @author Arthur, Kamel, Lahcene, Maxence
 */
public class Puzzlelistener {

	/** ArrayList de type UpdatePuzzle. */
	protected ArrayList<UpdatePuzzle>ecouteur;

	public Puzzlelistener() {   
		/** Initialization of attributs. */
		this.ecouteur = new ArrayList<>();
	}

	/** Responsible for listening our Puzzle 
	 * and to have ability to update. 
	 */
	public void addListning(UpdatePuzzle ecouteur) {
		this.ecouteur.add(ecouteur);			
	}

	/** Rung through our puzzle and listen to update it. */
	public void fireChangement(){ 
		for(UpdatePuzzle e :ecouteur){
			e.updating(this);
		}
	}
}
