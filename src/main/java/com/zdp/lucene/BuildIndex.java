package com.zdp.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;

/**
 * Created by dapeng.zhou on 2016/8/5.
 */
public class BuildIndex {
    public static void main(String[] args) throws Exception{
        File fileDir = new File("D:\\qunar\\mycode\\src\\main\\java\\com\\zdp\\lucene");
        File indexDir = new File("D:\\index");
        Analyzer analyzer = new StandardAnalyzer();
        IndexWriter indexWriter = new IndexWriter(indexDir,analyzer,true);
        File[] textFiles = fileDir.listFiles();
        for (File textFile:textFiles) {
            if (!textFile.getName().endsWith(".txt")) {
                continue;
            }
            System.out.println("为" + textFile.getName() + "建索引");
            Field pathField = new Field("path",textFile.getAbsolutePath(),Field.Store.YES,Field.Index.TOKENIZED);
            Field contentField = new Field("content",readFile(textFile),Field.Store.YES,Field.Index.TOKENIZED);
            Field nameField = new Field("name",textFile.getName(),Field.Store.YES,Field.Index.TOKENIZED);
            Document document = new Document();
            document.add(pathField);
            document.add(contentField);
            document.add(nameField);
            indexWriter.addDocument(document);
            indexWriter.optimize();
            indexWriter.close();
        }
    }

    private static String readFile(File file) throws Exception{
        InputStream inputStream = new FileInputStream(file);
        byte[] buffer = new byte[1024];
        int n = -1;
        StringBuilder sb = new StringBuilder();
        while ((n = inputStream.read(buffer)) != -1) {
            sb.append(new String(buffer,0,n));
        }
//        System.out.println(file.getName()+"的值为" + sb);
        return sb.toString();
    }
}
