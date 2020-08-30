package gpy.templates.lombok;

import lombok.*;
import lombok.experimental.FieldDefaults;


@Data      //  POJO ( @RequiredArgsConstructor + @Getter's + @Setter's + @HashCode + @EqualsAndHashCode )
           // если нужно указать парметры аннотаций, входящих в состав @Data, можно просто прописать эти
           // аннотации с параметрами вместе с @Data
// @Data(staticConstructor = "of")  // создает статический конструктор
// @Value     //   immutable версия @Data  ( final + @ToString + @EqualsAndHashCode + @AllArgsConstructor +
              //    @FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE) + @Getter )
@FieldDefaults(level = AccessLevel.PRIVATE)  // @Data по умолчанию не делает поля класса private
public class Manager {
    @NonNull
    String name;
    @NonNull
    int salary;
}



