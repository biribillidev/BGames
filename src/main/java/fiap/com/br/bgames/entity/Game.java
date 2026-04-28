package fiap.com.br.bgames.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "games")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String platform;
    private LocalDate releaseDate;

    @ManyToOne // muitos Games podem pertencer a uma Developer
    private Developer developer;

    @OneToMany // um Game pode ter muitas categorias
    private Category category;
}
