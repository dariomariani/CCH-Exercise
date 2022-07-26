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
        visitTree(category, false, categoriesFound, root);
        return categoriesFound;
    }

    private void visitTree(Category categoryToSearch, boolean nodeFound, List<Category> result, TreeNode currentNode){
        var found = nodeFound || currentNode.getCategory().equals(categoryToSearch);
        if (found) result.add(currentNode.getCategory());
        currentNode.getChildren().forEach(treeNode -> visitTree(categoryToSearch, found, result, treeNode));
    }
}
