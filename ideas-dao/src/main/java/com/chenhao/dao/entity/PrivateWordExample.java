package com.chenhao.dao.entity;

import java.util.ArrayList;
import java.util.List;

public class PrivateWordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PrivateWordExample() {
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

        public Criteria andPrivatewordIsNull() {
            addCriterion("privateWord is null");
            return (Criteria) this;
        }

        public Criteria andPrivatewordIsNotNull() {
            addCriterion("privateWord is not null");
            return (Criteria) this;
        }

        public Criteria andPrivatewordEqualTo(String value) {
            addCriterion("privateWord =", value, "privateword");
            return (Criteria) this;
        }

        public Criteria andPrivatewordNotEqualTo(String value) {
            addCriterion("privateWord <>", value, "privateword");
            return (Criteria) this;
        }

        public Criteria andPrivatewordGreaterThan(String value) {
            addCriterion("privateWord >", value, "privateword");
            return (Criteria) this;
        }

        public Criteria andPrivatewordGreaterThanOrEqualTo(String value) {
            addCriterion("privateWord >=", value, "privateword");
            return (Criteria) this;
        }

        public Criteria andPrivatewordLessThan(String value) {
            addCriterion("privateWord <", value, "privateword");
            return (Criteria) this;
        }

        public Criteria andPrivatewordLessThanOrEqualTo(String value) {
            addCriterion("privateWord <=", value, "privateword");
            return (Criteria) this;
        }

        public Criteria andPrivatewordLike(String value) {
            addCriterion("privateWord like", value, "privateword");
            return (Criteria) this;
        }

        public Criteria andPrivatewordNotLike(String value) {
            addCriterion("privateWord not like", value, "privateword");
            return (Criteria) this;
        }

        public Criteria andPrivatewordIn(List<String> values) {
            addCriterion("privateWord in", values, "privateword");
            return (Criteria) this;
        }

        public Criteria andPrivatewordNotIn(List<String> values) {
            addCriterion("privateWord not in", values, "privateword");
            return (Criteria) this;
        }

        public Criteria andPrivatewordBetween(String value1, String value2) {
            addCriterion("privateWord between", value1, value2, "privateword");
            return (Criteria) this;
        }

        public Criteria andPrivatewordNotBetween(String value1, String value2) {
            addCriterion("privateWord not between", value1, value2, "privateword");
            return (Criteria) this;
        }

        public Criteria andPublisheridIsNull() {
            addCriterion("publisherId is null");
            return (Criteria) this;
        }

        public Criteria andPublisheridIsNotNull() {
            addCriterion("publisherId is not null");
            return (Criteria) this;
        }

        public Criteria andPublisheridEqualTo(String value) {
            addCriterion("publisherId =", value, "publisherid");
            return (Criteria) this;
        }

        public Criteria andPublisheridNotEqualTo(String value) {
            addCriterion("publisherId <>", value, "publisherid");
            return (Criteria) this;
        }

        public Criteria andPublisheridGreaterThan(String value) {
            addCriterion("publisherId >", value, "publisherid");
            return (Criteria) this;
        }

        public Criteria andPublisheridGreaterThanOrEqualTo(String value) {
            addCriterion("publisherId >=", value, "publisherid");
            return (Criteria) this;
        }

        public Criteria andPublisheridLessThan(String value) {
            addCriterion("publisherId <", value, "publisherid");
            return (Criteria) this;
        }

        public Criteria andPublisheridLessThanOrEqualTo(String value) {
            addCriterion("publisherId <=", value, "publisherid");
            return (Criteria) this;
        }

        public Criteria andPublisheridLike(String value) {
            addCriterion("publisherId like", value, "publisherid");
            return (Criteria) this;
        }

        public Criteria andPublisheridNotLike(String value) {
            addCriterion("publisherId not like", value, "publisherid");
            return (Criteria) this;
        }

        public Criteria andPublisheridIn(List<String> values) {
            addCriterion("publisherId in", values, "publisherid");
            return (Criteria) this;
        }

        public Criteria andPublisheridNotIn(List<String> values) {
            addCriterion("publisherId not in", values, "publisherid");
            return (Criteria) this;
        }

        public Criteria andPublisheridBetween(String value1, String value2) {
            addCriterion("publisherId between", value1, value2, "publisherid");
            return (Criteria) this;
        }

        public Criteria andPublisheridNotBetween(String value1, String value2) {
            addCriterion("publisherId not between", value1, value2, "publisherid");
            return (Criteria) this;
        }

        public Criteria andReplieridIsNull() {
            addCriterion("replierId is null");
            return (Criteria) this;
        }

        public Criteria andReplieridIsNotNull() {
            addCriterion("replierId is not null");
            return (Criteria) this;
        }

        public Criteria andReplieridEqualTo(String value) {
            addCriterion("replierId =", value, "replierid");
            return (Criteria) this;
        }

        public Criteria andReplieridNotEqualTo(String value) {
            addCriterion("replierId <>", value, "replierid");
            return (Criteria) this;
        }

        public Criteria andReplieridGreaterThan(String value) {
            addCriterion("replierId >", value, "replierid");
            return (Criteria) this;
        }

        public Criteria andReplieridGreaterThanOrEqualTo(String value) {
            addCriterion("replierId >=", value, "replierid");
            return (Criteria) this;
        }

        public Criteria andReplieridLessThan(String value) {
            addCriterion("replierId <", value, "replierid");
            return (Criteria) this;
        }

