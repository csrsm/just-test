package com.newbee.controller.request;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author cuiming
 * @date 2018.07.12
 */
@Data
@Api(value = "用户信息")
public class User {
    @ApiModelProperty(value = "主键ID")
    private Long id;
    @ApiModelProperty(value = "用户名")
    private String userName;
    @ApiModelProperty(value = "用户性别 1：男 2：女")
    private String userSex;
    @ApiModelProperty(value = "用户婚否 1：是 2：否")
    private String isMarry;
    @ApiModelProperty(value = "做家务次数")
    private String workNum;

}
