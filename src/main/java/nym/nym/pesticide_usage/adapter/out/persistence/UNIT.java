package nym.nym.pesticide_usage.adapter.out.persistence;

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
