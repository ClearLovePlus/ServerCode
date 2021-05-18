package com.chenhao.dao.entity;

import java.util.ArrayList;
import java.util.List;

public class CommentRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommentRecordExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPidIsNull() {
            addCriterion("pId is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("pId is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(Long value) {
            addCriterion("pId =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(Long value) {
            addCriterion("pId <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(Long value) {
            addCriterion("pId >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(Long value) {
            addCriterion("pId >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(Long value) {
            addCriterion("pId <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(Long value) {
            addCriterion("pId <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<Long> values) {
            addCriterion("pId in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<Long> values) {
            addCriterion("pId not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(Long value1, Long value2) {
            addCriterion("pId between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(Long value1, Long value2) {
            addCriterion("pId not between", value1, value2, "pid");
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

        public Criteria andAnswereridIsNull() {
            addCriterion("answererId is null");
            return (Criteria) this;
        }

        public Criteria andAnswereridIsNotNull() {
            addCriterion("answererId is not null");
            return (Criteria) this;
        }

        public Criteria andAnswereridEqualTo(Integer value) {
            addCriterion("answererId =", value, "answererid");
            return (Criteria) this;
        }

        public Criteria andAnswereridNotEqualTo(Integer value) {
            addCriterion("answererId <>", value, "answererid");
            return (Criteria) this;
        }

        public Criteria andAnswereridGreaterThan(Integer value) {
            addCriterion("answererId >", value, "answererid");
            return (Criteria) this;
        }

        public Criteria andAnswereridGreaterThanOrEqualTo(Integer value) {
            addCriterion("answererId >=", value, "answererid");
            return (Criteria) this;
        }

        public Criteria andAnswereridLessThan(Integer value) {
            addCriterion("answererId <", value, "answererid");
            return (Criteria) this;
        }

        public Criteria andAnswereridLessThanOrEqualTo(Integer value) {
            addCriterion("answererId <=", value, "answererid");
            return (Criteria) this;
        }

        public Criteria andAnswereridIn(List<Integer> values) {
            addCriterion("answererId in", values, "answererid");
            return (Criteria) this;
        }

        public Criteria andAnswereridNotIn(List<Integer> values) {
            addCriterion("answererId not in", values, "answererid");
            return (Criteria) this;
        }

        public Criteria andAnswereridBetween(Integer value1, Integer value2) {
            addCriterion("answererId between", value1, value2, "answererid");
            return (Criteria) this;
        }

        public Criteria andAnswereridNotBetween(Integer value1, Integer value2) {
            addCriterion("answererId not between", value1, value2, "answererid");
            return (Criteria) this;
        }

        public Criteria andRespondentidIsNull() {
            addCriterion("respondentId is null");
            return (Criteria) this;
        }

        public Criteria andRespondentidIsNotNull() {
            addCriterion("respondentId is not null");
            return (Criteria) this;
        }

        public Criteria andRespondentidEqualTo(Integer value) {
            addCriterion("respondentId =", value, "respondentid");
            return (Criteria) this;
        }

        public Criteria andRespondentidNotEqualTo(Integer value) {
            addCriterion("respondentId <>", value, "respondentid");
            return (Criteria) this;
        }

        public Criteria andRespondentidGreaterThan(Integer value) {
            addCriterion("respondentId >", value, "respondentid");
            return (Criteria) this;
        }

        public Criteria andRespondentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("respondentId >=", value, "respondentid");
            return (Criteria) this;
        }

        public Criteria andRespondentidLessThan(Integer value) {
            addCriterion("respondentId <", value, "respondentid");
            return (Criteria) this;
        }

        public Criteria andRespondentidLessThanOrEqualTo(Integer value) {
            addCriterion("respondentId <=", value, "respondentid");
            return (Criteria) this;
        }

        public Criteria andRespondentidIn(List<Integer> values) {
            addCriterion("respondentId in", values, "respondentid");
            return (Criteria) this;
        }

        public Criteria andRespondentidNotIn(List<Integer> values) {
            addCriterion("respondentId not in", values, "respondentid");
            return (Criteria) this;
        }

        public Criteria andRespondentidBetween(Integer value1, Integer value2) {
            addCriterion("respondentId between", value1, value2, "respondentid");
            return (Criteria) this;
        }

        public Criteria andRespondentidNotBetween(Integer value1, Integer value2) {
            addCriterion("respondentId not between", value1, value2, "respondentid");
            return (Criteria) this;
        }

        public Criteria andCommentdateIsNull() {
            addCriterion("commentDate is null");
            return (Criteria) this;
        }

        public Criteria andCommentdateIsNotNull() {
            addCriterion("commentDate is not null");
            return (Criteria) this;
        }

        public Criteria andCommentdateEqualTo(String value) {
            addCriterion("commentDate =", value, "commentdate");
            return (Criteria) this;
        }

        public Criteria andCommentdateNotEqualTo(String value) {
            addCriterion("commentDate <>", value, "commentdate");
            return (Criteria) this;
        }

        public Criteria andCommentdateGreaterThan(String value) {
            addCriterion("commentDate >", value, "commentdate");
            return (Criteria) this;
        }

        public Criteria andCommentdateGreaterThanOrEqualTo(String value) {
            addCriterion("commentDate >=", value, "commentdate");
            return (Criteria) this;
        }

        public Criteria andCommentdateLessThan(String value) {
            addCriterion("commentDate <", value, "commentdate");
            return (Criteria) this;
        }

        public Criteria andCommentdateLessThanOrEqualTo(String value) {
            addCriterion("commentDate <=", value, "commentdate");
            return (Criteria) this;
        }

        public Criteria andCommentdateLike(String value) {
            addCriterion("commentDate like", value, "commentdate");
            return (Criteria) this;
        }

        public Criteria andCommentdateNotLike(String value) {
            addCriterion("commentDate not like", value, "commentdate");
            return (Criteria) this;
        }

        public Criteria andCommentdateIn(List<String> values) {
            addCriterion("commentDate in", values, "commentdate");
            return (Criteria) this;
        }

        public Criteria andCommentdateNotIn(List<String> values) {
            addCriterion("commentDate not in", values, "commentdate");
            return (Criteria) this;
        }

        public Criteria andCommentdateBetween(String value1, String value2) {
            addCriterion("commentDate between", value1, value2, "commentdate");
            return (Criteria) this;
        }

        public Criteria andCommentdateNotBetween(String value1, String value2) {
            addCriterion("commentDate not between", value1, value2, "commentdate");
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

        public Criteria andIsreadIsNull() {
            addCriterion("isRead is null");
            return (Criteria) this;
        }

        public Criteria andIsreadIsNotNull() {
            addCriterion("isRead is not null");
            return (Criteria) this;
        }

        public Criteria andIsreadEqualTo(Boolean value) {
            addCriterion("isRead =", value, "isread");
            return (Criteria) this;
        }

        public Criteria andIsreadNotEqualTo(Boolean value) {
            addCriterion("isRead <>", value, "isread");
            return (Criteria) this;
        }

        public Criteria andIsreadGreaterThan(Boolean value) {
            addCriterion("isRead >", value, "isread");
            return (Criteria) this;
        }

        public Criteria andIsreadGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isRead >=", value, "isread");
            return (Criteria) this;
        }

        public Criteria andIsreadLessThan(Boolean value) {
            addCriterion("isRead <", value, "isread");
            return (Criteria) this;
        }

        public Criteria andIsreadLessThanOrEqualTo(Boolean value) {
            addCriterion("isRead <=", value, "isread");
            return (Criteria) this;
        }

        public Criteria andIsreadIn(List<Boolean> values) {
            addCriterion("isRead in", values, "isread");
            return (Criteria) this;
        }

        public Criteria andIsreadNotIn(List<Boolean> values) {
            addCriterion("isRead not in", values, "isread");
            return (Criteria) this;
        }

        public Criteria andIsreadBetween(Boolean value1, Boolean value2) {
            addCriterion("isRead between", value1, value2, "isread");
            return (Criteria) this;
        }

        public Criteria andIsreadNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isRead not between", value1, value2, "isread");
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