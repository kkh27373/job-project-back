package com.job.back.dto.response.company;

import java.util.ArrayList;
import java.util.List;

import com.job.back.entity.resultSet.RelatedSearchWordResultSet;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "안 씀.")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetRelatedSearchWordResponseDto {
    private List<String> SearchWordList;
    
    public static GetRelatedSearchWordResponseDto copyList(List<RelatedSearchWordResultSet> list){
        List<String> result = new ArrayList<>();
        for(RelatedSearchWordResultSet item: list){
            result.add(item.getPreviousSearchWord());
        }   
        return new GetRelatedSearchWordResponseDto(result);
    }
}
