package nym.nym.pest_disease.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nym.nym.global.common.annotaion.PersistenceAdapter;
import nym.nym.pest_disease.application.port.out.CreatePestDiseasePort;
import nym.nym.pest_disease.domain.PestDisease;

@RequiredArgsConstructor
@PersistenceAdapter("pestDiseasePersistenceAdapter")
@Slf4j
public class PestDiseasePersistenceAdapter implements CreatePestDiseasePort {
    private final PestDiseaseRepository pestDiseaseRepository;
    private final P

    @Override
    public PestDisease createPestDisease(PestDisease pestDisease) {
        return null;
    }
}
