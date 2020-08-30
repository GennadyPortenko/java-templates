package gpk.annotations;

import gpk.annotations.example.CustomParameterValidationAnnotation;
import org.junit.Assert;
import org.junit.Test;

public class TestCustomParameterValidationAnnotation {

    private class StubClass {
        boolean stubMethod(@CustomParameterValidationAnnotation String s) {
            return s.contains("test");
        }
    }

    @Test
    public void validateParameter() {
        final String testString = "test text";
        Assert.assertTrue(new StubClass().stubMethod(testString));
    }
}
