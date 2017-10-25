package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class ReturnCode extends ByteCode {
    public void init(ArrayList ary) { }

    public void execute(VirtualMachine vm){
        // Each time a function is entered, the PC should be pushed onto the
        // return address stack. That happens in CallCode.
        // When that function exits, the PC should be restored from the return address
        // stack. This happens here.
        vm.runStackPopFrame();
        vm.setPc(vm.returnAddrsPop());
    }

    @Override
    public String toString() {
        return "ReturnCode{}";
    }
}
