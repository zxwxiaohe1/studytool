package com.study.en.support.export;

import cn.hutool.extra.tokenizer.Word;
import com.study.en.domain.entity.EnglishWord;
import com.study.en.modules.vo.Mean;
import com.study.en.modules.vo.SingleWord;
import com.study.en.support.ennum.WordExportType;
import com.study.en.support.ennum.WordType;
import com.study.en.utils.ConstantUtil;
import com.study.en.utils.FileUtil;
import com.study.en.utils.IdGen;
import com.study.en.utils.JacksonUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DocumentEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.util.ObjectUtils;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 导出Word
 *
 * @author heyong
 */
public class ExportWord {


    public void execEnglishWord(List<EnglishWord> dataSet, String type, String docName) {
        if (ObjectUtils.isEmpty(dataSet)) {
            return;
        }
        exec(sort(dataSet), type, docName);
    }

    public void exec(List<SingleWord> dataSet, String type, String docName) {
        Map<String, String> content = new HashMap<String, String>();
        if (dataSet != null) {
            String table = HtmlDataset.getTableHeader();
            if (WordExportType.word.name().equals(type)) {
                String wrtype = "";
                String mean = "";
                String[] str = null;
                String space = "";
                Boolean row0 = true;
                for (SingleWord sw : dataSet) {
                    System.out.println(sw.getWord());
                    row0 = true;
                    for (int i = 0, size = sw.getMeans().size(); i < size; i++) {
                        if (StringUtils.isBlank(sw.getWord()) || StringUtils.isBlank(sw.getMeans().get(i).getMean())) {
                            continue;
                        }
                        for (int j = 0, jsize = sw.getWord().trim().length(); j < jsize; j++) {
                            space = space + "&nbsp;";
                        }
                        if (StringUtils.isNotBlank(sw.getMeans().get(i).getWordType())) {
                            wrtype = WordType.type(sw.getMeans().get(i).getWordType()) + "表示";
                            sw.getMeans().get(i).setMean("(" + sw.getMeans().get(i).getMean() + ")" + ConstantUtil.FILE_SPERATOR_ENGLISH);
                        } else {
                            mean = sw.getMeans().get(i).getMean().replaceAll(" ", "");
                            if (mean.contains("表示(")) {
                                str = mean.split("表示\\(");
                            } else if (mean.contains("表示（")) {
                                str = mean.split("表示\\（");
                            } else {
                                sw.getMeans().get(i).setMean("(" + mean + ")" + ConstantUtil.FILE_SPERATOR_ENGLISH);
                            }
                            if (str != null) {
                                if (str.length > 0) {
                                    wrtype = str[0] + "表示";
                                }
                                if (str.length > 1) {
                                    sw.getMeans().get(i).setMean("(" + str[1] + ConstantUtil.FILE_SPERATOR_ENGLISH);
                                }
                            }
                        }
                        str = null;
                        mean = "";
                        if (row0) {
                            table = table + HtmlDataset.getTableData(
                                    HtmlDataset.setColor(sw.getWord().trim().toLowerCase() + ": ", "green")
                                            + HtmlDataset.setColor(wrtype, "#00B050") +
                                            HtmlDataset.setColor(sw.getMeans().get(i).getMean(), "green"));
                            row0 = false;
                        } else {
                            table = table + HtmlDataset.getTableData(space + HtmlDataset.setColor(wrtype, "#00B050") +
                                    HtmlDataset.setColor(sw.getMeans().get(i).getMean(), "green"));
                        }
                        space = "";
                    }
                }
                content.put("wordType", WordExportType.word.type() + "篇");
            } else if (WordExportType.phrase.name().equals(type)) {
                String space = "";
                for (SingleWord sw : dataSet) {
                    if (StringUtils.isBlank(sw.getWord())) {
                        continue;
                    }
                    for (int j = 0, jsize = sw.getWord().trim().length(); j < jsize; j++) {
                        space = space + "&nbsp;";
                    }
                    for (int i = 0, size = sw.getMeans().size(); i < size; i++) {
                        if (i == 0) {
                            table = table + HtmlDataset.getTableData(
                                    HtmlDataset.setColor(sw.getWord().trim().toLowerCase() + ": ", "green")
                                            + HtmlDataset.setColor(sw.getMeans().get(i).getMean() + ConstantUtil.FILE_SPERATOR_ENGLISH, "#2E75B6"));
                        } else {
                            table = table + HtmlDataset.getTableData(space +
                                    HtmlDataset.setColor(sw.getMeans().get(i).getMean() + ConstantUtil.FILE_SPERATOR_ENGLISH, "#2E75B6"));
                        }
                    }
                    space = "";
                }
                content.put("wordType", WordExportType.phrase.type() + "篇");
            } else if (WordExportType.sentence.name().equals(type)) {
                String end = "";
                for (SingleWord sw : dataSet) {
                    if (StringUtils.isBlank(sw.getWord())) {
                        continue;
                    }
                    for (int i = 0, size = sw.getMeans().size(); i < size; i++) {
                        if (i == 0) {
                            if (size == 1) {
                                end = ConstantUtil.FILE_SPERATOR_ENGLISH;
                            }
                            table = table + HtmlDataset.getTableData(HtmlDataset.setColor(sw.getWord().trim().toLowerCase(), "green"))
                                    + HtmlDataset.getTableData(HtmlDataset.setColor(sw.getMeans().get(i).getMean() + end, "#2E75B6"));
                        } else {
                            if (i == size - 1) {
                                end = ConstantUtil.FILE_SPERATOR_ENGLISH;
                            }
                            table = table + HtmlDataset.getTableData(HtmlDataset.setColor(sw.getMeans().get(i).getMean() + end, "#2E75B6"));
                        }
                    }
                    end = "";
                }
                content.put("wordType", WordExportType.sentence.type() + "篇");
            }
            table = table + HtmlDataset.getTableEnd();
            content.put("content", table);
        }
        writeWordFile(readHtmlFile(content), docName);
    }

