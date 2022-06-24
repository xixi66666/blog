package com.example.demo.service;

import com.example.demo.bean.Tag;

public interface TagManagementService {

    public int[] findTagIDByBlog(long blog);

    public Tag fingTagContentByTanID(long tag);

    public Tag[] findAllTags();
}
