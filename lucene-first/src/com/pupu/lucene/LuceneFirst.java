package com.pupu.lucene;

import org.apache.commons.io.FileUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.document.*;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.RAMDirectory;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;

/**
 * @author : lipu
 * @since : 2020-08-12 20:39
 */
public class LuceneFirst {

    @Test
    public void createIndex() throws Exception{
        //1、创建一个Director对象， 指定索引库保存的位置。
        Directory directory = new RAMDirectory();//保存在内存
        //保存在磁盘
        Directory open = FSDirectory.open(new File("H:\\download\\baiduDiskDownload\\黑马JavaEE 57期\\00 讲义+笔记+资料\\流行框架\\61.会员版(2.0)-就业课(2.0)-Lucene\\index").toPath());
        //2、基于Directory对象创建一个 IndexWriter对象
//        IndexWriter indexWriter = new IndexWriter(open, new IndexWriterConfig());
        IndexWriter indexWriter = new IndexWriter(open, new IndexWriterConfig(new IKAnalyzer()));
        //3、读取磁盘上的文件，对应每个文件创建一个文档对象。
        File dir = new File("H:\\download\\baiduDiskDownload\\黑马JavaEE 57期\\00 讲义+笔记+资料\\流行框架\\61.会员版(2.0)-就业课(2.0)-Lucene\\lucene\\02.参考资料\\searchsource");
        File[] files = dir.listFiles();
        for (File f : files) {
            //文件名、文件路径、文件内容、文件大小
            String fileName = f.getName();
            String filePath = f.getPath();
            String fileContent = FileUtils.readFileToString(f, "UTF-8");
            long fileSize = FileUtils.sizeOf(f);

            //创建Field   : 参数1是域的名称，参数2是域的内容，参数3表示是否存储
            Field fieldName = new TextField("name", fileName, Field.Store.YES);
//            Field fieldPath = new TextField("path", filePath, Field.Store.YES);
            Field fieldPath = new StoredField("path", filePath);
            Field fieldContent = new TextField("content", fileContent, Field.Store.YES);
//            Field fieldSize = new TextField("size", fileSize+"", Field.Store.YES);
            Field fieldSizeValue = new LongPoint("size", fileSize);//不存储
            Field fieldSizeStore = new StoredField("size", fileSize);//只存储

            //创建文档对象
            //4、向文档对象中添加域
            Document document = new Document();
            document.add(fieldName);
            document.add(fieldPath);
            document.add(fieldContent);
            document.add(fieldSizeValue);
            document.add(fieldSizeStore);

            //5、把文档对象写入索引库
            indexWriter.addDocument(document);
        }
        // 6、关闭indexwriter对象
        indexWriter.close();
    }



    @Test
    public void searchIndex() throws Exception{
        //1、创建一个Director对象， 指定索引库的位置
        Directory open = FSDirectory.open(new File("H:\\download\\baiduDiskDownload\\黑马JavaEE 57期\\00 讲义+笔记+资料\\流行框架\\61.会员版(2.0)-就业课(2.0)-Lucene\\index").toPath());
        //2、创建一一个IndexReader对象
        IndexReader indexReader = DirectoryReader.open(open);
        //3、创建一个IndexSearcher对象，构造方法中的参数indexReader对象
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
        //4、创建一个Query对象，TermQuery
        Query query = new TermQuery(new Term("content","spring"));
        //5、执行查询，得到一个TopDocs对象  参数1：查询对象，  参数2：返回的最大记录数
        TopDocs topDocs = indexSearcher.search(query, 10);
        //6、取查询结果的总记录数
        long totalHits = topDocs.totalHits;
        System.out.println("查询到的总记录数："+totalHits);
        //7、取文档列表
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        //8、打印文档中的内容
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
        //9、关闭IndexReader对象
        indexReader.close();
    }


    @Test
    public void testTokenStream() throws Exception{
        //1)创建一个Analyzer对象，StandardAnalyzer对象
//        Analyzer analyzer = new StandardAnalyzer();
        Analyzer analyzer = new IKAnalyzer();
        //2)使用分析器对象的tokenStream方法获得一个TokenStream对象  参数1：域名称，要分析的文本
//        TokenStream tokenStream = analyzer.tokenStream("", "The Spring Framework provides a comprehensive programming and configuration model.");
        TokenStream tokenStream = analyzer.tokenStream("", "2012年2月8日 - 李普每个网站的必须提供的基本功能之一,用Lucene构造一个“索引-查询”的应用是常见的java解决方案,目前由linliangyi2007创立的IK Analyzer是最好的Lu");
        //3)向TokenStream对象中设置一个引用，相当于数一个指针
        CharTermAttribute charTermAttribute = tokenStream.addAttribute(CharTermAttribute.class);
        //4)调用TokenStream对象的rest方法。如果不调用抛异常
        tokenStream.reset();
        //5)使用while循环遄历TokenStream对象
        while (tokenStream.incrementToken()){
            System.out.println(charTermAttribute.toString());
        }
        //6)关闭TokenStream对象
        tokenStream.close();
    }


}
