#### ThreadExample 字节码
```bash
public class feature_learn.thread.base.ThreadExample {
  public feature_learn.thread.base.ThreadExample();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
       3: new           #3                  // class java/lang/StringBuilder
       6: dup
       7: invokespecial #4                  // Method java/lang/StringBuilder."<init>":()V
      10: invokestatic  #5                  // Method java/lang/Thread.currentThread:()Ljava/lang/Thread;
      13: invokevirtual #6                  // Method java/lang/Thread.getName:()Ljava/lang/String;
      16: invokevirtual #7                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      19: ldc           #8                  // String  主程序执行第一句代码
      21: invokevirtual #7                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      24: invokevirtual #9                  // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
      27: invokevirtual #10                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      30: new           #11                 // class java/lang/Thread
      33: dup
      34: new           #12                 // class feature_learn/thread/base/ThreadExample$1
      37: dup
      38: invokespecial #13                 // Method feature_learn/thread/base/ThreadExample$1."<init>":()V
      41: invokespecial #14                 // Method java/lang/Thread."<init>":(Ljava/lang/Runnable;)V
      44: invokevirtual #15                 // Method java/lang/Thread.start:()V
      47: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
      50: new           #3                  // class java/lang/StringBuilder
      53: dup
      54: invokespecial #4                  // Method java/lang/StringBuilder."<init>":()V
      57: invokestatic  #5                  // Method java/lang/Thread.currentThread:()Ljava/lang/Thread;
      60: invokevirtual #6                  // Method java/lang/Thread.getName:()Ljava/lang/String;
      63: invokevirtual #7                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      66: ldc           #16                 // String  主程序执行第二部
      68: invokevirtual #7                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      71: invokevirtual #9                  // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
      74: invokevirtual #10                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      77: return
}

```
- getstatic: getstatic gets a static fields e.g. System.out is a static field of System so if you write
- invokestatic：调用静态方法
- invokespecial：调用私有实例方法
- invokevirtual：调用实例方法
- invokeinterface：调用接口方法 
- invokedynamic：调用动态方法
- ldc: (load constant)int、float或String型常量从常量池推送至栈顶
- dup: 
