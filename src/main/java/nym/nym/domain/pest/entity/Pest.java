package nym.nym.domain.pest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import nym.nym.global.common.entity.BaseEntity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Pest extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pest_id",nullable = false,unique = true)
    private Long pestId;

    @Column(name = "pest_name",nullable = false,length = 50)
    private String pestName;
}
