package com.sir.go.model.colleges.service.impl;

import com.sir.go.model.colleges.persistence.entity.ColTest;
import com.sir.go.model.colleges.persistence.dao.ColTestMapper;
import com.sir.go.model.colleges.service.IColTestService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 测试表 服务实现类
 * </p>
 *
 * @author careertree
 * @since 2018-01-17
 */
@Service
public class ColTestServiceImpl extends ServiceImpl<ColTestMapper, ColTest> implements IColTestService {
	
}
