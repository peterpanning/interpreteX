package interpreter;

import interpreter.ByteCode.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Program {

    private ArrayList<ByteCode> program;
    private HashMap<String, Integer> labelAddrs = new HashMap<String, Integer>();

    public Program() {
        program = new ArrayList<ByteCode>();
    }

    protected ByteCode getCode(int pc) {
        return this.program.get(pc);
    }

    public int getSize() {
        return this.program.size();
    }

    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter(PC)
     * HINT: make note what type of data-stucture bytecodes are stored in.
     *
     * @param program Program object that holds a list of ByteCodes
     */
    public void resolveAddrs(Program program) {
        // go through the program and find all the labels. add their string
        // and the iteration during which we found them to a hashmap.
        for (int i = 0; i < program.getSize(); i++)  {
            if (program.getCode(i) instanceof LabelCode) {
                labelAddrs.put(((LabelCode) program.getCode(i)).getLabel(), i);
            }
        }
        // then, go through the program and look for all FalseBranch, GoTo, and Call
        // ByteCodes and set their destination strings to the corresponding label
        // strings from the program's labelAddrs HashMap.
        for (int i = 0; i < program.getSize(); i++) {
            if (program.getCode(i) instanceof FalseBranchCode) {
                // get the bytecode's address as a string, look it up in the hashmap,
                // get the address as an integer, save it to the bytecode

                ((FalseBranchCode) program.getCode(i)).setDestInt(
                        program.getAddrs().get( ((FalseBranchCode) program.getCode(i)).getDestStr()));
            }
            else if (program.getCode(i) instanceof GotoCode) {
                ((GotoCode) program.getCode(i)).setDestInt(
                        program.getAddrs().get( ((GotoCode) program.getCode(i)).getDestStr()));
            }
            else if (program.getCode(i) instanceof CallCode) {
                ((CallCode) program.getCode(i)).setDestInt(
                        program.getAddrs().get( ((CallCode) program.getCode(i)).getDestStr()));
            }
        }
    }
    public HashMap<String, Integer> getAddrs() {
        return labelAddrs;
    }

    public void addByteCode(ByteCode bc) { program.add(bc); }
}
