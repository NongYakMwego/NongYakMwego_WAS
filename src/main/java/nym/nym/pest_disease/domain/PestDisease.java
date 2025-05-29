package nym.nym.pest_disease.domain;

import lombok.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class PestDisease {
    private final Long pestDiseaseId;
    private final String pestDiseaseNameKor;
    private final String pestDiseaseNameEng;
    private final String imaUrl;

   public static PestDisease withoutId(String pestDiseaseNameKor,String pestDiseaseNameEng,String imaUrl){
       return new PestDisease(null,pestDiseaseNameKor,pestDiseaseNameEng,imaUrl);
   }

   public static PestDisease withId(Long pestDiseaseId,String pestDiseaseNameKor,String pestDiseaseNameEng,String imaUrl){
       return new PestDisease(pestDiseaseId,pestDiseaseNameKor,pestDiseaseNameEng,imaUrl);
   }
}
