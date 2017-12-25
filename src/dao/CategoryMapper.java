package dao;
import java.util.List;
import vo.Category;

public interface CategoryMapper {
	public void addCategory(Category b);
		
		public void modifyCategory(Category b);
		
		public void deleteCategory(Category b);
		
		public Category selectCategory(Category b);
		
		public List<Category> queryCategory(Category b);
		
		public Integer countCategory(Category b);
	}
