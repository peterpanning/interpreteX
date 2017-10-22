package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class WriteCode extends ByteCode {
    public void init(ArrayList ary){ return; }

    public void execute(VirtualMachine vm){
        System.out.println(vm.runStackPeek());
    }
}
