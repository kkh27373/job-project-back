package com.job.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.job.back.common.constant.ApiPattern;
import com.job.back.dto.response.ResponseDto;
import com.job.back.dto.response.company.GetRelatedSearchWordResponseDto;
import com.job.back.dto.response.company.GetSearchListResponseDto;
import com.job.back.service.SearchService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "검색 모듈")
@RestController
@RequestMapping(ApiPattern.SEARCH)
public class SearchController {
    @Autowired private SearchService searchService;

    private final String GET_SEARCH_LIST = "/search-list/{searchWord}";
    private final String GET_SEARCH_LIST_PREVIOUS = "/search-list/{searchWord}/{previousSearchWord}";
    private final String GET_RELATED_SEARCH_WORD = "/related-search-word/{searchWord}";

    @ApiOperation(value = "검색어에 대한 게시물 리스트 가져오기")
    @GetMapping(value = {GET_SEARCH_LIST, GET_SEARCH_LIST_PREVIOUS})
    public ResponseDto<List<GetSearchListResponseDto>> getSearchList(
        @PathVariable("searchWord") String searchWord,
        @PathVariable(name = "previousSearchWord", required = false) String previousSearchWord
    ){
        ResponseDto<List<GetSearchListResponseDto>> response = searchService.getSearchList(searchWord, previousSearchWord);
        return response;
    }

    // @ApiOperation(value = "")
    // @GetMapping(GET_RELATED_SEARCH_WORD)
    // public ResponseDto<GetRelatedSearchWordResponseDto> getRelatedSearchWord(@PathVariable("searchWord") String searchWord){
    //     ResponseDto<GetRelatedSearchWordResponseDto> response = searchService.getRelatedSearchWord(searchWord);
    //     return response;
    // }
}
