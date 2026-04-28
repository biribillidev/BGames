package fiap.com.br.bgames.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "developers")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private LocalDate foundedDate;
    private Boolean active;

}
