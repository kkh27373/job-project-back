package com.job.back.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.back.common.constant.ResponseMessage;
import com.job.back.dto.response.ResponseDto;
import com.job.back.dto.response.company.GetRelatedSearchWordResponseDto;
import com.job.back.dto.response.company.GetSearchListResponseDto;
import com.job.back.entity.CompanyEntity;
import com.job.back.entity.RelatedSearchWordEntity;
import com.job.back.entity.SearchWordLogEntity;
import com.job.back.entity.resultSet.RelatedSearchWordResultSet;
import com.job.back.repository.CompanyReposiotry;
import com.job.back.repository.RelatedSearchWordRepository;
import com.job.back.repository.SearchWordLogRepository;
import com.job.back.service.SearchService;

@Service
public class SearchServiceImplements implements SearchService {

    @Autowired private CompanyReposiotry companyRepository;
    @Autowired private SearchWordLogRepository searchWordLogRepository;
    @Autowired private RelatedSearchWordRepository relatedSearchWordRepository;

    @Override
    public ResponseDto<List<GetSearchListResponseDto>> getSearchList(String searchWord, String previousSearchWord) {
        List<GetSearchListResponseDto> data = null;

        try {

            SearchWordLogEntity searchWordLogEntity = new SearchWordLogEntity(searchWord);
            searchWordLogRepository .save(searchWordLogEntity);

            if(previousSearchWord != null && previousSearchWord.isBlank()){
                RelatedSearchWordEntity relatedSearchWordEntity = new RelatedSearchWordEntity(searchWord, previousSearchWord);
                relatedSearchWordRepository.save(relatedSearchWordEntity);
            }

            List<CompanyEntity> companyList = companyRepository.findByCompanyNameContainsOrCompanyCategory(searchWord, searchWord);
            data = GetSearchListResponseDto.copyList(companyList);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    @Override
    public ResponseDto<GetRelatedSearchWordResponseDto> getRelatedSearchWord(String searchWord) {
        GetRelatedSearchWordResponseDto data = null;

        try {

            List<RelatedSearchWordResultSet> relatedSearchWordList = relatedSearchWordRepository.findTop15(searchWord);

            data = GetRelatedSearchWordResponseDto.copyList(relatedSearchWordList);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS,data);
    }
}
