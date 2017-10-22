package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class BopCode extends ByteCode {
    private int lhop;
    private int rhop;
    private String op;
    public void init(ArrayList<String> ary){
        op = ary.get(0);
    }

    public void execute(VirtualMachine vm){
        rhop = vm.runStackPop();
        lhop = vm.runStackPop();
        if (op.equals("+")) {
            vm.runStackPush(lhop + rhop);
        }
        else if (op.equals("-")) {
            vm.runStackPush(lhop - rhop);
        }
        else if (op.equals("*")) {
            vm.runStackPush(lhop * rhop);
        }
        else if (op.equals("/")) {
            vm.runStackPush(lhop / rhop);
        }
        else if (op.equals("==")) {
            if (lhop == rhop) vm.runStackPush(1);
            else vm.runStackPush(0);
        }
        else if (op.equals("!=")) {
            if (lhop != rhop) vm.runStackPush(1);
            else vm.runStackPush(0);
        }
        else if (op.equals("<")) {
            if (lhop < rhop) vm.runStackPush(1);
            else vm.runStackPush(0);
        }
        else if (op.equals(">")) {
            if (lhop > rhop) vm.runStackPush(1);
            else vm.runStackPush(0);
        }
        else if (op.equals("<=")) {
            if (lhop <= rhop) vm.runStackPush(1);
            else vm.runStackPush(0);
        }
        else if (op.equals(">=")) {
            if (lhop >= rhop) vm.runStackPush(1);
            else vm.runStackPush(0);
        }
        else if (op.equals("&")) {
            if (lhop == 1 && rhop == 1) vm.runStackPush(1);
            else vm.runStackPush(0);
        }
        else if (op.equals("|")) {
            if (lhop == 1 || rhop == 1) vm.runStackPush(1);
            else vm.runStackPush(0);
        }
    }
}
