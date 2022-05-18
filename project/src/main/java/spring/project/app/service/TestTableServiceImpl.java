package spring.project.app.service;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.project.app.model.mapper.TestTableMapper;

@Service
public class TestTableServiceImpl implements TestTableService {

	@Autowired
	TestTableMapper testtablemapper;

	@Override
	public List<Map<String, Object>> SelectAllList() throws Exception {
// TODO Auto-generated method stub
		return testtablemapper.SelectAllList();
	}

}