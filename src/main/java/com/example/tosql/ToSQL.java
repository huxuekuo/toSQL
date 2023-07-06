package com.example.tosql;

import com.example.tosql.util.OptContent;
import com.example.tosql.util.SQLParseTree;
import com.intellij.openapi.actionSystem.*;

public class ToSQL extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        // 获取选中内容
        String opText = OptContent.getOptContent(e);
        // 将选中的内容中去掉标签
        String sqlParse = SQLParseTree.parse(opText.toLowerCase());
        OptContent.setSysClipboardText(sqlParse);
    }


}
