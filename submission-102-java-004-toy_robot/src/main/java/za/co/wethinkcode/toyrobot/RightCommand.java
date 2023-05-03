package za.co.wethinkcode.toyrobot;

public class RightCommand extends Command{
    public RightCommand(){
        super("right");
    }
    @Override
    public boolean execute(Robot target){
        switch (target.getCurrentDirection()){
            case UP:
                target.setCurrentDirection(Direction.RIGHT);
                break;
            case RIGHT:
                target.setCurrentDirection(Direction.LEFT);
                break;
            case LEFT:
                target.setCurrentDirection(Direction.UP);
                break;
        }
        target.setStatus("Turned right");
        return true;
    }
}
