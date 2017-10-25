package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class CallCode extends ByteCode {
    private String destStr;
    private int destInt;

    public void init(ArrayList<String> ary){
        destStr = ary.get(0);
    };

    public void setDestStr(String str) {
        destStr = str;
    }

    public String getDestStr() {
        return destStr;
    }

    public int getDestInt() {
        return destInt;
    }

    public void setDestInt(int i) {
        destInt = i;
    }

    public void execute(VirtualMachine vm){
        // Each time a function is entered, the PC should be pushed onto the
        // return address stack.
        // When the function exits, the PC should be restored from the return address
        // stack. This happens in ReturnCode.
        vm.returnAddrsPush(vm.getPc());
        vm.setPc(destInt);
    }

    @Override
    public String toString() {
        return "CallCode{" +
                "destStr='" + destStr + '\'' +
                ", destInt=" + destInt +
                '}';
    }
}
