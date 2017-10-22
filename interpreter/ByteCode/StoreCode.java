package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class StoreCode extends ByteCode {
    private int offset;
    private String variable;

    public void init(ArrayList<String> ary){
        offset = Integer.parseInt(ary.get(0));
        variable = ary.get(1);
    }

    public void execute(VirtualMachine vm){
        // pop the value from the top of the runtime stack,
        // store it offset n from the top of the frame
        vm.store(offset);
    }
}
