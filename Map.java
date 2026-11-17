import java.util.Scanner;
import java.io.File;
import java.awt.image.BufferedImage;

public class Map {
    private Scene[] scenes;
    private int maxRows;
    private int maxCols;
    private int currentRow;
    private int currentCol;

    public Map(String mapFile){
        
        // create a spot in memory to create the Scanner
        Scanner fileInput = null;
        // could be errors, try to load the file to read
        try{
            fileInput = new Scanner(new File(mapFile));
        } catch(Exception e){ // if an error happens
            // print the error
            e.printStackTrace();
        }

        // read in the number of rows and columns
        this.maxRows = fileInput.nextInt();
        // move to next line
        fileInput.nextLine();
        this.maxCols = fileInput.nextInt();
        fileInput.nextLine();

        // read in my current location
        this.currentRow = fileInput.nextInt();
        fileInput.nextLine();
        this.currentCol = fileInput.nextInt();
        fileInput.nextLine();

        // initialize the scene array
        this.scenes = new Scene[this.maxRows*this.maxCols];

        // read in each scene and put it in the array
        int index = 0;
        // while there is still something to scan
        while(fileInput.hasNext()){
            // row and column of the scene
            int row = fileInput.nextInt();
            int col = fileInput.nextInt();

            // read in picture filename
            String picFile = fileInput.next();

            // movement directions
            boolean north = fileInput.nextBoolean();
            boolean east = fileInput.nextBoolean();
            boolean south = fileInput.nextBoolean();
            boolean west = fileInput.nextBoolean();

            // any description? and move down
            String desc = fileInput.nextLine();

            // make the scene
            Scene scene = new Scene(row, col, picFile, 
                north, east, south, west, desc);

            // put the scene into the array
            this.scenes[index] = scene;
            // move the index up
            index++;
        }

    }

    // find a specific scene
    private Scene findScene(int row, int col){
        // go through each Scene
        for(int i = 0; i < this.scenes.length; i++){
            // grab the current scene
            Scene s = this.scenes[i];
            // if we have matching rows and cols
            if(s.getRow() == row && s.getCol() == col){
                // found it!
                return s;
            }
        }
        // no match found
        return null;
    }

    public BufferedImage getImage() {
        // find the scene we are on
        Scene s = findScene(this.currentRow, this.currentCol);
        // return the image
        return s.getImage();
    }

    public void moveDown() {
      // find current scene
      Scene s = findScene(currentRow, currentCol);
      // can we move down?
      if(s.canMoveDown()){
          // move to the down
          this.currentRow++;
      }
    }

    public void moveLeft() {
       // find current scene
       Scene s = findScene(currentRow, currentCol);
       // can we move left?
       if(s.canMoveLeft()){
           // move to the left
           this.currentCol--;
       }
    }

    public void moveRight() {
        // find current scene
        Scene s = findScene(currentRow, currentCol);
        // can we move right?
        if(s.canMoveRight()){
            // move to the right
            this.currentCol++;
        }
    }

    public void moveUp() {
        // find current scene
      Scene s = findScene(currentRow, currentCol);
      // can we move up?
      if(s.canMoveUp()){
          // move to the up
          this.currentRow--;
      }
    }

    public String getDescription(){
      // find current scene
      Scene s = findScene(currentRow, currentCol);
      // return the description
      return s.getDescription();
    }
}
