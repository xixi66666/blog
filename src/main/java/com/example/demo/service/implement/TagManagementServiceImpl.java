package com.example.demo.service.implement;

import com.example.demo.bean.Tag;
import com.example.demo.mapper.TagManagementMapper;
import com.example.demo.service.TagManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagManagementServiceImpl implements TagManagementService {

    @Autowired
    private TagManagementMapper tagManagementMapper;

    @Override
    public int[] findTagIDByBlog(long blog) {
        return tagManagementMapper.findTagIDByBlog(blog);
    }

    @Override
    public Tag fingTagContentByTanID(long tag) {
        return tagManagementMapper.fingTagContentByTanID(tag);
    }

    @Override
    public Tag[] findAllTags() {
        return tagManagementMapper.findAllTags();
    }
}
