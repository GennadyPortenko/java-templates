package gpy.templates.lombok;

public class LombokExample {
    public static void main(String... args)  {
        // пример работы @RequiredArgsConstructor
        SoftwareDesigner designer = new SoftwareDesigner("John", 10000);
        // пример работы сгенерированных геттеров ( @Getter )
        System.out.println(designer.getName() + " : " + designer.getSalary());
        // пример работы сгенерированного toString()  ( @ToString )
        System.out.println(designer.toString());

        // пример работы val, var
        System.out.println(designer.getInfo());

        // пример работы @NoArgsConstructor
        SoftwareDesigner noArgsdesigner = new SoftwareDesigner();
        System.out.println(noArgsdesigner.getName() + " : " + noArgsdesigner.getSalary()); // null, 0

        // пример работы @Data
        Manager manager = new Manager("Dick", 20000);
        System.out.println(manager.getName() + " : " + manager.getSalary());
    }
}
