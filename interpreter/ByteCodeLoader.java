
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
        program = new Program();
        ArrayList<String> tokList = new ArrayList<String>();

        try {
            line = byteSource.readLine();
            while (line != null) {
                strtok = new StringTokenizer(line);
                token = strtok.nextToken();
                token = CodeTable.getClassName(token);
                try {
                    ByteCode bc = (ByteCode) (Class.forName("interpreter.ByteCode." + token).newInstance());
                    while (strtok.hasMoreTokens()) {
                        tokList.add(strtok.nextToken());
                    }
                    bc.init(tokList);
                    program.addByteCode(bc);
                } catch (Exception e) {
                    System.out.println("ByteCodeLoader Exception: " + e);
                    e.printStackTrace();
                }
                line = byteSource.readLine();
                tokList.clear();
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        program.resolveAddrs(program);
        return program;
    }
}
