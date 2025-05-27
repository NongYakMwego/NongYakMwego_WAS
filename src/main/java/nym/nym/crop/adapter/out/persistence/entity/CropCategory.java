package nym.nym.crop.adapter.out.persistence.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CropCategory {
    FOOD("식량작물"),
    FRUIT("과수"),
    VEGETABLE("채소"),
    FLOWER("화훼"),
    SPECIAL("특용작물");

    private final String msg;

}
