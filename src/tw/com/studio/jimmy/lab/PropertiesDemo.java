package tw.com.studio.jimmy.lab;

import java.io.*;
import java.util.Properties;

public class PropertiesDemo {

	private static Properties props;

	public static void main(String[] args) {

		props = new Properties();

		// 用props.setProperty("key", "value")設定(key, value)配對
		props.setProperty("key1", "value1");
		props.setProperty("key2", "中文測試");

		// 用 props.list(System.out)在console 印出props中所有的(key, value)配對
		// -- listing properties --
		// key2=中文測試
		// key1=value1
		System.out.println("在console 印出props中所有的(key, value)配對");
		props.list(System.out);
		System.out.println();

		// 設定重覆的(key, value)配對會覆蓋掉
		// -- listing properties --
		// key2=中文測試
		// key1=更改value1
		System.out.println("印出更改後所有的(key, value)配對");
		props.setProperty("key1", "更改value1");
		props.list(System.out);
		System.out.println();

		try {
			// 輸出props中所有的(key, value)配對到xml(storeToXML)及txt(store)
			// 輸出後Stream不會自動關閉必須手動關閉，否則有可能出錯(不是在()中使用new時)
			// storeToXML(OutputStream os, Stirng comment, String encode)
			// storeToXML(OutputStream os, Stirng comment) encode預設使用 UTF-8
			props.storeToXML(new FileOutputStream("properties.xml"),
					"storeToXML");
			props.store(new FileOutputStream("properties.properties"), "store");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		props.clear();

		try {
			// props.getProperty(key)讀出(key, value)配對
			// props.getProperty(String key, String defaultWhenNotFound)
			// props.getProperty(String key) throws exception when not found
			System.out.println("props.getProperty(key)讀出(key, value)配對");
			props.load(new FileInputStream("properties.properties"));
			System.out.println(props.getProperty("key", "test")); // default
																	// value
																	// test
			System.out.println(props.getProperty("key1"));
			props.clear();
			System.out.println();

			// 列印出所有properties.properties的 屬性
			props.load(new FileInputStream("properties.properties"));
			props.list(System.out);
			System.out.println();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			// 印出從 properties.xml 讀出的所有(key, value)配對
			System.out.println("印出properties.xml讀出的所有(key, value)配對");
			props.loadFromXML(new FileInputStream("properties.xml"));
			props.setProperty("key3", "new value");
			props.list(System.out);

			// 將新配對寫回 properties.xml，串流沒出錯
			props.storeToXML(new FileOutputStream("properties.xml"),
					"storeToXML");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}