package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class HaltCode extends ByteCode {
    public void init(ArrayList<String> ary){ }

    public void execute(VirtualMachine vm){
        vm.toggleRunning();
    }
}
