package interpreter.ByteCode;

import java.util.ArrayList;

public abstract class ByteCode {
    // Every ByteCode has a method of instantiation
    public abstract void init(ArrayList<String> ary);
    // Every ByteCode also has a method of execution.
    public abstract void execute();
}
