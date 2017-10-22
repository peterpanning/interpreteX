package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LoadCode extends ByteCode {
    private int offset;
    private String variable;
    public void init(ArrayList<String> ary){
        offset = Integer.parseInt(ary.get(0));
        variable = ary.get(1);
    }

    public void execute(VirtualMachine vm){
        vm.load(offset);
    }
}
