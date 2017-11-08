package com.zw.cf.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductExample() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andDooridIsNull() {
            addCriterion("doorId is null");
            return (Criteria) this;
        }

        public Criteria andDooridIsNotNull() {
            addCriterion("doorId is not null");
            return (Criteria) this;
        }

        public Criteria andDooridEqualTo(String value) {
            addCriterion("doorId =", value, "doorid");
            return (Criteria) this;
        }

        public Criteria andDooridNotEqualTo(String value) {
            addCriterion("doorId <>", value, "doorid");
            return (Criteria) this;
        }

        public Criteria andDooridGreaterThan(String value) {
            addCriterion("doorId >", value, "doorid");
            return (Criteria) this;
        }

        public Criteria andDooridGreaterThanOrEqualTo(String value) {
            addCriterion("doorId >=", value, "doorid");
            return (Criteria) this;
        }

        public Criteria andDooridLessThan(String value) {
            addCriterion("doorId <", value, "doorid");
            return (Criteria) this;
        }

        public Criteria andDooridLessThanOrEqualTo(String value) {
            addCriterion("doorId <=", value, "doorid");
            return (Criteria) this;
        }

        public Criteria andDooridLike(String value) {
            addCriterion("doorId like", value, "doorid");
            return (Criteria) this;
        }

        public Criteria andDooridNotLike(String value) {
            addCriterion("doorId not like", value, "doorid");
            return (Criteria) this;
        }

        public Criteria andDooridIn(List<String> values) {
            addCriterion("doorId in", values, "doorid");
            return (Criteria) this;
        }

        public Criteria andDooridNotIn(List<String> values) {
            addCriterion("doorId not in", values, "doorid");
            return (Criteria) this;
        }

        public Criteria andDooridBetween(String value1, String value2) {
            addCriterion("doorId between", value1, value2, "doorid");
            return (Criteria) this;
        }

        public Criteria andDooridNotBetween(String value1, String value2) {
            addCriterion("doorId not between", value1, value2, "doorid");
            return (Criteria) this;
        }

        public Criteria andProcessidsIsNull() {
            addCriterion("processIds is null");
            return (Criteria) this;
        }

        public Criteria andProcessidsIsNotNull() {
            addCriterion("processIds is not null");
            return (Criteria) this;
        }

        public Criteria andProcessidsEqualTo(String value) {
            addCriterion("processIds =", value, "processids");
            return (Criteria) this;
        }

        public Criteria andProcessidsNotEqualTo(String value) {
            addCriterion("processIds <>", value, "processids");
            return (Criteria) this;
        }

        public Criteria andProcessidsGreaterThan(String value) {
            addCriterion("processIds >", value, "processids");
            return (Criteria) this;
        }

        public Criteria andProcessidsGreaterThanOrEqualTo(String value) {
            addCriterion("processIds >=", value, "processids");
            return (Criteria) this;
        }

        public Criteria andProcessidsLessThan(String value) {
            addCriterion("processIds <", value, "processids");
            return (Criteria) this;
        }

        public Criteria andProcessidsLessThanOrEqualTo(String value) {
            addCriterion("processIds <=", value, "processids");
            return (Criteria) this;
        }

        public Criteria andProcessidsLike(String value) {
            addCriterion("processIds like", value, "processids");
            return (Criteria) this;
        }

        public Criteria andProcessidsNotLike(String value) {
            addCriterion("processIds not like", value, "processids");
            return (Criteria) this;
        }

        public Criteria andProcessidsIn(List<String> values) {
            addCriterion("processIds in", values, "processids");
            return (Criteria) this;
        }

        public Criteria andProcessidsNotIn(List<String> values) {
            addCriterion("processIds not in", values, "processids");
            return (Criteria) this;
        }

        public Criteria andProcessidsBetween(String value1, String value2) {
            addCriterion("processIds between", value1, value2, "processids");
            return (Criteria) this;
        }

        public Criteria andProcessidsNotBetween(String value1, String value2) {
            addCriterion("processIds not between", value1, value2, "processids");
            return (Criteria) this;
        }

        public Criteria andImgIsNull() {
            addCriterion("img is null");
            return (Criteria) this;
        }

        public Criteria andImgIsNotNull() {
            addCriterion("img is not null");
            return (Criteria) this;
        }

        public Criteria andImgEqualTo(String value) {
            addCriterion("img =", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotEqualTo(String value) {
            addCriterion("img <>", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgGreaterThan(String value) {
            addCriterion("img >", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgGreaterThanOrEqualTo(String value) {
            addCriterion("img >=", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLessThan(String value) {
            addCriterion("img <", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLessThanOrEqualTo(String value) {
            addCriterion("img <=", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLike(String value) {
            addCriterion("img like", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotLike(String value) {
            addCriterion("img not like", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgIn(List<String> values) {
            addCriterion("img in", values, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotIn(List<String> values) {
            addCriterion("img not in", values, "img");
            return (Criteria) this;
        }

        public Criteria andImgBetween(String value1, String value2) {
            addCriterion("img between", value1, value2, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotBetween(String value1, String value2) {
            addCriterion("img not between", value1, value2, "img");
            return (Criteria) this;
        }

        public Criteria andDescribeIsNull() {
            addCriterion("describe is null");
            return (Criteria) this;
        }

        public Criteria andDescribeIsNotNull() {
            addCriterion("describe is not null");
            return (Criteria) this;
        }

        public Criteria andDescribeEqualTo(String value) {
            addCriterion("describe =", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeNotEqualTo(String value) {
            addCriterion("describe <>", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeGreaterThan(String value) {
            addCriterion("describe >", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("describe >=", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeLessThan(String value) {
            addCriterion("describe <", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeLessThanOrEqualTo(String value) {
            addCriterion("describe <=", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeLike(String value) {
            addCriterion("describe like", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeNotLike(String value) {
            addCriterion("describe not like", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeIn(List<String> values) {
            addCriterion("describe in", values, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeNotIn(List<String> values) {
            addCriterion("describe not in", values, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeBetween(String value1, String value2) {
            addCriterion("describe between", value1, value2, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeNotBetween(String value1, String value2) {
            addCriterion("describe not between", value1, value2, "describe");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNull() {
            addCriterion("startTime is null");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNotNull() {
            addCriterion("startTime is not null");
            return (Criteria) this;
        }

        public Criteria andStarttimeEqualTo(Date value) {
            addCriterion("startTime =", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotEqualTo(Date value) {
            addCriterion("startTime <>", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThan(Date value) {
            addCriterion("startTime >", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("startTime >=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThan(Date value) {
            addCriterion("startTime <", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThanOrEqualTo(Date value) {
            addCriterion("startTime <=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeIn(List<Date> values) {
            addCriterion("startTime in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotIn(List<Date> values) {
            addCriterion("startTime not in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeBetween(Date value1, Date value2) {
            addCriterion("startTime between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotBetween(Date value1, Date value2) {
            addCriterion("startTime not between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNull() {
            addCriterion("endTime is null");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNotNull() {
            addCriterion("endTime is not null");
            return (Criteria) this;
        }

        public Criteria andEndtimeEqualTo(Date value) {
            addCriterion("endTime =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(Date value) {
            addCriterion("endTime <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(Date value) {
            addCriterion("endTime >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("endTime >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(Date value) {
            addCriterion("endTime <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(Date value) {
            addCriterion("endTime <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<Date> values) {
            addCriterion("endTime in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<Date> values) {
            addCriterion("endTime not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(Date value1, Date value2) {
            addCriterion("endTime between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(Date value1, Date value2) {
            addCriterion("endTime not between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andCorporationidIsNull() {
            addCriterion("corporationId is null");
            return (Criteria) this;
        }

        public Criteria andCorporationidIsNotNull() {
            addCriterion("corporationId is not null");
            return (Criteria) this;
        }

        public Criteria andCorporationidEqualTo(String value) {
            addCriterion("corporationId =", value, "corporationid");
            return (Criteria) this;
        }

        public Criteria andCorporationidNotEqualTo(String value) {
            addCriterion("corporationId <>", value, "corporationid");
            return (Criteria) this;
        }

        public Criteria andCorporationidGreaterThan(String value) {
            addCriterion("corporationId >", value, "corporationid");
            return (Criteria) this;
        }

        public Criteria andCorporationidGreaterThanOrEqualTo(String value) {
            addCriterion("corporationId >=", value, "corporationid");
            return (Criteria) this;
        }

        public Criteria andCorporationidLessThan(String value) {
            addCriterion("corporationId <", value, "corporationid");
            return (Criteria) this;
        }

        public Criteria andCorporationidLessThanOrEqualTo(String value) {
            addCriterion("corporationId <=", value, "corporationid");
            return (Criteria) this;
        }

        public Criteria andCorporationidLike(String value) {
            addCriterion("corporationId like", value, "corporationid");
            return (Criteria) this;
        }

        public Criteria andCorporationidNotLike(String value) {
            addCriterion("corporationId not like", value, "corporationid");
            return (Criteria) this;
        }

        public Criteria andCorporationidIn(List<String> values) {
            addCriterion("corporationId in", values, "corporationid");
            return (Criteria) this;
        }

        public Criteria andCorporationidNotIn(List<String> values) {
            addCriterion("corporationId not in", values, "corporationid");
            return (Criteria) this;
        }

        public Criteria andCorporationidBetween(String value1, String value2) {
            addCriterion("corporationId between", value1, value2, "corporationid");
            return (Criteria) this;
        }

        public Criteria andCorporationidNotBetween(String value1, String value2) {
            addCriterion("corporationId not between", value1, value2, "corporationid");
            return (Criteria) this;
        }

        public Criteria andWeightcoverIsNull() {
            addCriterion("weightCover is null");
            return (Criteria) this;
        }

        public Criteria andWeightcoverIsNotNull() {
            addCriterion("weightCover is not null");
            return (Criteria) this;
        }

        public Criteria andWeightcoverEqualTo(Integer value) {
            addCriterion("weightCover =", value, "weightcover");
            return (Criteria) this;
        }

        public Criteria andWeightcoverNotEqualTo(Integer value) {
            addCriterion("weightCover <>", value, "weightcover");
            return (Criteria) this;
        }

        public Criteria andWeightcoverGreaterThan(Integer value) {
            addCriterion("weightCover >", value, "weightcover");
            return (Criteria) this;
        }

        public Criteria andWeightcoverGreaterThanOrEqualTo(Integer value) {
            addCriterion("weightCover >=", value, "weightcover");
            return (Criteria) this;
        }

        public Criteria andWeightcoverLessThan(Integer value) {
            addCriterion("weightCover <", value, "weightcover");
            return (Criteria) this;
        }

        public Criteria andWeightcoverLessThanOrEqualTo(Integer value) {
            addCriterion("weightCover <=", value, "weightcover");
            return (Criteria) this;
        }

        public Criteria andWeightcoverIn(List<Integer> values) {
            addCriterion("weightCover in", values, "weightcover");
            return (Criteria) this;
        }

        public Criteria andWeightcoverNotIn(List<Integer> values) {
            addCriterion("weightCover not in", values, "weightcover");
            return (Criteria) this;
        }

        public Criteria andWeightcoverBetween(Integer value1, Integer value2) {
            addCriterion("weightCover between", value1, value2, "weightcover");
            return (Criteria) this;
        }

        public Criteria andWeightcoverNotBetween(Integer value1, Integer value2) {
            addCriterion("weightCover not between", value1, value2, "weightcover");
            return (Criteria) this;
        }

        public Criteria andHeightcoverIsNull() {
            addCriterion("heightCover is null");
            return (Criteria) this;
        }

        public Criteria andHeightcoverIsNotNull() {
            addCriterion("heightCover is not null");
            return (Criteria) this;
        }

        public Criteria andHeightcoverEqualTo(Integer value) {
            addCriterion("heightCover =", value, "heightcover");
            return (Criteria) this;
        }

        public Criteria andHeightcoverNotEqualTo(Integer value) {
            addCriterion("heightCover <>", value, "heightcover");
            return (Criteria) this;
        }

        public Criteria andHeightcoverGreaterThan(Integer value) {
            addCriterion("heightCover >", value, "heightcover");
            return (Criteria) this;
        }

        public Criteria andHeightcoverGreaterThanOrEqualTo(Integer value) {
            addCriterion("heightCover >=", value, "heightcover");
            return (Criteria) this;
        }

        public Criteria andHeightcoverLessThan(Integer value) {
            addCriterion("heightCover <", value, "heightcover");
            return (Criteria) this;
        }

        public Criteria andHeightcoverLessThanOrEqualTo(Integer value) {
            addCriterion("heightCover <=", value, "heightcover");
            return (Criteria) this;
        }

        public Criteria andHeightcoverIn(List<Integer> values) {
            addCriterion("heightCover in", values, "heightcover");
            return (Criteria) this;
        }

        public Criteria andHeightcoverNotIn(List<Integer> values) {
            addCriterion("heightCover not in", values, "heightcover");
            return (Criteria) this;
        }

        public Criteria andHeightcoverBetween(Integer value1, Integer value2) {
            addCriterion("heightCover between", value1, value2, "heightcover");
            return (Criteria) this;
        }

        public Criteria andHeightcoverNotBetween(Integer value1, Integer value2) {
            addCriterion("heightCover not between", value1, value2, "heightcover");
            return (Criteria) this;
        }

        public Criteria andDepthcoverIsNull() {
            addCriterion("depthCover is null");
            return (Criteria) this;
        }

        public Criteria andDepthcoverIsNotNull() {
            addCriterion("depthCover is not null");
            return (Criteria) this;
        }

        public Criteria andDepthcoverEqualTo(Integer value) {
            addCriterion("depthCover =", value, "depthcover");
            return (Criteria) this;
        }

        public Criteria andDepthcoverNotEqualTo(Integer value) {
            addCriterion("depthCover <>", value, "depthcover");
            return (Criteria) this;
        }

        public Criteria andDepthcoverGreaterThan(Integer value) {
            addCriterion("depthCover >", value, "depthcover");
            return (Criteria) this;
        }

        public Criteria andDepthcoverGreaterThanOrEqualTo(Integer value) {
            addCriterion("depthCover >=", value, "depthcover");
            return (Criteria) this;
        }

        public Criteria andDepthcoverLessThan(Integer value) {
            addCriterion("depthCover <", value, "depthcover");
            return (Criteria) this;
        }

        public Criteria andDepthcoverLessThanOrEqualTo(Integer value) {
            addCriterion("depthCover <=", value, "depthcover");
            return (Criteria) this;
        }

        public Criteria andDepthcoverIn(List<Integer> values) {
            addCriterion("depthCover in", values, "depthcover");
            return (Criteria) this;
        }

        public Criteria andDepthcoverNotIn(List<Integer> values) {
            addCriterion("depthCover not in", values, "depthcover");
            return (Criteria) this;
        }

        public Criteria andDepthcoverBetween(Integer value1, Integer value2) {
            addCriterion("depthCover between", value1, value2, "depthcover");
            return (Criteria) this;
        }

        public Criteria andDepthcoverNotBetween(Integer value1, Integer value2) {
            addCriterion("depthCover not between", value1, value2, "depthcover");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("weight is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(Integer value) {
            addCriterion("weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(Integer value) {
            addCriterion("weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(Integer value) {
            addCriterion("weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(Integer value) {
            addCriterion("weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(Integer value) {
            addCriterion("weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<Integer> values) {
            addCriterion("weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<Integer> values) {
            addCriterion("weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(Integer value1, Integer value2) {
            addCriterion("weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(Integer value1, Integer value2) {
            addCriterion("weight not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andHeightIsNull() {
            addCriterion("height is null");
            return (Criteria) this;
        }

        public Criteria andHeightIsNotNull() {
            addCriterion("height is not null");
            return (Criteria) this;
        }

        public Criteria andHeightEqualTo(Integer value) {
            addCriterion("height =", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotEqualTo(Integer value) {
            addCriterion("height <>", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThan(Integer value) {
            addCriterion("height >", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("height >=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThan(Integer value) {
            addCriterion("height <", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThanOrEqualTo(Integer value) {
            addCriterion("height <=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightIn(List<Integer> values) {
            addCriterion("height in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotIn(List<Integer> values) {
            addCriterion("height not in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightBetween(Integer value1, Integer value2) {
            addCriterion("height between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotBetween(Integer value1, Integer value2) {
            addCriterion("height not between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andWeightlbIsNull() {
            addCriterion("weightLb is null");
            return (Criteria) this;
        }

        public Criteria andWeightlbIsNotNull() {
            addCriterion("weightLb is not null");
            return (Criteria) this;
        }

        public Criteria andWeightlbEqualTo(Integer value) {
            addCriterion("weightLb =", value, "weightlb");
            return (Criteria) this;
        }

        public Criteria andWeightlbNotEqualTo(Integer value) {
            addCriterion("weightLb <>", value, "weightlb");
            return (Criteria) this;
        }

        public Criteria andWeightlbGreaterThan(Integer value) {
            addCriterion("weightLb >", value, "weightlb");
            return (Criteria) this;
        }

        public Criteria andWeightlbGreaterThanOrEqualTo(Integer value) {
            addCriterion("weightLb >=", value, "weightlb");
            return (Criteria) this;
        }

        public Criteria andWeightlbLessThan(Integer value) {
            addCriterion("weightLb <", value, "weightlb");
            return (Criteria) this;
        }

        public Criteria andWeightlbLessThanOrEqualTo(Integer value) {
            addCriterion("weightLb <=", value, "weightlb");
            return (Criteria) this;
        }

        public Criteria andWeightlbIn(List<Integer> values) {
            addCriterion("weightLb in", values, "weightlb");
            return (Criteria) this;
        }

        public Criteria andWeightlbNotIn(List<Integer> values) {
            addCriterion("weightLb not in", values, "weightlb");
            return (Criteria) this;
        }

        public Criteria andWeightlbBetween(Integer value1, Integer value2) {
            addCriterion("weightLb between", value1, value2, "weightlb");
            return (Criteria) this;
        }

        public Criteria andWeightlbNotBetween(Integer value1, Integer value2) {
            addCriterion("weightLb not between", value1, value2, "weightlb");
            return (Criteria) this;
        }

        public Criteria andHeightlbIsNull() {
            addCriterion("heightLb is null");
            return (Criteria) this;
        }

        public Criteria andHeightlbIsNotNull() {
            addCriterion("heightLb is not null");
            return (Criteria) this;
        }

        public Criteria andHeightlbEqualTo(Integer value) {
            addCriterion("heightLb =", value, "heightlb");
            return (Criteria) this;
        }

        public Criteria andHeightlbNotEqualTo(Integer value) {
            addCriterion("heightLb <>", value, "heightlb");
            return (Criteria) this;
        }

        public Criteria andHeightlbGreaterThan(Integer value) {
            addCriterion("heightLb >", value, "heightlb");
            return (Criteria) this;
        }

        public Criteria andHeightlbGreaterThanOrEqualTo(Integer value) {
            addCriterion("heightLb >=", value, "heightlb");
            return (Criteria) this;
        }

        public Criteria andHeightlbLessThan(Integer value) {
            addCriterion("heightLb <", value, "heightlb");
            return (Criteria) this;
        }

        public Criteria andHeightlbLessThanOrEqualTo(Integer value) {
            addCriterion("heightLb <=", value, "heightlb");
            return (Criteria) this;
        }

        public Criteria andHeightlbIn(List<Integer> values) {
            addCriterion("heightLb in", values, "heightlb");
            return (Criteria) this;
        }

        public Criteria andHeightlbNotIn(List<Integer> values) {
            addCriterion("heightLb not in", values, "heightlb");
            return (Criteria) this;
        }

        public Criteria andHeightlbBetween(Integer value1, Integer value2) {
            addCriterion("heightLb between", value1, value2, "heightlb");
            return (Criteria) this;
        }

        public Criteria andHeightlbNotBetween(Integer value1, Integer value2) {
            addCriterion("heightLb not between", value1, value2, "heightlb");
            return (Criteria) this;
        }

        public Criteria andWeightdbIsNull() {
            addCriterion("weightDb is null");
            return (Criteria) this;
        }

        public Criteria andWeightdbIsNotNull() {
            addCriterion("weightDb is not null");
            return (Criteria) this;
        }

        public Criteria andWeightdbEqualTo(Integer value) {
            addCriterion("weightDb =", value, "weightdb");
            return (Criteria) this;
        }

        public Criteria andWeightdbNotEqualTo(Integer value) {
            addCriterion("weightDb <>", value, "weightdb");
            return (Criteria) this;
        }

        public Criteria andWeightdbGreaterThan(Integer value) {
            addCriterion("weightDb >", value, "weightdb");
            return (Criteria) this;
        }

        public Criteria andWeightdbGreaterThanOrEqualTo(Integer value) {
            addCriterion("weightDb >=", value, "weightdb");
            return (Criteria) this;
        }

        public Criteria andWeightdbLessThan(Integer value) {
            addCriterion("weightDb <", value, "weightdb");
            return (Criteria) this;
        }

        public Criteria andWeightdbLessThanOrEqualTo(Integer value) {
            addCriterion("weightDb <=", value, "weightdb");
            return (Criteria) this;
        }

        public Criteria andWeightdbIn(List<Integer> values) {
            addCriterion("weightDb in", values, "weightdb");
            return (Criteria) this;
        }

        public Criteria andWeightdbNotIn(List<Integer> values) {
            addCriterion("weightDb not in", values, "weightdb");
            return (Criteria) this;
        }

        public Criteria andWeightdbBetween(Integer value1, Integer value2) {
            addCriterion("weightDb between", value1, value2, "weightdb");
            return (Criteria) this;
        }

        public Criteria andWeightdbNotBetween(Integer value1, Integer value2) {
            addCriterion("weightDb not between", value1, value2, "weightdb");
            return (Criteria) this;
        }

        public Criteria andHeightdbIsNull() {
            addCriterion("heightDb is null");
            return (Criteria) this;
        }

        public Criteria andHeightdbIsNotNull() {
            addCriterion("heightDb is not null");
            return (Criteria) this;
        }

        public Criteria andHeightdbEqualTo(Integer value) {
            addCriterion("heightDb =", value, "heightdb");
            return (Criteria) this;
        }

        public Criteria andHeightdbNotEqualTo(Integer value) {
            addCriterion("heightDb <>", value, "heightdb");
            return (Criteria) this;
        }

        public Criteria andHeightdbGreaterThan(Integer value) {
            addCriterion("heightDb >", value, "heightdb");
            return (Criteria) this;
        }

        public Criteria andHeightdbGreaterThanOrEqualTo(Integer value) {
            addCriterion("heightDb >=", value, "heightdb");
            return (Criteria) this;
        }

        public Criteria andHeightdbLessThan(Integer value) {
            addCriterion("heightDb <", value, "heightdb");
            return (Criteria) this;
        }

        public Criteria andHeightdbLessThanOrEqualTo(Integer value) {
            addCriterion("heightDb <=", value, "heightdb");
            return (Criteria) this;
        }

        public Criteria andHeightdbIn(List<Integer> values) {
            addCriterion("heightDb in", values, "heightdb");
            return (Criteria) this;
        }

        public Criteria andHeightdbNotIn(List<Integer> values) {
            addCriterion("heightDb not in", values, "heightdb");
            return (Criteria) this;
        }

        public Criteria andHeightdbBetween(Integer value1, Integer value2) {
            addCriterion("heightDb between", value1, value2, "heightdb");
            return (Criteria) this;
        }

        public Criteria andHeightdbNotBetween(Integer value1, Integer value2) {
            addCriterion("heightDb not between", value1, value2, "heightdb");
            return (Criteria) this;
        }

        public Criteria andColoridIsNull() {
            addCriterion("colorId is null");
            return (Criteria) this;
        }

        public Criteria andColoridIsNotNull() {
            addCriterion("colorId is not null");
            return (Criteria) this;
        }

        public Criteria andColoridEqualTo(String value) {
            addCriterion("colorId =", value, "colorid");
            return (Criteria) this;
        }

        public Criteria andColoridNotEqualTo(String value) {
            addCriterion("colorId <>", value, "colorid");
            return (Criteria) this;
        }

        public Criteria andColoridGreaterThan(String value) {
            addCriterion("colorId >", value, "colorid");
            return (Criteria) this;
        }

        public Criteria andColoridGreaterThanOrEqualTo(String value) {
            addCriterion("colorId >=", value, "colorid");
            return (Criteria) this;
        }

        public Criteria andColoridLessThan(String value) {
            addCriterion("colorId <", value, "colorid");
            return (Criteria) this;
        }

        public Criteria andColoridLessThanOrEqualTo(String value) {
            addCriterion("colorId <=", value, "colorid");
            return (Criteria) this;
        }

        public Criteria andColoridLike(String value) {
            addCriterion("colorId like", value, "colorid");
            return (Criteria) this;
        }

        public Criteria andColoridNotLike(String value) {
            addCriterion("colorId not like", value, "colorid");
            return (Criteria) this;
        }

        public Criteria andColoridIn(List<String> values) {
            addCriterion("colorId in", values, "colorid");
            return (Criteria) this;
        }

        public Criteria andColoridNotIn(List<String> values) {
            addCriterion("colorId not in", values, "colorid");
            return (Criteria) this;
        }

        public Criteria andColoridBetween(String value1, String value2) {
            addCriterion("colorId between", value1, value2, "colorid");
            return (Criteria) this;
        }

        public Criteria andColoridNotBetween(String value1, String value2) {
            addCriterion("colorId not between", value1, value2, "colorid");
            return (Criteria) this;
        }

        public Criteria andLineidIsNull() {
            addCriterion("lineId is null");
            return (Criteria) this;
        }

        public Criteria andLineidIsNotNull() {
            addCriterion("lineId is not null");
            return (Criteria) this;
        }

        public Criteria andLineidEqualTo(String value) {
            addCriterion("lineId =", value, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidNotEqualTo(String value) {
            addCriterion("lineId <>", value, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidGreaterThan(String value) {
            addCriterion("lineId >", value, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidGreaterThanOrEqualTo(String value) {
            addCriterion("lineId >=", value, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidLessThan(String value) {
            addCriterion("lineId <", value, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidLessThanOrEqualTo(String value) {
            addCriterion("lineId <=", value, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidLike(String value) {
            addCriterion("lineId like", value, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidNotLike(String value) {
            addCriterion("lineId not like", value, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidIn(List<String> values) {
            addCriterion("lineId in", values, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidNotIn(List<String> values) {
            addCriterion("lineId not in", values, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidBetween(String value1, String value2) {
            addCriterion("lineId between", value1, value2, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidNotBetween(String value1, String value2) {
            addCriterion("lineId not between", value1, value2, "lineid");
            return (Criteria) this;
        }

        public Criteria andLinesumIsNull() {
            addCriterion("lineSum is null");
            return (Criteria) this;
        }

        public Criteria andLinesumIsNotNull() {
            addCriterion("lineSum is not null");
            return (Criteria) this;
        }

        public Criteria andLinesumEqualTo(Integer value) {
            addCriterion("lineSum =", value, "linesum");
            return (Criteria) this;
        }

        public Criteria andLinesumNotEqualTo(Integer value) {
            addCriterion("lineSum <>", value, "linesum");
            return (Criteria) this;
        }

        public Criteria andLinesumGreaterThan(Integer value) {
            addCriterion("lineSum >", value, "linesum");
            return (Criteria) this;
        }

        public Criteria andLinesumGreaterThanOrEqualTo(Integer value) {
            addCriterion("lineSum >=", value, "linesum");
            return (Criteria) this;
        }

        public Criteria andLinesumLessThan(Integer value) {
            addCriterion("lineSum <", value, "linesum");
            return (Criteria) this;
        }

        public Criteria andLinesumLessThanOrEqualTo(Integer value) {
            addCriterion("lineSum <=", value, "linesum");
            return (Criteria) this;
        }

        public Criteria andLinesumIn(List<Integer> values) {
            addCriterion("lineSum in", values, "linesum");
            return (Criteria) this;
        }

        public Criteria andLinesumNotIn(List<Integer> values) {
            addCriterion("lineSum not in", values, "linesum");
            return (Criteria) this;
        }

        public Criteria andLinesumBetween(Integer value1, Integer value2) {
            addCriterion("lineSum between", value1, value2, "linesum");
            return (Criteria) this;
        }

        public Criteria andLinesumNotBetween(Integer value1, Integer value2) {
            addCriterion("lineSum not between", value1, value2, "linesum");
            return (Criteria) this;
        }

        public Criteria andProductcolIsNull() {
            addCriterion("productcol is null");
            return (Criteria) this;
        }

        public Criteria andProductcolIsNotNull() {
            addCriterion("productcol is not null");
            return (Criteria) this;
        }

        public Criteria andProductcolEqualTo(String value) {
            addCriterion("productcol =", value, "productcol");
            return (Criteria) this;
        }

        public Criteria andProductcolNotEqualTo(String value) {
            addCriterion("productcol <>", value, "productcol");
            return (Criteria) this;
        }

        public Criteria andProductcolGreaterThan(String value) {
            addCriterion("productcol >", value, "productcol");
            return (Criteria) this;
        }

        public Criteria andProductcolGreaterThanOrEqualTo(String value) {
            addCriterion("productcol >=", value, "productcol");
            return (Criteria) this;
        }

        public Criteria andProductcolLessThan(String value) {
            addCriterion("productcol <", value, "productcol");
            return (Criteria) this;
        }

        public Criteria andProductcolLessThanOrEqualTo(String value) {
            addCriterion("productcol <=", value, "productcol");
            return (Criteria) this;
        }

        public Criteria andProductcolLike(String value) {
            addCriterion("productcol like", value, "productcol");
            return (Criteria) this;
        }

        public Criteria andProductcolNotLike(String value) {
            addCriterion("productcol not like", value, "productcol");
            return (Criteria) this;
        }

        public Criteria andProductcolIn(List<String> values) {
            addCriterion("productcol in", values, "productcol");
            return (Criteria) this;
        }

        public Criteria andProductcolNotIn(List<String> values) {
            addCriterion("productcol not in", values, "productcol");
            return (Criteria) this;
        }

        public Criteria andProductcolBetween(String value1, String value2) {
            addCriterion("productcol between", value1, value2, "productcol");
            return (Criteria) this;
        }

        public Criteria andProductcolNotBetween(String value1, String value2) {
            addCriterion("productcol not between", value1, value2, "productcol");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andIsmoduleIsNull() {
            addCriterion("isModule is null");
            return (Criteria) this;
        }

        public Criteria andIsmoduleIsNotNull() {
            addCriterion("isModule is not null");
            return (Criteria) this;
        }

        public Criteria andIsmoduleEqualTo(Boolean value) {
            addCriterion("isModule =", value, "ismodule");
            return (Criteria) this;
        }

        public Criteria andIsmoduleNotEqualTo(Boolean value) {
            addCriterion("isModule <>", value, "ismodule");
            return (Criteria) this;
        }

        public Criteria andIsmoduleGreaterThan(Boolean value) {
            addCriterion("isModule >", value, "ismodule");
            return (Criteria) this;
        }

        public Criteria andIsmoduleGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isModule >=", value, "ismodule");
            return (Criteria) this;
        }

        public Criteria andIsmoduleLessThan(Boolean value) {
            addCriterion("isModule <", value, "ismodule");
            return (Criteria) this;
        }

        public Criteria andIsmoduleLessThanOrEqualTo(Boolean value) {
            addCriterion("isModule <=", value, "ismodule");
            return (Criteria) this;
        }

        public Criteria andIsmoduleIn(List<Boolean> values) {
            addCriterion("isModule in", values, "ismodule");
            return (Criteria) this;
        }

        public Criteria andIsmoduleNotIn(List<Boolean> values) {
            addCriterion("isModule not in", values, "ismodule");
            return (Criteria) this;
        }

        public Criteria andIsmoduleBetween(Boolean value1, Boolean value2) {
            addCriterion("isModule between", value1, value2, "ismodule");
            return (Criteria) this;
        }

        public Criteria andIsmoduleNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isModule not between", value1, value2, "ismodule");
            return (Criteria) this;
        }

        public Criteria andModuleidIsNull() {
            addCriterion("moduleId is null");
            return (Criteria) this;
        }

        public Criteria andModuleidIsNotNull() {
            addCriterion("moduleId is not null");
            return (Criteria) this;
        }

        public Criteria andModuleidEqualTo(String value) {
            addCriterion("moduleId =", value, "moduleid");
            return (Criteria) this;
        }

        public Criteria andModuleidNotEqualTo(String value) {
            addCriterion("moduleId <>", value, "moduleid");
            return (Criteria) this;
        }

        public Criteria andModuleidGreaterThan(String value) {
            addCriterion("moduleId >", value, "moduleid");
            return (Criteria) this;
        }

        public Criteria andModuleidGreaterThanOrEqualTo(String value) {
            addCriterion("moduleId >=", value, "moduleid");
            return (Criteria) this;
        }

        public Criteria andModuleidLessThan(String value) {
            addCriterion("moduleId <", value, "moduleid");
            return (Criteria) this;
        }

        public Criteria andModuleidLessThanOrEqualTo(String value) {
            addCriterion("moduleId <=", value, "moduleid");
            return (Criteria) this;
        }

        public Criteria andModuleidLike(String value) {
            addCriterion("moduleId like", value, "moduleid");
            return (Criteria) this;
        }

        public Criteria andModuleidNotLike(String value) {
            addCriterion("moduleId not like", value, "moduleid");
            return (Criteria) this;
        }

        public Criteria andModuleidIn(List<String> values) {
            addCriterion("moduleId in", values, "moduleid");
            return (Criteria) this;
        }

        public Criteria andModuleidNotIn(List<String> values) {
            addCriterion("moduleId not in", values, "moduleid");
            return (Criteria) this;
        }

        public Criteria andModuleidBetween(String value1, String value2) {
            addCriterion("moduleId between", value1, value2, "moduleid");
            return (Criteria) this;
        }

        public Criteria andModuleidNotBetween(String value1, String value2) {
            addCriterion("moduleId not between", value1, value2, "moduleid");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
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