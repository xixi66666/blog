package com.example.demo.bean;

import java.util.Date;

public class Comment {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.ID
     *
     * @mbggenerated Sat Apr 09 10:50:28 CST 2022
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.user1
     *
     * @mbggenerated Sat Apr 09 10:50:28 CST 2022
     */
    private Long user1;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.blog_id
     *
     * @mbggenerated Sat Apr 09 10:50:28 CST 2022
     */
    private Long blogId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.baba_id
     *
     * @mbggenerated Sat Apr 09 10:50:28 CST 2022
     */
    private Long babaId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.agree_num
     *
     * @mbggenerated Sat Apr 09 10:50:28 CST 2022
     */
    private Long agreeNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.date
     *
     * @mbggenerated Sat Apr 09 10:50:28 CST 2022
     */
    private Date date;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.description
     *
     * @mbggenerated Sat Apr 09 10:50:28 CST 2022
     */
    private String description;

    public Comment(Long id, Long user1, Long blogId, Long babaId, Long agreeNum, Date date, String description) {
        this.id = id;
        this.user1 = user1;
        this.blogId = blogId;
        this.babaId = babaId;
        this.agreeNum = agreeNum;
        this.date = date;
        this.description = description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.ID
     *
     * @return the value of comment.ID
     *
     * @mbggenerated Sat Apr 09 10:50:28 CST 2022
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.ID
     *
     * @param id the value for comment.ID
     *
     * @mbggenerated Sat Apr 09 10:50:28 CST 2022
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.user1
     *
     * @return the value of comment.user1
     *
     * @mbggenerated Sat Apr 09 10:50:28 CST 2022
     */
    public Long getUser1() {
        return user1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.user1
     *
     * @param user1 the value for comment.user1
     *
     * @mbggenerated Sat Apr 09 10:50:28 CST 2022
     */
    public void setUser1(Long user1) {
        this.user1 = user1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.blog_id
     *
     * @return the value of comment.blog_id
     *
     * @mbggenerated Sat Apr 09 10:50:28 CST 2022
     */
    public Long getBlogId() {
        return blogId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.blog_id
     *
     * @param blogId the value for comment.blog_id
     *
     * @mbggenerated Sat Apr 09 10:50:28 CST 2022
     */
    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.baba_id
     *
     * @return the value of comment.baba_id
     *
     * @mbggenerated Sat Apr 09 10:50:28 CST 2022
     */
    public Long getBabaId() {
        return babaId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.baba_id
     *
     * @param babaId the value for comment.baba_id
     *
     * @mbggenerated Sat Apr 09 10:50:28 CST 2022
     */
    public void setBabaId(Long babaId) {
        this.babaId = babaId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.agree_num
     *
     * @return the value of comment.agree_num
     *
     * @mbggenerated Sat Apr 09 10:50:28 CST 2022
     */
    public Long getAgreeNum() {
        return agreeNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.agree_num
     *
     * @param agreeNum the value for comment.agree_num
     *
     * @mbggenerated Sat Apr 09 10:50:28 CST 2022
     */
    public void setAgreeNum(Long agreeNum) {
        this.agreeNum = agreeNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.date
     *
     * @return the value of comment.date
     *
     * @mbggenerated Sat Apr 09 10:50:28 CST 2022
     */
    public Date getDate() {
        return date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.date
     *
     * @param date the value for comment.date
     *
     * @mbggenerated Sat Apr 09 10:50:28 CST 2022
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.description
     *
     * @return the value of comment.description
     *
     * @mbggenerated Sat Apr 09 10:50:28 CST 2022
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.description
     *
     * @param description the value for comment.description
     *
     * @mbggenerated Sat Apr 09 10:50:28 CST 2022
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

}