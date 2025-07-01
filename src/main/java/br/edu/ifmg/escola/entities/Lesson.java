package br.edu.ifmg.escola.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name = "tb_lesson")
public abstract class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String title;
    private Integer position;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "section_id")
    private Section section;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "tb_lessons_done",
        joinColumns = @JoinColumn(name = "lesson_id"),
        inverseJoinColumns = {
            @JoinColumn(name = "user_id"),
            @JoinColumn(name = "offer_id")
        }
    )
    private Set<Enrollment> enrollmentsDone = new HashSet<>();

    @OneToMany(mappedBy = "lesson")
    private List<Deliver> deliveries = new ArrayList<>();
}
