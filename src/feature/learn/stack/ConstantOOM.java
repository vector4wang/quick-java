package feature.learn.stack;

import java.util.ArrayList;
import java.util.List;

public class ConstantOOM {
  
    /** 
     * @param args 
     */  
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
        List<String> list = new ArrayList<String>();
        int i=0;  
        while(true){  
            list.add(String.valueOf(i++).intern());  
        }  
    }  
  
}  