package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class DumpCode extends ByteCode {
    private boolean dumpOn;
    public void init(ArrayList ary){
        if (ary.get(0) == "ON") dumpOn = true;
        else dumpOn = false;
    }

    @Override
    public String toString() {
        return "DumpCode{" +
                "dumpOn=" + dumpOn +
                '}';
    }

    public void execute(VirtualMachine vm){
        vm.setDumpOn(dumpOn);
    }
}
