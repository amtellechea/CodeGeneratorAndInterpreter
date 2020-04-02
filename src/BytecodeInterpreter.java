import java.util.ArrayList;

public class BytecodeInterpreter {
    ArrayList<Integer> bytecode = new ArrayList<Integer>();
    ArrayList<Integer> memory = new ArrayList<Integer>();
    private static int accumulator = 0;
    private int memorySize;
    public static final int LOAD = 0;
    public static final int LOADI = 1;
    public static final int STORE = 2;
    int index = 0;

    public BytecodeInterpreter(int m) {
        this.memorySize = m;
        this.bytecode = bytecode;
        this.memory = memory;
        for (int i = 0; i <= 10; i++) {
            memory.add(0);
        }
    }

    public ArrayList<Integer> generate(int operation, int operand) {
        bytecode.add(operation);
        bytecode.add(operand);
        return bytecode;
    }

    public ArrayList<Integer> run() {
        while (index <= bytecode.size() - 1) {
            if (bytecode.get(index) == LOAD) {
                load();
            }
            if (bytecode.get(index) == LOADI) {
                loadi();
            }
            if (bytecode.get(index) == STORE) {
                store();
            }
            index += 2;
        }
        return memory;
    }

    private int load() {
        accumulator += memory.get(bytecode.get(index + 1));
        return accumulator;
    }

    private int loadi() {
        accumulator += bytecode.get(index + 1);
        return accumulator;
    }

    private int store() {
        if (bytecode.get(index + 1) >= 0 && bytecode.get(index + 1) < memorySize - 1) {
            memory.set(bytecode.get(index + 1), accumulator);
            accumulator = 0;
        } else {
            System.out.println("Run-time error: Address out of bounds");
        }
        return accumulator;
    }
}
