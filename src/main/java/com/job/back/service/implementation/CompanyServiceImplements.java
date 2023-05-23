package com.job.back.service.implementation;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.back.common.constant.ResponseMessage;
import com.job.back.dto.request.company.CompanyAdditionalInfoDto;
import com.job.back.dto.request.company.PatchCompanyProfileDto;
import com.job.back.dto.request.company.ValidateCompanyEmailDto;
import com.job.back.dto.request.company.ValidateCompanyTelNumberDto;
import com.job.back.dto.response.ResponseDto;
import com.job.back.dto.response.company.GetCompanyListMainResponseDto;
import com.job.back.dto.response.company.GetCompanyResponseDto;
import com.job.back.dto.response.company.GetRelatedSearchWordResponseDto;
import com.job.back.dto.response.company.GetSearchListResponseDto;
import com.job.back.dto.response.company.GetCompanyTop3ListResponseDto;
import com.job.back.dto.response.company.CompanyInfoResponseDto;
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
    public ResponseDto<PatchCompanyProfileResponseDto> patchCompanyProfile(String companyEmail,PatchCompanyProfileDto dto){

        PatchCompanyProfileResponseDto data = null;

        try{

            CompanyEntity companyEntity = companyRepository.findByCompanyEmail(companyEmail);
            if(companyEntity == null) return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_COMPANY);
            companyEntity.setCompanyProfileUrl(dto.getCompanyProfileUrl());
            companyRepository.save(companyEntity);
            
            data = new PatchCompanyProfileResponseDto(companyEntity);
        
        }catch(Exception exception){
            exception.printStackTrace();
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

    // @Override
    // public ResponseDto<GetCompanyTop3ListResponseDto[]> getTop3CompanyList(String companyEmail){

    //     GetCompanyTop3ListResponseDto[] data = null;

    //     try{
    //         // ! 기준을 정하면 기준에 따라 디스플레이 되는 회사들의 순번이 정해진다 
    //         List<CompanyEntity> companyEntities = companyRepository.findAll();
    //         data = new GetCompanyTop3ListResponseDto[companyEntities.size()];

    //     for (int i = 0; i < companyEntities.size(); i++) {

    //         CompanyEntity companyEntity = companyEntities.get(i);
    //         GetCompanyListMainResponseDto responseDto = new GetCompanyListMainResponseDto();

    //         responseDto.setCompanyAddress(companyEntity.getCompanyAddress());
    //         responseDto.setCompanyCategory(companyEntity.getCompanyCategory());
    //         responseDto.setCompanyName(companyEntity.getCompanyName());
    //         responseDto.setCompanyPassword(companyEntity.getCompanyPassword());
    //         responseDto.setCompanyProfileUrl(companyEntity.getCompanyProfileUrl());
    //         responseDto.setCompanyTelNumber(companyEntity.getCompanyTelNumber());

    //         data[i] = responseDto;
    //     }
            
    //     }catch(Exception e){
    //         e.printStackTrace();
    //         return ResponseDto.setFailed((ResponseMessage.DATABASE_ERROR));
    //     }
    //     return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);  

    // }

    @Override
    public ResponseDto<CompanyInfoResponseDto>insertCompanyAdditionalInfo( CompanyAdditionalInfoDto requestBody) {
        
        CompanyInfoResponseDto data = null;

        CompanyEntity companyInformationEntity = new CompanyEntity(requestBody);

        try {
            // ? 기존의 정보
            CompanyEntity companyentity_old =companyRepository.findByCompanyTelNumber(requestBody.getCompanyTelNumber());
            
            // ?새로운 정보
            CompanyEntity companyentity_new = new CompanyEntity(requestBody);

            companyentity_old.setCompanyEmployee(companyentity_new.getCompanyEmployee());
            


            // ? Repository에 저장 
            companyRepository.save(companyentity_old);
 
            data = new CompanyInfoResponseDto(true);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS,data);
    }

    // @Override
    // public ResponseDto<CompanyInfoResponseDto> updateCompanyInfo(CompanyAdditionalInfoDto requestBody) {
    //     CompanyInfoResponseDto data = null;

    //     CompanyInformationEntity companyInformationEntity = new CompanyInformationEntity(requestBody);

    //     try {
    //         companyInformationEntity.patchCompany(requestBody); 
            
    //         companyInformationRepository.save(companyInformationEntity);
 
    //         data = new CompanyInfoResponseDto(true);

    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
    //     }

    //     return ResponseDto.setSuccess(ResponseMessage.SUCCESS,data);
    // }

    // @Override
    // public ResponseDto<GetCompanyInfoResponseDto> getComapnyInfo( String compantTelNumber) {
        
    //     GetCompanyInfoResponseDto data = null;

    //     try{
    //         CompanyInformationEntity companyInformationEntity = companyInformationRepository.findByCompanyTelNumber(compantTelNumber);
    //         if(companyInformationEntity == null) return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_COMPANY);

    //         companyInformationRepository.save(companyInformationEntity);

    //         data = new GetCompanyInfoResponseDto(companyInformationEntity);

    //     }catch (Exception e) {
    //         e.printStackTrace();
    //         return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
    //     }
    //     return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    // }
}
