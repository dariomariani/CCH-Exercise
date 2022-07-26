package it.cch.data;

import lombok.Getter;

import java.util.List;

public class TreeNode {
    @Getter Category category;
    @Getter List<TreeNode> children;
}
