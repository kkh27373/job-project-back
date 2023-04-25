package com.job.back.common.constant;

<<<<<<< HEAD
public interface ResponseMessage {
    public static final String SUCCESS = "Success.";

    public static final String FAIL_SIGN_IN = "Failed Sign In.";
    public static final String NOT_EXIST_BOARD = "Does Not Exist Board.";
    public static final String NOT_EXIST_USER = "Does Not Exist User.";
    public static final String NOT_PERMISSION = "Do Not Have Permission";

    public static final String EXIST_EMAIL = "Existed Email.";
    public static final String EXIST_NICKNAME = "Exited Nickname.";
    public static final String EXIST_TEL_NUMBER = "Existed Tel Number.";

    public static final String DATABASE_ERROR = "Database Error.";
=======
public class ResponseMessage {
    
     // ^ static 변수니까 나중에 다른곳에서 객체생성없이 클래스명.상수명 이렇게 쉽게 사용가능 
     public static final String DATABASE_ERROR = "Database Error";
     public static final String SUCCESS = "Sucess";
     public static final String EXIST_EMAIL = "Already Existed Email";
     public static final String EXIST_TEL_NUMBER = "Existed Tel Number";
     public static final String FAIL_SIGN_IN =  "Failed Sign In";
     public static final String NOT_EXIST_USER = "Does Not Exist User";  
     public static final String NOT_EXIST_BOARD = "Does Not Exist Board";
     public static final String NOT_PERMISSION = "Does not have Permission";
     public static final String EXIST_NICKNAME = "Already Exist Nickname";
    
>>>>>>> b5718ad3a49d2577d8fe3e2a042b74f3a013e301
}
