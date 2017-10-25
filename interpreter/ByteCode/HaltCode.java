package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class HaltCode extends ByteCode {
    public void init(ArrayList<String> ary){ }

    @Override
    public String toString() {
        return "HaltCode{}";
    }

    public void execute(VirtualMachine vm){
        vm.toggleRunning();
    }
}
