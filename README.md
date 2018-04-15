README
====
1) Basic assumptions, comments:  
- there is Board.java class which represents the visible field where you can draw. You can't use coordinates which aren't
  in the board's field. This can be easily changed by modifying the BOARD_MIN_X, BOARD_MAX_X, BOARD_MIN_Y, BOARD_MAX_Y constants.
- command letter (the first letter representing the operation) is restricted to letter only by a regex COMMAND_LETTER_REGEX in CommandConstants.java
- Each drawing operation has its own package. When you want a new operation, just add new package together with class for drawing and validating.
  Additionally, add a new Enum into the DrawingEnum, to point to the new operation. Example for rectangle:
  ```
  RECTANGLE("R", new Rectangle(), new RectangleValidator())
  ```
- there are junit tests for all validators and operation drawings.
  Additional tests are written for validation of commands and parameters given in the command line.
  Due to time restrictions, I've skipped writing tests for DrawingApplication.jar and focused on more detailed testing of validation/drawing.
- validation is handled by throwing customized exceptions which are catched and displayed to the user. Only validation error is visible at a time.
- extra spaces are allowed between parameters
- Line operation - it's allowed to draw one point (x1=x2, y1=y2)
- Canvas operation - minimum allowed width is 0 and height is 1. This can be changed in the Canvas.jar.
- Rectangle operation - it's not allowed to draw one point (x1=x2, y1=y2)
- coordinates can be positive Integers, 'colour' for 'B' operation can be a single character 

2) Necessary tools:  
- JDK 1.8  
- Maven 3 (I'm using 3.5.0)  
- Application code  

3) How to run application:  

- go to command line.  
- build project and run tests:    

```
mvn clean install
```

- run application  

```
java -jar target/drawingtest.jar
```

Alternatively, you can just run the main method from DrawingApplication.java from your IDE.  