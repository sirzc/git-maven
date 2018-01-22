package com.sir.go.model.colleges.service.impl;

import com.sir.go.model.colleges.persistence.entity.ColMajor;
import com.sir.go.model.colleges.persistence.dao.ColMajorMapper;
import com.sir.go.model.colleges.service.IColMajorService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 全国高校专业表（教育部2012年更新） 服务实现类
 * </p>
 *
 * @author careertree
 * @since 2018-01-17
 */
@Service
public class ColMajorServiceImpl extends ServiceImpl<ColMajorMapper, ColMajor> implements IColMajorService {
	
}
