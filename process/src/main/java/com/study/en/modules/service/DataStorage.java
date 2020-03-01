package com.study.en.modules.service;

import com.study.en.modules.vo.DataBase;
import com.study.en.support.ennum.DriverTypes;
import com.study.en.utils.StringUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author heyong
 * @date 2020/2/28
 */
@Setter
@Getter
@Slf4j
public class DataStorage {

    private DataBase dataBase;
    private List<String> createList = new ArrayList<String>();
    private List<String> insertList = new ArrayList<String>();
    private List<String> dropList = new ArrayList<String>();
    private List<String> commentList = new ArrayList<String>();
    private List<String> alterList = new ArrayList<String>();
    private List<String> indexList = new ArrayList<String>();
    private List<String> otherList = new ArrayList<String>();

    /**
     * 执行数据导入
     *
     * @param path String类型
     * @return void
     */
    public void readAndClassify(String path) {
        try {
            File file = new File(path);
            InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
            BufferedReader reader = new BufferedReader(read);
            String line;
            String str = "";
            Integer ide = 0;
            StringBuffer sql = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                sql.append(line + " ");
                str = sql.toString().trim();
                if ((str.startsWith("/*") && str.endsWith("*/"))
                        || (str.startsWith("--") && str.endsWith("--"))) {
                    sql.setLength(0);
                    continue;
                }
                if (str.endsWith(";")) {
                    if (str.startsWith("create") || str.startsWith("CREATE")) {
                        if (str.contains("index")) {
                            ide = str.indexOf("index");
                        } else if (str.contains("INDEX")) {
                            ide = str.indexOf("INDEX");
                        }
                        if (ide > 0 && ide < str.indexOf("(")) {
                            this.dropList.add("DROP INDEX " + getIndexName(str));
                            this.indexList.add(replaceKey(str));
                            sql.setLength(0);
                            continue;
                        }
                        this.createList.add(replaceKey(str));
                    } else if (str.startsWith("insert") || str.startsWith("INSERT")) {
                        this.insertList.add(replaceKey(str));
                    } else if (str.startsWith("drop") || str.startsWith("DROP")) {
                        this.dropList.add(replaceKey(str));
                    } else if (str.startsWith("comment") || str.startsWith("COMMENT")) {
                        this.commentList.add(replaceKey(str));
                    } else if (str.startsWith("alter") || str.startsWith("ALTER")) {
                        this.alterList.add(replaceKey(str));
                    } else {
                        this.otherList.add(replaceKey(str));
                    }
                    sql.setLength(0);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获得序列名称
     *
     * @param sql String类型
     * @return String
     */
    public String getIndexName(String sql) {
        String indexName = "";
        if (StringUtil.isBlank(sql)) {
            return "";
        }
        Integer index = 0, on = 0;
        if (sql.contains(" index ")) {
            index = sql.indexOf(" index ");
        } else if (sql.contains(" INDEX ")) {
            index = sql.indexOf(" INDEX ");
        }
        if (sql.contains(" on ")) {
            on = sql.indexOf(" on ");
        } else if (sql.contains("ON")) {
            on = sql.indexOf(" ON ");
        }
        indexName = sql.substring(index + " index ".length(), on).trim();
        return indexName;
    }

    /**
     * 替换关键字
     *
     * @param sql String类型
     * @return String
     */
    public String replaceKey(String sql) {

        if (StringUtil.isBlank(sql)) {
            return "";
        }
        if (DriverTypes.dm.name().equals(dataBase.getType())) {
            if (sql.startsWith("create") || sql.startsWith("CREATE")) {
                sql = sql.replaceAll("BYTE\\)", ")");
                sql = sql.replaceAll("CHAR\\)", ")");
            }
            if (sql.contains(")")) {
                return sql.substring(0, sql.lastIndexOf(")") + 1);
            }
        }
        return sql.replaceAll(";", "");
    }
}
