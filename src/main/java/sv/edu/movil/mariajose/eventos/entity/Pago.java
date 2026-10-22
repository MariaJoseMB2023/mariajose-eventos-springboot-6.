package sv.edu.movil.mariajose.eventos.entity;
import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDateTime;
import java.math.BigDecimal;
@Entity @Table(name="pagos") @Getter @Setter @NoArgsConstructor @AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pago {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(nullable = false)
    private LocalDateTime fechaPago;
    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal monto;
    @Column(nullable = false)
    private String metodo;
    @Column(nullable = false)
    private String estado;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "reserva_id", nullable = false)
    private Reserva reserva;
}
