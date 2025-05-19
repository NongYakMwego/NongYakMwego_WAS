package nym.nym.adapter.out.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Lob;

@Embeddable
public class PesticideDetail {
    //농약 이름
    @Column(name = "pesticide_name",nullable = false,length = 50)
    private String pesticideName;

    //희석 비율
    @Column(name = "dilution_ratio")
    private Integer dilutionRatio;

    //판매사이트
    @Column(name = "sales_site_url",length = 100)
    private String salesSiteUrl;

    //위험도 설명
    @Lob
    @Column(name = "risk_description")
    private String riskDescription;
}