    public void writeWordFile(File file, String docName) {
        if (!file.exists()) {
            return;
        }
        ByteArrayInputStream bais = null;
        FileOutputStream ostream = null;
        try {
            // 检查目录是否存在
            File fileDir = new File(ConstantUtil.FILE_DIR_HTML);
            if (!fileDir.exists()) {
                fileDir.mkdirs();
            }
            // 生成临时文件名称
            byte b[] = FileUtil.getStreamBytes(new FileInputStream(file));
            bais = new ByteArrayInputStream(b);
            POIFSFileSystem poifs = new POIFSFileSystem();
            DirectoryEntry directory = poifs.getRoot();
            DocumentEntry documentEntry = directory.createDocument("WordDocument", bais);
            ostream = new FileOutputStream(ConstantUtil.FILE_DIR_HTML + docName);
            poifs.writeFilesystem(ostream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bais != null) {
                    bais.close();
                }
                if (ostream != null) {
                    ostream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            file.delete();
        }
    }

    public File readHtmlFile(Map<String, String> value) {
        String lineStr = "";
        InputStreamReader isr = null;
        BufferedWriter bw = null;
        BufferedReader bf = null;
        InputStream in = null;
        try {
            in = this.getClass().getResourceAsStream("/" + ConstantUtil.FILE_TEMPLATE_HTML_NAME);
            File targetDir = new File(ConstantUtil.FILE_DIR_HTML + ConstantUtil.FILE_TEMPLATE_HTML_NAME.substring(0, ConstantUtil.FILE_TEMPLATE_HTML_NAME.lastIndexOf("/")));
            if (!targetDir.exists()) {
                targetDir.mkdirs();
            }
            isr = new InputStreamReader(in, ConstantUtil.CHARASTER_ENCODE_GBK);
            bf = new BufferedReader(isr);
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(
                    ConstantUtil.FILE_DIR_HTML + ConstantUtil.FILE_TEMPLATE_HTML_NAME), false), ConstantUtil.CHARASTER_ENCODE_GBK));
            while ((lineStr = bf.readLine()) != null) {
                lineStr = replaceAll(lineStr, value);
                bw.write(lineStr);
                bw.newLine();
                bw.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (isr != null) {
                    isr.close();
                }
                if (bf != null) {
                    bf.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new File(ConstantUtil.FILE_DIR_HTML + ConstantUtil.FILE_TEMPLATE_HTML_NAME);
    }

    public String replaceAll(String source, Map<String, String> value) throws IOException {
        if (StringUtils.isBlank(source)) {
            return "";
        }
        if (source.contains("${wordType}")) {
            source = source.replace("${wordType}", (String) value.get("wordType"));
        } else if (source.contains("${content}")) {
            source = source.replace("${content}", (String) value.get("content"));
        }
        return source;
    }

    public List<SingleWord> sort(List<EnglishWord> target) {
        if (ObjectUtils.isEmpty(target)) {
            return null;
        }
        Map<String, EnglishWord> appleMap = target.stream().collect(Collectors.toMap(EnglishWord::getWord, a -> a, (k1, k2) -> k1));
        List<String> sortw = new ArrayList<>(appleMap.keySet());
        Collections.sort(sortw);
        List<SingleWord> words = new ArrayList<>();
        for (String w : sortw) {
            EnglishWord englishWord = appleMap.get(w);
            if (ObjectUtils.isEmpty(englishWord)) {
                continue;
            }
            SingleWord singleWord = new SingleWord();
            singleWord.setWord(englishWord.getWord());
            singleWord.setMeans(JacksonUtil.json2JavaType(englishWord.getMean(), List.class, Mean.class));
            words.add(singleWord);
        }
        return words;
    }
}
