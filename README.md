# InterpreteX

This is an interpreter for the mock language X. Some code--the Interpreter and CodeTable class--was given, to facilitate speedy completion of this project. 

Command line instructions to compile and execute

To compile and execute this program, I created a new IntelliJ project with the git repository as the project root directory. I edited the build configuration to point at the local fib.x.cod or factorial.x.cod file as desired, built the project, and ran it. When testing the ouput, I set interpreter.VirtualMachine.dumpOn to True. It is set to False by default, and does not dump the runtime stack until that is changed, either manually or by a DumpCode. 

Limitations: This project does not expect zero division, so that will break the interpreter. It also only works with integer operations, no floating points. It should be able to interpret Xcode files when PopCodes are called with arguments larger than the size of the frame or runtime stack. 

Implementation details:

Starting at the project root and proceeding in the order which files and folders appear in the GitHub repository:

ByteCode:

This folder contains the ByteCode Abstract class and all of its inherited classes, from ArgsCode to WriteCode. All ByteCodes require a method of initialization, a method of execution, and a toString() method. The abstract ByteCode class therefore declared all of those and made them abstract, expecting every single subclass to implement each of those functions. 

The toString() functions for each subclass were made by IntelliJ. I don't think I changed any of them at all except for the ReadCode class, which requires a Scanner. Instead of printing out the Scanner, which is fairly uninformative and quite lengthy, that class prints out whatever input it has read in. 

The init() function of every ByteCode subclass takes in an ArrayList of Strings which are read from a file. 

The execute() function of every ByteCode typically just does what it says it does. The functions are short and sweet, and the main goal was to write them in such a way that did not break encapsulation, simply calling functions of the Virtual Machine rather than interacting directly with the RunTimeStack.

There are some special cases: CallCode, FalseBranchCode, and GoToCode all required special treatment. They would initially hold labels read in from program files, which needed to be converted to line numbers. This was the responsibility of the Program class, using the destInt field to represent the Destination of that ByteCode as an Integer. 

There is one other special ByteCode, which is DumpCode. It simply flips a switch in the VM, which, if the switch is flipped, causes the VM to print last executed ByteCode and the contents of the runtime stack after the execution of every ByteCode. Extremely useful for debugging and grading, not so useful for an actual interpreter. The flag in the VM is set to false by default for this reason. 

The ByteCodeLoader class reads in the file which the interpreter will operate on, and tells the Program class to resolve all the address labels within to line numbers. 

The CodeTable class holds a HashMap of all the ByteCodes as they appear in Xcode files and their corresponding class names, as well as a method to access that table. 

The Interpreter tells the ByteCodeLoader to load in ByteCodes from the appropriate file and then executes that Program in a Virtual Machine. 

The Program class holds the ByteCodes, and resolves their address labels to line numbers the first time it loads a new program. 

The RunTimeStack class is where most of the magic happens. It has pretty good commenting throughout so I'm not going to review every function in depth. It functions as a runtime stack for our load/store based mock language X. It has a couple of methods that I think may be redundant, but they were in the assignment spec. 

VirtualMachine is where the rest of the magic happens. The Virtual Machine provides the interface through which ByteCodes interact with the runtime stack. ByteCodes take in the VirtualMachine as an argument so that they can call its various methods, which in turn call methods of the runtime stack. The VirtualMachine has the option of printing the last executed ByteCode and the entire runtime stack if the dumpOn variable is set to true, either manually or by a DumpCode. 
