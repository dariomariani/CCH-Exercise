package it.cch.exercise1;

import it.cch.data.Category;
import it.cch.data.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exercise1Test {

    private final Exercise1 exercise1 = new Exercise1();
    @Test
    public void testFindDescendingWhenTreeHasOnlyRootAndCategoryFoundReturnRoot(){
        var root = new TreeNode(Category.CAT1);
        assertEquals(Collections.singletonList(Category.CAT1), exercise1.findAllDescendantsBy(Category.CAT1, root));
    }

    @Test
    public void testFindDescendingWhenTreeHasOnlyRootAndCategoryNotFoundReturnEmptyList(){
        var root = new TreeNode(Category.CAT2);
        assertEquals(Collections.emptyList(), exercise1.findAllDescendantsBy(Category.CAT1, root));
    }

    @Test
    public void testFindDescendingWhenTreeHasOneLevelAndCategoryFoundAtLevelOneReturnSingleNode(){
        var root = new TreeNode(Category.CAT1);
        var firstLevel = List.of(new TreeNode(Category.CAT2),new TreeNode(Category.CAT3));
        root.setChildren(firstLevel);
        assertEquals(Collections.singletonList(Category.CAT2), exercise1.findAllDescendantsBy(Category.CAT2, root));
    }

    @Test
    public void testFindDescendingWhenTreeHasOneLevelAndCategoryNotFoundReturnEmptyList(){
        var root = new TreeNode(Category.CAT1);
        var firstLevel = List.of(new TreeNode(Category.CAT2),new TreeNode(Category.CAT3));
        root.setChildren(firstLevel);
        assertEquals(Collections.emptyList(), exercise1.findAllDescendantsBy(Category.CAT4, root));
    }

}
