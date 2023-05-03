package za.co.wethinkcode.toyrobot;

import java.util.ArrayList;
import java.util.Collections;

public class ReplayCommand extends Command{
    public static int getLength;

    public ReplayCommand() {
        super("replay");
    }
    public ReplayCommand(String argument) {
        super("replay", argument);
    }

    public ReplayCommand(String argument, String args) {
        super("replay", argument, args);
    }
    @Override
    public boolean execute(Robot target) {
        int counter = 0;

        if (getLength == 1) {
            if (getArgument().isBlank()) {
                for (String cmd : target.getHistory()) {
                    Command newCommand = Command.create(cmd);
                    target.handleCommand((newCommand));
                    System.out.println(target);
                    counter++;
                }
                target.setStatus("replayed " + counter + " commands.");
            }
        } else if (getLength == 2) {
            if (getArgument().equals("reversed") && getArgs() == null) {
                Collections.reverse(target.getHistory());
                for (String cmd : target.getHistory()) {
                    Command newCommand = Command.create(cmd);
                    target.handleCommand((newCommand));
                    System.out.println(target);
                    counter++;
                }
                target.setStatus("replayed " + counter + " commands.");

            } else if (getArgument().contains("_")) {
                String[] args = getArgument().split("-");
                int n = Integer.parseInt(args[0]);
                int m = Integer.parseInt(args[1]);
                ArrayList<String> newList = new ArrayList<>();
                for (int i = target.getHistory().size() - n; i <= target.getHistory().size() - m - 1; i++) {
                    newList.add(target.getHistory().get(i));
                }
                for (String cmd : newList) {
                    Command newCommand = Command.create(cmd);
                    target.handleCommand(newCommand);
                    System.out.println(target);
                    counter++;
                }
                target.setStatus("replayed " + counter + " commands.");
            }
        }
        if (getLength == 3) {
            if (getArgs().contains("-")) {
                String[] args = getArgs().split("-");
                int n = Integer.parseInt(args[0]);
                int m = Integer.parseInt(args[1]);
                ArrayList<String> newList = new ArrayList<>();
                for (int i = target.getHistory().size() - m - 1; i >= target.getHistory().size() - n; i--) {
                    newList.add(target.getHistory().get(i));
                }
                for (String cmd : newList) {
                    Command newCommand = Command.create(cmd);
                    target.handleCommand(newCommand);
                    System.out.println(target);
                    counter++;
                }
                target.setStatus("replayed " + counter + " commands.");
            } else if (getArgs().contains(String.valueOf(Integer.parseInt(getArgs())))) {
                int n = Integer.parseInt(getArgs());
                ArrayList<String> newList = new ArrayList<>();
                for (int i = target.getHistory().size() - 1; i >= target.getHistory().size() - n; i--) {
                    newList.add(target.getHistory().get(i));
                }
                for (String cmd : newList) {
                    Command newCommand = Command.create(cmd);
                    target.handleCommand(newCommand);
                    System.out.println(target);
                    counter++;
                }
                target.setStatus("replayed " + counter + " commands.");
            }
        }

        return true;

    }
}