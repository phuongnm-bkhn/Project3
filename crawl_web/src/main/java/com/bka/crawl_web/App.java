package com.bka.crawl_web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.bka.lib.SiteExtractor;
import com.bka.lib.WrongFormatConfigException;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, JSONException, WrongFormatConfigException
    {
    	FileInputStream steam=new FileInputStream(new File("/home/quang/Desktop/nutch_conf/24h_com_vn.json"));
		String json=IOUtils.toString(steam,"UTF-8");
		SiteExtractor siteExtractor=new SiteExtractor(new JSONObject(json));
		
		Document jsoup = Jsoup.connect("http://www.24h.com.vn/bong-da/mu-mourinho-con-thua-ca-mot-con-lua-c48a819703.html").post();
		//System.out.println(jsoup.toString());
		HashMap<String, String> data=new HashMap<String, String>();
		System.out.println(data);
		siteExtractor.extract(jsoup.toString(), data);
		System.out.println(data);
    }
}
