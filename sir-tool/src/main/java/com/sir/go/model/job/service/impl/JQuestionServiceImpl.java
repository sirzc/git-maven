package com.sir.go.model.job.service.impl;

import com.sir.go.model.job.persistence.entity.JQuestion;
import com.sir.go.model.job.persistence.dao.JQuestionMapper;
import com.sir.go.model.job.service.IJQuestionService;
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
public class JQuestionServiceImpl extends ServiceImpl<JQuestionMapper, JQuestion> implements IJQuestionService {
	
}
