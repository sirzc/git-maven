package com.sir.go.model.job.service.impl;

import com.sir.go.model.job.persistence.entity.JTest;
import com.sir.go.model.job.persistence.dao.JTestMapper;
import com.sir.go.model.job.service.IJTestService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author careertree
 * @since 2018-01-03
 */
@Service
public class JTestServiceImpl extends ServiceImpl<JTestMapper, JTest> implements IJTestService {
	
}
