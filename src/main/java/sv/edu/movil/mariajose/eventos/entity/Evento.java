package sv.edu.movil.mariajose.eventos.entity;
import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDateTime;
import java.math.BigDecimal;
@Entity @Table(name="eventos") @Getter @Setter @NoArgsConstructor @AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Evento {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = true)
    private String descripcion;
    @Column(nullable = false)
    private LocalDateTime fechaHora;
    @Column(nullable = false)
    private String estado;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "lugar_id", nullable = false)
    private Lugar lugar;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoria_evento_id", nullable = false)
    private CategoriaEvento categoriaEvento;
}
