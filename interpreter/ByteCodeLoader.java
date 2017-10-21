
package interpreter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import interpreter.ByteCode.*;

public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;
    private Program program;
    private String line;
    private StringTokenizer strtok;
    private String token;

    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
    }
    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     *      Tokenize string to break it into parts.
     *      Grab correct class name for the given bytecode from CodeTable
     *      create an instance of the bytecode class name returned from code table.
     *      Parse any additional arguments for the given bytecode and send them to
     *      the newly created bytecode instance via the init function.
     */
    public Program loadCodes() {
        try {
            line = byteSource.readLine();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        strtok = new StringTokenizer(line);
        token = strtok.nextToken();
        token = CodeTable.getClassName(token);
        // TODO: Fix this
        try {
            ByteCode bc = (ByteCode)(Class.forName("interpreter."+token).newInstance());
            token = strtok.nextToken();
            // TODO: trying putting it in an array list
            ArrayList<String> toklist = new ArrayList<String>();
            toklist.add(token);
            bc.init((toklist));
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
