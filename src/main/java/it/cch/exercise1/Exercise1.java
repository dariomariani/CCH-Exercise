package it.cch.exercise1;

import it.cch.data.Category;
import it.cch.data.TreeNode;

import java.util.Collections;
import java.util.List;

public class Exercise1 {
    /**
     * @param category the category of which find all descendants
     * @param root the root node of the tree
     *
     * @return the list of all descendants categories, including the category passed as input
     */
    public List<Category> findAllDescendantsBy(Category category, TreeNode root) {
        if (category.equals(root.getCategory())) return Collections.singletonList(category);
        return Collections.emptyList();
    }
}
