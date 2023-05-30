package com.job.back.service.implementation;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.back.common.constant.ResponseMessage;
import com.job.back.common.util.DatabaseJson;
import com.job.back.dto.request.company.CompanyAdditionalInfoDto;
import com.job.back.dto.request.company.PatchCompanyProfileDto;
import com.job.back.dto.request.company.ValidateCompanyEmailDto;
import com.job.back.dto.request.company.ValidateCompanyTelNumberDto;
import com.job.back.dto.response.ResponseDto;
import com.job.back.dto.response.company.GetCompanyListMainResponseDto;
import com.job.back.dto.response.company.GetCompanyPageResponseDto;
import com.job.back.dto.response.company.GetCompanyResponseDto;
import com.job.back.dto.response.company.GetRelatedSearchWordResponseDto;
import com.job.back.dto.response.company.GetSearchListResponseDto;
import com.job.back.dto.response.company.GetCompanyTop3ListResponseDto;
import com.job.back.dto.response.company.CompanyInfoResponseDto;
import com.job.back.dto.response.company.ListUpApplicantResponseDto;
import com.job.back.dto.response.company.PatchCompanyProfileResponseDto;
import com.job.back.dto.response.company.SelectUniversityResponseDto;
import com.job.back.dto.response.company.ValidateCompanyEmailResponseDto;
import com.job.back.dto.response.company.ValidateCompanyTelNumberResponseDto;
import com.job.back.entity.ApplicantEntity;
import com.job.back.entity.CompanyEntity;
import com.job.back.entity.RelatedSearchWordEntity;
import com.job.back.entity.SearchWordLogEntity;
import com.job.back.entity.resultSet.RelatedSearchWordResultSet;
import com.job.back.repository.ApplicantRepositroy;
import com.job.back.repository.RelatedSearchWordRepository;
import com.job.back.repository.SearchWordLogRepository;
import com.job.back.entity.CompanySelectComponent_Carrer_Entity;
import com.job.back.entity.CompanySelectComponent_License_Entity;
import com.job.back.entity.CompanySelectComponent_University_Entity;
import com.job.back.entity.UserEntity;
import com.job.back.repository.CompanyRepository;
import com.job.back.repository.CompanySelectComponent_University_Repository;
import com.job.back.repository.UserReposiotory;
import com.job.back.service.CompanyService;

@Service
public class CompanyServiceImplements implements CompanyService {
    @Autowired private CompanyRepository companyRepository;
    @Autowired private ApplicantRepositroy applicantRepositroy;
    @Autowired private CompanySelectComponent_University_Repository companySelectComponentIUniversityRepository;
   
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
            List<CompanyEntity> companyEntity = companyRepository.findByCompanyEmail(companyEmail);
            if(companyEntity == null) return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_COMPANY);

            data = new GetCompanyResponseDto(companyEntity.get(0));
            
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

            List<CompanyEntity> companyEntity = companyRepository.findByCompanyEmail(companyEmail);
            if(companyEntity == null) return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_COMPANY);
            companyEntity.get(0).setCompanyProfileUrl(dto.getCompanyProfileUrl());
            companyRepository.save(companyEntity.get(0));
            
            data = new PatchCompanyProfileResponseDto(companyEntity.get(0));
        
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

    
    @Override
    public ResponseDto<GetCompanyTop3ListResponseDto[]> getTop3CompanyList(String companyEmail){

        GetCompanyTop3ListResponseDto[] data = null;

        try{
            // 회사데이터를 가져온다.
            List<CompanyEntity> companyEntities = companyRepository.findAll();
            data = new GetCompanyTop3ListResponseDto[companyEntities.size()];
            // 화면에 반환 해줘야 되는 것들을 가져온다.
        for (int i = 0; i < companyEntities.size(); i++) {

            CompanyEntity companyEntity = companyEntities.get(i);
            GetCompanyTop3ListResponseDto responseDto = new GetCompanyTop3ListResponseDto();

            responseDto.setCompanyAddress(companyEntity.getCompanyAddress());
            responseDto.setCompanyCategory(companyEntity.getCompanyCategory());
            responseDto.setCompanyName(companyEntity.getCompanyName());
            responseDto.setCompanyPassword(companyEntity.getCompanyPassword());
            responseDto.setCompanyProfileUrl(companyEntity.getCompanyProfileUrl());
            responseDto.setCompanyTelNumber(companyEntity.getCompanyTelNumber());

            data[i]=responseDto;
        }
       
            
        }catch(Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed((ResponseMessage.DATABASE_ERROR));
        }
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);  

    }


    @Override
    public ResponseDto<CompanyInfoResponseDto>insertCompanyAdditionalInfo( CompanyAdditionalInfoDto requestBody) {
        
        CompanyInfoResponseDto data = null;

        
        System.out.println(requestBody.getCompanyContents());
        System.out.println(requestBody.getCompanyAnnualSales());
        System.out.println(requestBody.getCompanyTelNumber());

        try {
            // ? 기존의 정보
            // ? 이게 null이라네 
            CompanyEntity companyentity_old =companyRepository.findByCompanyTelNumber(requestBody.getCompanyTelNumber());
            
            // ?새로운 정보
            CompanyEntity companyentity_new = new CompanyEntity(requestBody);

            companyentity_old.setCompanyEmployee(companyentity_new.getCompanyEmployee());
            companyentity_old.setCompanyHomePage(companyentity_new.getCompanyHomePage());
            companyentity_old.setCompanyContents(companyentity_new.getCompanyContents());
            companyentity_old.setCompanyCategory(companyentity_new.getCompanyCategory());
            companyentity_old.setCompanyAnnualSales(companyentity_new.getCompanyAnnualSales());
            companyentity_old.setCompanyStartingSalary(companyentity_new.getCompanyStartingSalary());

            


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

    @Override
    public ResponseDto<GetCompanyPageResponseDto> getCompanyPage(String companyTelNumber) {
        
        GetCompanyPageResponseDto data = null;

        try {
            CompanyEntity companyEntity = companyRepository.findByCompanyTelNumber(companyTelNumber);
            if(companyEntity == null) return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_TEL_NUMBER);
            
            data = new GetCompanyPageResponseDto(companyEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    @Override
    public ResponseDto<SelectUniversityResponseDto> getSelectComponentUniversity(String companyTelNumber) {
        
        SelectUniversityResponseDto data = null;

        try {
            CompanySelectComponent_University_Entity companySelectComponent_Information_Entity = companySelectComponentIUniversityRepository.findByCompanyTelNumber(companyTelNumber);
            if(companySelectComponent_Information_Entity == null) return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_TEL_NUMBER);

            data = new SelectUniversityResponseDto(companySelectComponent_Information_Entity);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS,data);
    }

}
