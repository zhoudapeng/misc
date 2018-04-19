package com.zdp.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.Hits;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;

/**
 * Created by dapeng.zhou on 2016/8/5.
 */
public class SearchEngine {
    public static void main(String[] args) throws Exception {
        String indexPath = "D:\\index";
        IndexSearcher searcher = new IndexSearcher(indexPath);
        Analyzer analyzer = new StandardAnalyzer();
        QueryParser parser = new QueryParser("content", analyzer);
        Query query = parser.parse("中华");
        Hits hits = searcher.search(query);
        System.out.println("hits:" + hits.length());
        int length = hits.length();
        for (int i = 0; i < length; i++) {
            System.out.println(hits.doc(i).getField("path").stringValue());
        }
    }
}
