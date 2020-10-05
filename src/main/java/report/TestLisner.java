package report;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.concurrent.ConcurrentHashMap;

public class TestLisner implements ITestListener {
    private ConcurrentHashMap<String, ExtentTest> allTests = new ConcurrentHashMap<>();
    String reportFolderPath = System.getProperty("user.dir") + "//AutomationReports//";
    String reportName = "AutomationReport.html";

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = ExtentManager.createInstance(reportFolderPath, reportName).createTest(result.getMethod().getMethodName(),result.getMethod().getDescription());
        allTests.put(result.getMethod().getMethodName(), extentTest);
        ExtentManager.setTest(extentTest);
        ExtentManager.getInstance().flush();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentManager.getTest().get().assignCategory(result.getClass().getSimpleName());
        ExtentManager.getTest().get().createNode(MarkupHelper.createLabel("Test passed", ExtentColor.GREEN).getMarkup());
        ExtentManager.getInstance().flush();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentManager.getTest().get().createNode(MarkupHelper.createLabel("Test Failed", ExtentColor.RED).getMarkup()).fail(result.getThrowable());
        ExtentManager.getInstance().flush();
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentManager.getInstance().flush();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
