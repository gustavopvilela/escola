package br.edu.ifmg.escola.entities;

import br.edu.ifmg.escola.constants.DeliverStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_deliver")
public class Deliver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String uri;
    private Instant moment;

    @Enumerated(EnumType.STRING)
    private DeliverStatus status;
    private String feedback;
    private Integer correctCount;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "offer_id"),
        @JoinColumn(name = "user_id")
    })
    private Enrollment enrollment;
}
