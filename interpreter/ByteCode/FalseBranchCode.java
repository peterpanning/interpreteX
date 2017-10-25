package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class FalseBranchCode extends ByteCode {
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

    @Override
    public String toString() {
        return "FalseBranchCode{" +
                "destStr='" + destStr + '\'' +
                ", destInt=" + destInt +
                '}';
    }

    public void setDestInt(int i) {
        destInt = i;
    }
    public void execute(VirtualMachine vm){
        if (vm.runStackPop() == 0) {
            vm.setPc(destInt);
        }
    }
}
