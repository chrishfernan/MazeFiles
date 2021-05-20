//The purpose of this code is to create a maze based off a read in file
//Author Chris Fernandez
import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;
import javafx.application.*;
import javafx.event.*;
import javafx.stage.*;
import javafx.scene.canvas.*;
import javafx.scene.paint.*;
import javafx.scene.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.animation.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import java.net.*;
import javafx.geometry.*;
import javafx.scene.shape.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;


public class MazeClass extends Canvas
{

   String fileName;
   int mazeArr[][] = new int[21][21]; 
   GraphicsContext gc = getGraphicsContext2D();
   
   int playerX;
   int playerY;
      
   public MazeClass(String fileName) //The canvas class that takes in file 
   {
      this.fileName = fileName;
      setOnKeyPressed(new KeyListenerDown());

      try
      {
         Scanner fileIn = new Scanner(new File(fileName));      
    
          for(int j = 0; j < 21; j++) //For loop to create the board setup
          {   
             for(int i = 0; i < 21; i++)
             {
               int num = fileIn.nextInt();
               mazeArr[i][j] = num;
             }	
          }
      }
       
      catch(FileNotFoundException e)
      {
         System.out.println("File not found");
      }

      setWidth(525);
      setHeight(525);
      GraphicsContext gc = getGraphicsContext2D();
      draw(gc);
          
   }
   
   public void draw(GraphicsContext gc) //Draw class to set up the canvas and draw the shapes with colors etc...
   {

      for(int row = 0; row < mazeArr.length; row++)
      {
         for(int col = 0; col < mazeArr[0].length; col++)
         {
               switch(mazeArr[row][col])
               {
                  case 0:
                  
                     if(mazeArr[row][col] == 0)
                     {
                        gc.setFill(Color.WHITE);
                        
                        if(col == 0)
                        {
                           gc.setFill(Color.CYAN);
                           playerX = row*25;
                           playerY = col*25;
                        }
                     }                     
                     break;
                     
                  case 1:
                  
                     gc.setFill(Color.BLACK);
                     break;
                     
               }
               gc.fillRect(row*25, col*25, 25, 25); //Creates the inital position of the player automatically 
         }
      }
   }
   
   public class KeyListenerDown implements EventHandler<KeyEvent>  //The class to pause with A and play with S
   {
      public void handle(KeyEvent event) 
      {
         gc.clearRect(playerX, playerY, 25, 25);
         
         if (event.getCode() == KeyCode.UP)  //Move player up
         {
            if(playerY == 0)
            {
            }
            
            else if(mazeArr[playerX/25][(playerY/25)-(1)] == 0) //If there is a wall above, dont move   
               playerY = playerY - 25; //Move up          
         }
        
         else if (event.getCode() == KeyCode.DOWN) //Move player down
         {
            if(playerY == 500)
            {
            }

            else if(mazeArr[playerX/25][(playerY/25)+(1)] == 0) //If there is a wall below, dont move
               playerY = playerY + 25; //Move down
         } 
         
         else if (event.getCode() == KeyCode.LEFT) //Move player left
         {
            if(playerX == 0)
            {
            }

            else if(mazeArr[(playerX/25)-(1)][playerY/25] == 0) //If there is a wall on the right, dont move
               playerX = playerX - 25; //Move right
         } 
         
         else if (event.getCode() == KeyCode.RIGHT) //Move player right
         {
            if(playerX == 500)
               {
               }
               
            else if(mazeArr[(playerX/25)+(1)][playerY/25] == 0) //If there is a wall on the left, dont move
               playerX = playerX + 25; //Move left
         }
     
         gc.setFill(Color.CYAN);
         gc.fillRect(playerX, playerY, 25, 25); //The drawn position of the player
         
                                          
         if(playerY == 500) //Once player reaches Y 500, the game ends and you win
         {
            gc.clearRect(0, 0, 525, 525);            
            System.out.println("You Win!");
         }
      }
   }
}
