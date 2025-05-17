package nym.nym.domain.estate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import nym.nym.global.common.entity.BaseEntity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Estate extends BaseEntity {
    @Id
    @Column(name = "estate_id",nullable = false,unique = true)
    private String estateId;

    @Embedded
    private Location location;
}
