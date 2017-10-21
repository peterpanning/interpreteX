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
            System.out.println(runTimeStack.get(runTimeStack.size() - i) + "\n");
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
        // offset indicates the number of slots down from the top of RunTimeStack
        // for starting the new frame

        // Add the current size of the RunTimeStack, minus the offset, to the
        // top of the framePointer stack
        framePointer.push(runTimeStack.size() - offset);
    };

    public void popFrame(){
        // We pop the top frame when we return from a function; before popping, the
        // function’s return value is at the top of the stack so we’ll save the value,
        // pop the top frame and then push the return value
        // TODO: If frames and return values are getting fucked up, it might be happening here
        int offset = framePointer.pop();
        int temp = this.pop();
        for (int i = 0; i < offset; i++){
            this.pop();
        }
        this.push(temp);
    }

    public int store(int offset) {
        // used to store into variables
        return 0;
    };

    public int load(int offset) {
        // used to load variables onto the stack
        return 0;
    };

    public Integer push(Integer i ) {
        // used to load literals onto the stack
        return 0;
    };


}
