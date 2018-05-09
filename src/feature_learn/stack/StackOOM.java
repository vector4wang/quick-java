package feature_learn.stack;

public class StackOOM {

    /**
     * @param args
     */

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        // TODO Auto-generated method stub  
        StackOOM oom = new StackOOM();
        try {
            oom.stackLeak();
        } catch (Throwable err) {
            System.out.println("Stack length:" + oom.stackLength);
            throw err;
        }

    }

}  