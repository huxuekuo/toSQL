package com.example.tosql.util;

import com.example.tosql.enumall.SqlTagEnum;

public class SQLParseTree {


    public static String parse(String sql) {
        System.out.println(sql);
        // 解析标签,固定匹配
        sql = sql.replaceAll("<where>", " where ");
        sql = sql.replaceAll("<!\\[cdata\\[", "");
        sql = sql.replaceAll("]]>", "");
        sql = sql.replaceAll("&gt;", ">");
        sql = sql.replaceAll("&lt;", "<");

        // 正则匹配
        sql = sql.replaceAll("<(\\w|/)(.*?)>", "");
        sql = sql.replaceAll("<!(.*?)>", "");
        sql = sql.replaceAll("(\\$|#)\\{(.*?)}", "''");
        System.out.println(sql);
        return sql;
    }

}
