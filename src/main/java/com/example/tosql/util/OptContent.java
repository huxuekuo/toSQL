package com.example.tosql.util;

import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.editor.richcopy.settings.RichCopySettings;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

public class OptContent {


    public static String getOptContent(AnActionEvent e) {
        String originalContent = getSysClipboardText();
        //模拟copy动作
        RichCopySettings settings = RichCopySettings.getInstance();
        boolean savedValue = settings.isEnabled();

        try {
            settings.setEnabled(true);
            ActionManager.getInstance().getAction("EditorCopy").actionPerformed(e);
        } finally {
            settings.setEnabled(savedValue);
        }
        String sysClipboardText = getSysClipboardText();

        setSysClipboardText(originalContent);

        return sysClipboardText;
    }


    //清空剪贴板
    public static void setSysClipboardText(String writeMe) {
        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable tText = new StringSelection(writeMe);//覆盖系统剪切板
        clip.setContents(tText, null);
    }


    public static String getSysClipboardText() {
        String ret = "";
        Clipboard sysClip = Toolkit.getDefaultToolkit().getSystemClipboard();
        // 获取剪切板中的内容
        Transferable clipTf = sysClip.getContents(null);

        if (clipTf != null) {
            // 检查内容是否是文本类型
            if (clipTf.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                try {
                    ret = (String) clipTf
                            .getTransferData(DataFlavor.stringFlavor);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return ret;
    }
}
