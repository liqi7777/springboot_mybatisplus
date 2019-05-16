package com.example.springboot_mybatisplus.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot_mybatisplus.model.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot_mybatisplus.sqlInjector.DeleteAll;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author liqi
 * @since 2019-05-13
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * <p>
     * 注意!!: 如果入参是有多个,需要加注解指定参数名才能在xml中取值
     * </p>
     *
     * @param page 分页对象,xml中可以从里面进行取值,传递参数 Page 即自动分页,必须放在第一位(你可以继承Page实现自己的分页对象)
     * @param age  状态
     * @return 分页对象
     */
    IPage<User> selectPageVo(Page page, @Param("age") Integer age);


    /**
     * sql 注入器注入删除全部方法
     */
    void deleteAll();
}
