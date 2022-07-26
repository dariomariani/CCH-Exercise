package it.cch.exercise1;

import it.cch.data.Category;
import it.cch.data.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Exercise1 {
    /**
     * @param category the category of which find all descendants
     * @param root the root node of the tree
     *
     * @return the list of all descendants categories, including the category passed as input
     */
    public List<Category> findAllDescendantsBy(Category category, TreeNode root) {
        var categoriesFound = new LinkedList<Category>();
        categoriesFound.addAll(findCategory(category, root));
        if (!root.getChildren().isEmpty()){
            root.getChildren().forEach(treeNode -> {
                categoriesFound.addAll(findCategory(category, treeNode));
            });
        }
        return categoriesFound;
    }

    private List<Category> findCategory(Category category, TreeNode currentNode){
        var result = new LinkedList<Category>();
        if (category.equals(currentNode.getCategory())) result.add(currentNode.getCategory());
        return result;
    }
}
