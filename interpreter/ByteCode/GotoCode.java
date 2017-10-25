package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class GotoCode extends ByteCode {
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

    @Override
    public String toString() {
        return "GotoCode{" +
                "destStr='" + destStr + '\'' +
                ", destInt=" + destInt +
                '}';
    }

    public int getDestInt() {
        return destInt;
    }

    public void setDestInt(int i) {
        destInt = i;
    }

    public void execute(VirtualMachine vm){
        vm.setPc(destInt);
    }
}
