package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class DumpCode extends ByteCode {
    public void init(ArrayList ary){
    };

    public void execute(VirtualMachine vm){
        vm.dump();
    }
}
