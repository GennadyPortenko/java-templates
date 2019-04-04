package webstudio;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WebStudio {
    int id;
    @NonNull
    String name;
    @NonNull
    double annualProfit;
    @NonNull
    int employeesNum;
}
