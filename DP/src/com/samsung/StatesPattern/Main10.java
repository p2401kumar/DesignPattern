package com.samsung.StatesPattern;

interface State {
    void close();
}

class NewFileState implements State {

    NotepadWindow nw;

    public NewFileState(NotepadWindow notepadWindow) {
        this.nw = notepadWindow;
    }

    @Override
    public void close() {
        // We should write code which applies to Untitled file
        // if new file is created and data is saved in it
        // switch to Existing File state
        nw.changeToExistingFileState();
    }
}

class ExistingFileState implements State {

    private final NotepadWindow nw;

    public ExistingFileState(NotepadWindow notepadWindow) {
        this.nw = notepadWindow;
    }

    @Override
    public void close() {
        // We should write code which applies to Existing file

    }
}

class NotepadWindow { //extends JFrame

    private NewFileState nfs;
    private ExistingFileState efs;
    private State currentState;

    public NotepadWindow(/*NotepadWindow this*/) {
        nfs = new NewFileState(this);
        efs = new ExistingFileState(this);
        currentState = nfs;
    }

    public void changeToExistingFileState() {
        currentState = efs;
    }

    public void changeToNewFileState() {
        currentState = nfs;
    }

    public void show() {
        // register the closeHandler() to be called on click of close button
        // call setvisible(true); // starts Event Dispatch Thread
    }

    public void newHandler() {

    }

    public void Openhandler() {

    }

    public void saveHandler() {

    }

    public void closeHandler() {
        currentState.close(); // late bound call {runtime - polymorphism}
    }
}

public class Main10 {

    public static void main(String[] args) {
        NotepadWindow nw = new NotepadWindow();
        nw.show();
    }
}
