package com.job.back.service.implementation;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.back.common.constant.ResponseMessage;
import com.job.back.dto.request.company.PatchCompanyProfileDto;
import com.job.back.dto.request.company.ValidateCompanyEmailDto;
import com.job.back.dto.request.company.ValidateCompanyTelNumberDto;
import com.job.back.dto.response.ResponseDto;
import com.job.back.dto.response.company.GetCompanyListMainResponseDto;
import com.job.back.dto.response.company.GetCompanyResponseDto;
import com.job.back.dto.response.company.GetRelatedSearchWordResponseDto;
import com.job.back.dto.response.company.GetSearchListResponseDto;
import com.job.back.dto.response.company.ListUpApplicantResponseDto;
import com.job.back.dto.response.company.PatchCompanyProfileResponseDto;
import com.job.back.dto.response.company.ValidateCompanyEmailResponseDto;
import com.job.back.dto.response.company.ValidateCompanyTelNumberResponseDto;
import com.job.back.entity.ApplicantEntity;
import com.job.back.entity.CompanyEntity;
import com.job.back.entity.RelatedSearchWordEntity;
import com.job.back.entity.SearchWordLogEntity;
import com.job.back.entity.resultSet.RelatedSearchWordResultSet;
import com.job.back.repository.ApplicantRepositroy;
import com.job.back.repository.CompanyReposiotry;
import com.job.back.repository.RelatedSearchWordRepository;
import com.job.back.repository.SearchWordLogRepository;
import com.job.back.service.CompanyService;

@Service
public class CompanyServiceImplements implements CompanyService {
    @Autowired private CompanyReposiotry companyRepository;
    @Autowired private ApplicantRepositroy applicantRepositroy;
    @Autowired private SearchWordLogRepository searchWordLogRepository;
    @Autowired private RelatedSearchWordRepository relatedSearchWordRepository;



   
    @Override
    public ResponseDto<ValidateCompanyEmailResponseDto> validateCompanyEmail(ValidateCompanyEmailDto dto) {
        ValidateCompanyEmailResponseDto data = null;

        String companyEmail = dto.getCompanyEmail();

        try {
            boolean hasEmail = companyRepository.existsByCompanyEmail(companyEmail);
            data = new ValidateCompanyEmailResponseDto(!hasEmail);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
        
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);

    }

    @Override
    public ResponseDto<ValidateCompanyTelNumberResponseDto> validateCompanyTelNumber(ValidateCompanyTelNumberDto dto) {
        ValidateCompanyTelNumberResponseDto data = null;

        String companyTelNumber = dto.getCompanyTelNumber();

        try {
            boolean hasTelNumber = companyRepository.existsByCompanyTelNumber(companyTelNumber);
            data = new ValidateCompanyTelNumberResponseDto(!hasTelNumber);
            
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
        
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
        
    }
    
    @Override
    public ResponseDto<GetCompanyResponseDto> getCompany(String companyEmail) {
        GetCompanyResponseDto data = null;
        
        try {
            CompanyEntity companyEntity = companyRepository.findByCompanyEmail(companyEmail);
            if(companyEntity == null) return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_COMPANY);

            data = new GetCompanyResponseDto(companyEntity);
            
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);

    }

    @Override
    public ResponseDto<ListUpApplicantResponseDto> ListUpApplicant(String companyTelNumber){

        ListUpApplicantResponseDto data =null;

        try{
            

            List<ApplicantEntity> applicant_List = applicantRepositroy.findByApplicantCompanyTelNumber(companyTelNumber);




            data = new ListUpApplicantResponseDto(applicant_List);
            

        }catch(Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);

    }

    @Override
    public ResponseDto<PatchCompanyProfileResponseDto> patchCompanyProfile(PatchCompanyProfileDto patchCompanyProfileDto){

        PatchCompanyProfileResponseDto data = null;

        try{

            CompanyEntity companyentity = companyRepository.findByCompanyTelNumber(patchCompanyProfileDto.getCompanyTelNumber());

            companyentity.setCompanyName(patchCompanyProfileDto.getCompanyName());
            companyentity.setCompanyAddress(patchCompanyProfileDto.getCompanyAddress());
            companyentity.setCompanyProfileUrl(patchCompanyProfileDto.getCompanyProfileUrl());

            companyRepository.save(companyentity);
            data = new PatchCompanyProfileResponseDto(companyentity);


        }catch(Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    @Override
    public ResponseDto<GetCompanyListMainResponseDto[]> getCompanyListMain(String companyEmail){
        
        
        GetCompanyListMainResponseDto[] data = null;

        try{

            List<CompanyEntity> companyEntities = companyRepository.findAll();
            data = new GetCompanyListMainResponseDto[companyEntities.size()];

        for (int i = 0; i < companyEntities.size(); i++) {

            CompanyEntity companyEntity = companyEntities.get(i);
            GetCompanyListMainResponseDto responseDto = new GetCompanyListMainResponseDto();

            responseDto.setCompanyAddress(companyEntity.getCompanyAddress());
            responseDto.setCompanyCategory(companyEntity.getCompanyCategory());
            responseDto.setCompanyName(companyEntity.getCompanyName());
            responseDto.setCompanyPassword(companyEntity.getCompanyPassword());
            responseDto.setCompanyProfileUrl(companyEntity.getCompanyProfileUrl());
            responseDto.setCompanyTelNumber(companyEntity.getCompanyTelNumber());

            data[i] = responseDto;

            


        }


        }catch(Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);

        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
        
    }

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
