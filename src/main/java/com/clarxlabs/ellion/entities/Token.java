package com.clarxlabs.ellion.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.FractionalSeconds;
import org.hibernate.annotations.Generated;

import java.time.ZonedDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tokens")
public class Token {
    @Id
    @ColumnDefault("gen_random_uuid()")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "access", nullable = false, unique = true)
    private String access;

    @Generated
    @ColumnDefault("now() + '1 day'::interval")
    @FractionalSeconds(0)
    @Column(name = "access_expires_at", nullable = false)
    private ZonedDateTime accessExpiresAt;

    @Column(name = "refresh", nullable = false, unique = true)
    private String refresh;

    @Generated
    @ColumnDefault("now() + '7 days'::interval")
    @FractionalSeconds(0)
    @Column(name = "refresh_expires_at", nullable = false)
    private ZonedDateTime refreshExpiresAt;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @FractionalSeconds(0)
    @CreationTimestamp
    @Column(name = "inserted_at", nullable = false)
    private ZonedDateTime insertedAt;
}
