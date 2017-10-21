package interpreter.ByteCode;

import java.util.ArrayList;

public class GoToCode extends ByteCode {
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

    public void execute(){ };
}
