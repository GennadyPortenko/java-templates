package gpy.templates.lombok;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;

@RequiredArgsConstructor          // создает конструктор с @NonNull и final полями
// @RequiredArgsConstructor(staticName = "of") // создает статический конструктор
@NoArgsConstructor(force = true)  // создает конструктор по умолчанию (без аргументов)
                                  // если есть @NonNull поля, то без force = true не скомпилируется
// @NoArgsConstructor(staticName = "of")  // создает статический конструктор
// @AllArgsConstructor                     // создает конструктор для всех полей с проверкой на null для @NonNull полей
// @AllArgsConstructor(staticName = "of")  // создает статический конструктор
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@ToString                         // создает ToString()
@EqualsAndHashCode                // создает equals() и hashCode()
public class SoftwareDesigner {
    @Getter       // создает getter
    // @Setter    // создает setter - для final полей не скомпилируется
    // @NonNull  //  если в FieldDefaults установлен паарметр makeFinal = true,
                 // то @NonNull для @RequiredArgsConstructor избыточен
    String name;
    @Getter
    int salary;

    public String getInfo() {
        val info = "salary : ";    //  val позволяет не указывать тип при инициализации final переменной
        var value = this.salary;   //  var позволяет не указывать тип при инициализации НЕ final переменной
        return info + (value + 100);
    }
}

