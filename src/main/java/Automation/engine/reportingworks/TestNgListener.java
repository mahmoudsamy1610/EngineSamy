package Automation.engine.reportingworks;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.util.Collection;
import java.util.List;

public class TestNgListener extends TestListenerAdapter{

    public TestNgListener() {
        super();
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        super.onTestSuccess(tr);
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        super.onTestFailure(tr);
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        super.onTestSkipped(tr);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult tr) {
        super.onTestFailedWithTimeout(tr);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult tr) {
        super.onTestFailedButWithinSuccessPercentage(tr);
    }

    @Override
    protected ITestNGMethod[] getAllTestMethods() {
        return super.getAllTestMethods();
    }

    @Override
    public void onStart(ITestContext testContext) {
        super.onStart(testContext);
    }

    @Override
    public void onFinish(ITestContext testContext) {
        super.onFinish(testContext);
    }

    @Override
    public List<ITestResult> getFailedButWithinSuccessPercentageTests() {
        return super.getFailedButWithinSuccessPercentageTests();
    }

    @Override
    public List<ITestResult> getFailedTests() {
        return super.getFailedTests();
    }

    @Override
    public List<ITestResult> getPassedTests() {
        return super.getPassedTests();
    }

    @Override
    public List<ITestResult> getSkippedTests() {
        return super.getSkippedTests();
    }

    @Override
    public Collection<ITestResult> getTimedoutTests() {
        return super.getTimedoutTests();
    }

    @Override
    public void setAllTestMethods(List<ITestNGMethod> allTestMethods) {
        super.setAllTestMethods(allTestMethods);
    }

    @Override
    public void setFailedButWithinSuccessPercentageTests(List<ITestResult> failedButWithinSuccessPercentageTests) {
        super.setFailedButWithinSuccessPercentageTests(failedButWithinSuccessPercentageTests);
    }

    @Override
    public void setFailedTests(List<ITestResult> failedTests) {
        super.setFailedTests(failedTests);
    }

    @Override
    public void setPassedTests(List<ITestResult> passedTests) {
        super.setPassedTests(passedTests);
    }

    @Override
    public void setSkippedTests(List<ITestResult> skippedTests) {
        super.setSkippedTests(skippedTests);
    }

    @Override
    public void onTestStart(ITestResult result) {
        super.onTestStart(result);
    }

    @Override
    public List<ITestContext> getTestContexts() {
        return super.getTestContexts();
    }

    @Override
    public List<ITestResult> getConfigurationFailures() {
        return super.getConfigurationFailures();
    }

    @Override
    public void onConfigurationFailure(ITestResult itr) {
        super.onConfigurationFailure(itr);
    }

    @Override
    public List<ITestResult> getConfigurationSkips() {
        return super.getConfigurationSkips();
    }

    @Override
    public void beforeConfiguration(ITestResult tr) {
        super.beforeConfiguration(tr);
    }

    @Override
    public void onConfigurationSkip(ITestResult itr) {
        super.onConfigurationSkip(itr);
    }

    @Override
    public void onConfigurationSuccess(ITestResult itr) {
        super.onConfigurationSuccess(itr);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void onConfigurationSuccess(ITestResult tr, ITestNGMethod tm) {
        super.onConfigurationSuccess(tr, tm);
    }

    @Override
    public void onConfigurationFailure(ITestResult tr, ITestNGMethod tm) {
        super.onConfigurationFailure(tr, tm);
    }

    @Override
    public void onConfigurationSkip(ITestResult tr, ITestNGMethod tm) {
        super.onConfigurationSkip(tr, tm);
    }

    @Override
    public void beforeConfiguration(ITestResult tr, ITestNGMethod tm) {
        super.beforeConfiguration(tr, tm);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
