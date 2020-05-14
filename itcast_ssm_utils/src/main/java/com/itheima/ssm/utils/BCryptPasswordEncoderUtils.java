package com.itheima.ssm.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
/** 
* @ClassName: BCryptPasswordEncoderUtils 
* @Description: TODO 
* @author: Mr.Mao 
* @date: 2020年04月03日 17:03 
*/

public class BCryptPasswordEncoderUtils {

    private static BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();

    public static String getBCryptPasswordEncoder(String password){
        return bCryptPasswordEncoder.encode(password);
    }
    /* 
    * @FunctionName: main
    * @Description: TODO
    * @author: Mr.mao
    * @date: 2020年04月03日 17:11
    * @Param: [args]
    * @Return: void
    */
    public static void main(String[] args) {
        System.out.println(BCryptPasswordEncoderUtils.getBCryptPasswordEncoder("123456"));
    }
}
