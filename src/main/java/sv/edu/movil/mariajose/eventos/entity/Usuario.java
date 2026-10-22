package sv.edu.movil.mariajose.eventos.entity;
import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDateTime;
import java.math.BigDecimal;
@Entity @Table(name="usuarios") @Getter @Setter @NoArgsConstructor @AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false, unique = true)
    private String correo;
    @Column(nullable = false)
    private String clave;
    @Column(nullable = false)
    private String rol;
    @Column(nullable = false)
    private Boolean activo;
}
