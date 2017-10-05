package interpreter;

import java.util.Stack;


public class VirtualMachine {

    private RunTimeStack runStack;
    private int pc;
    private Stack returnAddrs;
    private boolean isRunning;
    private Program program;

    protected VirtualMachine(Program program) {
        this.program = program;
    }


}
