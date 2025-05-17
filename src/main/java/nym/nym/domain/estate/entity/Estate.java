package nym.nym.domain.estate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import nym.nym.global.common.entity.BaseEntity;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Estate extends BaseEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @UuidGenerator
    @Column(name = "estate_id",nullable = false,unique = true)
    private UUID estateId;

    @Embedded
    private Location location;
}
