package interpreter.ByteCode;

import java.util.ArrayList;

public class LabelCode extends ByteCode {
    private String label;

    public void init(ArrayList<String> ary){
        label = ary.get(0);
    };

    public String getLabel() {
        return label;
    }

    public void execute(){ };
}