package tw.com.studio.jimmy.lab;

import java.io.*;
import java.util.Properties;

public class PropertiesDemo {

	private static Properties props;

	public static void main(String[] args) {

		props = new Properties();

		// ��props.setProperty("key", "value")�]�w(key, value)�t��
		props.setProperty("key1", "value1");
		props.setProperty("key2", "�������");

		// �� props.list(System.out)�bconsole �L�Xprops���Ҧ���(key, value)�t��
		// -- listing properties --
		// key2=�������
		// key1=value1
		System.out.println("�bconsole �L�Xprops���Ҧ���(key, value)�t��");
		props.list(System.out);
		System.out.println();

		// �]�w���Ъ�(key, value)�t��|�л\��
		// -- listing properties --
		// key2=�������
		// key1=���value1
		System.out.println("�L�X����Ҧ���(key, value)�t��");
		props.setProperty("key1", "���value1");
		props.list(System.out);
		System.out.println();

		try {
			// ��Xprops���Ҧ���(key, value)�t���xml(storeToXML)��txt(store)
			// ��X��Stream���|�۰�����������������A�_�h���i��X��(���O�b()���ϥ�new��)
			// storeToXML(OutputStream os, Stirng comment, String encode)
			// storeToXML(OutputStream os, Stirng comment) encode�w�]�ϥ� UTF-8
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
			// props.getProperty(key)Ū�X(key, value)�t��
			// props.getProperty(String key, String defaultWhenNotFound)
			// props.getProperty(String key) throws exception when not found
			System.out.println("props.getProperty(key)Ū�X(key, value)�t��");
			props.load(new FileInputStream("properties.properties"));
			System.out.println(props.getProperty("key", "test")); // default
																	// value
																	// test
			System.out.println(props.getProperty("key1"));
			props.clear();
			System.out.println();

			// �C�L�X�Ҧ�properties.properties�� �ݩ�
			props.load(new FileInputStream("properties.properties"));
			props.list(System.out);
			System.out.println();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			// �L�X�q properties.xml Ū�X���Ҧ�(key, value)�t��
			System.out.println("�L�Xproperties.xmlŪ�X���Ҧ�(key, value)�t��");
			props.loadFromXML(new FileInputStream("properties.xml"));
			props.setProperty("key3", "new value");
			props.list(System.out);

			// �N�s�t��g�^ properties.xml�A��y�S�X��
			props.storeToXML(new FileOutputStream("properties.xml"),
					"storeToXML");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}