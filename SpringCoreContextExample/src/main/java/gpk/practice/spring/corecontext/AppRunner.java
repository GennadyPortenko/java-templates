package gpk.practice.spring.corecontext;

import gpk.practice.spring.corecontext.app.annotationconfigapp.AnnotationConfigurationApp;
import gpk.practice.spring.corecontext.app.IApp;
import gpk.practice.spring.corecontext.app.xmlconfigapp.XmlConfigApp;

public class AppRunner {
    public static void main(String... args) {
        // IApp app = new AnnotationConfigurationApp();
        IApp app = new XmlConfigApp();
        app.start();
    }
}
