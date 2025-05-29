package nym.nym.crop_pest.adapter.out.persistence;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum LEVEL  {
    HIGH("높음"),
    MEDIUM("중간"),
    LOW("낮음");

    private final String msg;
}
