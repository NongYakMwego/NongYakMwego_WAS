package nym.nym.crop.application.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nym.nym.crop.application.port.out.FetchCropPort;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@Slf4j
@Service
public class FetchCropService {
    private final FetchCropPort fetchCropPort;

}
