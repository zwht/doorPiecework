package com.zw.cf.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TicketExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TicketExample() {
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

        public Criteria andDealersIdIsNull() {
            addCriterion("dealers_id is null");
            return (Criteria) this;
        }

        public Criteria andDealersIdIsNotNull() {
            addCriterion("dealers_id is not null");
            return (Criteria) this;
        }

        public Criteria andDealersIdEqualTo(String value) {
            addCriterion("dealers_id =", value, "dealersId");
            return (Criteria) this;
        }

        public Criteria andDealersIdNotEqualTo(String value) {
            addCriterion("dealers_id <>", value, "dealersId");
            return (Criteria) this;
        }

        public Criteria andDealersIdGreaterThan(String value) {
            addCriterion("dealers_id >", value, "dealersId");
            return (Criteria) this;
        }

        public Criteria andDealersIdGreaterThanOrEqualTo(String value) {
            addCriterion("dealers_id >=", value, "dealersId");
            return (Criteria) this;
        }

        public Criteria andDealersIdLessThan(String value) {
            addCriterion("dealers_id <", value, "dealersId");
            return (Criteria) this;
        }

        public Criteria andDealersIdLessThanOrEqualTo(String value) {
            addCriterion("dealers_id <=", value, "dealersId");
            return (Criteria) this;
        }

        public Criteria andDealersIdLike(String value) {
            addCriterion("dealers_id like", value, "dealersId");
            return (Criteria) this;
        }

        public Criteria andDealersIdNotLike(String value) {
            addCriterion("dealers_id not like", value, "dealersId");
            return (Criteria) this;
        }

        public Criteria andDealersIdIn(List<String> values) {
            addCriterion("dealers_id in", values, "dealersId");
            return (Criteria) this;
        }

        public Criteria andDealersIdNotIn(List<String> values) {
            addCriterion("dealers_id not in", values, "dealersId");
            return (Criteria) this;
        }

        public Criteria andDealersIdBetween(String value1, String value2) {
            addCriterion("dealers_id between", value1, value2, "dealersId");
            return (Criteria) this;
        }

        public Criteria andDealersIdNotBetween(String value1, String value2) {
            addCriterion("dealers_id not between", value1, value2, "dealersId");
            return (Criteria) this;
        }

        public Criteria andBrandIdIsNull() {
            addCriterion("brand_id is null");
            return (Criteria) this;
        }

        public Criteria andBrandIdIsNotNull() {
            addCriterion("brand_id is not null");
            return (Criteria) this;
        }

        public Criteria andBrandIdEqualTo(String value) {
            addCriterion("brand_id =", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotEqualTo(String value) {
            addCriterion("brand_id <>", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdGreaterThan(String value) {
            addCriterion("brand_id >", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdGreaterThanOrEqualTo(String value) {
            addCriterion("brand_id >=", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLessThan(String value) {
            addCriterion("brand_id <", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLessThanOrEqualTo(String value) {
            addCriterion("brand_id <=", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLike(String value) {
            addCriterion("brand_id like", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotLike(String value) {
            addCriterion("brand_id not like", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdIn(List<String> values) {
            addCriterion("brand_id in", values, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotIn(List<String> values) {
            addCriterion("brand_id not in", values, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdBetween(String value1, String value2) {
            addCriterion("brand_id between", value1, value2, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotBetween(String value1, String value2) {
            addCriterion("brand_id not between", value1, value2, "brandId");
            return (Criteria) this;
        }

        public Criteria andOddIsNull() {
            addCriterion("odd is null");
            return (Criteria) this;
        }

        public Criteria andOddIsNotNull() {
            addCriterion("odd is not null");
            return (Criteria) this;
        }

        public Criteria andOddEqualTo(String value) {
            addCriterion("odd =", value, "odd");
            return (Criteria) this;
        }

        public Criteria andOddNotEqualTo(String value) {
            addCriterion("odd <>", value, "odd");
            return (Criteria) this;
        }

        public Criteria andOddGreaterThan(String value) {
            addCriterion("odd >", value, "odd");
            return (Criteria) this;
        }

        public Criteria andOddGreaterThanOrEqualTo(String value) {
            addCriterion("odd >=", value, "odd");
            return (Criteria) this;
        }

        public Criteria andOddLessThan(String value) {
            addCriterion("odd <", value, "odd");
            return (Criteria) this;
        }

        public Criteria andOddLessThanOrEqualTo(String value) {
            addCriterion("odd <=", value, "odd");
            return (Criteria) this;
        }

        public Criteria andOddLike(String value) {
            addCriterion("odd like", value, "odd");
            return (Criteria) this;
        }

        public Criteria andOddNotLike(String value) {
            addCriterion("odd not like", value, "odd");
            return (Criteria) this;
        }

        public Criteria andOddIn(List<String> values) {
            addCriterion("odd in", values, "odd");
            return (Criteria) this;
        }

        public Criteria andOddNotIn(List<String> values) {
            addCriterion("odd not in", values, "odd");
            return (Criteria) this;
        }

        public Criteria andOddBetween(String value1, String value2) {
            addCriterion("odd between", value1, value2, "odd");
            return (Criteria) this;
        }

        public Criteria andOddNotBetween(String value1, String value2) {
            addCriterion("odd not between", value1, value2, "odd");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
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

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andOverTimeIsNull() {
            addCriterion("over_time is null");
            return (Criteria) this;
        }

        public Criteria andOverTimeIsNotNull() {
            addCriterion("over_time is not null");
            return (Criteria) this;
        }

        public Criteria andOverTimeEqualTo(Date value) {
            addCriterion("over_time =", value, "overTime");
            return (Criteria) this;
        }

        public Criteria andOverTimeNotEqualTo(Date value) {
            addCriterion("over_time <>", value, "overTime");
            return (Criteria) this;
        }

        public Criteria andOverTimeGreaterThan(Date value) {
            addCriterion("over_time >", value, "overTime");
            return (Criteria) this;
        }

        public Criteria andOverTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("over_time >=", value, "overTime");
            return (Criteria) this;
        }

        public Criteria andOverTimeLessThan(Date value) {
            addCriterion("over_time <", value, "overTime");
            return (Criteria) this;
        }

        public Criteria andOverTimeLessThanOrEqualTo(Date value) {
            addCriterion("over_time <=", value, "overTime");
            return (Criteria) this;
        }

        public Criteria andOverTimeIn(List<Date> values) {
            addCriterion("over_time in", values, "overTime");
            return (Criteria) this;
        }

        public Criteria andOverTimeNotIn(List<Date> values) {
            addCriterion("over_time not in", values, "overTime");
            return (Criteria) this;
        }

        public Criteria andOverTimeBetween(Date value1, Date value2) {
            addCriterion("over_time between", value1, value2, "overTime");
            return (Criteria) this;
        }

        public Criteria andOverTimeNotBetween(Date value1, Date value2) {
            addCriterion("over_time not between", value1, value2, "overTime");
            return (Criteria) this;
        }

        public Criteria andProductIdsIsNull() {
            addCriterion("product_ids is null");
            return (Criteria) this;
        }

        public Criteria andProductIdsIsNotNull() {
            addCriterion("product_ids is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdsEqualTo(String value) {
            addCriterion("product_ids =", value, "productIds");
            return (Criteria) this;
        }

        public Criteria andProductIdsNotEqualTo(String value) {
            addCriterion("product_ids <>", value, "productIds");
            return (Criteria) this;
        }

        public Criteria andProductIdsGreaterThan(String value) {
            addCriterion("product_ids >", value, "productIds");
            return (Criteria) this;
        }

        public Criteria andProductIdsGreaterThanOrEqualTo(String value) {
            addCriterion("product_ids >=", value, "productIds");
            return (Criteria) this;
        }

        public Criteria andProductIdsLessThan(String value) {
            addCriterion("product_ids <", value, "productIds");
            return (Criteria) this;
        }

        public Criteria andProductIdsLessThanOrEqualTo(String value) {
            addCriterion("product_ids <=", value, "productIds");
            return (Criteria) this;
        }

        public Criteria andProductIdsLike(String value) {
            addCriterion("product_ids like", value, "productIds");
            return (Criteria) this;
        }

        public Criteria andProductIdsNotLike(String value) {
            addCriterion("product_ids not like", value, "productIds");
            return (Criteria) this;
        }

        public Criteria andProductIdsIn(List<String> values) {
            addCriterion("product_ids in", values, "productIds");
            return (Criteria) this;
        }

        public Criteria andProductIdsNotIn(List<String> values) {
            addCriterion("product_ids not in", values, "productIds");
            return (Criteria) this;
        }

        public Criteria andProductIdsBetween(String value1, String value2) {
            addCriterion("product_ids between", value1, value2, "productIds");
            return (Criteria) this;
        }

        public Criteria andProductIdsNotBetween(String value1, String value2) {
            addCriterion("product_ids not between", value1, value2, "productIds");
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

        public Criteria andNumberIsNull() {
            addCriterion("number is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("number is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(String value) {
            addCriterion("number =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(String value) {
            addCriterion("number <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(String value) {
            addCriterion("number >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(String value) {
            addCriterion("number >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(String value) {
            addCriterion("number <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(String value) {
            addCriterion("number <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLike(String value) {
            addCriterion("number like", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotLike(String value) {
            addCriterion("number not like", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<String> values) {
            addCriterion("number in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<String> values) {
            addCriterion("number not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(String value1, String value2) {
            addCriterion("number between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(String value1, String value2) {
            addCriterion("number not between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andPayIsNull() {
            addCriterion("pay is null");
            return (Criteria) this;
        }

        public Criteria andPayIsNotNull() {
            addCriterion("pay is not null");
            return (Criteria) this;
        }

        public Criteria andPayEqualTo(Float value) {
            addCriterion("pay =", value, "pay");
            return (Criteria) this;
        }

        public Criteria andPayNotEqualTo(Float value) {
            addCriterion("pay <>", value, "pay");
            return (Criteria) this;
        }

        public Criteria andPayGreaterThan(Float value) {
            addCriterion("pay >", value, "pay");
            return (Criteria) this;
        }

        public Criteria andPayGreaterThanOrEqualTo(Float value) {
            addCriterion("pay >=", value, "pay");
            return (Criteria) this;
        }

        public Criteria andPayLessThan(Float value) {
            addCriterion("pay <", value, "pay");
            return (Criteria) this;
        }

        public Criteria andPayLessThanOrEqualTo(Float value) {
            addCriterion("pay <=", value, "pay");
            return (Criteria) this;
        }

        public Criteria andPayIn(List<Float> values) {
            addCriterion("pay in", values, "pay");
            return (Criteria) this;
        }

        public Criteria andPayNotIn(List<Float> values) {
            addCriterion("pay not in", values, "pay");
            return (Criteria) this;
        }

        public Criteria andPayBetween(Float value1, Float value2) {
            addCriterion("pay between", value1, value2, "pay");
            return (Criteria) this;
        }

        public Criteria andPayNotBetween(Float value1, Float value2) {
            addCriterion("pay not between", value1, value2, "pay");
            return (Criteria) this;
        }

        public Criteria andSumDoorIsNull() {
            addCriterion("sum_door is null");
            return (Criteria) this;
        }

        public Criteria andSumDoorIsNotNull() {
            addCriterion("sum_door is not null");
            return (Criteria) this;
        }

        public Criteria andSumDoorEqualTo(Float value) {
            addCriterion("sum_door =", value, "sumDoor");
            return (Criteria) this;
        }

        public Criteria andSumDoorNotEqualTo(Float value) {
            addCriterion("sum_door <>", value, "sumDoor");
            return (Criteria) this;
        }

        public Criteria andSumDoorGreaterThan(Float value) {
            addCriterion("sum_door >", value, "sumDoor");
            return (Criteria) this;
        }

        public Criteria andSumDoorGreaterThanOrEqualTo(Float value) {
            addCriterion("sum_door >=", value, "sumDoor");
            return (Criteria) this;
        }

        public Criteria andSumDoorLessThan(Float value) {
            addCriterion("sum_door <", value, "sumDoor");
            return (Criteria) this;
        }

        public Criteria andSumDoorLessThanOrEqualTo(Float value) {
            addCriterion("sum_door <=", value, "sumDoor");
            return (Criteria) this;
        }

        public Criteria andSumDoorIn(List<Float> values) {
            addCriterion("sum_door in", values, "sumDoor");
            return (Criteria) this;
        }

        public Criteria andSumDoorNotIn(List<Float> values) {
            addCriterion("sum_door not in", values, "sumDoor");
            return (Criteria) this;
        }

        public Criteria andSumDoorBetween(Float value1, Float value2) {
            addCriterion("sum_door between", value1, value2, "sumDoor");
            return (Criteria) this;
        }

        public Criteria andSumDoorNotBetween(Float value1, Float value2) {
            addCriterion("sum_door not between", value1, value2, "sumDoor");
            return (Criteria) this;
        }

        public Criteria andSumTaobanIsNull() {
            addCriterion("sum_taoban is null");
            return (Criteria) this;
        }

        public Criteria andSumTaobanIsNotNull() {
            addCriterion("sum_taoban is not null");
            return (Criteria) this;
        }

        public Criteria andSumTaobanEqualTo(Float value) {
            addCriterion("sum_taoban =", value, "sumTaoban");
            return (Criteria) this;
        }

        public Criteria andSumTaobanNotEqualTo(Float value) {
            addCriterion("sum_taoban <>", value, "sumTaoban");
            return (Criteria) this;
        }

        public Criteria andSumTaobanGreaterThan(Float value) {
            addCriterion("sum_taoban >", value, "sumTaoban");
            return (Criteria) this;
        }

        public Criteria andSumTaobanGreaterThanOrEqualTo(Float value) {
            addCriterion("sum_taoban >=", value, "sumTaoban");
            return (Criteria) this;
        }

        public Criteria andSumTaobanLessThan(Float value) {
            addCriterion("sum_taoban <", value, "sumTaoban");
            return (Criteria) this;
        }

        public Criteria andSumTaobanLessThanOrEqualTo(Float value) {
            addCriterion("sum_taoban <=", value, "sumTaoban");
            return (Criteria) this;
        }

        public Criteria andSumTaobanIn(List<Float> values) {
            addCriterion("sum_taoban in", values, "sumTaoban");
            return (Criteria) this;
        }

        public Criteria andSumTaobanNotIn(List<Float> values) {
            addCriterion("sum_taoban not in", values, "sumTaoban");
            return (Criteria) this;
        }

        public Criteria andSumTaobanBetween(Float value1, Float value2) {
            addCriterion("sum_taoban between", value1, value2, "sumTaoban");
            return (Criteria) this;
        }

        public Criteria andSumTaobanNotBetween(Float value1, Float value2) {
            addCriterion("sum_taoban not between", value1, value2, "sumTaoban");
            return (Criteria) this;
        }

        public Criteria andSumLineIsNull() {
            addCriterion("sum_line is null");
            return (Criteria) this;
        }

        public Criteria andSumLineIsNotNull() {
            addCriterion("sum_line is not null");
            return (Criteria) this;
        }

        public Criteria andSumLineEqualTo(Float value) {
            addCriterion("sum_line =", value, "sumLine");
            return (Criteria) this;
        }

        public Criteria andSumLineNotEqualTo(Float value) {
            addCriterion("sum_line <>", value, "sumLine");
            return (Criteria) this;
        }

        public Criteria andSumLineGreaterThan(Float value) {
            addCriterion("sum_line >", value, "sumLine");
            return (Criteria) this;
        }

        public Criteria andSumLineGreaterThanOrEqualTo(Float value) {
            addCriterion("sum_line >=", value, "sumLine");
            return (Criteria) this;
        }

        public Criteria andSumLineLessThan(Float value) {
            addCriterion("sum_line <", value, "sumLine");
            return (Criteria) this;
        }

        public Criteria andSumLineLessThanOrEqualTo(Float value) {
            addCriterion("sum_line <=", value, "sumLine");
            return (Criteria) this;
        }

        public Criteria andSumLineIn(List<Float> values) {
            addCriterion("sum_line in", values, "sumLine");
            return (Criteria) this;
        }

        public Criteria andSumLineNotIn(List<Float> values) {
            addCriterion("sum_line not in", values, "sumLine");
            return (Criteria) this;
        }

        public Criteria andSumLineBetween(Float value1, Float value2) {
            addCriterion("sum_line between", value1, value2, "sumLine");
            return (Criteria) this;
        }

        public Criteria andSumLineNotBetween(Float value1, Float value2) {
            addCriterion("sum_line not between", value1, value2, "sumLine");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
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