package interpreter;

import java.util.ArrayList;
import java.util.Stack;

public class RunTimeStack {

    private ArrayList<Integer> runTimeStack;
    private Stack<Integer> framePointer;

    public RunTimeStack() 
    {
        runTimeStack = new ArrayList<Integer>();
        framePointer = new Stack<Integer>();
        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

    public void dump() {
        System.out.println("Runtime Stack: ");
        for (int i = 0; i < runTimeStack.size(); i++) {
            System.out.println(runTimeStack.get(runTimeStack.size() - i - 1) + "\n");
        }
    }

    public int peek() { return runTimeStack.get(runTimeStack.size() - 1); }

    public int pop() {
        // Used to pop items from the runTimeStack
        int i = runTimeStack.get(runTimeStack.size() - 1);
        runTimeStack.remove(runTimeStack.size() - 1);
        return i;
    }

    public int push(int i) {
        // Used to add items to the runTimeStack
        runTimeStack.add(i);
        return i;
    }

    public void newFrameAt(int offset){
        // Adds the location of a new call frame in the runtime stack.

        // offset indicates the number of slots down from the top of RunTimeStack
        // for starting the new frame

        framePointer.push(runTimeStack.size() - offset);
    }

    public void popFrame(){
        // We pop the top frame when we return from a function; before popping, the
        // function’s return value is at the top of the stack so we’ll save the value,
        // pop the top frame and then push the return value
        int frameBottom = framePointer.pop();
        int temp = this.pop();
        while (runTimeStack.size() > frameBottom) {
            this.pop();
        }
        this.push(temp);
    }

    public int store(int offset) {
        // used to store into variables
        runTimeStack.add(runTimeStack.size() - offset, pop());
        return 0;
    }

    public int load(int offset) {
        // used to load variables onto the stack
        push(runTimeStack.get(runTimeStack.size() - offset - 1));
        return 0;
    }

    public void push(Integer i) {
        // used to load literals onto the stack
        runTimeStack.add(i);
    }
}
