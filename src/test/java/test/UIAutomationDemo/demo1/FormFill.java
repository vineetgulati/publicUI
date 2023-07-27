package test.UIAutomationDemo.demo1;
import test.UIAutomationDemo.FormData.FormData1;


public class FormFill 
{
    public static void main( String[] args ) throws InterruptedException
    {
        
        FormData1 obj = new FormData1();
        obj.setUp();
        obj.formFill();
        obj.tearDown();
    }
}
