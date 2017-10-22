package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class ArgsCode extends ByteCode {
    private int args;

    public void init(ArrayList<String> ary){
        args = Integer.parseInt(ary.get(0));
    }

    public void execute(VirtualMachine vm){
        vm.runStackPushFrame(args);
    }
}
