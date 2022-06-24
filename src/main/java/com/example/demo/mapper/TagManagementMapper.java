package com.example.demo.mapper;

import com.example.demo.bean.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TagManagementMapper {

    @Select("select tagid from tag_record where blogid = #{blog}")
    public int[] findTagIDByBlog(long blog);

    @Select("select * from tag where tagid = #{tag}")
    public Tag fingTagContentByTanID(long tag);

    @Select("select * from tag")
    public Tag[] findAllTags();
}
