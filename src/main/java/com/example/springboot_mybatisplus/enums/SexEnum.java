package com.example.springboot_mybatisplus.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.core.enums.IEnum;

/**
 * @author Sky
 * create 2019/05/15
 * email sky.li@ixiaoshuidi.com
 **/
public enum SexEnum implements IEnum<String> {
    MAN("man", "男生"), WOMAN("woman", "女生");

    @EnumValue
    private String value;
    private String descp;

    SexEnum(String value, String descp) {
        this.value = value;
        this.descp = descp;
    }

    @Override
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescp() {
        return descp;
    }

    public void setDescp(String descp) {
        this.descp = descp;
    }
}
