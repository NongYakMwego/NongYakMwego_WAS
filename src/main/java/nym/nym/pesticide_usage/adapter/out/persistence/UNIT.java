package nym.nym.pesticide_usage.adapter.out.persistence;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UNIT{
    mL("밀리리터"),
    L("리터"),
    mg("밀리그램"),
    g("그램"),
    kg("키로그램");

    private final String msg;
}
