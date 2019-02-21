package com.imooc.dao;

import com.imooc.model.SysAclModel;

public interface SysAclModelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysAclModel record);

    int insertSelective(SysAclModel record);

    SysAclModel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysAclModel record);

    int updateByPrimaryKey(SysAclModel record);
}