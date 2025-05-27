package nym.nym.crop.adapter.out.persistence.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import nym.nym.crop.domain.Crop;

@Getter
@RequiredArgsConstructor
public enum CropCategory {
    FOOD("식량작물"),
    FRUIT("과수"),
    VEGETABLE("채소"),
    FLOWER("화훼"),
    SPECIAL("특용작물");

    private final String msg;

    public static CropCategory fromMsg(String msg) {
        for (CropCategory category : values()) {
            if (category.getMsg().equals(msg)) {
                return category;
            }
        }
        return null;
    }
}
