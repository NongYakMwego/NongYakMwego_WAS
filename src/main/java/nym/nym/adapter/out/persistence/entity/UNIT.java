package nym.nym.adapter.out.persistence.entity;

import lombok.Getter;
import nym.nym.global.common.EnumMapperType;

@Getter
public enum UNIT implements EnumMapperType {
    mL,
    L,
    mg,
    g;

    @Override
    public String getCode() {
        return name();
    }
}
