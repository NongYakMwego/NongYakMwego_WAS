package nym.nym.domain.pesticide.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import nym.nym.domain.estate.entity.Location;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Pesticide {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pesticide_id",unique = true,nullable = false)
    private Long pesticideId;

    @Embedded
    private PesticideDetail pesticideDetail;

}
