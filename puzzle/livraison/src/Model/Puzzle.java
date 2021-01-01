package src.Model;

import java.util.Random;
import src.VC.Puzzlelistener;

/** Classe represents a PuzzleListener.
 * @author Arthur, Kamel, Lahcene, Maxence
 */
public class Puzzle extends Puzzlelistener{

  /** Attributs for our class. */
  private int[][] grid;
  private int x;
  private int y;
  private int moveNb;

  /**@param x represents lines.
   * @param y represents columns.
   */
  public Puzzle(int x, int y){
    this.x = x;
    this.y = y;
    this.grid = new int[x][y];
    this.setGrid();
    this.randomiseGrid();
    this.moveNb = 0;
  }

  /** Return the grid. */
  public int[][] getGrid(){
    return this.grid;
  }

  /** Responsible set of the grid. */
  private void setGrid(){
    int x = this.grid.length;
    int y = this.grid[0].length;

    int value = 1;
    for(int ord=0; ord<y; ord++){
      for(int abs=0; abs<x; abs++){
        if(value == x*y){
          value = 0;
        }
        this.grid[abs][ord] = value;
        value ++;
      }
    }
  }

  /** Responsible for mixing the grid. */
  private void randomiseGrid(){
    Random rand = new Random();
    int randomLevel = 0;

    while(randomLevel <= 1000){
      if(this.move(rand.nextInt(this.grid.length), rand.nextInt(this.grid[0].length))){
       fireChangement();
        randomLevel ++;
      }
    }

  }

  /** Responsible for printing the grid. */
  public void printGrid(){
    int x = this.grid.length;
    int y = this.grid[0].length;
    for(int abs=0; abs<y; abs++){
      for(int ord=0; ord<x; ord++){
        System.out.print(this.grid[ord][abs]);
        System.out.print(" ");
      }
      System.out.println("");
    }
    System.out.println("==========================");
  }

  /** Responsible of moving the box. */
  public boolean move(int coordX, int coordY){
    int x = 0;
    int y = 0;

    /** Return false if out of grid. */
    if(coordX < 0 || coordY < 0 || coordX >= this.grid.length || coordY >= this.grid[0].length){
      return false;
    }

    /** Get coord of the empty case. */
    for(int ord=0; ord<this.grid[0].length; ord++){
      for(int abs=0; abs<this.grid.length; abs++){
        if(grid[abs][ord] == 0){
          x = abs;
          y = ord;
        }
      }
    }

    if(Math.abs(coordX - x) + Math.abs(coordY - y) == 1){
      int c;
      c = this.grid[coordX][coordY];
      this.grid[coordX][coordY] = this.grid[x][y];
      this.grid[x][y] = c;
      fireChangement();
      return true;
    }
    return false;
  }

  /** Responsible for checking if the box is empty. */
  public int casevideX(){
    int i = 0;
     for(int ord=0; ord<x; ord++){
      for(int abs=0; abs<y; abs++){
        if(grid[ord][abs] == 0){
          i = abs;
        }
      }
    }
    return i;
  }

  public int casevideY(){
    int j = 0;
     for(int ord=0; ord<x; ord++){
      for(int abs=0; abs<y; abs++){
        if(grid[ord][abs] == 0){
          j = ord;
        }
      }
    }
    return j;
  }

  /** Moving to High. */
  public void deplaceH(){
    int c;
    int a = casevideY();
    int b = casevideX();
    System.out.println(a+""+b);
    System.out.println(grid[a][b]);
    if (a>=0 && b-1>=0 && a<x && b-1<y) {
      c = grid[a][b];
      grid[a][b] = grid[a][b-1];
      grid[a][b-1] = c;
    }
  }

  /** Moving to Down. */
  public void deplaceB(){
    int c;
    int a = casevideY();
    int b = casevideX();
    System.out.println(a+""+b);
    System.out.println(grid[a][b]);
    if (a>=0 && b+1>=0 && a<x && b+1<y) {
      c = grid[a][b];
      grid[a][b] = grid[a][b+1];
      grid[a][b+1] = c;
    }
  }

  /** Moving to Left. */
  public void deplaceG(){
    int c;
    int a = casevideY();
    int b = casevideX();
    System.out.println(a+""+b);
    System.out.println(grid[a][b]);
    if (a-1>=0 && b>=0 && a-1<x && b<y) {
      c = grid[a][b];
      grid[a][b] = grid[a-1][b];
      grid[a-1][b] = c;
    }
  }
  /** Moving to Right. */
  public void deplaceD(){
    int c;
    int a = casevideY();
    int b = casevideX();
    System.out.println(a+""+b);
    System.out.println(grid[a][b]);
    if (a+1>=0 && b>=0 && a+1<x && b<y) {
      c = grid[a][b];
      grid[a][b] = grid[a+1][b];
      grid[a+1][b] = c;
    }
  }
}
