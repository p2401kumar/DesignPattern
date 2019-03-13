package com.samsung;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

class ApplicationData {
    double value = 0;
}

public class Main2 {

    public static void main(String[] args) {

        // Load all the classes using reflection
        File folder = new File("out/production/DP/com/samsung");
        String[] files = folder.list();

        for (String file: files) {
            try {
                Class.forName("com.samsung." + file.split("\\.")[0]);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        // -------------------------------------

        ApplicationData applicationData = new ApplicationData();

        while(true){
            //Display the aplication data
            System.out.println(applicationData.value);

            //Take the input from the user: command commandValue
            //Scanner is extensible as it can work with different
            //Stream object, here streams are varying
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();

            //process the command on application data using commandValue
            String[] items = line.split(" ");

            //for each - based on Iterator Design pattern
            for(Command command: Command.commands){
                command.process(items[0], Double.parseDouble(items[1]), applicationData);
            }
        }
    }
}

//Abstraction
abstract class Command{

    // it should not become part of any sub-class object
    static ArrayList<Command> commands = new ArrayList<>();
    Command(/*com.samsung.Command this = ref. of sub-class object */){
        commands.add(this);
    }

    abstract void process(String commandName, double commandValue, ApplicationData applicationData);
}

//Implementations: Commands are varying, hence encapsulate them
class AddCommand extends Command{

    AddCommand(/* com.samsung.AddCommand this = ref. of object */){
        super(/*value of this*/);
    }

    static { new AddCommand(); }

    @Override
    public void process(String commandName, double commandValue, ApplicationData applicationData) {
        // code to perform specific work
        if(commandName.equalsIgnoreCase("add"))
            applicationData.value += commandValue;
    }
}
class MulCommand extends Command{

    MulCommand(/*com.samsung.MulCommand this = ref. of object*/){
        super(/*value of this*/);
    }

    static { new MulCommand(); }

    @Override
    public void process(String commandName, double commandValue, ApplicationData applicationData) {
        // code to perform specific work
        if(commandName.equalsIgnoreCase("mul"))
            applicationData.value *= commandValue;
    }
}

class asjbaus extends Command{
    static {new asjbaus();}

    asjbaus(){
        super();
    }

    @Override
    void process(String commandName, double commandValue, ApplicationData applicationData) {
        if(commandName.equalsIgnoreCase("sub"))
            applicationData.value -= commandValue;
    }

}

// try to discover what is varying
// Encapsulate it - Hide Implementation behind abstraction FROM CLIENT
// Implementation - Class whose object we create to perform specific work
// Abstraction - Interface that decide what Implementation should do
// Client - Can use Abstraction to reach implementation behind
// Generally we should hide Implementation behind Abstraction when
// Implementation varies
// Client becomes extensible when we VARYING implementation from it using
// Abstraction

// when new Implementations are developed, client should not be required
// to be changed. This is OCP: Open Close Principle

// Robert Martin (SOLID)
// S
// O - OCP - Open Close System
// L
// I
// D - Dependency Inversion

// OOP = SOLID Principles + DP(Design Pattern);
// Encapsulation: Hiding VARYING implementations behind abstraction from Client so client becomes extensible

