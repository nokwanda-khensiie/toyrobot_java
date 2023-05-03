package za.co.wethinkcode.toyrobot;

public class LeftCommand extends Command{
    public LeftCommand() {
        super("left");
    }
    @Override
    public boolean execute(Robot target){
        switch (target.getCurrentDirection()){
            case UP:
                target.setCurrentDirection(Direction.LEFT);
                break;
            case LEFT:
                target.setCurrentDirection(Direction.DOWN);
                break;
            case DOWN:
                target.setCurrentDirection(Direction.RIGHT);
                break;
            case RIGHT:
                target.setCurrentDirection(Direction.UP);
                break;
        }
        target.setStatus("Turned left");
        return true;
    }

}
