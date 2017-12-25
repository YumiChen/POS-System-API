package dao;

import java.util.HashMap;
import java.util.List;

import vo.User;

public interface TableMapper {
	public List<HashMap<String,String>> selectTable();
	public List<String> selectTableNames();
	public List<HashMap<String,String>> selectOneTable(String name);
	public List<String> getPK(String name);
}
