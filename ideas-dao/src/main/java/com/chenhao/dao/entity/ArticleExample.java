package com.chenhao.dao.entity;

import java.util.ArrayList;
import java.util.List;

public class ArticleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ArticleExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andArticleidIsNull() {
            addCriterion("articleId is null");
            return (Criteria) this;
        }

        public Criteria andArticleidIsNotNull() {
            addCriterion("articleId is not null");
            return (Criteria) this;
        }

        public Criteria andArticleidEqualTo(Long value) {
            addCriterion("articleId =", value, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidNotEqualTo(Long value) {
            addCriterion("articleId <>", value, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidGreaterThan(Long value) {
            addCriterion("articleId >", value, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidGreaterThanOrEqualTo(Long value) {
            addCriterion("articleId >=", value, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidLessThan(Long value) {
            addCriterion("articleId <", value, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidLessThanOrEqualTo(Long value) {
            addCriterion("articleId <=", value, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidIn(List<Long> values) {
            addCriterion("articleId in", values, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidNotIn(List<Long> values) {
            addCriterion("articleId not in", values, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidBetween(Long value1, Long value2) {
            addCriterion("articleId between", value1, value2, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidNotBetween(Long value1, Long value2) {
            addCriterion("articleId not between", value1, value2, "articleid");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNull() {
            addCriterion("author is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNotNull() {
            addCriterion("author is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorEqualTo(String value) {
            addCriterion("author =", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotEqualTo(String value) {
            addCriterion("author <>", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThan(String value) {
            addCriterion("author >", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("author >=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThan(String value) {
            addCriterion("author <", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThanOrEqualTo(String value) {
            addCriterion("author <=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLike(String value) {
            addCriterion("author like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotLike(String value) {
            addCriterion("author not like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorIn(List<String> values) {
            addCriterion("author in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotIn(List<String> values) {
            addCriterion("author not in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorBetween(String value1, String value2) {
            addCriterion("author between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotBetween(String value1, String value2) {
            addCriterion("author not between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andOriginalauthorIsNull() {
            addCriterion("originalAuthor is null");
            return (Criteria) this;
        }

        public Criteria andOriginalauthorIsNotNull() {
            addCriterion("originalAuthor is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalauthorEqualTo(String value) {
            addCriterion("originalAuthor =", value, "originalauthor");
            return (Criteria) this;
        }

        public Criteria andOriginalauthorNotEqualTo(String value) {
            addCriterion("originalAuthor <>", value, "originalauthor");
            return (Criteria) this;
        }

        public Criteria andOriginalauthorGreaterThan(String value) {
            addCriterion("originalAuthor >", value, "originalauthor");
            return (Criteria) this;
        }

        public Criteria andOriginalauthorGreaterThanOrEqualTo(String value) {
            addCriterion("originalAuthor >=", value, "originalauthor");
            return (Criteria) this;
        }

        public Criteria andOriginalauthorLessThan(String value) {
            addCriterion("originalAuthor <", value, "originalauthor");
            return (Criteria) this;
        }

        public Criteria andOriginalauthorLessThanOrEqualTo(String value) {
            addCriterion("originalAuthor <=", value, "originalauthor");
            return (Criteria) this;
        }

        public Criteria andOriginalauthorLike(String value) {
            addCriterion("originalAuthor like", value, "originalauthor");
            return (Criteria) this;
        }

        public Criteria andOriginalauthorNotLike(String value) {
            addCriterion("originalAuthor not like", value, "originalauthor");
            return (Criteria) this;
        }

        public Criteria andOriginalauthorIn(List<String> values) {
            addCriterion("originalAuthor in", values, "originalauthor");
            return (Criteria) this;
        }

        public Criteria andOriginalauthorNotIn(List<String> values) {
            addCriterion("originalAuthor not in", values, "originalauthor");
            return (Criteria) this;
        }

        public Criteria andOriginalauthorBetween(String value1, String value2) {
            addCriterion("originalAuthor between", value1, value2, "originalauthor");
            return (Criteria) this;
        }

        public Criteria andOriginalauthorNotBetween(String value1, String value2) {
            addCriterion("originalAuthor not between", value1, value2, "originalauthor");
            return (Criteria) this;
        }

        public Criteria andArticletitleIsNull() {
            addCriterion("articleTitle is null");
            return (Criteria) this;
        }

        public Criteria andArticletitleIsNotNull() {
            addCriterion("articleTitle is not null");
            return (Criteria) this;
        }

        public Criteria andArticletitleEqualTo(String value) {
            addCriterion("articleTitle =", value, "articletitle");
            return (Criteria) this;
        }

        public Criteria andArticletitleNotEqualTo(String value) {
            addCriterion("articleTitle <>", value, "articletitle");
            return (Criteria) this;
        }

        public Criteria andArticletitleGreaterThan(String value) {
            addCriterion("articleTitle >", value, "articletitle");
            return (Criteria) this;
        }

        public Criteria andArticletitleGreaterThanOrEqualTo(String value) {
            addCriterion("articleTitle >=", value, "articletitle");
            return (Criteria) this;
        }

        public Criteria andArticletitleLessThan(String value) {
            addCriterion("articleTitle <", value, "articletitle");
            return (Criteria) this;
        }

        public Criteria andArticletitleLessThanOrEqualTo(String value) {
            addCriterion("articleTitle <=", value, "articletitle");
            return (Criteria) this;
        }

        public Criteria andArticletitleLike(String value) {
            addCriterion("articleTitle like", value, "articletitle");
            return (Criteria) this;
        }

        public Criteria andArticletitleNotLike(String value) {
            addCriterion("articleTitle not like", value, "articletitle");
            return (Criteria) this;
        }

        public Criteria andArticletitleIn(List<String> values) {
            addCriterion("articleTitle in", values, "articletitle");
            return (Criteria) this;
        }

        public Criteria andArticletitleNotIn(List<String> values) {
            addCriterion("articleTitle not in", values, "articletitle");
            return (Criteria) this;
        }

        public Criteria andArticletitleBetween(String value1, String value2) {
            addCriterion("articleTitle between", value1, value2, "articletitle");
            return (Criteria) this;
        }

        public Criteria andArticletitleNotBetween(String value1, String value2) {
            addCriterion("articleTitle not between", value1, value2, "articletitle");
            return (Criteria) this;
        }

        public Criteria andArticletagsIsNull() {
            addCriterion("articleTags is null");
            return (Criteria) this;
        }

        public Criteria andArticletagsIsNotNull() {
            addCriterion("articleTags is not null");
            return (Criteria) this;
        }

        public Criteria andArticletagsEqualTo(String value) {
            addCriterion("articleTags =", value, "articletags");
            return (Criteria) this;
        }

        public Criteria andArticletagsNotEqualTo(String value) {
            addCriterion("articleTags <>", value, "articletags");
            return (Criteria) this;
        }

        public Criteria andArticletagsGreaterThan(String value) {
            addCriterion("articleTags >", value, "articletags");
            return (Criteria) this;
        }

        public Criteria andArticletagsGreaterThanOrEqualTo(String value) {
            addCriterion("articleTags >=", value, "articletags");
            return (Criteria) this;
        }

        public Criteria andArticletagsLessThan(String value) {
            addCriterion("articleTags <", value, "articletags");
            return (Criteria) this;
        }

        public Criteria andArticletagsLessThanOrEqualTo(String value) {
            addCriterion("articleTags <=", value, "articletags");
            return (Criteria) this;
        }

        public Criteria andArticletagsLike(String value) {
            addCriterion("articleTags like", value, "articletags");
            return (Criteria) this;
        }

        public Criteria andArticletagsNotLike(String value) {
            addCriterion("articleTags not like", value, "articletags");
            return (Criteria) this;
        }

        public Criteria andArticletagsIn(List<String> values) {
            addCriterion("articleTags in", values, "articletags");
            return (Criteria) this;
        }

        public Criteria andArticletagsNotIn(List<String> values) {
            addCriterion("articleTags not in", values, "articletags");
            return (Criteria) this;
        }

        public Criteria andArticletagsBetween(String value1, String value2) {
            addCriterion("articleTags between", value1, value2, "articletags");
            return (Criteria) this;
        }

        public Criteria andArticletagsNotBetween(String value1, String value2) {
            addCriterion("articleTags not between", value1, value2, "articletags");
            return (Criteria) this;
        }

        public Criteria andArticletypeIsNull() {
            addCriterion("articleType is null");
            return (Criteria) this;
        }

        public Criteria andArticletypeIsNotNull() {
            addCriterion("articleType is not null");
            return (Criteria) this;
        }

        public Criteria andArticletypeEqualTo(String value) {
            addCriterion("articleType =", value, "articletype");
            return (Criteria) this;
        }

        public Criteria andArticletypeNotEqualTo(String value) {
            addCriterion("articleType <>", value, "articletype");
            return (Criteria) this;
        }

        public Criteria andArticletypeGreaterThan(String value) {
            addCriterion("articleType >", value, "articletype");
            return (Criteria) this;
        }

        public Criteria andArticletypeGreaterThanOrEqualTo(String value) {
            addCriterion("articleType >=", value, "articletype");
            return (Criteria) this;
        }

        public Criteria andArticletypeLessThan(String value) {
            addCriterion("articleType <", value, "articletype");
            return (Criteria) this;
        }

        public Criteria andArticletypeLessThanOrEqualTo(String value) {
            addCriterion("articleType <=", value, "articletype");
            return (Criteria) this;
        }

        public Criteria andArticletypeLike(String value) {
            addCriterion("articleType like", value, "articletype");
            return (Criteria) this;
        }

        public Criteria andArticletypeNotLike(String value) {
            addCriterion("articleType not like", value, "articletype");
            return (Criteria) this;
        }

        public Criteria andArticletypeIn(List<String> values) {
            addCriterion("articleType in", values, "articletype");
            return (Criteria) this;
        }

        public Criteria andArticletypeNotIn(List<String> values) {
            addCriterion("articleType not in", values, "articletype");
            return (Criteria) this;
        }

        public Criteria andArticletypeBetween(String value1, String value2) {
            addCriterion("articleType between", value1, value2, "articletype");
            return (Criteria) this;
        }

        public Criteria andArticletypeNotBetween(String value1, String value2) {
            addCriterion("articleType not between", value1, value2, "articletype");
            return (Criteria) this;
        }

        public Criteria andArticlecategoriesIsNull() {
            addCriterion("articleCategories is null");
            return (Criteria) this;
        }

        public Criteria andArticlecategoriesIsNotNull() {
            addCriterion("articleCategories is not null");
            return (Criteria) this;
        }

        public Criteria andArticlecategoriesEqualTo(String value) {
            addCriterion("articleCategories =", value, "articlecategories");
            return (Criteria) this;
        }

        public Criteria andArticlecategoriesNotEqualTo(String value) {
            addCriterion("articleCategories <>", value, "articlecategories");
            return (Criteria) this;
        }

        public Criteria andArticlecategoriesGreaterThan(String value) {
            addCriterion("articleCategories >", value, "articlecategories");
            return (Criteria) this;
        }

        public Criteria andArticlecategoriesGreaterThanOrEqualTo(String value) {
            addCriterion("articleCategories >=", value, "articlecategories");
            return (Criteria) this;
        }

        public Criteria andArticlecategoriesLessThan(String value) {
            addCriterion("articleCategories <", value, "articlecategories");
            return (Criteria) this;
        }

        public Criteria andArticlecategoriesLessThanOrEqualTo(String value) {
            addCriterion("articleCategories <=", value, "articlecategories");
            return (Criteria) this;
        }

        public Criteria andArticlecategoriesLike(String value) {
            addCriterion("articleCategories like", value, "articlecategories");
            return (Criteria) this;
        }

        public Criteria andArticlecategoriesNotLike(String value) {
            addCriterion("articleCategories not like", value, "articlecategories");
            return (Criteria) this;
        }

        public Criteria andArticlecategoriesIn(List<String> values) {
            addCriterion("articleCategories in", values, "articlecategories");
            return (Criteria) this;
        }

        public Criteria andArticlecategoriesNotIn(List<String> values) {
            addCriterion("articleCategories not in", values, "articlecategories");
            return (Criteria) this;
        }

        public Criteria andArticlecategoriesBetween(String value1, String value2) {
            addCriterion("articleCategories between", value1, value2, "articlecategories");
            return (Criteria) this;
        }

        public Criteria andArticlecategoriesNotBetween(String value1, String value2) {
            addCriterion("articleCategories not between", value1, value2, "articlecategories");
            return (Criteria) this;
        }

        public Criteria andPublishdateIsNull() {
            addCriterion("publishDate is null");
            return (Criteria) this;
        }

        public Criteria andPublishdateIsNotNull() {
            addCriterion("publishDate is not null");
            return (Criteria) this;
        }

        public Criteria andPublishdateEqualTo(String value) {
            addCriterion("publishDate =", value, "publishdate");
            return (Criteria) this;
        }

        public Criteria andPublishdateNotEqualTo(String value) {
            addCriterion("publishDate <>", value, "publishdate");
            return (Criteria) this;
        }

        public Criteria andPublishdateGreaterThan(String value) {
            addCriterion("publishDate >", value, "publishdate");
            return (Criteria) this;
        }

        public Criteria andPublishdateGreaterThanOrEqualTo(String value) {
            addCriterion("publishDate >=", value, "publishdate");
            return (Criteria) this;
        }

        public Criteria andPublishdateLessThan(String value) {
            addCriterion("publishDate <", value, "publishdate");
            return (Criteria) this;
        }

        public Criteria andPublishdateLessThanOrEqualTo(String value) {
            addCriterion("publishDate <=", value, "publishdate");
            return (Criteria) this;
        }

        public Criteria andPublishdateLike(String value) {
            addCriterion("publishDate like", value, "publishdate");
            return (Criteria) this;
        }

        public Criteria andPublishdateNotLike(String value) {
            addCriterion("publishDate not like", value, "publishdate");
            return (Criteria) this;
        }

        public Criteria andPublishdateIn(List<String> values) {
            addCriterion("publishDate in", values, "publishdate");
            return (Criteria) this;
        }

        public Criteria andPublishdateNotIn(List<String> values) {
            addCriterion("publishDate not in", values, "publishdate");
            return (Criteria) this;
        }

        public Criteria andPublishdateBetween(String value1, String value2) {
            addCriterion("publishDate between", value1, value2, "publishdate");
            return (Criteria) this;
        }

        public Criteria andPublishdateNotBetween(String value1, String value2) {
            addCriterion("publishDate not between", value1, value2, "publishdate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateIsNull() {
            addCriterion("updateDate is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedateIsNotNull() {
            addCriterion("updateDate is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedateEqualTo(String value) {
            addCriterion("updateDate =", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateNotEqualTo(String value) {
            addCriterion("updateDate <>", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateGreaterThan(String value) {
            addCriterion("updateDate >", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateGreaterThanOrEqualTo(String value) {
            addCriterion("updateDate >=", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateLessThan(String value) {
            addCriterion("updateDate <", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateLessThanOrEqualTo(String value) {
            addCriterion("updateDate <=", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateLike(String value) {
            addCriterion("updateDate like", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateNotLike(String value) {
            addCriterion("updateDate not like", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateIn(List<String> values) {
            addCriterion("updateDate in", values, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateNotIn(List<String> values) {
            addCriterion("updateDate not in", values, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateBetween(String value1, String value2) {
            addCriterion("updateDate between", value1, value2, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateNotBetween(String value1, String value2) {
            addCriterion("updateDate not between", value1, value2, "updatedate");
            return (Criteria) this;
        }

        public Criteria andArticleurlIsNull() {
            addCriterion("articleUrl is null");
            return (Criteria) this;
        }

        public Criteria andArticleurlIsNotNull() {
            addCriterion("articleUrl is not null");
            return (Criteria) this;
        }

        public Criteria andArticleurlEqualTo(String value) {
            addCriterion("articleUrl =", value, "articleurl");
            return (Criteria) this;
        }

        public Criteria andArticleurlNotEqualTo(String value) {
            addCriterion("articleUrl <>", value, "articleurl");
            return (Criteria) this;
        }

        public Criteria andArticleurlGreaterThan(String value) {
            addCriterion("articleUrl >", value, "articleurl");
            return (Criteria) this;
        }

        public Criteria andArticleurlGreaterThanOrEqualTo(String value) {
            addCriterion("articleUrl >=", value, "articleurl");
            return (Criteria) this;
        }

        public Criteria andArticleurlLessThan(String value) {
            addCriterion("articleUrl <", value, "articleurl");
            return (Criteria) this;
        }

        public Criteria andArticleurlLessThanOrEqualTo(String value) {
            addCriterion("articleUrl <=", value, "articleurl");
            return (Criteria) this;
        }

        public Criteria andArticleurlLike(String value) {
            addCriterion("articleUrl like", value, "articleurl");
            return (Criteria) this;
        }

        public Criteria andArticleurlNotLike(String value) {
            addCriterion("articleUrl not like", value, "articleurl");
            return (Criteria) this;
        }

        public Criteria andArticleurlIn(List<String> values) {
            addCriterion("articleUrl in", values, "articleurl");
            return (Criteria) this;
        }

        public Criteria andArticleurlNotIn(List<String> values) {
            addCriterion("articleUrl not in", values, "articleurl");
            return (Criteria) this;
        }

        public Criteria andArticleurlBetween(String value1, String value2) {
            addCriterion("articleUrl between", value1, value2, "articleurl");
            return (Criteria) this;
        }

        public Criteria andArticleurlNotBetween(String value1, String value2) {
            addCriterion("articleUrl not between", value1, value2, "articleurl");
            return (Criteria) this;
        }

        public Criteria andLikesIsNull() {
            addCriterion("likes is null");
            return (Criteria) this;
        }

        public Criteria andLikesIsNotNull() {
            addCriterion("likes is not null");
            return (Criteria) this;
        }

        public Criteria andLikesEqualTo(Integer value) {
            addCriterion("likes =", value, "likes");
            return (Criteria) this;
        }

        public Criteria andLikesNotEqualTo(Integer value) {
            addCriterion("likes <>", value, "likes");
            return (Criteria) this;
        }

        public Criteria andLikesGreaterThan(Integer value) {
            addCriterion("likes >", value, "likes");
            return (Criteria) this;
        }

        public Criteria andLikesGreaterThanOrEqualTo(Integer value) {
            addCriterion("likes >=", value, "likes");
            return (Criteria) this;
        }

        public Criteria andLikesLessThan(Integer value) {
            addCriterion("likes <", value, "likes");
            return (Criteria) this;
        }

        public Criteria andLikesLessThanOrEqualTo(Integer value) {
            addCriterion("likes <=", value, "likes");
            return (Criteria) this;
        }

        public Criteria andLikesIn(List<Integer> values) {
            addCriterion("likes in", values, "likes");
            return (Criteria) this;
        }

        public Criteria andLikesNotIn(List<Integer> values) {
            addCriterion("likes not in", values, "likes");
            return (Criteria) this;
        }

        public Criteria andLikesBetween(Integer value1, Integer value2) {
            addCriterion("likes between", value1, value2, "likes");
            return (Criteria) this;
        }

        public Criteria andLikesNotBetween(Integer value1, Integer value2) {
            addCriterion("likes not between", value1, value2, "likes");
            return (Criteria) this;
        }

        public Criteria andLastarticleidIsNull() {
            addCriterion("lastArticleId is null");
            return (Criteria) this;
        }

        public Criteria andLastarticleidIsNotNull() {
            addCriterion("lastArticleId is not null");
            return (Criteria) this;
        }

        public Criteria andLastarticleidEqualTo(Long value) {
            addCriterion("lastArticleId =", value, "lastarticleid");
            return (Criteria) this;
        }

        public Criteria andLastarticleidNotEqualTo(Long value) {
            addCriterion("lastArticleId <>", value, "lastarticleid");
            return (Criteria) this;
        }

        public Criteria andLastarticleidGreaterThan(Long value) {
            addCriterion("lastArticleId >", value, "lastarticleid");
            return (Criteria) this;
        }

        public Criteria andLastarticleidGreaterThanOrEqualTo(Long value) {
            addCriterion("lastArticleId >=", value, "lastarticleid");
            return (Criteria) this;
        }

        public Criteria andLastarticleidLessThan(Long value) {
            addCriterion("lastArticleId <", value, "lastarticleid");
            return (Criteria) this;
        }

        public Criteria andLastarticleidLessThanOrEqualTo(Long value) {
            addCriterion("lastArticleId <=", value, "lastarticleid");
            return (Criteria) this;
        }

        public Criteria andLastarticleidIn(List<Long> values) {
            addCriterion("lastArticleId in", values, "lastarticleid");
            return (Criteria) this;
        }

        public Criteria andLastarticleidNotIn(List<Long> values) {
            addCriterion("lastArticleId not in", values, "lastarticleid");
            return (Criteria) this;
        }

        public Criteria andLastarticleidBetween(Long value1, Long value2) {
            addCriterion("lastArticleId between", value1, value2, "lastarticleid");
            return (Criteria) this;
        }

        public Criteria andLastarticleidNotBetween(Long value1, Long value2) {
            addCriterion("lastArticleId not between", value1, value2, "lastarticleid");
            return (Criteria) this;
        }

        public Criteria andNextarticleidIsNull() {
            addCriterion("nextArticleId is null");
            return (Criteria) this;
        }

        public Criteria andNextarticleidIsNotNull() {
            addCriterion("nextArticleId is not null");
            return (Criteria) this;
        }

        public Criteria andNextarticleidEqualTo(Long value) {
            addCriterion("nextArticleId =", value, "nextarticleid");
            return (Criteria) this;
        }

        public Criteria andNextarticleidNotEqualTo(Long value) {
            addCriterion("nextArticleId <>", value, "nextarticleid");
            return (Criteria) this;
        }

        public Criteria andNextarticleidGreaterThan(Long value) {
            addCriterion("nextArticleId >", value, "nextarticleid");
            return (Criteria) this;
        }

        public Criteria andNextarticleidGreaterThanOrEqualTo(Long value) {
            addCriterion("nextArticleId >=", value, "nextarticleid");
            return (Criteria) this;
        }

        public Criteria andNextarticleidLessThan(Long value) {
            addCriterion("nextArticleId <", value, "nextarticleid");
            return (Criteria) this;
        }

        public Criteria andNextarticleidLessThanOrEqualTo(Long value) {
            addCriterion("nextArticleId <=", value, "nextarticleid");
            return (Criteria) this;
        }

        public Criteria andNextarticleidIn(List<Long> values) {
            addCriterion("nextArticleId in", values, "nextarticleid");
            return (Criteria) this;
        }

        public Criteria andNextarticleidNotIn(List<Long> values) {
            addCriterion("nextArticleId not in", values, "nextarticleid");
            return (Criteria) this;
        }

        public Criteria andNextarticleidBetween(Long value1, Long value2) {
            addCriterion("nextArticleId between", value1, value2, "nextarticleid");
            return (Criteria) this;
        }

        public Criteria andNextarticleidNotBetween(Long value1, Long value2) {
            addCriterion("nextArticleId not between", value1, value2, "nextarticleid");
            return (Criteria) this;
        }

        public Criteria andIsActiveIsNull() {
            addCriterion("is_active is null");
            return (Criteria) this;
        }

        public Criteria andIsActiveIsNotNull() {
            addCriterion("is_active is not null");
            return (Criteria) this;
        }

        public Criteria andIsActiveEqualTo(Integer value) {
            addCriterion("is_active =", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveNotEqualTo(Integer value) {
            addCriterion("is_active <>", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveGreaterThan(Integer value) {
            addCriterion("is_active >", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_active >=", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveLessThan(Integer value) {
            addCriterion("is_active <", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveLessThanOrEqualTo(Integer value) {
            addCriterion("is_active <=", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveIn(List<Integer> values) {
            addCriterion("is_active in", values, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveNotIn(List<Integer> values) {
            addCriterion("is_active not in", values, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveBetween(Integer value1, Integer value2) {
            addCriterion("is_active between", value1, value2, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveNotBetween(Integer value1, Integer value2) {
            addCriterion("is_active not between", value1, value2, "isActive");
            return (Criteria) this;
        }

        public Criteria andAuthoridIsNull() {
            addCriterion("authorId is null");
            return (Criteria) this;
        }

        public Criteria andAuthoridIsNotNull() {
            addCriterion("authorId is not null");
            return (Criteria) this;
        }

        public Criteria andAuthoridEqualTo(Integer value) {
            addCriterion("authorId =", value, "authorid");
            return (Criteria) this;
        }

        public Criteria andAuthoridNotEqualTo(Integer value) {
            addCriterion("authorId <>", value, "authorid");
            return (Criteria) this;
        }

        public Criteria andAuthoridGreaterThan(Integer value) {
            addCriterion("authorId >", value, "authorid");
            return (Criteria) this;
        }

        public Criteria andAuthoridGreaterThanOrEqualTo(Integer value) {
            addCriterion("authorId >=", value, "authorid");
            return (Criteria) this;
        }

        public Criteria andAuthoridLessThan(Integer value) {
            addCriterion("authorId <", value, "authorid");
            return (Criteria) this;
        }

        public Criteria andAuthoridLessThanOrEqualTo(Integer value) {
            addCriterion("authorId <=", value, "authorid");
            return (Criteria) this;
        }

        public Criteria andAuthoridIn(List<Integer> values) {
            addCriterion("authorId in", values, "authorid");
            return (Criteria) this;
        }

        public Criteria andAuthoridNotIn(List<Integer> values) {
            addCriterion("authorId not in", values, "authorid");
            return (Criteria) this;
        }

        public Criteria andAuthoridBetween(Integer value1, Integer value2) {
            addCriterion("authorId between", value1, value2, "authorid");
            return (Criteria) this;
        }

        public Criteria andAuthoridNotBetween(Integer value1, Integer value2) {
            addCriterion("authorId not between", value1, value2, "authorid");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}