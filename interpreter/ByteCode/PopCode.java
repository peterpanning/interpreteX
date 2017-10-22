package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class PopCode extends ByteCode {
    int levels;
    public void init(ArrayList<String> ary){
        levels = Integer.parseInt(ary.get(0));
    }

    public void execute(VirtualMachine vm){
        for (int i = 0; i < levels; i++) {
            vm.runStackPop();
        }
    }
}
