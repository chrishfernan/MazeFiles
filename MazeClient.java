//The purpose of this code is to create a maze based off a read in file
//Author Chris Fernandez
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.canvas.*;
import javafx.scene.layout.*;
import javafx.animation.*;
import javafx.application.*;
import javafx.geometry.*;
import javafx.stage.*;
import java.util.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.io.*;
import java.util.*;
import java.lang.*;

public class MazeClient extends Application
{

   public void start(Stage stage) //The stage that everything is drawn on
   {
      FlowPane root = new FlowPane(); //Create a flow pane
      
      MazeClass maze = new MazeClass("MazeFile.txt"); //Constructor for adding the maze file
      
      root.getChildren().add(maze);
      
      
      Scene scene = new Scene(root, 525, 525); //The scene the pane is created in
      stage.setTitle("You aMAZE me");
      stage.setScene(scene);
      stage.show();
     
      maze.requestFocus();

    }

   
   public static void main(String[] args)
   {
      launch(args);
   }
}