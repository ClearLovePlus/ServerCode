package com.chenhao.service.impl;

import com.chenhao.common.enums.BusinessEnum;
import com.chenhao.common.exception.BusinessException;
import com.chenhao.dao.entity.*;
import com.chenhao.dao.mapper.ArticleMapper;
import com.chenhao.dao.mapper.CategoriesMapper;
import com.chenhao.dao.mapper.CategoryArticleRelationMapper;
import com.chenhao.dto.request.AddCategoriesRequestDTO;
import com.chenhao.dto.request.CategoryArticleRelationAddRequestDTO;
import com.chenhao.dto.response.CategoryResponse;
import com.chenhao.service.BaseLoginService;
import com.chenhao.service.ICategoriesService;
import com.chenhao.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: chenhao
 * @date: 2021-11-22 14:32
 */
@Component("categoriesService")
public class CategoriesServiceImpl implements ICategoriesService {
    /**
     * 不符合规则的userId
     */
    private static final Integer ILLEGAL_USERID = 0;
    /**
     * 未被删除的
     */
    private static final Integer IS_ACTIVE = 1;
    @Resource
    private CategoriesMapper categoriesMapper;
    @Resource
    private CategoryArticleRelationMapper categoryArticleRelationMapper;
    @Resource
    private ArticleMapper articleMapper;
    @Autowired
    private IUserService userService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean addCategories(List<AddCategoriesRequestDTO> list) throws Exception {
        if (CollectionUtils.isEmpty(list)) {
            throw new BusinessException(BusinessEnum.MISSING_PARAMETER);
        }
        List<AddCategoriesRequestDTO> collect = list.stream().filter(this::existOrNo).collect(Collectors.toList());
        List<Categories> dataToDbList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(collect)) {
            collect.forEach(p -> {
                Categories data = new Categories();
                data.setCreatetime(new Date());
                data.setUserid(p.getUserId());
                data.setCategoryname(p.getCategoryName());
                data.setIsActive(1);
                data.setUpdatetime(new Date());
                dataToDbList.add(data);
            });
            return categoriesMapper.insertBatch(dataToDbList) > ILLEGAL_USERID;
        }
        return false;
    }

    @Override
    public List<CategoryResponse> getCategoriesBelongToTheUser(Integer userId) throws Exception {
        if (ILLEGAL_USERID.equals(userId)) {
            throw new BusinessException(BusinessEnum.MISSING_USER_ID_OR_USER_NAME);
        }
        User userByUserId = userService.getUserByUserId(userId);
        //用户不存在
        if (userByUserId == null) {
            throw new BusinessException(BusinessEnum.USER_NOT_LOGIN_IN);
        }
        List<CategoryResponse> result = new ArrayList<>();
        CategoriesExample example = new CategoriesExample();
        example.createCriteria().andUseridEqualTo(userId)
                .andIsActiveEqualTo(IS_ACTIVE);
        List<Categories> categories = categoriesMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(categories)) {
            Categories defaultCategory = defaultCategory();
            CategoryResponse response = new CategoryResponse();
            response.setUserId(defaultCategory.getUserid());
            response.setCategoryName(defaultCategory.getCategoryname());
            result.add(response);
        } else {
            categories.forEach(p -> {
                CategoryResponse response = new CategoryResponse();
                response.setUserId(p.getUserid());
                response.setCategoryName(p.getCategoryname());
                result.add(response);
            });
        }
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean addCategoryArticleRelation(Integer categoryId, Integer articleId, Integer userId) throws Exception {
        if (categoryId.equals(ILLEGAL_USERID) || articleId.equals(ILLEGAL_USERID)) {
            throw new BusinessException(BusinessEnum.MISSING_PARAMETER);
        }
        User userByUserId = userService.getUserByUserId(userId);
        if (userByUserId == null) {
            throw new BusinessException(BusinessEnum.USER_NOT_EXIST);
        }
        //判断标签和人的是否对的上
        CategoriesExample example = new CategoriesExample();
        example.createCriteria().andIsActiveEqualTo(IS_ACTIVE).andUseridEqualTo(userId).andIdEqualTo(categoryId);
        List<Categories> categories = categoriesMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(categories)) {
            throw new BusinessException(BusinessEnum.CATEGORY_NOT_EXIST);
        }
        //判断文章是否对得上
        ArticleExample articleExample = new ArticleExample();
        articleExample.createCriteria().andIdEqualTo(articleId).andAuthoridEqualTo(userId).andIsActiveEqualTo(IS_ACTIVE);
        if (CollectionUtils.isEmpty(articleMapper.selectByExample(articleExample))) {
            throw new BusinessException(BusinessEnum.ARTICLE_NOT_BELONG_TO_THE_USER);
        }
        CategoryArticleRelation relation = new CategoryArticleRelation();
        relation.setCategoryId(categoryId);
        relation.setArticleId(articleId);
        relation.setCreatetime(new Date());
        relation.setUpdatetime(new Date());
        relation.setIsActive(1);
        return categoryArticleRelationMapper.insertSelective(relation) > ILLEGAL_USERID;
    }

    @Override
    public Categories getCategoryByUserIdAndName(Integer userId, String name) throws Exception {
        if (userId == null || userId.equals(ILLEGAL_USERID) || StringUtils.isEmpty(name)) {
            throw new BusinessException(BusinessEnum.USER_NOT_EXIST);
        }
        CategoriesExample example = new CategoriesExample();
        example.createCriteria().andIsActiveEqualTo(IS_ACTIVE).andUseridEqualTo(userId).andCategorynameEqualTo(name);
        List<Categories> categories = categoriesMapper.selectByExample(example);
        return CollectionUtils.isEmpty(categories) ? null : categories.get(0);
    }

    @Override
    public Categories getDefault() throws Exception {
        return this.defaultCategory();
    }

    /**
     * 判断新增的标签是否已经存在了
     *
     * @param request
     * @return
     */
    private boolean existOrNo(AddCategoriesRequestDTO request) {
        CategoriesExample example = new CategoriesExample();
        example.createCriteria().andCategorynameEqualTo(request.getCategoryName())
                .andUseridEqualTo(request.getUserId());
        List<Categories> categories = categoriesMapper.selectByExample(example);
        return CollectionUtils.isEmpty(categories);
    }

    /**
     * 没有任何分类的返回默认的分类
     *
     * @return
     */
    private Categories defaultCategory() {
        return categoriesMapper.selectByPrimaryKey(1);
    }

}
