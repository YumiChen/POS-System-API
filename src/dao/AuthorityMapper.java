package dao;

import java.util.List;

import vo.Authority;

public interface AuthorityMapper {
public void addAuthority(Authority b);
	
	public void modifyAuthority(Authority b);
	
	public void deleteAuthority(Authority b);
	
	public Authority selectAuthority(Authority b);
	
	public List<Authority> queryAuthority(Authority b);
	
	public Integer countAuthority(Authority b);
}
