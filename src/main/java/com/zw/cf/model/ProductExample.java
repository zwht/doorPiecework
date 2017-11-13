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

        public Criteria andProcessIdsIsNull() {
            addCriterion("process_ids is null");
            return (Criteria) this;
        }

        public Criteria andProcessIdsIsNotNull() {
            addCriterion("process_ids is not null");
            return (Criteria) this;
        }

        public Criteria andProcessIdsEqualTo(String value) {
            addCriterion("process_ids =", value, "processIds");
            return (Criteria) this;
        }

        public Criteria andProcessIdsNotEqualTo(String value) {
            addCriterion("process_ids <>", value, "processIds");
            return (Criteria) this;
        }

        public Criteria andProcessIdsGreaterThan(String value) {
            addCriterion("process_ids >", value, "processIds");
            return (Criteria) this;
        }

        public Criteria andProcessIdsGreaterThanOrEqualTo(String value) {
            addCriterion("process_ids >=", value, "processIds");
            return (Criteria) this;
        }

        public Criteria andProcessIdsLessThan(String value) {
            addCriterion("process_ids <", value, "processIds");
            return (Criteria) this;
        }

        public Criteria andProcessIdsLessThanOrEqualTo(String value) {
            addCriterion("process_ids <=", value, "processIds");
            return (Criteria) this;
        }

        public Criteria andProcessIdsLike(String value) {
            addCriterion("process_ids like", value, "processIds");
            return (Criteria) this;
        }

        public Criteria andProcessIdsNotLike(String value) {
            addCriterion("process_ids not like", value, "processIds");
            return (Criteria) this;
        }

        public Criteria andProcessIdsIn(List<String> values) {
            addCriterion("process_ids in", values, "processIds");
            return (Criteria) this;
        }

        public Criteria andProcessIdsNotIn(List<String> values) {
            addCriterion("process_ids not in", values, "processIds");
            return (Criteria) this;
        }

        public Criteria andProcessIdsBetween(String value1, String value2) {
            addCriterion("process_ids between", value1, value2, "processIds");
            return (Criteria) this;
        }

        public Criteria andProcessIdsNotBetween(String value1, String value2) {
            addCriterion("process_ids not between", value1, value2, "processIds");
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

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andCorporationIdIsNull() {
            addCriterion("corporation_id is null");
            return (Criteria) this;
        }

        public Criteria andCorporationIdIsNotNull() {
            addCriterion("corporation_id is not null");
            return (Criteria) this;
        }

        public Criteria andCorporationIdEqualTo(String value) {
            addCriterion("corporation_id =", value, "corporationId");
            return (Criteria) this;
        }

        public Criteria andCorporationIdNotEqualTo(String value) {
            addCriterion("corporation_id <>", value, "corporationId");
            return (Criteria) this;
        }

        public Criteria andCorporationIdGreaterThan(String value) {
            addCriterion("corporation_id >", value, "corporationId");
            return (Criteria) this;
        }

        public Criteria andCorporationIdGreaterThanOrEqualTo(String value) {
            addCriterion("corporation_id >=", value, "corporationId");
            return (Criteria) this;
        }

        public Criteria andCorporationIdLessThan(String value) {
            addCriterion("corporation_id <", value, "corporationId");
            return (Criteria) this;
        }

        public Criteria andCorporationIdLessThanOrEqualTo(String value) {
            addCriterion("corporation_id <=", value, "corporationId");
            return (Criteria) this;
        }

        public Criteria andCorporationIdLike(String value) {
            addCriterion("corporation_id like", value, "corporationId");
            return (Criteria) this;
        }

        public Criteria andCorporationIdNotLike(String value) {
            addCriterion("corporation_id not like", value, "corporationId");
            return (Criteria) this;
        }

        public Criteria andCorporationIdIn(List<String> values) {
            addCriterion("corporation_id in", values, "corporationId");
            return (Criteria) this;
        }

        public Criteria andCorporationIdNotIn(List<String> values) {
            addCriterion("corporation_id not in", values, "corporationId");
            return (Criteria) this;
        }

        public Criteria andCorporationIdBetween(String value1, String value2) {
            addCriterion("corporation_id between", value1, value2, "corporationId");
            return (Criteria) this;
        }

        public Criteria andCorporationIdNotBetween(String value1, String value2) {
            addCriterion("corporation_id not between", value1, value2, "corporationId");
            return (Criteria) this;
        }

        public Criteria andWeightCoverIsNull() {
            addCriterion("weight_cover is null");
            return (Criteria) this;
        }

        public Criteria andWeightCoverIsNotNull() {
            addCriterion("weight_cover is not null");
            return (Criteria) this;
        }

        public Criteria andWeightCoverEqualTo(Integer value) {
            addCriterion("weight_cover =", value, "weightCover");
            return (Criteria) this;
        }

        public Criteria andWeightCoverNotEqualTo(Integer value) {
            addCriterion("weight_cover <>", value, "weightCover");
            return (Criteria) this;
        }

        public Criteria andWeightCoverGreaterThan(Integer value) {
            addCriterion("weight_cover >", value, "weightCover");
            return (Criteria) this;
        }

        public Criteria andWeightCoverGreaterThanOrEqualTo(Integer value) {
            addCriterion("weight_cover >=", value, "weightCover");
            return (Criteria) this;
        }

        public Criteria andWeightCoverLessThan(Integer value) {
            addCriterion("weight_cover <", value, "weightCover");
            return (Criteria) this;
        }

        public Criteria andWeightCoverLessThanOrEqualTo(Integer value) {
            addCriterion("weight_cover <=", value, "weightCover");
            return (Criteria) this;
        }

        public Criteria andWeightCoverIn(List<Integer> values) {
            addCriterion("weight_cover in", values, "weightCover");
            return (Criteria) this;
        }

        public Criteria andWeightCoverNotIn(List<Integer> values) {
            addCriterion("weight_cover not in", values, "weightCover");
            return (Criteria) this;
        }

        public Criteria andWeightCoverBetween(Integer value1, Integer value2) {
            addCriterion("weight_cover between", value1, value2, "weightCover");
            return (Criteria) this;
        }

        public Criteria andWeightCoverNotBetween(Integer value1, Integer value2) {
            addCriterion("weight_cover not between", value1, value2, "weightCover");
            return (Criteria) this;
        }

        public Criteria andHeightCoverIsNull() {
            addCriterion("height_cover is null");
            return (Criteria) this;
        }

        public Criteria andHeightCoverIsNotNull() {
            addCriterion("height_cover is not null");
            return (Criteria) this;
        }

        public Criteria andHeightCoverEqualTo(Integer value) {
            addCriterion("height_cover =", value, "heightCover");
            return (Criteria) this;
        }

        public Criteria andHeightCoverNotEqualTo(Integer value) {
            addCriterion("height_cover <>", value, "heightCover");
            return (Criteria) this;
        }

        public Criteria andHeightCoverGreaterThan(Integer value) {
            addCriterion("height_cover >", value, "heightCover");
            return (Criteria) this;
        }

        public Criteria andHeightCoverGreaterThanOrEqualTo(Integer value) {
            addCriterion("height_cover >=", value, "heightCover");
            return (Criteria) this;
        }

        public Criteria andHeightCoverLessThan(Integer value) {
            addCriterion("height_cover <", value, "heightCover");
            return (Criteria) this;
        }

        public Criteria andHeightCoverLessThanOrEqualTo(Integer value) {
            addCriterion("height_cover <=", value, "heightCover");
            return (Criteria) this;
        }

        public Criteria andHeightCoverIn(List<Integer> values) {
            addCriterion("height_cover in", values, "heightCover");
            return (Criteria) this;
        }

        public Criteria andHeightCoverNotIn(List<Integer> values) {
            addCriterion("height_cover not in", values, "heightCover");
            return (Criteria) this;
        }

        public Criteria andHeightCoverBetween(Integer value1, Integer value2) {
            addCriterion("height_cover between", value1, value2, "heightCover");
            return (Criteria) this;
        }

        public Criteria andHeightCoverNotBetween(Integer value1, Integer value2) {
            addCriterion("height_cover not between", value1, value2, "heightCover");
            return (Criteria) this;
        }

        public Criteria andDepthCoverIsNull() {
            addCriterion("depth_cover is null");
            return (Criteria) this;
        }

        public Criteria andDepthCoverIsNotNull() {
            addCriterion("depth_cover is not null");
            return (Criteria) this;
        }

        public Criteria andDepthCoverEqualTo(Integer value) {
            addCriterion("depth_cover =", value, "depthCover");
            return (Criteria) this;
        }

        public Criteria andDepthCoverNotEqualTo(Integer value) {
            addCriterion("depth_cover <>", value, "depthCover");
            return (Criteria) this;
        }

        public Criteria andDepthCoverGreaterThan(Integer value) {
            addCriterion("depth_cover >", value, "depthCover");
            return (Criteria) this;
        }

        public Criteria andDepthCoverGreaterThanOrEqualTo(Integer value) {
            addCriterion("depth_cover >=", value, "depthCover");
            return (Criteria) this;
        }

        public Criteria andDepthCoverLessThan(Integer value) {
            addCriterion("depth_cover <", value, "depthCover");
            return (Criteria) this;
        }

        public Criteria andDepthCoverLessThanOrEqualTo(Integer value) {
            addCriterion("depth_cover <=", value, "depthCover");
            return (Criteria) this;
        }

        public Criteria andDepthCoverIn(List<Integer> values) {
            addCriterion("depth_cover in", values, "depthCover");
            return (Criteria) this;
        }

        public Criteria andDepthCoverNotIn(List<Integer> values) {
            addCriterion("depth_cover not in", values, "depthCover");
            return (Criteria) this;
        }

        public Criteria andDepthCoverBetween(Integer value1, Integer value2) {
            addCriterion("depth_cover between", value1, value2, "depthCover");
            return (Criteria) this;
        }

        public Criteria andDepthCoverNotBetween(Integer value1, Integer value2) {
            addCriterion("depth_cover not between", value1, value2, "depthCover");
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

        public Criteria andWeightLbIsNull() {
            addCriterion("weight_lb is null");
            return (Criteria) this;
        }

        public Criteria andWeightLbIsNotNull() {
            addCriterion("weight_lb is not null");
            return (Criteria) this;
        }

        public Criteria andWeightLbEqualTo(Integer value) {
            addCriterion("weight_lb =", value, "weightLb");
            return (Criteria) this;
        }

        public Criteria andWeightLbNotEqualTo(Integer value) {
            addCriterion("weight_lb <>", value, "weightLb");
            return (Criteria) this;
        }

        public Criteria andWeightLbGreaterThan(Integer value) {
            addCriterion("weight_lb >", value, "weightLb");
            return (Criteria) this;
        }

        public Criteria andWeightLbGreaterThanOrEqualTo(Integer value) {
            addCriterion("weight_lb >=", value, "weightLb");
            return (Criteria) this;
        }

        public Criteria andWeightLbLessThan(Integer value) {
            addCriterion("weight_lb <", value, "weightLb");
            return (Criteria) this;
        }

        public Criteria andWeightLbLessThanOrEqualTo(Integer value) {
            addCriterion("weight_lb <=", value, "weightLb");
            return (Criteria) this;
        }

        public Criteria andWeightLbIn(List<Integer> values) {
            addCriterion("weight_lb in", values, "weightLb");
            return (Criteria) this;
        }

        public Criteria andWeightLbNotIn(List<Integer> values) {
            addCriterion("weight_lb not in", values, "weightLb");
            return (Criteria) this;
        }

        public Criteria andWeightLbBetween(Integer value1, Integer value2) {
            addCriterion("weight_lb between", value1, value2, "weightLb");
            return (Criteria) this;
        }

        public Criteria andWeightLbNotBetween(Integer value1, Integer value2) {
            addCriterion("weight_lb not between", value1, value2, "weightLb");
            return (Criteria) this;
        }

        public Criteria andHeightLbIsNull() {
            addCriterion("height_lb is null");
            return (Criteria) this;
        }

        public Criteria andHeightLbIsNotNull() {
            addCriterion("height_lb is not null");
            return (Criteria) this;
        }

        public Criteria andHeightLbEqualTo(Integer value) {
            addCriterion("height_lb =", value, "heightLb");
            return (Criteria) this;
        }

        public Criteria andHeightLbNotEqualTo(Integer value) {
            addCriterion("height_lb <>", value, "heightLb");
            return (Criteria) this;
        }

        public Criteria andHeightLbGreaterThan(Integer value) {
            addCriterion("height_lb >", value, "heightLb");
            return (Criteria) this;
        }

        public Criteria andHeightLbGreaterThanOrEqualTo(Integer value) {
            addCriterion("height_lb >=", value, "heightLb");
            return (Criteria) this;
        }

        public Criteria andHeightLbLessThan(Integer value) {
            addCriterion("height_lb <", value, "heightLb");
            return (Criteria) this;
        }

        public Criteria andHeightLbLessThanOrEqualTo(Integer value) {
            addCriterion("height_lb <=", value, "heightLb");
            return (Criteria) this;
        }

        public Criteria andHeightLbIn(List<Integer> values) {
            addCriterion("height_lb in", values, "heightLb");
            return (Criteria) this;
        }

        public Criteria andHeightLbNotIn(List<Integer> values) {
            addCriterion("height_lb not in", values, "heightLb");
            return (Criteria) this;
        }

        public Criteria andHeightLbBetween(Integer value1, Integer value2) {
            addCriterion("height_lb between", value1, value2, "heightLb");
            return (Criteria) this;
        }

        public Criteria andHeightLbNotBetween(Integer value1, Integer value2) {
            addCriterion("height_lb not between", value1, value2, "heightLb");
            return (Criteria) this;
        }

        public Criteria andWeightDbIsNull() {
            addCriterion("weight_db is null");
            return (Criteria) this;
        }

        public Criteria andWeightDbIsNotNull() {
            addCriterion("weight_db is not null");
            return (Criteria) this;
        }

        public Criteria andWeightDbEqualTo(Integer value) {
            addCriterion("weight_db =", value, "weightDb");
            return (Criteria) this;
        }

        public Criteria andWeightDbNotEqualTo(Integer value) {
            addCriterion("weight_db <>", value, "weightDb");
            return (Criteria) this;
        }

        public Criteria andWeightDbGreaterThan(Integer value) {
            addCriterion("weight_db >", value, "weightDb");
            return (Criteria) this;
        }

        public Criteria andWeightDbGreaterThanOrEqualTo(Integer value) {
            addCriterion("weight_db >=", value, "weightDb");
            return (Criteria) this;
        }

        public Criteria andWeightDbLessThan(Integer value) {
            addCriterion("weight_db <", value, "weightDb");
            return (Criteria) this;
        }

        public Criteria andWeightDbLessThanOrEqualTo(Integer value) {
            addCriterion("weight_db <=", value, "weightDb");
            return (Criteria) this;
        }

        public Criteria andWeightDbIn(List<Integer> values) {
            addCriterion("weight_db in", values, "weightDb");
            return (Criteria) this;
        }

        public Criteria andWeightDbNotIn(List<Integer> values) {
            addCriterion("weight_db not in", values, "weightDb");
            return (Criteria) this;
        }

        public Criteria andWeightDbBetween(Integer value1, Integer value2) {
            addCriterion("weight_db between", value1, value2, "weightDb");
            return (Criteria) this;
        }

        public Criteria andWeightDbNotBetween(Integer value1, Integer value2) {
            addCriterion("weight_db not between", value1, value2, "weightDb");
            return (Criteria) this;
        }

        public Criteria andHeightDbIsNull() {
            addCriterion("height_db is null");
            return (Criteria) this;
        }

        public Criteria andHeightDbIsNotNull() {
            addCriterion("height_db is not null");
            return (Criteria) this;
        }

        public Criteria andHeightDbEqualTo(Integer value) {
            addCriterion("height_db =", value, "heightDb");
            return (Criteria) this;
        }

        public Criteria andHeightDbNotEqualTo(Integer value) {
            addCriterion("height_db <>", value, "heightDb");
            return (Criteria) this;
        }

        public Criteria andHeightDbGreaterThan(Integer value) {
            addCriterion("height_db >", value, "heightDb");
            return (Criteria) this;
        }

        public Criteria andHeightDbGreaterThanOrEqualTo(Integer value) {
            addCriterion("height_db >=", value, "heightDb");
            return (Criteria) this;
        }

        public Criteria andHeightDbLessThan(Integer value) {
            addCriterion("height_db <", value, "heightDb");
            return (Criteria) this;
        }

        public Criteria andHeightDbLessThanOrEqualTo(Integer value) {
            addCriterion("height_db <=", value, "heightDb");
            return (Criteria) this;
        }

        public Criteria andHeightDbIn(List<Integer> values) {
            addCriterion("height_db in", values, "heightDb");
            return (Criteria) this;
        }

        public Criteria andHeightDbNotIn(List<Integer> values) {
            addCriterion("height_db not in", values, "heightDb");
            return (Criteria) this;
        }

        public Criteria andHeightDbBetween(Integer value1, Integer value2) {
            addCriterion("height_db between", value1, value2, "heightDb");
            return (Criteria) this;
        }

        public Criteria andHeightDbNotBetween(Integer value1, Integer value2) {
            addCriterion("height_db not between", value1, value2, "heightDb");
            return (Criteria) this;
        }

        public Criteria andColorIdIsNull() {
            addCriterion("color_id is null");
            return (Criteria) this;
        }

        public Criteria andColorIdIsNotNull() {
            addCriterion("color_id is not null");
            return (Criteria) this;
        }

        public Criteria andColorIdEqualTo(String value) {
            addCriterion("color_id =", value, "colorId");
            return (Criteria) this;
        }

        public Criteria andColorIdNotEqualTo(String value) {
            addCriterion("color_id <>", value, "colorId");
            return (Criteria) this;
        }

        public Criteria andColorIdGreaterThan(String value) {
            addCriterion("color_id >", value, "colorId");
            return (Criteria) this;
        }

        public Criteria andColorIdGreaterThanOrEqualTo(String value) {
            addCriterion("color_id >=", value, "colorId");
            return (Criteria) this;
        }

        public Criteria andColorIdLessThan(String value) {
            addCriterion("color_id <", value, "colorId");
            return (Criteria) this;
        }

        public Criteria andColorIdLessThanOrEqualTo(String value) {
            addCriterion("color_id <=", value, "colorId");
            return (Criteria) this;
        }

        public Criteria andColorIdLike(String value) {
            addCriterion("color_id like", value, "colorId");
            return (Criteria) this;
        }

        public Criteria andColorIdNotLike(String value) {
            addCriterion("color_id not like", value, "colorId");
            return (Criteria) this;
        }

        public Criteria andColorIdIn(List<String> values) {
            addCriterion("color_id in", values, "colorId");
            return (Criteria) this;
        }

        public Criteria andColorIdNotIn(List<String> values) {
            addCriterion("color_id not in", values, "colorId");
            return (Criteria) this;
        }

        public Criteria andColorIdBetween(String value1, String value2) {
            addCriterion("color_id between", value1, value2, "colorId");
            return (Criteria) this;
        }

        public Criteria andColorIdNotBetween(String value1, String value2) {
            addCriterion("color_id not between", value1, value2, "colorId");
            return (Criteria) this;
        }

        public Criteria andLineIdIsNull() {
            addCriterion("line_id is null");
            return (Criteria) this;
        }

        public Criteria andLineIdIsNotNull() {
            addCriterion("line_id is not null");
            return (Criteria) this;
        }

        public Criteria andLineIdEqualTo(String value) {
            addCriterion("line_id =", value, "lineId");
            return (Criteria) this;
        }

        public Criteria andLineIdNotEqualTo(String value) {
            addCriterion("line_id <>", value, "lineId");
            return (Criteria) this;
        }

        public Criteria andLineIdGreaterThan(String value) {
            addCriterion("line_id >", value, "lineId");
            return (Criteria) this;
        }

        public Criteria andLineIdGreaterThanOrEqualTo(String value) {
            addCriterion("line_id >=", value, "lineId");
            return (Criteria) this;
        }

        public Criteria andLineIdLessThan(String value) {
            addCriterion("line_id <", value, "lineId");
            return (Criteria) this;
        }

        public Criteria andLineIdLessThanOrEqualTo(String value) {
            addCriterion("line_id <=", value, "lineId");
            return (Criteria) this;
        }

        public Criteria andLineIdLike(String value) {
            addCriterion("line_id like", value, "lineId");
            return (Criteria) this;
        }

        public Criteria andLineIdNotLike(String value) {
            addCriterion("line_id not like", value, "lineId");
            return (Criteria) this;
        }

        public Criteria andLineIdIn(List<String> values) {
            addCriterion("line_id in", values, "lineId");
            return (Criteria) this;
        }

        public Criteria andLineIdNotIn(List<String> values) {
            addCriterion("line_id not in", values, "lineId");
            return (Criteria) this;
        }

        public Criteria andLineIdBetween(String value1, String value2) {
            addCriterion("line_id between", value1, value2, "lineId");
            return (Criteria) this;
        }

        public Criteria andLineIdNotBetween(String value1, String value2) {
            addCriterion("line_id not between", value1, value2, "lineId");
            return (Criteria) this;
        }

        public Criteria andLineSumIsNull() {
            addCriterion("line_sum is null");
            return (Criteria) this;
        }

        public Criteria andLineSumIsNotNull() {
            addCriterion("line_sum is not null");
            return (Criteria) this;
        }

        public Criteria andLineSumEqualTo(Integer value) {
            addCriterion("line_sum =", value, "lineSum");
            return (Criteria) this;
        }

        public Criteria andLineSumNotEqualTo(Integer value) {
            addCriterion("line_sum <>", value, "lineSum");
            return (Criteria) this;
        }

        public Criteria andLineSumGreaterThan(Integer value) {
            addCriterion("line_sum >", value, "lineSum");
            return (Criteria) this;
        }

        public Criteria andLineSumGreaterThanOrEqualTo(Integer value) {
            addCriterion("line_sum >=", value, "lineSum");
            return (Criteria) this;
        }

        public Criteria andLineSumLessThan(Integer value) {
            addCriterion("line_sum <", value, "lineSum");
            return (Criteria) this;
        }

        public Criteria andLineSumLessThanOrEqualTo(Integer value) {
            addCriterion("line_sum <=", value, "lineSum");
            return (Criteria) this;
        }

        public Criteria andLineSumIn(List<Integer> values) {
            addCriterion("line_sum in", values, "lineSum");
            return (Criteria) this;
        }

        public Criteria andLineSumNotIn(List<Integer> values) {
            addCriterion("line_sum not in", values, "lineSum");
            return (Criteria) this;
        }

        public Criteria andLineSumBetween(Integer value1, Integer value2) {
            addCriterion("line_sum between", value1, value2, "lineSum");
            return (Criteria) this;
        }

        public Criteria andLineSumNotBetween(Integer value1, Integer value2) {
            addCriterion("line_sum not between", value1, value2, "lineSum");
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

        public Criteria andIsModuleIsNull() {
            addCriterion("is_module is null");
            return (Criteria) this;
        }

        public Criteria andIsModuleIsNotNull() {
            addCriterion("is_module is not null");
            return (Criteria) this;
        }

        public Criteria andIsModuleEqualTo(Boolean value) {
            addCriterion("is_module =", value, "isModule");
            return (Criteria) this;
        }

        public Criteria andIsModuleNotEqualTo(Boolean value) {
            addCriterion("is_module <>", value, "isModule");
            return (Criteria) this;
        }

        public Criteria andIsModuleGreaterThan(Boolean value) {
            addCriterion("is_module >", value, "isModule");
            return (Criteria) this;
        }

        public Criteria andIsModuleGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_module >=", value, "isModule");
            return (Criteria) this;
        }

        public Criteria andIsModuleLessThan(Boolean value) {
            addCriterion("is_module <", value, "isModule");
            return (Criteria) this;
        }

        public Criteria andIsModuleLessThanOrEqualTo(Boolean value) {
            addCriterion("is_module <=", value, "isModule");
            return (Criteria) this;
        }

        public Criteria andIsModuleIn(List<Boolean> values) {
            addCriterion("is_module in", values, "isModule");
            return (Criteria) this;
        }

        public Criteria andIsModuleNotIn(List<Boolean> values) {
            addCriterion("is_module not in", values, "isModule");
            return (Criteria) this;
        }

        public Criteria andIsModuleBetween(Boolean value1, Boolean value2) {
            addCriterion("is_module between", value1, value2, "isModule");
            return (Criteria) this;
        }

        public Criteria andIsModuleNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_module not between", value1, value2, "isModule");
            return (Criteria) this;
        }

        public Criteria andModuleIdIsNull() {
            addCriterion("module_id is null");
            return (Criteria) this;
        }

        public Criteria andModuleIdIsNotNull() {
            addCriterion("module_id is not null");
            return (Criteria) this;
        }

        public Criteria andModuleIdEqualTo(String value) {
            addCriterion("module_id =", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdNotEqualTo(String value) {
            addCriterion("module_id <>", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdGreaterThan(String value) {
            addCriterion("module_id >", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdGreaterThanOrEqualTo(String value) {
            addCriterion("module_id >=", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdLessThan(String value) {
            addCriterion("module_id <", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdLessThanOrEqualTo(String value) {
            addCriterion("module_id <=", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdLike(String value) {
            addCriterion("module_id like", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdNotLike(String value) {
            addCriterion("module_id not like", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdIn(List<String> values) {
            addCriterion("module_id in", values, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdNotIn(List<String> values) {
            addCriterion("module_id not in", values, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdBetween(String value1, String value2) {
            addCriterion("module_id between", value1, value2, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdNotBetween(String value1, String value2) {
            addCriterion("module_id not between", value1, value2, "moduleId");
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