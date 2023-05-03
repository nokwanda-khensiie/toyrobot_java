package za.co.wethinkcode.toyrobot;


import java.util.ArrayList;

public class Robot {
    private final Position TOP_LEFT = new Position(-200,100);
    private final Position BOTTOM_RIGHT = new Position(100,-200);

    public static final Position CENTRE = new Position(0,0);

    private Position position;
    private Direction currentDirection;
    private String status;
    private final String name;
    private final ArrayList<String> history;

    public Robot(String name) {
        this.name = name;
        this.status = "Ready";
        this.position = CENTRE;
        this.currentDirection = Direction.UP;
        this.history = new ArrayList<>();
    }

    public String getStatus() {
        return this.status;
    }

    public ArrayList<String> getHistory(){
        return this.history;
    }

    public Direction getCurrentDirection() {
        return this.currentDirection;
    }

    public boolean handleCommand(Command command) {
        return command.execute(this);
    }

    public boolean updatePosition(int nrSteps){
        int newX = this.position.getX();
        int newY = this.position.getY();

        if (Direction.UP.equals(this.currentDirection)) {
            newY = newY + nrSteps;
        }if (Direction.RIGHT.equals(this.currentDirection)) {
            newX = newX + nrSteps;
        }if (Direction.DOWN.equals(this.currentDirection)) {
            newY = newY - nrSteps;
        }if (Direction.LEFT.equals(this.currentDirection)) {
            newX = newX - nrSteps;
        }

        Position newPosition = new Position(newX, newY);
        if (newPosition.isIn(TOP_LEFT,BOTTOM_RIGHT)){
            this.position = newPosition;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
       return "[" + this.position.getX() + "," + this.position.getY() + "] "
               + this.name + "> " + this.status;
    }

    public Position getPosition() {
        return this.position;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setHistory(String command){
        this.history.add(command);
    }

    public String getName() {
        return name;
    }

    public void  setCurrentDirection(Direction currentDirection){
        this.currentDirection = currentDirection;
    }
}