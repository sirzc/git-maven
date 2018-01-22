package com.sir.go.model.colleges.service.impl;

import com.sir.go.model.colleges.persistence.entity.ColSchool;
import com.sir.go.model.colleges.persistence.dao.ColSchoolMapper;
import com.sir.go.model.colleges.service.IColSchoolService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 全国高校库（教育部2017年6月更新） 服务实现类
 * </p>
 *
 * @author careertree
 * @since 2018-01-17
 */
@Service
public class ColSchoolServiceImpl extends ServiceImpl<ColSchoolMapper, ColSchool> implements IColSchoolService {
	
}
