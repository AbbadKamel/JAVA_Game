package src.Launch;

import src.Event.UserInterface;
import src.Model.Puzzle;
import src.VC.Frame;

/** Classe represents the Main for the .jar.
 * @author Arthur, Kamel, Lahcene, Maxence
 */
public class Main2 {
	public static void main(String[] args){
		
		Puzzle p = new Puzzle(3,3);
		UserInterface userInterface = new UserInterface(p,3,3);
		Frame frame=new Frame(userInterface,3,3);
	}
}
