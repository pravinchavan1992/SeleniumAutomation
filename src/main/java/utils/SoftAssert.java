package utils;

public class SoftAssert extends org.testng.asserts.SoftAssert{
    public SoftAssert() { }

    public void assertEquals(String actual, String expected, String attributeName) {
        String error = this.logValidation(attributeName, actual, expected);
        super.assertEquals(actual, expected, error);
    }

    public void assertEquals(int actual, int expected, String attributeName) {
        String error = this.logValidation(attributeName, actual, expected);
        super.assertEquals(actual, expected, error);
    }
    public void assertTrue(boolean condition, String expected) {
        super.assertTrue(condition, expected);
    }

    private String logValidation(String name, Object actual, Object expected) {
        return name + " did not matched";
    }
}
