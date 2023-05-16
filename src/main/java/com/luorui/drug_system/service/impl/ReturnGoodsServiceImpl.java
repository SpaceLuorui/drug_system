package com.luorui.drug_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luorui.drug_system.entity.ReturnGoods;
import com.luorui.drug_system.mapper.ReturnGoodsMapper;
import com.luorui.drug_system.service.ReturnGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

/**
 * @author 罗锐
 * @date 2023/5/6
 */
@Service
public class ReturnGoodsServiceImpl extends ServiceImpl<ReturnGoodsMapper,ReturnGoods> implements ReturnGoodsService {
    @Autowired
    private ReturnGoodsMapper returnGoodsMapper;
    /**
     * 分页查询收到退货数据
     *
     * @param pageNum  第几页
     * @param pageSize 每页多少条数据
     * @param param    查询参数-收到退货名称
     * @return 返回结果
     */
    @Override
    public IPage<ReturnGoods> queryReturnGoodsPage(int pageNum, int pageSize, String param) {
        QueryWrapper<ReturnGoods> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(param)){
            queryWrapper.like("dname",param);
        }
        Page<ReturnGoods> page = new Page<>(pageNum,pageSize);
        return returnGoodsMapper.selectPage(page,queryWrapper);
    }

    /**
     * 新增一条收到退货信息
     *
     * @param returnGoods 退货
     */
    @Override
    public int addReturnGoods(ReturnGoods returnGoods) {
        return returnGoodsMapper.insert(returnGoods);
    }

    /**
     * 修改一条收到退货信息
     *
     * @param returnGoods 退货
     */
    @Override
    public int editReturnGoods(ReturnGoods returnGoods) {
        return returnGoodsMapper.updateById(returnGoods);
    }

    /**
     * 根据主键id查询一个收到退货对象
     *
     * @param id id
     * @return 返回结果
     */
    @Override
    public ReturnGoods queryReturnGoodsById(Integer id) {
        return returnGoodsMapper.selectById(id);
    }

    /**
     * 根据主键id删除一个收到退货对象
     *
     * @param id id
     * @return 返回结果
     */
    @Override
    public int delReturnGoodsById(Integer id) {
        return returnGoodsMapper.deleteById(id);
    }
}
