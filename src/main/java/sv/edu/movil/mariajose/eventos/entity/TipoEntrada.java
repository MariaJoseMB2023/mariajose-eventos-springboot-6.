package sv.edu.movil.mariajose.eventos.entity;
import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDateTime;
import java.math.BigDecimal;
@Entity @Table(name="tipos_entrada") @Getter @Setter @NoArgsConstructor @AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TipoEntrada {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal precio;
    @Column(nullable = false)
    private Integer cantidadDisponible;
    @Column(nullable = false)
    private Boolean activo;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "evento_id", nullable = false)
    private Evento evento;
}
