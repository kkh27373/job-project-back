package com.job.back.service;

import java.util.List;

import com.job.back.dto.response.ResponseDto;
import com.job.back.dto.response.company.GetRelatedSearchWordResponseDto;
import com.job.back.dto.response.company.GetSearchListResponseDto;

public interface SearchService {
    public ResponseDto<List<GetSearchListResponseDto>> getSearchList(String searchWord, String previousSearchWord);
    public ResponseDto<GetRelatedSearchWordResponseDto> getRelatedSearchWord(String searchWord);
}
