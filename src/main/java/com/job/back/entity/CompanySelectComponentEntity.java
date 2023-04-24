package com.job.back.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "CompanySelectComponent")
@Table(name = "CompanySelectComponent")
public class CompanySelectComponentEntity {
    // 회사 전화번호
    private String companyTelNumber;
    // 최종 학력 1 (대졸,박사 학위,석사 학위,고졸)
    private int userFinalEducationGradeOne;
    // 최종 학력 2 ( 전공 과목 )
    private int userFinalEducationGradeTwo;
    // 최종 학력 3 (최종학교 명)
    private int userFinalEducationGradeThree;
    // 최종 학력 점수
    private int userFinalEducationGradeEtc;
    // 경력
    private int userCareerGradeOne;
    // 자격증
    private int userLiceseGradeOne;

    @JsonProperty("서울대학교")
    public int seoulUniversity() {
        return userFinalEducationGradeOne;
    }

    @JsonProperty("연세대학교")
    public int yonseiUniversity() {
        return userFinalEducationGradeOne;
    }

    @JsonProperty("고려대학교")
    public int koreaUniversity() {   
        return userFinalEducationGradeOne;
    }

    //=============================================

    @JsonProperty("울산대학교")
    public int ulsanUniversity() {   
        return userFinalEducationGradeTwo;
    }

    @JsonProperty("중앙대학교")
    public int chungAngUniversity() {   
        return userFinalEducationGradeTwo;
    }

    @JsonProperty("부산대학교")
    public int busanUniversity() {   
        return userFinalEducationGradeTwo;
    }

    @JsonProperty("아주대학교")
    public int jijuUniversity() {   
        return userFinalEducationGradeTwo;
    }

    @JsonProperty("서강대학교")
    public int sogangUniversity() {   
        return userFinalEducationGradeTwo;
    }

    //=============================================

    @JsonProperty("전북대학교")
    public int chonbukUniversity() {   
        return userFinalEducationGradeThree;
    }

    @JsonProperty("영남대학교")
    public int yeungnamUniversity() {   
        return userFinalEducationGradeThree;
    }

    @JsonProperty("충남대학교")
    public int chungnamUniversity() {   
        return userFinalEducationGradeThree;
    }

    @JsonProperty("강원대학교")
    public int kangwonUniversity() {   
        return userFinalEducationGradeThree;
    }

    @JsonProperty("한림대학교")
    public int hallymUniversity() {   
        return userFinalEducationGradeThree;
    }

    @JsonProperty("기타")
    public int anotherUniversity() {   
        return userFinalEducationGradeEtc;
    }

    @JsonProperty("경력")
    public int career(){
        return userCareerGradeOne;
    }

    @JsonProperty("자격증")
    public int lisence(){
        return userLiceseGradeOne;
    }
    
}
