package com.digibyte.midfinwealth.finqube.controller;

import com.digibyte.midfinwealth.finqube.domain.UserInfo;
import com.digibyte.midfinwealth.finqube.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sample")
@RequiredArgsConstructor
public class SampleDataController {
    
    private final UserInfoService userInfoService;
    
    @PostMapping("/can")
    public UserInfo saveUserInfo(@RequestBody UserInfo userInfo){
        return userInfoService.saveUserInfo(userInfo);  
    }

    @PostMapping("/can/bulk")
    public List<UserInfo> saveAllUserInfo(@RequestBody List<UserInfo> userInfos){
        return userInfoService.loadManyData(userInfos);
    }
    
    @GetMapping("/can")
    public List<UserInfo> getAll (){
        return userInfoService.getAllUser();
    }
    
    @GetMapping("/can/{id}")
    public UserInfo getByID(@PathVariable long id){
        return userInfoService.getById(id);
    }
}
