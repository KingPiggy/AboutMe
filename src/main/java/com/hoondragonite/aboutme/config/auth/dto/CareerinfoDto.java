package com.hoondragonite.aboutme.config.auth.dto;

import com.hoondragonite.aboutme.domain.careerinfo.Careerinfo;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CareerinfoDto {
    private int cno;
    private String cicarname;
    private String cicomment;
    private String startdate;
    private String enddate;

    public Careerinfo toEntity(){
        Careerinfo build = Careerinfo.builder()
                .cno(cno)
                .cicarname(cicarname)
                .cicomment(cicomment)
                .startdate(startdate)
                .enddate(enddate)
                .build();
        return build;
    }

    @Builder
    public CareerinfoDto(int cno, String cicarname, String cicomment, String startdate, String enddate){
        this.cno = cno;
        this.cicarname = cicarname;
        this.cicomment = cicomment;
        this.startdate = startdate;
        this.enddate = enddate;
    }





}