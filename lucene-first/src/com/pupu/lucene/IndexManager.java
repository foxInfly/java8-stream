package com.pupu.lucene;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;

/**
 * @author : lipu
 * @since : 2020-08-12 23:15
 */
public class IndexManager {


    @Test
    public void addDocument() throws Exception{
        //创建一个Indexwriter对象，需要使用IKAnalyzer作为分析器
        Directory open = FSDirectory.open(new File("H:\\download\\baiduDiskDownload\\黑马JavaEE 57期\\00 讲义+笔记+资料\\流行框架\\61.会员版(2.0)-就业课(2.0)-Lucene\\index").toPath());
        IndexWriter indexWriter = new IndexWriter(open, new IndexWriterConfig(new IKAnalyzer()));
        //创建一个Document 对象
        Document d = new Document();
        //向document对象中添加域
        d.add(new TextField("name","新添加的文件", Field.Store.YES));
        d.add(new TextField("content","新添加的文件内容", Field.Store.YES));
        d.add(new TextField("path","c://temp/helo", Field.Store.YES));
        //把文档写入索引库

        indexWriter.addDocument(d);
        //关闭索引库
        indexWriter.close();
    }


    @Test
    public void deletAllDocument() throws Exception{
        //创建一个Indexwriter对象，需要使用IKAnalyzer作为分析器
        Directory open = FSDirectory.open(new File("H:\\download\\baiduDiskDownload\\黑马JavaEE 57期\\00 讲义+笔记+资料\\流行框架\\61.会员版(2.0)-就业课(2.0)-Lucene\\index").toPath());
        IndexWriter indexWriter = new IndexWriter(open, new IndexWriterConfig(new IKAnalyzer()));

        indexWriter.deleteAll();
        //关闭索引库
        indexWriter.close();
    }

    @Test
    public void deletDocumentByQuery() throws Exception{
        //创建一个Indexwriter对象，需要使用IKAnalyzer作为分析器
        Directory open = FSDirectory.open(new File("H:\\download\\baiduDiskDownload\\黑马JavaEE 57期\\00 讲义+笔记+资料\\流行框架\\61.会员版(2.0)-就业课(2.0)-Lucene\\index").toPath());
        IndexWriter indexWriter = new IndexWriter(open, new IndexWriterConfig(new IKAnalyzer()));

        indexWriter.deleteDocuments(new Term("name","apache"));
        //关闭索引库
        indexWriter.close();
    }

    @Test
    public void updateDocument() throws Exception{
        //创建一个Indexwriter对象，需要使用IKAnalyzer作为分析器
        Directory open = FSDirectory.open(new File("H:\\download\\baiduDiskDownload\\黑马JavaEE 57期\\00 讲义+笔记+资料\\流行框架\\61.会员版(2.0)-就业课(2.0)-Lucene\\index").toPath());
        IndexWriter indexWriter = new IndexWriter(open, new IndexWriterConfig(new IKAnalyzer()));

        //创建一个Document 对象
        Document d = new Document();
        //向document对象中添加域
        d.add(new TextField("name","新更新的文件", Field.Store.YES));
        d.add(new TextField("content","新更新的文件内容", Field.Store.YES));
        d.add(new TextField("path","c://temp/helo", Field.Store.YES));

        indexWriter.updateDocument(new Term("name","spring"),d);
        //关闭索引库
        indexWriter.close();
    }
}
