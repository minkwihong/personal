package com.ksign.access.mapper;

import java.util.ArrayList;
import java.util.HashMap;

public interface KAAuditMapper {
	public int selectKAAuditListCount(HashMap<String, Object> paramMap);
	public ArrayList<HashMap<String, Object>> selectKAAuditList(HashMap<String, Object> paramMap);
}
