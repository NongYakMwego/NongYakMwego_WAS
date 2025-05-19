package nym.nym.domain.model;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Crop {
    private Long cropId;
    private String cropDescription;
    private String cropName;
    private Integer cropCount;

    public static Crop of(String cropDescription,String cropName,Integer cropCount){
        return Crop.builder()
                .cropCount(cropCount)
                .cropDescription(cropDescription)
                .cropName(cropName)
                .build();
    }

    /**
     * @apiNote 작물 개수 변경 메서드
     * @param cropCount 변경할 작물 개수
     */
    public void changeCropCount(Integer cropCount){
        this.cropCount=cropCount;
    }

}
