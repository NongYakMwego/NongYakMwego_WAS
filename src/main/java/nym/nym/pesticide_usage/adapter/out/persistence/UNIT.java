package nym.nym.pesticide_usage.adapter.out.persistence;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import nym.nym.global.common.EnumMapperType;

@Getter
@RequiredArgsConstructor
public enum UNIT implements EnumMapperType {
    mL("밀리리터"),
    L("리터"),
    mg("밀리그램"),
    g("그램"),
    kg("키로그램");

    private final String msg;


    @Override
    public String getCode() {
        return name();
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
