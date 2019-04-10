package gpk.practice.spring.corecontext;

import gpk.practice.spring.corecontext.app.annotationconfigapp.AnnotationConfigurationApp;
import gpk.practice.spring.corecontext.app.IApp;

public class AppRunner {
    public static void main(String... args) {
        IApp app = new AnnotationConfigurationApp();
        app.start();
    }
}
