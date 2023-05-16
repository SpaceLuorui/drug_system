package com.luorui.drug_system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.luorui.drug_system.entity.Problem;
import org.springframework.stereotype.Repository;

/**
 * 问题药品的增删改查Mapper
 */
@Repository
public interface ProblemMapper extends BaseMapper<Problem> {
}
