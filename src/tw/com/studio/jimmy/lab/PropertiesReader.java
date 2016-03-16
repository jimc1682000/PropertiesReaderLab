package tw.com.studio.jimmy.lab;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertiesReader {

	private static final String ERRMSG_INI_LOC = "C:/FixGw/ErrMsg.ini";
	private static final String ORDERSTATE_XML_LOC = "C:/FixGw/OrderState.xml";
	private static final String FILE_ENCODING = "MS950";

	public static void main(String[] args) throws FileNotFoundException {
		// 確定檔案編碼
		// System.out.println("enc: " + System.getProperty("file.encoding"));
		System.out.println(getErrMsgBy("-303"));
		System.out.println(getOrderStateBy("1"));
	}

	public static String getOrderStateBy(String stateCode) {
		Properties props = new Properties();
		File file = new File(ORDERSTATE_XML_LOC);
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			props.loadFromXML(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "StateCode " + stateCode + ": " + props.getProperty(stateCode);
	}

	public static String getErrMsgBy(String errCode) {
		Properties props = new Properties();
		File file = new File(ERRMSG_INI_LOC);
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			// 指定編碼為MS950
			InputStreamReader isr = new InputStreamReader(fis, FILE_ENCODING);
			props.load(isr);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "ErrorCode " + errCode + ": " + props.getProperty(errCode);
	}

}
