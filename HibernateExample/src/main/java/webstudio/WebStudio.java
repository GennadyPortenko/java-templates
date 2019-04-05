package webstudio;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@Entity(name = "WEBSTUDIO")
@Table(name = "WEBSTUDIO")

@NoArgsConstructor         // для вызова метода Hibernate createQuery()
@RequiredArgsConstructor

@FieldDefaults(level = AccessLevel.PRIVATE)
public class WebStudio {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @NonNull
    @Column(name="name")
    String name;

    @NonNull
    @Column(name="annual_profit")
    double annualProfit;

    @NonNull
    @Column(name="employees_num")
    int employeesNum;

    public int getId() { return this.id; }  //  не обязательный
}

