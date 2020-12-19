18024817

FROGGER game

GitHub repository for my coursework for COMP2042 Software Maintenence. It is a Frogger game that I am refactoring and changing. 
This repository consists of:
1. README.md file
2. A class dagram of the game structure (classes, interfaces, relationships and multiplicity)
3. The Javadoc source code for the Frogger game
4. A short video of the Frogger game running

# Screenshot of Game
![alt text](https://raw.githubusercontent.com/AimanNm/COMP2042_CW_AimanNM/main/screenshot.png)

This project requires a Java IDE. Import the necessary files into a project in the IDE to run.

Changelog:
1. Main.java - Changed BackgroundImage source to a working png image file.
2. Main.java - Removed redundant line of code. Commented repeat of line 39.
3. Main.java - Removed uncessesary commented log obstacles.
4. Main.java - Moved score to the left side of the screen.
5. Main.java - Added 'Score' Text to background.
6. Main.java - Added java Random utility and small amounts of randomness to some log obstacles.
7. Main.java - Removed lots of commented lines of code that seemed like the programmer was experimenting with obstacle placements. Placed new comments about some lines of code.
8. Animal.java - Removed unused 'bounds' integer.
9. Main.java - Removed unused imported javafx.scene.media.Media, javafx.scene.media.MediaPlayer, javafx.scene.text.Text, javafx.util.Duration, java.io.File, java.util.List
10. MyStage.java - Removed unused import javafx.util.Duration
11. World.java - Removed unused import javafx.scene.layout.FlowPane, javafx.scene.layout.StackPane
12. Changed music used.
13. Main.java - Exracted variables logheight and logspeed for log spawns
14. Main.java - Simplified the numbers for background.add(new End())
15. Main.java - Added a notification when the program ended.
16. Main.java - Changed turtle obstacle to a method.
17. Main.java - Added variable for goal y value.
