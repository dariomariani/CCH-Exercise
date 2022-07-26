package it.cch.data;

import lombok.*;

import java.util.List;
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TreeNode {
    @Getter @NonNull @EqualsAndHashCode.Include Category category;
    @Getter @Setter List<TreeNode> children;
}
