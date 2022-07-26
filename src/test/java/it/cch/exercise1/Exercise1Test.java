package it.cch.exercise1;

import it.cch.data.Category;
import it.cch.data.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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
    public void testFindDescendingWhenTreeHasTwoLevelAndCategoryFoundAtLevelZeroReturnSubtree(){
        var root = new TreeNode(Category.CAT1);
        var firstLevel = List.of(new TreeNode(Category.CAT2),new TreeNode(Category.CAT3));
        root.setChildren(firstLevel);
        assertEquals(List.of(Category.CAT1, Category.CAT2, Category.CAT3), exercise1.findAllDescendantsBy(Category.CAT1, root));
    }

    @Test
    public void testFindDescendingWhenTreeHasThreeLevelAndCategoryFoundAtLevelZeroReturnSubtree(){
        var root = new TreeNode(Category.CAT1);
        var firstRootChild = new TreeNode(Category.CAT2);
        var secondRootChild = new TreeNode(Category.CAT3);
        var firstLevel = List.of(firstRootChild,secondRootChild);
        root.setChildren(firstLevel);
        var secondLevel = List.of(new TreeNode(Category.CAT4),new TreeNode(Category.CAT5));
        firstRootChild.setChildren(secondLevel);
        assertThat(List.of(Category.CAT1, Category.CAT2, Category.CAT3, Category.CAT4, Category.CAT5)).hasSameElementsAs(exercise1.findAllDescendantsBy(Category.CAT1, root));
    }

    @Test
    public void testFindDescendingWhenTreeHasOneLevelAndCategoryNotFoundReturnEmptyList(){
        var root = new TreeNode(Category.CAT1);
        var firstLevel = List.of(new TreeNode(Category.CAT2),new TreeNode(Category.CAT3));
        root.setChildren(firstLevel);
        assertEquals(Collections.emptyList(), exercise1.findAllDescendantsBy(Category.CAT4, root));
    }
    @Test
    public void testFindDescendingWhenTreeHasTwoLevelAndCategoryFoundAtLevelTwoReturnSingleNode(){
        var root = new TreeNode(Category.CAT1);
        var firstRootChild = new TreeNode(Category.CAT2);
        var secondRootChild = new TreeNode(Category.CAT3);
        var firstLevel = List.of(firstRootChild,secondRootChild);
        root.setChildren(firstLevel);
        var secondLevel = List.of(new TreeNode(Category.CAT4),new TreeNode(Category.CAT5));
        firstRootChild.setChildren(secondLevel);
        assertEquals(Collections.singletonList(Category.CAT4), exercise1.findAllDescendantsBy(Category.CAT4, root));
    }

    @Test
    public void testFindDescendingWhenTreeHasThreeLevelAndCategoryFoundAtLevelOneReturnSubTree(){
        var root = new TreeNode(Category.CAT1);
        var firstRootChild = new TreeNode(Category.CAT2);
        var secondRootChild = new TreeNode(Category.CAT3);
        var firstLevel = List.of(firstRootChild,secondRootChild);
        root.setChildren(firstLevel);
        var secondLevel = List.of(new TreeNode(Category.CAT4),new TreeNode(Category.CAT5));
        firstRootChild.setChildren(secondLevel);
        assertThat(List.of(Category.CAT2, Category.CAT4,Category.CAT5)).hasSameElementsAs(exercise1.findAllDescendantsBy(Category.CAT2, root));
    }

    @Test
    public void testFindDescendingWhenTreeHasThreeCompleteLevelsAndCategoryFoundAtLevelOneReturnSubTree(){
        var root = new TreeNode(Category.CAT1);
        var firstRootChild = new TreeNode(Category.CAT2);
        var secondRootChild = new TreeNode(Category.CAT3);
        var firstLevel = List.of(firstRootChild,secondRootChild);
        root.setChildren(firstLevel);
        var secondLevelFirstParent = List.of(new TreeNode(Category.CAT4),new TreeNode(Category.CAT5));
        firstRootChild.setChildren(secondLevelFirstParent);
        var secondLevelSecondParent = List.of(new TreeNode(Category.CAT6),new TreeNode(Category.CAT7));
        secondRootChild.setChildren(secondLevelSecondParent);
        assertThat(List.of(Category.CAT2, Category.CAT4,Category.CAT5)).hasSameElementsAs(exercise1.findAllDescendantsBy(Category.CAT2, root));
    }

}
