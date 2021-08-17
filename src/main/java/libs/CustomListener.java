package libs;

import io.qameta.allure.Attachment;
import org.testng.ITestListener;
import org.testng.TestListenerAdapter;

public class CustomListener extends TestListenerAdapter {
    public CustomListener() {
    }

    public void onTestStart(ITestListener result){

    }

    public void onTestSuccess(){

    }

    public void onTestFailure(){

    }

    @Attachment(value="screenshot", type = "image/png")
    public byte[] screenshot(){
        return new byte[0];
    }
}
