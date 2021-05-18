package com.chenhao.dao.entity;

import java.io.Serializable;

public class Article implements Serializable {
    private Integer id;

    private Long articleid;

    private String author;

    private String originalauthor;

    private String articletitle;

    private String articletags;

    private String articletype;

    private String articlecategories;

    private String publishdate;

    private String updatedate;

    private String articleurl;

    private Integer likes;

    private Long lastarticleid;

    private Long nextarticleid;

    private Integer isActive;

    private String articlecontent;

    private String articletabloid;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getArticleid() {
        return articleid;
    }

    public void setArticleid(Long articleid) {
        this.articleid = articleid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getOriginalauthor() {
        return originalauthor;
    }

    public void setOriginalauthor(String originalauthor) {
        this.originalauthor = originalauthor == null ? null : originalauthor.trim();
    }

    public String getArticletitle() {
        return articletitle;
    }

    public void setArticletitle(String articletitle) {
        this.articletitle = articletitle == null ? null : articletitle.trim();
    }

    public String getArticletags() {
        return articletags;
    }

    public void setArticletags(String articletags) {
        this.articletags = articletags == null ? null : articletags.trim();
    }

    public String getArticletype() {
        return articletype;
    }

    public void setArticletype(String articletype) {
        this.articletype = articletype == null ? null : articletype.trim();
    }

    public String getArticlecategories() {
        return articlecategories;
    }

    public void setArticlecategories(String articlecategories) {
        this.articlecategories = articlecategories == null ? null : articlecategories.trim();
    }

    public String getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(String publishdate) {
        this.publishdate = publishdate == null ? null : publishdate.trim();
    }

    public String getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(String updatedate) {
        this.updatedate = updatedate == null ? null : updatedate.trim();
    }

    public String getArticleurl() {
        return articleurl;
    }

    public void setArticleurl(String articleurl) {
        this.articleurl = articleurl == null ? null : articleurl.trim();
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Long getLastarticleid() {
        return lastarticleid;
    }

    public void setLastarticleid(Long lastarticleid) {
        this.lastarticleid = lastarticleid;
    }

    public Long getNextarticleid() {
        return nextarticleid;
    }

    public void setNextarticleid(Long nextarticleid) {
        this.nextarticleid = nextarticleid;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public String getArticlecontent() {
        return articlecontent;
    }

    public void setArticlecontent(String articlecontent) {
        this.articlecontent = articlecontent == null ? null : articlecontent.trim();
    }

    public String getArticletabloid() {
        return articletabloid;
    }

    public void setArticletabloid(String articletabloid) {
        this.articletabloid = articletabloid == null ? null : articletabloid.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", articleid=").append(articleid);
        sb.append(", author=").append(author);
        sb.append(", originalauthor=").append(originalauthor);
        sb.append(", articletitle=").append(articletitle);
        sb.append(", articletags=").append(articletags);
        sb.append(", articletype=").append(articletype);
        sb.append(", articlecategories=").append(articlecategories);
        sb.append(", publishdate=").append(publishdate);
        sb.append(", updatedate=").append(updatedate);
        sb.append(", articleurl=").append(articleurl);
        sb.append(", likes=").append(likes);
        sb.append(", lastarticleid=").append(lastarticleid);
        sb.append(", nextarticleid=").append(nextarticleid);
        sb.append(", isActive=").append(isActive);
        sb.append(", articlecontent=").append(articlecontent);
        sb.append(", articletabloid=").append(articletabloid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}