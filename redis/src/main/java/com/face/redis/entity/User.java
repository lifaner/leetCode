package com.face.redis.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Create by lifan.
 * Date: 2019/5/5.
 * Time: 11:26.
 */
@Data
public class User implements Serializable {

    private String name;
    private String age;
}
