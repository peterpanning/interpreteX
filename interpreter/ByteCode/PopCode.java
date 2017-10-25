package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class PopCode extends ByteCode {
    int levels;
    int frameSize;
    public void init(ArrayList<String> ary){ levels = Integer.parseInt(ary.get(0)); }

    public void execute(VirtualMachine vm){
        frameSize = vm.frameSize();
        for (int i = 0; i < levels && i < frameSize; i++) {
            vm.runStackPop();
        }
    }

    @Override
    public String toString() {
        return "PopCode{" +
                "levels=" + levels +
                ", frameSize=" + frameSize +
                '}';
    }
}
