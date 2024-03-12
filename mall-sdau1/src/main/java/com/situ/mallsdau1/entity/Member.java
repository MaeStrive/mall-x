package com.situ.mallsdau1.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author author
 * @since 2023-06-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("member")
public class Member implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "Id", type = IdType.AUTO)
    private Integer Id;

    private String username;

    private String password;

    private String tel;

    private String name;

    private LocalDateTime createTime;

    private Integer status;

    private String avatar;


}
