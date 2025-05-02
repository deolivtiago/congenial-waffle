package com.clarxlabs.ellion.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.FractionalSeconds;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @ColumnDefault("gen_random_uuid()")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false, unique = true)
    private String password;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @ColumnDefault("''")
    @Builder.Default
    @Column(name = "avatar_url", nullable = false)
    private String avatarUrl = "";

    @ColumnDefault("false")
    @Builder.Default
    @Column(name = "is_verified", nullable = false)
    private boolean isVerified = false;

    @ColumnDefault("'user'")
    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @JsonBackReference
    @Builder.Default
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<Token> tokens = new HashSet<>();

    @ColumnDefault("now()")
    @UpdateTimestamp
    @FractionalSeconds(0)
    @Column(name = "updated_at", nullable = false)
    private ZonedDateTime updatedAt;

    @CreationTimestamp
    @FractionalSeconds(0)
    @Column(name = "inserted_at", nullable = false)
    private ZonedDateTime insertedAt;
}
