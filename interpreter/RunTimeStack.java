package interpreter;

import java.util.ArrayList;
import java.util.Collections;
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
        // Print the runtime stack, frames separated by brackets and
        // variables within frames separated by commas

        ArrayList<Integer> frames = new ArrayList<Integer>();
        for (int i = 0; i < framePointer.size(); i++) {
            frames.add(framePointer.pop());
            Collections.reverse(frames); // Frames as an ArrayList
        }
        // push the items from frames back into the framePointer stack
        for (int i = 0; i < frames.size(); i++) {
            framePointer.push(frames.get(i));
        }
        // Use an external iterator variable to track position in frames ArrayList
        int j = 1;
        // Open with a bracket,
        if (runTimeStack.size() > 0) {
            String output = "[";
            // Then print every item in the runTimeStack
            for (int i = 0; i < runTimeStack.size(); i++) {
                output = output + runTimeStack.get(i) + ",";
                // Add in brackets where necessary
                if (frames.size() > j && i == frames.get(j)) {
                    output = output + "] [";
                    j++;
                }
            }
            // Trim closing comma
            output = output.substring(0, output.length() - 1);
            // Close with another bracket
            output = output + "]";
            System.out.println(output);
        }
    }

    public int peek() { return runTimeStack.get(runTimeStack.size() - 1); }

    public int pop() {
        // Used to pop items from the runTimeStack
        int i = 0;
        if (runTimeStack.size() != 0) {
            i = runTimeStack.get(runTimeStack.size() - 1);
            runTimeStack.remove(runTimeStack.size() - 1);
        }
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
        int frameSize = framePointer.pop();
        int rv = this.pop();
        while (runTimeStack.size() - 1 > frameSize) {
            this.pop();
        }
        this.push(rv);
    }

    public int store(int offset) {
        // used to store into variables
        runTimeStack.add(runTimeStack.size() - offset - 1, pop());
        return 0;
    }

    public int load(int offset) {
        // used to load variables onto the stack
        // loads variable which is *offset* above the frame pointer onto the top of the stack
        if (runTimeStack.size() != 0) {
            int temp = runTimeStack.get(framePointer.peek() + offset);
            push(temp);
        }
        return 0;

    }

    public void push(Integer i) {
        // used to load literals onto the stack
        runTimeStack.add(i);
    }

    public int frameSize() {
        return runTimeStack.size() - framePointer.peek();
    }
}
