package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LitCode extends ByteCode {
    private int val;
    private String var;
    public void init(ArrayList<String> ary){
        val = Integer.parseInt(ary.get(0));
        var = ary.get(1);
    }

    public void execute(VirtualMachine vm){
        vm.runStackPush(val);
        vm.load(0);
    }
}
