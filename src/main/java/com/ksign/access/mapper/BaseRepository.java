package com.ksign.access.mapper;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseRepository implements IMapper {
	@Autowired
	protected SqlSessionTemplate sqlSession;
}
