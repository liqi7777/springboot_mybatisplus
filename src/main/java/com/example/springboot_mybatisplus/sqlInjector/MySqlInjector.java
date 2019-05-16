package com.example.springboot_mybatisplus.sqlInjector;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.extension.injector.methods.additional.LogicDeleteByIdWithFill;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 自定义Sql注入
 * 自定义自己的通用方法可以实现接口 ISqlInjector
 * 也可以继承抽象类 AbstractSqlInjector 注入通用方法 SQL 语句
 * 然后继承 BaseMapper 添加自定义方法，全局配置 sqlInjector 注入 MP 会自动将类所有方法注入到 mybatis 容器中。
 *
 * @author nieqiurong 2018/8/11 20:23.
 */
@Component
public class MySqlInjector extends DefaultSqlInjector {

    @Override
    public List<AbstractMethod> getMethodList() {
        List<AbstractMethod> methodList = super.getMethodList();
        //增加自定义方法
        methodList.add(new DeleteAll());
        return methodList;
    }
}
