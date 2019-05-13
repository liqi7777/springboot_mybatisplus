package com.example.springboot_mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot_mybatisplus.mapper.SysUserMapper;
import com.example.springboot_mybatisplus.mapper.UserMapper;
import com.example.springboot_mybatisplus.model.SysUser;
import com.example.springboot_mybatisplus.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMybatisplusApplicationTests {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<SysUser> userList = sysUserMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    /**
     * 根据 ID 查询
     *
     * @throws Exception
     */
    @Test
    public void selectById() throws Exception {
        // 根据 ID 查询
        User user = userMapper.selectById(1);
        System.out.println(user.toString());
    }

    /**
     * 查询（根据ID 批量查询）
     *
     * @throws Exception
     */
    @Test
    public void selectBatchIds() throws Exception {
        //查询（根据ID 批量查询）
        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        List<User> users = userMapper.selectBatchIds(ids);
        System.out.println(users);
    }

    /**
     * 查询（根据 columnMap 条件）
     *
     * @throws Exception
     */
    @Test
    public void selectByMap() throws Exception {
        //查询（根据 columnMap 条件）
        HashMap<String, Object> map = new HashMap<>();
        map.put("alias_name", "liqi_01");
        List<User> users1 = userMapper.selectByMap(map);
        System.out.println(users1);
    }

    /**
     * 根据 entity 条件，查询一条记录
     * Wrapper 条件构造器
     *
     * @throws Exception
     */
    @Test
    public void selectOne() throws Exception {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("alias_name", "liqi_01");
        User user = userMapper.selectOne(userQueryWrapper);
        System.out.println(user.toString());
    }

    /**
     * 根据 Wrapper 条件，查询总记录数
     *
     * @throws Exception
     */
    @Test
    public void selectCount() throws Exception {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("alias_name", "liqi_01");
        Integer count = userMapper.selectCount(userQueryWrapper);
        System.out.println(count);
    }

    /**
     * <p>
     * 根据 entity 条件，查询全部记录
     * </p>
     *
     * @return 实体集合
     */
    @Test
    public void selectList() throws Exception {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("age", "20");
        List<User> users = userMapper.selectList(userQueryWrapper);
        System.out.println(users);
    }

    /**
     * 根据 Wrapper 条件，查询全部记录
     * selectMaps
     *
     * @throws Exception
     */
    @Test
    public void selectMaps() throws Exception {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("age", "20");
        List<Map<String, Object>> userMaps = userMapper.selectMaps(userQueryWrapper);
        System.out.println(userMaps);
    }

    /**
     * 根据 Wrapper 条件，查询全部记录
     * 注意： 只返回第一个字段的值
     *
     * @throws Exception
     */
    @Test
    public void selectObjs() throws Exception {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("age", "20");
        List<Object> objects = userMapper.selectObjs(userQueryWrapper);
        System.out.println(objects);
    }

    /**
     * <p>
     * 根据 entity 条件，查询全部记录（并翻页）
     * </p>
     * page         分页查询条件（可以为 RowBounds.DEFAULT）
     * queryWrapper 实体对象封装操作类（可以为 null）
     *
     * @return 实体分页对象
     */
    @Test
    public void selectPage() throws Exception {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        IPage<User> userIPage = userMapper.selectPage(new Page<User>(1, 1), userQueryWrapper);
        List<User> users = userIPage.getRecords();
        long pages = userIPage.getPages();
        long current = userIPage.getCurrent();
        long size = userIPage.getSize();
        long total = userIPage.getTotal();
        System.out.println(users);
    }

    /**
     * <p>
     * 根据 Wrapper 条件，查询全部记录（并翻页）
     * </p>
     * <p>
     * page         分页查询条件
     * queryWrapper 实体对象封装操作类
     *
     * @return 字段映射对象 Map 分页对象
     */
    @Test
    public void selectMapsPage() throws Exception {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        IPage<Map<String, Object>> userIPageMap = userMapper.selectMapsPage(new Page<User>(1, 2), userQueryWrapper);
        List<Map<String, Object>> userMaps = userIPageMap.getRecords();
        long pages = userIPageMap.getPages();
        long current = userIPageMap.getCurrent();
        long size = userIPageMap.getSize();
        long total = userIPageMap.getTotal();
        System.out.println(userMaps);
    }

    /**
     * and or  nested
     * nested :正常嵌套 不带 AND 或者 OR
     * 主动调用or表示紧接着下一个方法不是用and连接!(不调用or则默认为使用and连接)
     *
     * @throws Exception
     */
    @Test
    public void queryWrapper() throws Exception {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("name", "Sandy").or(userQueryWrapper1 -> userQueryWrapper1.eq("age", 20).ne("alias_name", "liqi_01"));
//        userQueryWrapper.eq("age",20).eq("alias_name","liqi_01");
        List<User> users = userMapper.selectList(userQueryWrapper);
        System.out.println(users);
    }


    /**
     * 设置查询字段
     * select(String... sqlSelect)
     * select(Predicate<TableFieldInfo> predicate)
     * select(Class<T> entityClass, Predicate<TableFieldInfo> predicate)
     *
     * @throws Exception
     */
    @Test
    public void QueryWrapper() throws Exception {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>(new User());
        //指定查询字段
//        userQueryWrapper.select("id", "name");
//        userQueryWrapper.select(tableFieldInfo -> tableFieldInfo.getColumn().startsWith("na"));
        List<Map<String, Object>> mapList = userMapper.selectMaps(userQueryWrapper);
        System.out.println(mapList);
    }


    /**
     * set(String column, Object val)
     * set(boolean condition, String column, Object val)
     *
     * @throws Exception
     */
    @Test
    public void UpdateWrapper() throws Exception {
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        User user = userMapper.selectById(2);
        userUpdateWrapper.set("name", "jack").eq("name", "Jack");
        int updateResult = userMapper.update(user, userUpdateWrapper);
        System.out.println(updateResult);
    }
}
