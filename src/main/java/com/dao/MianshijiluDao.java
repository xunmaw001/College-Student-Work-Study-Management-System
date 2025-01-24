package com.dao;

import com.entity.MianshijiluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.MianshijiluView;

/**
 * 面试记录 Dao 接口
 *
 * @author 
 */
public interface MianshijiluDao extends BaseMapper<MianshijiluEntity> {

   List<MianshijiluView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
