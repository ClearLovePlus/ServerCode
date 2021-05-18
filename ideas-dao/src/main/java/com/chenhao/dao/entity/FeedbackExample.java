package com.chenhao.dao.entity;

import java.util.ArrayList;
import java.util.List;

public class FeedbackExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FeedbackExample() {
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

        public Criteria andContactinfoIsNull() {
            addCriterion("contactInfo is null");
            return (Criteria) this;
        }

        public Criteria andContactinfoIsNotNull() {
            addCriterion("contactInfo is not null");
            return (Criteria) this;
        }

        public Criteria andContactinfoEqualTo(String value) {
            addCriterion("contactInfo =", value, "contactinfo");
            return (Criteria) this;
        }

        public Criteria andContactinfoNotEqualTo(String value) {
            addCriterion("contactInfo <>", value, "contactinfo");
            return (Criteria) this;
        }

        public Criteria andContactinfoGreaterThan(String value) {
            addCriterion("contactInfo >", value, "contactinfo");
            return (Criteria) this;
        }

        public Criteria andContactinfoGreaterThanOrEqualTo(String value) {
            addCriterion("contactInfo >=", value, "contactinfo");
            return (Criteria) this;
        }

        public Criteria andContactinfoLessThan(String value) {
            addCriterion("contactInfo <", value, "contactinfo");
            return (Criteria) this;
        }

        public Criteria andContactinfoLessThanOrEqualTo(String value) {
            addCriterion("contactInfo <=", value, "contactinfo");
            return (Criteria) this;
        }

        public Criteria andContactinfoLike(String value) {
            addCriterion("contactInfo like", value, "contactinfo");
            return (Criteria) this;
        }

        public Criteria andContactinfoNotLike(String value) {
            addCriterion("contactInfo not like", value, "contactinfo");
            return (Criteria) this;
        }

        public Criteria andContactinfoIn(List<String> values) {
            addCriterion("contactInfo in", values, "contactinfo");
            return (Criteria) this;
        }

        public Criteria andContactinfoNotIn(List<String> values) {
            addCriterion("contactInfo not in", values, "contactinfo");
            return (Criteria) this;
        }

        public Criteria andContactinfoBetween(String value1, String value2) {
            addCriterion("contactInfo between", value1, value2, "contactinfo");
            return (Criteria) this;
        }

        public Criteria andContactinfoNotBetween(String value1, String value2) {
            addCriterion("contactInfo not between", value1, value2, "contactinfo");
            return (Criteria) this;
        }

        public Criteria andPersonidIsNull() {
            addCriterion("personId is null");
            return (Criteria) this;
        }

        public Criteria andPersonidIsNotNull() {
            addCriterion("personId is not null");
            return (Criteria) this;
        }

        public Criteria andPersonidEqualTo(Integer value) {
            addCriterion("personId =", value, "personid");
            return (Criteria) this;
        }

        public Criteria andPersonidNotEqualTo(Integer value) {
            addCriterion("personId <>", value, "personid");
            return (Criteria) this;
        }

        public Criteria andPersonidGreaterThan(Integer value) {
            addCriterion("personId >", value, "personid");
            return (Criteria) this;
        }

        public Criteria andPersonidGreaterThanOrEqualTo(Integer value) {
            addCriterion("personId >=", value, "personid");
            return (Criteria) this;
        }

        public Criteria andPersonidLessThan(Integer value) {
            addCriterion("personId <", value, "personid");
            return (Criteria) this;
        }

        public Criteria andPersonidLessThanOrEqualTo(Integer value) {
            addCriterion("personId <=", value, "personid");
            return (Criteria) this;
        }

        public Criteria andPersonidIn(List<Integer> values) {
            addCriterion("personId in", values, "personid");
            return (Criteria) this;
        }

        public Criteria andPersonidNotIn(List<Integer> values) {
            addCriterion("personId not in", values, "personid");
            return (Criteria) this;
        }

        public Criteria andPersonidBetween(Integer value1, Integer value2) {
            addCriterion("personId between", value1, value2, "personid");
            return (Criteria) this;
        }

        public Criteria andPersonidNotBetween(Integer value1, Integer value2) {
            addCriterion("personId not between", value1, value2, "personid");
            return (Criteria) this;
        }

        public Criteria andFeedbackdateIsNull() {
            addCriterion("feedbackDate is null");
            return (Criteria) this;
        }

        public Criteria andFeedbackdateIsNotNull() {
            addCriterion("feedbackDate is not null");
            return (Criteria) this;
        }

        public Criteria andFeedbackdateEqualTo(String value) {
            addCriterion("feedbackDate =", value, "feedbackdate");
            return (Criteria) this;
        }

        public Criteria andFeedbackdateNotEqualTo(String value) {
            addCriterion("feedbackDate <>", value, "feedbackdate");
            return (Criteria) this;
        }

        public Criteria andFeedbackdateGreaterThan(String value) {
            addCriterion("feedbackDate >", value, "feedbackdate");
            return (Criteria) this;
        }

        public Criteria andFeedbackdateGreaterThanOrEqualTo(String value) {
            addCriterion("feedbackDate >=", value, "feedbackdate");
            return (Criteria) this;
        }

        public Criteria andFeedbackdateLessThan(String value) {
            addCriterion("feedbackDate <", value, "feedbackdate");
            return (Criteria) this;
        }

        public Criteria andFeedbackdateLessThanOrEqualTo(String value) {
            addCriterion("feedbackDate <=", value, "feedbackdate");
            return (Criteria) this;
        }

        public Criteria andFeedbackdateLike(String value) {
            addCriterion("feedbackDate like", value, "feedbackdate");
            return (Criteria) this;
        }

        public Criteria andFeedbackdateNotLike(String value) {
            addCriterion("feedbackDate not like", value, "feedbackdate");
            return (Criteria) this;
        }

        public Criteria andFeedbackdateIn(List<String> values) {
            addCriterion("feedbackDate in", values, "feedbackdate");
            return (Criteria) this;
        }

        public Criteria andFeedbackdateNotIn(List<String> values) {
            addCriterion("feedbackDate not in", values, "feedbackdate");
            return (Criteria) this;
        }

        public Criteria andFeedbackdateBetween(String value1, String value2) {
            addCriterion("feedbackDate between", value1, value2, "feedbackdate");
            return (Criteria) this;
        }

        public Criteria andFeedbackdateNotBetween(String value1, String value2) {
            addCriterion("feedbackDate not between", value1, value2, "feedbackdate");
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