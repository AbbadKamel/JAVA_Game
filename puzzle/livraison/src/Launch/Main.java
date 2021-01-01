package src.Launch;
import src.VC.Frame;
import java.util.*;
import src.Event.UserInterface;
import src.Model.*;
import javax.swing.JFrame;

/** Classe represents the Main.
 * @author Arthur, Kamel, Lahcene, Maxence
 */
public class Main{
	public static void main(String[] args){
		
		int mode;
		do{
			System.out.println("Choose the mode that you want to play: \n *Tap 1 to play on the TERMINAL\n *Tap 2 to play on the INTERFACE");
	        Scanner sc= new Scanner(System.in);
	        mode = sc.nextInt();
	    }while(mode!=1 && mode!=2);
        
        if(mode == 1){
        	Scanner sc1 = new Scanner(System.in);
    		System.out.println("Enter number of lines?");
    		int lines = sc1.nextInt();
    		System.out.println("Enter number of columns?");
    		int columns = sc1.nextInt(); 
    		
    		Puzzle p = new Puzzle(lines,columns);
            
        	System.out.println("The mixed grid: ");
        	p.printGrid();
        	for(int i=0;i<=20;i++){
           		System.out.println("Choose how to move: 1-> High , 2-> Low , 3-> Left , 4-> Right");
            	Scanner sc3= new Scanner(System.in);
            	int nb = sc3.nextInt();
            	switch (nb){
        	    	case 1:
            			p.deplaceH();
                	break;
                	case 2:
                    	p.deplaceB();
                	break;
                	case 3:
                		p.deplaceG();
                	break;
                	case 4:
                    	p.deplaceD();
                	break;
                	default:
                    	System.out.println("!!!!!!!!!!!!ERROR!!!!!!!!\nYou must choose one of these numbers!");
            	}
            	p.printGrid();

        	}

    	}else if(mode == 2){
    		Scanner sc1 = new Scanner(System.in);
    		System.out.println("Enter number of lines?");
    		int lines = sc1.nextInt();
    		System.out.println("Enter number of columns?");
    		int columns = sc1.nextInt(); 
    		
    		Puzzle p = new Puzzle(lines,columns);
            
        	System.out.println("Enjoy the game !");
    		
        	UserInterface userInterface = new UserInterface(p,lines,columns);
    		Frame frame=new Frame(userInterface,lines,columns);
        }
   }
}