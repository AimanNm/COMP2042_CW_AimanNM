package p4_group_8_repo;

import java.awt.Toolkit;
import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Main extends Application {
	AnimationTimer timer;
	MyStage background;
	Animal animal;
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
	    background = new MyStage();
	    Scene scene  = new Scene(background,600,800);
	    Random dice = new Random();
	    int logheight = 150; //Height of log
	    int enda = 96;
	    float logspeed = 0.75F; //Speed of some of the logs
	    
	    //Sets background image.
		BackgroundImage froggerback = new BackgroundImage("file:src/p4_group_8_repo/frogbackground1.png");
	    
		background.add(froggerback);
		
		//Spawns the logs in the water
		background.add(new Log("file:src/p4_group_8_repo/log3.png", logheight, 0, 166, logspeed));
		background.add(new Log("file:src/p4_group_8_repo/log3.png", logheight, 150+dice.nextInt(100), 166, logspeed));
		background.add(new Log("file:src/p4_group_8_repo/log3.png", logheight, 400+dice.nextInt(100), 166, logspeed)); //Added a small amount of randomness
		background.add(new Log("file:src/p4_group_8_repo/logs.png", 2*logheight, 0, 276, -2));
		background.add(new Log("file:src/p4_group_8_repo/logs.png", 2*logheight, 400, 276, -2));
		background.add(new Log("file:src/p4_group_8_repo/log3.png", logheight, 50, 329, logspeed));
		background.add(new Log("file:src/p4_group_8_repo/log3.png", logheight, 270, 329, logspeed));
		background.add(new Log("file:src/p4_group_8_repo/log3.png", logheight, 490, 329, logspeed));
		
		//Spawns the turtles that you can walk on when in the water.
		turtleNum(); //The turtles that do not submerge
		background.add(new WetTurtle(800, 376, -1, 130, 130)); //Wet turtle in a different lane
		wetTurtleNum(); //The turtles that submerge
		
		//End areas where the frog is trying to reach.
		background.add(new End(13,enda));
		background.add(new End(141,enda));
		background.add(new End(269,enda));
		background.add(new End(396,enda));
		background.add(new End(528,enda));
		
		//For the frog protagonist.
		animal = new Animal("file:src/p4_group_8_repo/froggerUp.png");
		background.add(animal);
		
		//Adds the truck and car obstacles to the road.
		background.add(new Obstacle("file:src/p4_group_8_repo/truck1"+"Right.png", 0, 649, 1, 120, 120));
		background.add(new Obstacle("file:src/p4_group_8_repo/truck1"+"Right.png", 300, 649, 1, 120, 120));
		background.add(new Obstacle("file:src/p4_group_8_repo/truck1"+"Right.png", 600, 649, 1, 120, 120));
		background.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 100, 597, -1, 50, 50));
		background.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 250, 597, -1, 50, 50));
		background.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 400, 597, -1, 50, 50));
		background.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 550, 597, -1, 50, 50));
		background.add(new Obstacle("file:src/p4_group_8_repo/truck2Right.png", 0, 540, 1, 200, 200));
		background.add(new Obstacle("file:src/p4_group_8_repo/truck2Right.png", 500, 540, 1, 200, 200));
		background.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 500, 490, -5, 50, 50));
		
		//Adds initial '0' to the score.
		background.add(new Digit(0, 30, 80, 25));
		
		
		background.start();
		primaryStage.setScene(scene);
		primaryStage.show();
		start();  
	}
	public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	if (animal.changeScore()) {
            		setNumber(animal.getPoints());
            	}
            	if (animal.getStop()) {
            		System.out.print("STOPPED:");
            		background.stopMusic();
            		stop();
            		background.stop();
            		Alert alert = new Alert(AlertType.INFORMATION);
            		Toolkit.getDefaultToolkit().beep();
            		alert.setTitle("Congratulations, You Have Finished The Game!");
            		alert.setHeaderText("Your High Score: "+animal.getPoints()+"!");
            		alert.setContentText("Highest Possible Score: 800");
            		alert.show();
            	}
            }
        };
    }
	//Start and Music
	public void start() {
		background.playMusic();
    	createTimer();
        timer.start();
    }

    public void turtleNum() {
    	for (int i=300; i<501; i+=200) {
    		background.add(new Turtle(i, 376, -1, 130, 130));
    	}
    }
    
    public void wetTurtleNum() {
    	for (int i=200; i<601; i+=200) {
    		background.add(new Turtle(i, 217, -1, 130, 130));
    	}
    }
	public void stop() {
        timer.stop();
    }
    //Update score
    public void setNumber(int n) {
    	int shift = 0;
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  background.add(new Digit(k, 30, 80 - shift, 25));
    		  shift+=30;
    		}
    }
}
