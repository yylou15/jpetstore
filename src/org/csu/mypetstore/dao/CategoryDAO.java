package org.csu.mypetstore.dao;

import org.csu.mypetstore.domain.Category;

import java.util.List;

public interface CategoryDAO {
    //Select All category
    List<Category> getCategoryList();
    //Select By Id
    Category getCategory(String categoryId);
}
