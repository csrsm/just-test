package com.newbee.Model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author  cuiming
 * @date 2018.07.12
 */

@TableName("user_info")
@Data
public class UserInfo extends Model<UserInfo> {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String userName;
    private String userWxid;
    private Date joinDate;

    @Override
    protected Serializable pkVal() {
        // TODO Auto-generated method stub
        return id;
    }
}
