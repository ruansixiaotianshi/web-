package cn.itcast.test;

import cn.itcast.junit.Calculator;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    @Test
    public void testAdd(){
        //创建对象
        Calculator c= new Calculator();

        //调用
        int result= c.add(1,2);
        //System.out.println(result);
//        int result= c.sub(2,1);
//        System.out.println(result);
//断言
        Assert.assertEquals(3,result);
    }
    @Test
    public void testSub(){
    //创建对象
    Calculator c= new Calculator();

    //调用
    int result= c.sub(1,2);
       // System.out.println(result);
//        int result= c.sub(2,1);
//        System.out.println(result);
//断言
        Assert.assertEquals(-1,result);
}


}
