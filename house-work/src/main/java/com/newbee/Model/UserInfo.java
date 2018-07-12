package com.newbee.Model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * @author  cuiming
 * @date 2018.07.12
 */

@TableName("user_info")
public class UserInfo extends Model<UserInfo> {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String userName;
    private String userSex;
    private String isMarry;
    private String workNum;

    @Override
    protected Serializable pkVal() {
        // TODO Auto-generated method stub
        return id;
    }
}
