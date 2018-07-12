package com.newbee.Service;

import com.newbee.controller.request.User;
import org.springframework.stereotype.Service;

/**
 * @author cuiming
 * @date 2018.07.12
 */

public interface UserInfoService {

    /**
     * 新增用户信息
     */
    Object saveUser(User user);

    /**
     * 修改用户信息
     */
    Object updateUser(User user);

    /**
     * 单条查询
     *
     * @param id
     * @return
     */
    Object getUserDetail(Long id);

    /**
     * 删除用户信息
     * @param
     * @returnid
     */
    Object deleteUser(Long id);
}
