package za.co.wethinkcode.toyrobot;

public class SprintCommand extends Command{
    @Override
    public boolean execute(Robot target) {
        int n = Integer.parseInt(getArgument());
        for (int i = n; i > 0; i--){
            target.handleCommand(new ForwardCommand(String.valueOf(i)));
            System.out.println(target);
        }
        return true;
    }
    public SprintCommand(String argument){
        super("sprint", argument);
    }
}
