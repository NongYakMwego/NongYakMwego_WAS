package nym.nym.domain.estate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Estate {
    @Id
    @Column(name = "estate_id",nullable = false,unique = true)
    private String estateId;

    @Embedded
    private Location location;
}
