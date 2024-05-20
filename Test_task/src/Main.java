import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class TreeNode {
    private int value;
    private List<TreeNode> children;
}

public class TreeSearcher {

    // Метод для поиска узлов с value больше N в дереве
    public List<TreeNode> findNodesWithValueGreaterThan(TreeNode root, int n) {
        // Создаем пустой список для хранения найденных узлов
        List<TreeNode> result = new ArrayList<>();

        // Запускаем рекурсивный поиск узлов
        findNodesRecursive(root, n, result);

        // Возвращаем список найденных узлов
        return result;
    }

    // Рекурсивный метод для обхода дерева и поиска узлов
    private void findNodesRecursive(TreeNode node, int n, List<TreeNode> result) {
        // Если value текущего узла больше N, добавляем его в список
        if (node.getValue() > n) {
            result.add(node);
        }

        // Если у узла есть дети, рекурсивно обходим их
        if (node.getChildren() != null) {
            for (TreeNode child : node.getChildren()) {
                findNodesRecursive(child, n, result);
            }
        }
    }
}