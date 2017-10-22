package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;
import java.util.Scanner;

public class ReadCode extends ByteCode {
    private int input;
    private Scanner scan;
    public void init(ArrayList ary){
        scan = new Scanner(System.in);
    }

    public void execute(VirtualMachine vm){
        System.out.println("Please enter the integer you would like to add to the stack: ");
        input = scan.nextInt();
        vm.runStackPush(input);
    }
}
