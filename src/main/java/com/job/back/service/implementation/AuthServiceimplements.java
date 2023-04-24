package com.job.back.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.job.back.common.constant.ResponseMessage;
import com.job.back.dto.request.auth.CompanySignInDto;
import com.job.back.dto.request.auth.CompanySignUpDto;
import com.job.back.dto.request.auth.UserSignInDto;
import com.job.back.dto.request.auth.UserSignUpDto;
import com.job.back.dto.response.ResponseDto;
import com.job.back.dto.response.auth.CompanySignInResponseDto;
import com.job.back.dto.response.auth.CompanySignUpResponseDto;
import com.job.back.dto.response.auth.UserSignInResponseDto;
import com.job.back.dto.response.auth.UserSignUpResonseDto;
import com.job.back.entity.CompanyEntity;
import com.job.back.entity.UserEntity;
import com.job.back.provider.TokenProvider;
import com.job.back.repository.CompanyReposiotry;
import com.job.back.repository.UserReposiotory;
import com.job.back.service.AuthService;

@Service
public class AuthServiceimplements implements AuthService {

    @Autowired private UserReposiotory userReposiotory;
    @Autowired private CompanyReposiotry companyReposiotry;
    @Autowired private TokenProvider tokenProvider;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public ResponseDto<UserSignUpResonseDto> userSignUp(UserSignUpDto dto) {
        UserSignUpResonseDto data = null;

        String userEmail = dto.getUserEmail();
        String userPassword = dto.getUserPassword();
        String userTelNumber = dto.getUserTelNumber();

        UserEntity userEntity = new UserEntity(dto);

        try {
            boolean hasEmail = userReposiotory.existsByUserEmail(userEmail);
            if(hasEmail) return ResponseDto.setFailed(ResponseMessage.EXIST_EMAIL);

            boolean hasTelNumber = userReposiotory.existsByUserTelNumber(userTelNumber);
            if(hasTelNumber) return ResponseDto.setFailed(ResponseMessage.EXIST_TEL_NUMBER);

            String edcodedPassword = passwordEncoder.encode(userPassword);
            userEntity.setUserPassword(edcodedPassword);
            userReposiotory.save(userEntity);

            data = new UserSignUpResonseDto(true);
            
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
        
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);

    }

    @Override
    public ResponseDto<CompanySignUpResponseDto> companySignUp(CompanySignUpDto dto) {
        CompanySignUpResponseDto data = null;

        String companyEmail = dto.getCompanyEmail();
        String companyPassword = dto.getCompanyPassword();
        String companyTelNumber = dto.getCompanyTelNumber();

        CompanyEntity companyEntity = new CompanyEntity(dto);

        try {
            boolean hasEmail = companyReposiotry.existsByCompanyEmail(companyEmail);
            if(hasEmail) return ResponseDto.setFailed(ResponseMessage.EXIST_EMAIL);

            boolean hasTelNumber = companyReposiotry.existsByCompanyTelNumber(companyTelNumber);
            if(hasTelNumber) return ResponseDto.setFailed(ResponseMessage.EXIST_TEL_NUMBER);

            String encodedPassword = passwordEncoder.encode(companyPassword);
            companyEntity.setCompanyPassword(encodedPassword);
            companyReposiotry.save(companyEntity);

            data = new CompanySignUpResponseDto(true);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS,data);
    }

    //=============================================================================================

    @Override
    public ResponseDto<UserSignInResponseDto> userSignIn(UserSignInDto dto) {
        UserSignInResponseDto data = null;
        
        UserEntity userEntity = null;

        String userEmail = dto.getUserEmail();
        String userPassword = dto.getUserPassword();

        try {
            userEntity = userReposiotory.findByUserEmail(userEmail);
            if(userEntity == null) return ResponseDto.setFailed(ResponseMessage.FAIL_SIGN_IN);

            boolean isEqualPassword = passwordEncoder.matches(userPassword, userEntity.getUserPassword());
            if(!isEqualPassword) return ResponseDto.setFailed(ResponseMessage.FAIL_SIGN_IN);
            
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        try {
            String token = tokenProvider.create(userEmail);
            data = new UserSignInResponseDto(userEntity, token);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.FAIL_SIGN_IN);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }


    @Override
    public ResponseDto<CompanySignInResponseDto> companySignIn(CompanySignInDto dto) {
        CompanySignInResponseDto data = null;
        
        CompanyEntity companyEntity = null;

        String companyEmail = dto.getCompanyEmail();
        String companyPassword = dto.getCompanyPassword();

        try {
            companyEntity = companyReposiotry.findByCompanyEmail(companyEmail);
            if(companyEntity == null) return ResponseDto.setFailed(ResponseMessage.FAIL_SIGN_IN);

            boolean isEqualPassword = passwordEncoder.matches(companyPassword, companyEntity.getCompanyPassword());
            if(!isEqualPassword) return ResponseDto.setFailed(ResponseMessage.FAIL_SIGN_IN);
            
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        try {
            String token = tokenProvider.create(companyEmail);
            data = new CompanySignInResponseDto(companyEntity, token);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.FAIL_SIGN_IN);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    
}
