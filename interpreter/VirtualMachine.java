package interpreter;

import interpreter.ByteCode.ByteCode;

import java.util.Stack;


public class VirtualMachine {

    private RunTimeStack runStack;
    private int pc;  // Program counter
    private Stack<Integer> returnAddrs;
    private boolean isRunning;
    private Program program;
    private boolean dumpOn;
    private ByteCode code;

    protected VirtualMachine(Program program) {
        this.program = program;
    }

    public void executeProgram() {
        pc = 0;
        runStack = new RunTimeStack();
        returnAddrs = new Stack<Integer>();
        isRunning = true;
        boolean dumpOn = false;

        while(isRunning){
            code = program.getCode(pc);
            code.execute(this);
            //dump();
            if (dumpOn) {
                System.out.println(code.toString());
                // TODO: Add to_string methods for all bytecode classes.
                runStack.dump();
            }
            pc++;
        }
    }
/*
    public void dump() {
        if (dumpOn) {
            System.out.println(code.toString());
            // TODO: Add to_string methods for all bytecode classes.
            runStack.dump();
        }
    }
*/
    public void setDumpOn(boolean bool) {
        dumpOn = bool;
    }

    public int runStackPop() {
        return runStack.pop();
    }

    public int runStackPeek() {
        return runStack.peek();
    }

    public void runStackPush(int i) {
        runStack.push(i);
    }

    public int returnAddrsPop() {
        return returnAddrs.pop();
    }

    public void returnAddrsPush(int i) {
        returnAddrs.push(i);
    }

    public void runStackPopFrame() {
        runStack.popFrame();
    }

    public void runStackPushFrame(int offset) {
        runStack.newFrameAt(offset);
    }

    public int getPc() { return pc; }

    public void setPc(int i) { pc = i; }

    public void toggleRunning() { isRunning = !isRunning; }

    public void store(int offset) {
        runStack.store(offset);
    }

    public void load(int offset) {
        runStack.load(offset);
    }

    public int frameSize() { return runStack.frameSize(); }

}
