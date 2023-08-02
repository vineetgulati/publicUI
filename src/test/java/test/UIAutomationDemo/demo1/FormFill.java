package test.UIAutomationDemo.demo1;

import org.testng.annotations.Test;

import test.UIAutomationDemo.FormData.FormData1;

public class FormFill {
    @Test
    public void testFormFill() throws InterruptedException {
        FormData1 obj = new FormData1();
        obj.setUp();
        obj.formFill();
        obj.tearDown();
    }
}
