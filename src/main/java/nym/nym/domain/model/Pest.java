package nym.nym.domain.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
public class Pest {
    private Long pestId;
    private String pestName;

    public static Pest of(String pestName){
        return Pest.builder()
                .pestName(pestName)
                .build();
    }
}
