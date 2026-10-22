package sv.edu.movil.mariajose.eventos.entity;
import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDateTime;
import java.math.BigDecimal;
@Entity @Table(name="lugares") @Getter @Setter @NoArgsConstructor @AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Lugar {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String direccion;
    @Column(nullable = false)
    private Integer capacidad;
    @Column(nullable = false)
    private Boolean activo;
}
