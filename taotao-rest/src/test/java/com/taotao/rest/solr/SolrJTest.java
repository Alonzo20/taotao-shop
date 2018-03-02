package com.taotao.rest.solr;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

public class SolrJTest {

	
	@Test
	public void deleteDocument() throws Exception {
		// 创建一个连接
		SolrServer solrServer = new HttpSolrServer("http://192.168.1.118:8080/solr");
		//solrServer.deleteById("test01");
		solrServer.deleteByQuery("*:*");
		// 提交
		solrServer.commit();
	}
	
	@Test
	public void addDocument() throws Exception {
		// 创建一个连接
		SolrServer solrServer = new HttpSolrServer("http://192.168.1.118:8080/solr");
		// 创建一个文档对象
		SolrInputDocument document = new SolrInputDocument();
		document.addField("id", "test01");
		document.addField("item_title", "测试商品");
		document.addField("item_price", 123);
		// 把文档对象写入索引库
		solrServer.add(document);
		// 提交
		solrServer.commit();
	}
	
	
}
