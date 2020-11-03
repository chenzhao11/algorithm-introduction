import java.util.Arrays;

/**
 * @ClassName Test.java
 * @author zhao
 * @version 1.0.0
 * @Description test
 * @createTime 2020年11月03日 20:20:00
 */

public class Test {
    public  static void main(String[] args){
        MaxPriorityQueue maxQueue=new MaxPriorityQueue();
        maxQueue.insert(100);
        maxQueue.insert(1);
        maxQueue.insert(60);
        maxQueue.insert(12154);
        System.out.println("should be 12154,actually is:  "+maxQueue.max());
        maxQueue.extractMax();
        System.out.println("new max after extract should be 100,  actually is:   "+maxQueue.max());
        maxQueue.changeKeyValue(0,9999999);
        System.out.println("修改为999999  "+maxQueue.max());

    }
}
