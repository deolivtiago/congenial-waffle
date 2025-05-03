package com.clarxlabs.ellion.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
public class Role {
    @Id
    private String id;

    @Generated
    @ColumnDefault("'{}'::text[]")
    @Builder.Default
    @Column(name = "permissions", nullable = false)
    private Set<String> permissions = new HashSet<>();

    @JsonBackReference
    @Builder.Default
    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    private Set<User> users = new HashSet<>();

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
