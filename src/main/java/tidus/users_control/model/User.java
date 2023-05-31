package tidus.users_control.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity @Table(name = "users")
public class User implements Serializable {

    @JsonProperty(access = Access.READ_ONLY)
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O nome não pode ser nulo")
    @Size(min = 3, max = 100, message = "O nome tem que estar entre {min} e {max}")
    @Column(nullable = false, length = 100)
    private String name;

    @NotNull(message = "A senha não pode ser nula")
    @Size(min = 10, max = 50, message = "A senha tem que estar entre {min} e {max}")
    @JsonProperty(access = Access.WRITE_ONLY)
    @Column(nullable = false, length = 50)
    private String password;

    @Past(message = "A data precisa ser menor que a de hoje")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(nullable = false, name = "data_nascimento")
    private LocalDate dataNascimento;

    @NotNull(message = "O tipo de usuário não pode ser nulo")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 6)
    private UserType userType;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String description;

    @JsonProperty(access = Access.READ_ONLY)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @JsonProperty(access = Access.READ_ONLY)
    @UpdateTimestamp
    private LocalDateTime updatedAt;

}