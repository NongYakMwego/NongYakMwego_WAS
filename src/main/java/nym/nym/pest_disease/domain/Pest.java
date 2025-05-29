package nym.nym.pest_disease.domain;

import lombok.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Pest {
    private final Long pestId;
    private final String pestName;

    public static Pest of(String pestName){
        return new Pest(null,pestName);
    }
}
