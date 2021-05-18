package com.chenhao.dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RewardExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RewardExample() {
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

        public Criteria andFundraiserIsNull() {
            addCriterion("fundRaiser is null");
            return (Criteria) this;
        }

        public Criteria andFundraiserIsNotNull() {
            addCriterion("fundRaiser is not null");
            return (Criteria) this;
        }

        public Criteria andFundraiserEqualTo(String value) {
            addCriterion("fundRaiser =", value, "fundraiser");
            return (Criteria) this;
        }

        public Criteria andFundraiserNotEqualTo(String value) {
            addCriterion("fundRaiser <>", value, "fundraiser");
            return (Criteria) this;
        }

        public Criteria andFundraiserGreaterThan(String value) {
            addCriterion("fundRaiser >", value, "fundraiser");
            return (Criteria) this;
        }

        public Criteria andFundraiserGreaterThanOrEqualTo(String value) {
            addCriterion("fundRaiser >=", value, "fundraiser");
            return (Criteria) this;
        }

        public Criteria andFundraiserLessThan(String value) {
            addCriterion("fundRaiser <", value, "fundraiser");
            return (Criteria) this;
        }

        public Criteria andFundraiserLessThanOrEqualTo(String value) {
            addCriterion("fundRaiser <=", value, "fundraiser");
            return (Criteria) this;
        }

        public Criteria andFundraiserLike(String value) {
            addCriterion("fundRaiser like", value, "fundraiser");
            return (Criteria) this;
        }

        public Criteria andFundraiserNotLike(String value) {
            addCriterion("fundRaiser not like", value, "fundraiser");
            return (Criteria) this;
        }

        public Criteria andFundraiserIn(List<String> values) {
            addCriterion("fundRaiser in", values, "fundraiser");
            return (Criteria) this;
        }

        public Criteria andFundraiserNotIn(List<String> values) {
            addCriterion("fundRaiser not in", values, "fundraiser");
            return (Criteria) this;
        }

        public Criteria andFundraiserBetween(String value1, String value2) {
            addCriterion("fundRaiser between", value1, value2, "fundraiser");
            return (Criteria) this;
        }

        public Criteria andFundraiserNotBetween(String value1, String value2) {
            addCriterion("fundRaiser not between", value1, value2, "fundraiser");
            return (Criteria) this;
        }

        public Criteria andFundraisingsourcesIsNull() {
            addCriterion("fundRaisingSources is null");
            return (Criteria) this;
        }

        public Criteria andFundraisingsourcesIsNotNull() {
            addCriterion("fundRaisingSources is not null");
            return (Criteria) this;
        }

        public Criteria andFundraisingsourcesEqualTo(String value) {
            addCriterion("fundRaisingSources =", value, "fundraisingsources");
            return (Criteria) this;
        }

        public Criteria andFundraisingsourcesNotEqualTo(String value) {
            addCriterion("fundRaisingSources <>", value, "fundraisingsources");
            return (Criteria) this;
        }

        public Criteria andFundraisingsourcesGreaterThan(String value) {
            addCriterion("fundRaisingSources >", value, "fundraisingsources");
            return (Criteria) this;
        }

        public Criteria andFundraisingsourcesGreaterThanOrEqualTo(String value) {
            addCriterion("fundRaisingSources >=", value, "fundraisingsources");
            return (Criteria) this;
        }

        public Criteria andFundraisingsourcesLessThan(String value) {
            addCriterion("fundRaisingSources <", value, "fundraisingsources");
            return (Criteria) this;
        }

        public Criteria andFundraisingsourcesLessThanOrEqualTo(String value) {
            addCriterion("fundRaisingSources <=", value, "fundraisingsources");
            return (Criteria) this;
        }

        public Criteria andFundraisingsourcesLike(String value) {
            addCriterion("fundRaisingSources like", value, "fundraisingsources");
            return (Criteria) this;
        }

        public Criteria andFundraisingsourcesNotLike(String value) {
            addCriterion("fundRaisingSources not like", value, "fundraisingsources");
            return (Criteria) this;
        }

        public Criteria andFundraisingsourcesIn(List<String> values) {
            addCriterion("fundRaisingSources in", values, "fundraisingsources");
            return (Criteria) this;
        }

        public Criteria andFundraisingsourcesNotIn(List<String> values) {
            addCriterion("fundRaisingSources not in", values, "fundraisingsources");
            return (Criteria) this;
        }

        public Criteria andFundraisingsourcesBetween(String value1, String value2) {
            addCriterion("fundRaisingSources between", value1, value2, "fundraisingsources");
            return (Criteria) this;
        }

        public Criteria andFundraisingsourcesNotBetween(String value1, String value2) {
            addCriterion("fundRaisingSources not between", value1, value2, "fundraisingsources");
            return (Criteria) this;
        }

        public Criteria andFundraisingplaceIsNull() {
            addCriterion("fundraisingPlace is null");
            return (Criteria) this;
        }

        public Criteria andFundraisingplaceIsNotNull() {
            addCriterion("fundraisingPlace is not null");
            return (Criteria) this;
        }

        public Criteria andFundraisingplaceEqualTo(String value) {
            addCriterion("fundraisingPlace =", value, "fundraisingplace");
            return (Criteria) this;
        }

        public Criteria andFundraisingplaceNotEqualTo(String value) {
            addCriterion("fundraisingPlace <>", value, "fundraisingplace");
            return (Criteria) this;
        }

        public Criteria andFundraisingplaceGreaterThan(String value) {
            addCriterion("fundraisingPlace >", value, "fundraisingplace");
            return (Criteria) this;
        }

        public Criteria andFundraisingplaceGreaterThanOrEqualTo(String value) {
            addCriterion("fundraisingPlace >=", value, "fundraisingplace");
            return (Criteria) this;
        }

        public Criteria andFundraisingplaceLessThan(String value) {
            addCriterion("fundraisingPlace <", value, "fundraisingplace");
            return (Criteria) this;
        }

        public Criteria andFundraisingplaceLessThanOrEqualTo(String value) {
            addCriterion("fundraisingPlace <=", value, "fundraisingplace");
            return (Criteria) this;
        }

        public Criteria andFundraisingplaceLike(String value) {
            addCriterion("fundraisingPlace like", value, "fundraisingplace");
            return (Criteria) this;
        }

        public Criteria andFundraisingplaceNotLike(String value) {
            addCriterion("fundraisingPlace not like", value, "fundraisingplace");
            return (Criteria) this;
        }

        public Criteria andFundraisingplaceIn(List<String> values) {
            addCriterion("fundraisingPlace in", values, "fundraisingplace");
            return (Criteria) this;
        }

        public Criteria andFundraisingplaceNotIn(List<String> values) {
            addCriterion("fundraisingPlace not in", values, "fundraisingplace");
            return (Criteria) this;
        }

        public Criteria andFundraisingplaceBetween(String value1, String value2) {
            addCriterion("fundraisingPlace between", value1, value2, "fundraisingplace");
            return (Criteria) this;
        }

        public Criteria andFundraisingplaceNotBetween(String value1, String value2) {
            addCriterion("fundraisingPlace not between", value1, value2, "fundraisingplace");
            return (Criteria) this;
        }

        public Criteria andRewardmoneyIsNull() {
            addCriterion("rewardMoney is null");
            return (Criteria) this;
        }

        public Criteria andRewardmoneyIsNotNull() {
            addCriterion("rewardMoney is not null");
            return (Criteria) this;
        }

        public Criteria andRewardmoneyEqualTo(Float value) {
            addCriterion("rewardMoney =", value, "rewardmoney");
            return (Criteria) this;
        }

        public Criteria andRewardmoneyNotEqualTo(Float value) {
            addCriterion("rewardMoney <>", value, "rewardmoney");
            return (Criteria) this;
        }

        public Criteria andRewardmoneyGreaterThan(Float value) {
            addCriterion("rewardMoney >", value, "rewardmoney");
            return (Criteria) this;
        }

        public Criteria andRewardmoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("rewardMoney >=", value, "rewardmoney");
            return (Criteria) this;
        }

        public Criteria andRewardmoneyLessThan(Float value) {
            addCriterion("rewardMoney <", value, "rewardmoney");
            return (Criteria) this;
        }

        public Criteria andRewardmoneyLessThanOrEqualTo(Float value) {
            addCriterion("rewardMoney <=", value, "rewardmoney");
            return (Criteria) this;
        }

        public Criteria andRewardmoneyIn(List<Float> values) {
            addCriterion("rewardMoney in", values, "rewardmoney");
            return (Criteria) this;
        }

        public Criteria andRewardmoneyNotIn(List<Float> values) {
            addCriterion("rewardMoney not in", values, "rewardmoney");
            return (Criteria) this;
        }

        public Criteria andRewardmoneyBetween(Float value1, Float value2) {
            addCriterion("rewardMoney between", value1, value2, "rewardmoney");
            return (Criteria) this;
        }

        public Criteria andRewardmoneyNotBetween(Float value1, Float value2) {
            addCriterion("rewardMoney not between", value1, value2, "rewardmoney");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRewarddateIsNull() {
            addCriterion("rewardDate is null");
            return (Criteria) this;
        }

        public Criteria andRewarddateIsNotNull() {
            addCriterion("rewardDate is not null");
            return (Criteria) this;
        }

        public Criteria andRewarddateEqualTo(Date value) {
            addCriterion("rewardDate =", value, "rewarddate");
            return (Criteria) this;
        }

        public Criteria andRewarddateNotEqualTo(Date value) {
            addCriterion("rewardDate <>", value, "rewarddate");
            return (Criteria) this;
        }

        public Criteria andRewarddateGreaterThan(Date value) {
            addCriterion("rewardDate >", value, "rewarddate");
            return (Criteria) this;
        }

        public Criteria andRewarddateGreaterThanOrEqualTo(Date value) {
            addCriterion("rewardDate >=", value, "rewarddate");
            return (Criteria) this;
        }

        public Criteria andRewarddateLessThan(Date value) {
            addCriterion("rewardDate <", value, "rewarddate");
            return (Criteria) this;
        }

        public Criteria andRewarddateLessThanOrEqualTo(Date value) {
            addCriterion("rewardDate <=", value, "rewarddate");
            return (Criteria) this;
        }

        public Criteria andRewarddateIn(List<Date> values) {
            addCriterion("rewardDate in", values, "rewarddate");
            return (Criteria) this;
        }

        public Criteria andRewarddateNotIn(List<Date> values) {
            addCriterion("rewardDate not in", values, "rewarddate");
            return (Criteria) this;
        }

        public Criteria andRewarddateBetween(Date value1, Date value2) {
            addCriterion("rewardDate between", value1, value2, "rewarddate");
            return (Criteria) this;
        }

        public Criteria andRewarddateNotBetween(Date value1, Date value2) {
            addCriterion("rewardDate not between", value1, value2, "rewarddate");
            return (Criteria) this;
        }

        public Criteria andRewardurlIsNull() {
            addCriterion("rewardUrl is null");
            return (Criteria) this;
        }

        public Criteria andRewardurlIsNotNull() {
            addCriterion("rewardUrl is not null");
            return (Criteria) this;
        }

        public Criteria andRewardurlEqualTo(String value) {
            addCriterion("rewardUrl =", value, "rewardurl");
            return (Criteria) this;
        }

        public Criteria andRewardurlNotEqualTo(String value) {
            addCriterion("rewardUrl <>", value, "rewardurl");
            return (Criteria) this;
        }

        public Criteria andRewardurlGreaterThan(String value) {
            addCriterion("rewardUrl >", value, "rewardurl");
            return (Criteria) this;
        }

        public Criteria andRewardurlGreaterThanOrEqualTo(String value) {
            addCriterion("rewardUrl >=", value, "rewardurl");
            return (Criteria) this;
        }

        public Criteria andRewardurlLessThan(String value) {
            addCriterion("rewardUrl <", value, "rewardurl");
            return (Criteria) this;
        }

        public Criteria andRewardurlLessThanOrEqualTo(String value) {
            addCriterion("rewardUrl <=", value, "rewardurl");
            return (Criteria) this;
        }

        public Criteria andRewardurlLike(String value) {
            addCriterion("rewardUrl like", value, "rewardurl");
            return (Criteria) this;
        }

        public Criteria andRewardurlNotLike(String value) {
            addCriterion("rewardUrl not like", value, "rewardurl");
            return (Criteria) this;
        }

        public Criteria andRewardurlIn(List<String> values) {
            addCriterion("rewardUrl in", values, "rewardurl");
            return (Criteria) this;
        }

        public Criteria andRewardurlNotIn(List<String> values) {
            addCriterion("rewardUrl not in", values, "rewardurl");
            return (Criteria) this;
        }

        public Criteria andRewardurlBetween(String value1, String value2) {
            addCriterion("rewardUrl between", value1, value2, "rewardurl");
            return (Criteria) this;
        }

        public Criteria andRewardurlNotBetween(String value1, String value2) {
            addCriterion("rewardUrl not between", value1, value2, "rewardurl");
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