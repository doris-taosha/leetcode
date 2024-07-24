package top150;
import java.sql.PreparedStatement;
import java.util.*;

/**
 *71.简化路径
 * 给定一个 Unix 风格文件系统的绝对路径，以斜杠开头'/'，将此路径转换为其简化的规范路径。
 * 在 Unix 风格的文件系统上下文中，单个句点'.'表示当前目录，双句点".."表示向上移动一个目录级别，多个斜线（例如）"//"被解释为单个斜线。在此问题中，将先前规则未涵盖的句点序列（例如"..."）视为文件或目录的有效名称。

 * 简化规范路径应遵守以下规则：
 *
 * 它必须以单斜杠开头'/'。
 * 路径内的目录应该仅用一个斜杠分隔'/'。
 * 它不应该以斜线结尾'/'，除非它是根目录。
 * 它应该排除用于表示当前或父目录的任何单句点或双句点。
 * 返回新路径。
 *
 *
 * 示例 1：
 * 输入： path = “/home/”
 * 输出： “/home”
 * 解释：结尾的斜杠应该被删除。
 *
 *
 * 示例 2：
 * 输入： path = “/home//foo/”
 * 输出： “/home/foo”
 * 解释：多个连续的斜线将被替换为一个斜线。
 *
 * 示例 3：
 * 输入： path =“/home/user/Documents/../Pictures”
 * 输出： “/home/user/Pictures”
 * 解释：双句号".."指的是上一级目录。
 *
 * 示例 4：
 * 输入： path = “/../”
 * 输出： ”/”
 * 解释：无法从根目录向上一级。
 *
 * 示例 5：
 * 输入： path = “/.../a/../b/c/../d/./”
 * 输出： “/.../b/d”
 * 解释："..."是该问题中目录的有效名称。
 *
 */


public class G2_71_simplifyPath {

    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/"));
        System.out.println(simplifyPath("/home//foo/"));
        System.out.println(simplifyPath("/home/user/Documents/../Pictures"));
        System.out.println(simplifyPath("/../"));
        System.out.println(simplifyPath("/.../a/../b/c/../d/./"));


    }

    public static String simplifyPath(String path) {
        Stack<String> stacks = new Stack<>();
        String[] pathArr = path.split("/");

        for(String dir : pathArr){
            if(dir.equals(".") || dir.isEmpty()){
                continue;
            }else if(dir.equals("..")){
                if(!stacks.isEmpty()) stacks.pop();
            }else{
                stacks.push(dir);
            }
        }

        StringBuilder res = new StringBuilder();
        for(String dir: stacks){
            res.append("/").append(dir);
        }
        return res.length() > 0 ? res.toString() : "/";
    }
}