        public Criteria andReplieridLessThanOrEqualTo(String value) {
            addCriterion("replierId <=", value, "replierid");
            return (Criteria) this;
        }

        public Criteria andReplieridLike(String value) {
            addCriterion("replierId like", value, "replierid");
            return (Criteria) this;
        }

        public Criteria andReplieridNotLike(String value) {
            addCriterion("replierId not like", value, "replierid");
            return (Criteria) this;
        }

        public Criteria andReplieridIn(List<String> values) {
            addCriterion("replierId in", values, "replierid");
            return (Criteria) this;
        }

        public Criteria andReplieridNotIn(List<String> values) {
            addCriterion("replierId not in", values, "replierid");
            return (Criteria) this;
        }

        public Criteria andReplieridBetween(String value1, String value2) {
            addCriterion("replierId between", value1, value2, "replierid");
            return (Criteria) this;
        }

        public Criteria andReplieridNotBetween(String value1, String value2) {
            addCriterion("replierId not between", value1, value2, "replierid");
            return (Criteria) this;
        }

        public Criteria andReplycontentIsNull() {
            addCriterion("replyContent is null");
            return (Criteria) this;
        }

        public Criteria andReplycontentIsNotNull() {
            addCriterion("replyContent is not null");
            return (Criteria) this;
        }

        public Criteria andReplycontentEqualTo(String value) {
            addCriterion("replyContent =", value, "replycontent");
            return (Criteria) this;
        }

        public Criteria andReplycontentNotEqualTo(String value) {
            addCriterion("replyContent <>", value, "replycontent");
            return (Criteria) this;
        }

        public Criteria andReplycontentGreaterThan(String value) {
            addCriterion("replyContent >", value, "replycontent");
            return (Criteria) this;
        }

        public Criteria andReplycontentGreaterThanOrEqualTo(String value) {
            addCriterion("replyContent >=", value, "replycontent");
            return (Criteria) this;
        }

        public Criteria andReplycontentLessThan(String value) {
            addCriterion("replyContent <", value, "replycontent");
            return (Criteria) this;
        }

        public Criteria andReplycontentLessThanOrEqualTo(String value) {
            addCriterion("replyContent <=", value, "replycontent");
            return (Criteria) this;
        }

        public Criteria andReplycontentLike(String value) {
            addCriterion("replyContent like", value, "replycontent");
            return (Criteria) this;
        }

        public Criteria andReplycontentNotLike(String value) {
            addCriterion("replyContent not like", value, "replycontent");
            return (Criteria) this;
        }

        public Criteria andReplycontentIn(List<String> values) {
            addCriterion("replyContent in", values, "replycontent");
            return (Criteria) this;
        }

        public Criteria andReplycontentNotIn(List<String> values) {
            addCriterion("replyContent not in", values, "replycontent");
            return (Criteria) this;
        }

        public Criteria andReplycontentBetween(String value1, String value2) {
            addCriterion("replyContent between", value1, value2, "replycontent");
            return (Criteria) this;
        }

        public Criteria andReplycontentNotBetween(String value1, String value2) {
            addCriterion("replyContent not between", value1, value2, "replycontent");
            return (Criteria) this;
        }

        public Criteria andPublisherdateIsNull() {
            addCriterion("publisherDate is null");
            return (Criteria) this;
        }

        public Criteria andPublisherdateIsNotNull() {
            addCriterion("publisherDate is not null");
            return (Criteria) this;
        }

        public Criteria andPublisherdateEqualTo(String value) {
            addCriterion("publisherDate =", value, "publisherdate");
            return (Criteria) this;
        }

        public Criteria andPublisherdateNotEqualTo(String value) {
            addCriterion("publisherDate <>", value, "publisherdate");
            return (Criteria) this;
        }

        public Criteria andPublisherdateGreaterThan(String value) {
            addCriterion("publisherDate >", value, "publisherdate");
            return (Criteria) this;
        }

        public Criteria andPublisherdateGreaterThanOrEqualTo(String value) {
            addCriterion("publisherDate >=", value, "publisherdate");
            return (Criteria) this;
        }

        public Criteria andPublisherdateLessThan(String value) {
            addCriterion("publisherDate <", value, "publisherdate");
            return (Criteria) this;
        }

        public Criteria andPublisherdateLessThanOrEqualTo(String value) {
            addCriterion("publisherDate <=", value, "publisherdate");
            return (Criteria) this;
        }

        public Criteria andPublisherdateLike(String value) {
            addCriterion("publisherDate like", value, "publisherdate");
            return (Criteria) this;
        }

        public Criteria andPublisherdateNotLike(String value) {
            addCriterion("publisherDate not like", value, "publisherdate");
            return (Criteria) this;
        }

        public Criteria andPublisherdateIn(List<String> values) {
            addCriterion("publisherDate in", values, "publisherdate");
            return (Criteria) this;
        }

        public Criteria andPublisherdateNotIn(List<String> values) {
            addCriterion("publisherDate not in", values, "publisherdate");
            return (Criteria) this;
        }

        public Criteria andPublisherdateBetween(String value1, String value2) {
            addCriterion("publisherDate between", value1, value2, "publisherdate");
            return (Criteria) this;
        }

        public Criteria andPublisherdateNotBetween(String value1, String value2) {
            addCriterion("publisherDate not between", value1, value2, "publisherdate");
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