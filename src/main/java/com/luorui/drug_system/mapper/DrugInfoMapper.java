package com.luorui.drug_system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.luorui.drug_system.entity.DrugInfo;
import org.springframework.stereotype.Repository;

/**
 * 药品的增删改查Mapper
 */
@Repository
public interface DrugInfoMapper extends BaseMapper<DrugInfo> {
}
