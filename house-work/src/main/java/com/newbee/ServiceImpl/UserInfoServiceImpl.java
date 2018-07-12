package com.newbee.ServiceImpl;

import com.newbee.Model.UserInfo;
import com.newbee.Service.UserInfoService;
import com.newbee.controller.request.User;
import com.newbee.repository.UserInfoRepository;
import com.newbee.util.ResponseResult;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
@Service
public class UserInfoServiceImpl implements UserInfoService{

    @Resource
    private UserInfoRepository userInfoRepository;

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Object saveUser (User user){
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(user,userInfo);
        return ResponseResult.ok(userInfoRepository.insert(userInfo));
    }
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Object updateUser (User user){
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(user,userInfo);
        return ResponseResult.ok(userInfoRepository.updateById(userInfo));
    }

    @Override
    public Object getUserDetail(Long id) {
        UserInfo userInfo = userInfoRepository.selectById(id);
        if(userInfo == null){
            return ResponseResult.build(HttpStatus.BAD_GATEWAY,"该记录已经不存在");
        }
        return ResponseResult.ok(userInfoRepository.selectById(id));
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Object deleteUser(Long id) {
        return ResponseResult.ok(userInfoRepository.deleteById(id));
    }

}
