package nym.nym.data.adapter.out;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nym.nym.crop.adapter.out.persistence.CropEntity;
import nym.nym.crop.adapter.out.persistence.CropRepository;
import nym.nym.crop.application.port.out.CreateCropPort;
import nym.nym.domain.model.Crop;
import nym.nym.mapper.CropMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Slf4j
public class DataInitAdapter implements CreateCropPort{
    private final CropMapper cropMapper;
    private final CropRepository cropRepository;


    @Override
    public Crop createCrop(Crop crop) {
        CropEntity cropEntity=cropMapper.domainToEntity(crop);
        CropEntity savedCropEntity=cropRepository.save(cropEntity);
        return cropMapper.entityToDomain(savedCropEntity);
    }
}
