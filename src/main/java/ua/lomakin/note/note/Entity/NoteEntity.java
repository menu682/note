package ua.lomakin.note.note.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "note")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class NoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column(name = "note_name", nullable = false)
    private String name;

    @Column(name = "note_text", nullable = false)
    private String text;

    @Column(name = "grand", nullable = false)
    private Boolean grand;
}
