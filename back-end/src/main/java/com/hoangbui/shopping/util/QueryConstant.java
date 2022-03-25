package com.hoangbui.shopping.util;

import org.apache.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryConstant {
    static final Logger log = Logger.getLogger(QueryConstant.class);

    public static String callQuery(String property, String query, Object... parameters) {
        StringBuilder sql = new StringBuilder();
        sql.append(" call ").append(getGenericName()).append(property);
        sql.append(query).append(getGenericName());
        sql.append("(");
        if (parameters != null && parameters.length != 0) {
            sql.append("?");
            for (int i = 0; i < parameters.length; i++) {
                if (i >= 1) {
                    sql.append(getGenericName()).append(", ?");
                }
            }
        }
        sql.append(")");
        log.info("query property ====> " + sql.toString());
        return sql.toString();
    }

    public static String callQueryUpdate(String property, String query, int values) {
        StringBuilder sql = new StringBuilder();
        sql.append(" call ").append(getGenericName()).append(property);
        sql.append(query).append(getGenericName());
        sql.append("(");
        if (values != 0 && values > 1) {
            int count = values;
            sql.append("?");
            while(count != 1 && count > 1) {
                sql.append(getGenericName()).append(", ?");
                count--;
            }
        } else if(values > 0 && values <= 1) {
            sql.append("?");
        } else  {
            sql.append("");
        }
        sql.append(")");
        log.info("query property ====> " + sql.toString());
        return sql.toString();
    }

    private static String getGenericName() {
        String s = QueryConstant.class.getGenericSuperclass().toString();
        Pattern pattern = Pattern.compile("\\<(.*?)\\>");
        Matcher m = pattern.matcher(s);
        String generic = "";
        if (m.find()) {
            generic = m.group(1);
        }
        return generic;
    }
}