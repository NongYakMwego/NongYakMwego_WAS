package nym.nym.pest_disease.domain;

import lombok.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class PestDisease {
    private final Long pestDiseaseId;
    private final String pestDiseaseName;
    private final String imaUrl;

   public static PestDisease withoutId(String pestDiseaseName,String imaUrl){
       return new PestDisease(null,pestDiseaseName,imaUrl);
   }

   public static PestDisease withId(Long pestDiseaseId,String pestDiseaseName,String imaUrl){
       return new PestDisease(pestDiseaseId,pestDiseaseName,imaUrl);
   }
}
