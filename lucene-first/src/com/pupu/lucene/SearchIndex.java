package com.pupu.lucene;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.LongPoint;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Before;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;

/**
 * @author : lipu
 * @since : 2020-08-12 23:34
 */
public class SearchIndex {

    private IndexReader indexReader;
    private IndexSearcher indexSearcher;

    @Before
    public void init() throws Exception{
        Directory open = FSDirectory.open(new File("H:\\download\\baiduDiskDownload\\黑马JavaEE 57期\\00 讲义+笔记+资料\\流行框架\\61.会员版(2.0)-就业课(2.0)-Lucene\\index").toPath());
        //2、创建一一个IndexReader对象
        indexReader = DirectoryReader.open(open);
        indexSearcher = new IndexSearcher(indexReader);
    }


    @Test
    public void testRangeQuery() throws Exception{
        Query query = LongPoint.newRangeQuery("size", 0L, 100L);
        this.printResult(query);
    }



    private void printResult(Query query)throws Exception{
        TopDocs topDocs = indexSearcher.search(query, 10);
        System.out.println("总记录数哦："+topDocs.totalHits);
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        for (ScoreDoc scoreDoc : scoreDocs) {
            //取文档id
            int docId = scoreDoc.doc;
            //根据文档id获取文档
            Document document = indexSearcher.doc(docId);
            System.out.println(document.get("name"));
            System.out.println(document.get("path"));
            System.out.println(document.get("size"));
//            System.out.println(document.get("content"));
            System.out.println("-----------------------寂寞的分隔说---------------------");
        }
        indexReader.close();
    }


    @Test
    public void testQuerParser() throws Exception{
        //1)创建一个QuerParser对象，参数1：默认搜索域，参数2：分析器对象
        QueryParser queryParser = new QueryParser("name",new IKAnalyzer());
        Query query = queryParser.parse("lucene是一个Java开发的全文检索工具包\n");
        printResult(query);
    }
}
