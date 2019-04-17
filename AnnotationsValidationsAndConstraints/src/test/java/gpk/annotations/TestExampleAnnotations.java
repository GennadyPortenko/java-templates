package gpk.annotations;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

import gpk.annotations.example.CustomClassAnnotation;
import org.junit.Test;

public class TestExampleAnnotations {

    @Test
    public void readClassAnnotationValue() {
        @CustomClassAnnotation(name="Custom Class Annotation")
        class AnnotatedClass {}
        assertTrue(AnnotatedClass.class.isAnnotationPresent(CustomClassAnnotation.class));
        CustomClassAnnotation annotation = AnnotatedClass.class.getAnnotation(CustomClassAnnotation.class);
        assertEquals(annotation.name(), "Custom Class Annotation");
    }

}
