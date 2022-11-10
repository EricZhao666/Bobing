package com.zrgame.springboot_bogame.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zrgame.springboot_bogame.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {


}
