package com.situ.mallsdauweb.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
