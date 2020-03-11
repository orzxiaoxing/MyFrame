package com.testing.UIFrame;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Report {
	// 用例名称
	String caseName;
	// 用例执行条数
	int totalCount;
	// 用例通过条数
	int passCount;
	// 传参数的map
	Map<String, String> m = new HashMap<String, String>();
	List<String> list = new ArrayList<String>();

	public Map<String, String> census(ExcelReader er) {
		totalCount = er.rows - 1;
		for (int a = 1; a < er.rows; a++) {
			list = er.readLine(a);
			if (list.get(5).equals("PASS")) {
				passCount++;
			}
			m.put("caseName", list.get(0));
			m.put("totalCount", totalCount + "");
			m.put("passCount", passCount + "");

		}
		return m;
	}

	public String html(Map<String, String> m) {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowtime = sdf.format(d);
		m.put("runTime", nowtime);
		m.put("caseName", m.get("caseName"));
		m.put("totalCount", m.get("totalCount"));
		m.put("passCount", m.get("passCount"));

		String caseResult = "";
		if (m.get("totalCount").equals(m.get("passCount"))) {
			caseResult = "<td style=\"border:1px solid red\"><center>PASS</center></td>";
		} else {
			caseResult = "<td style=\"border:1px solid red\"><center style=\"color:red\">FAIL</center></td>";
		}

		String htmlResult = "";
		String html = "<html lang=\"en\">\r\n" + " <head> \r\n" + "  <meta charset=\"UTF-8\" /> \r\n"
				+ "  <title>我的测试报告</title> \r\n" + " </head> \r\n" + " <body> \r\n"
				+ "  <table width=\"700px\" height=\"100px\" frame=\"box\"> \r\n" + "   <tbody>\r\n" + "    <tr>\r\n"
				+ "	 <td style=\"border:1px solid red\"><center>执行时间</center></td> 	\r\n"
				+ "     <td style=\"border:1px solid red\"><center>用例名称</center></td> \r\n"
				+ "     <td style=\"border:1px solid red\"><center>用例执行条数</center></td>\r\n"
				+ "	 <td style=\"border:1px solid red\"><center>用例通过条数</center></td> \r\n"
				+ "	 <td style=\"border:1px solid red\"><center>执行结果</center></td> \r\n" + "    </tr> \r\n"
				+ "    <tr>\r\n" + "	 <td style=\"border:1px solid red\"><center>runTime</center></td> 	\r\n"
				+ "     <td style=\"border:1px solid red\"><center>caseName</center></td> \r\n"
				+ "     <td style=\"border:1px solid red\"><center>totalCount</center></td>\r\n"
				+ "	 <td style=\"border:1px solid red\"><center>passCount</center></td> \r\n" + caseResult
				+ "    </tr>\r\n" + "   </tbody>\r\n" + "  </table>  \r\n" + " </body>\r\n" + "</html>";

		htmlResult = html.replace("runTime", m.get("runTime")).replace("caseName", m.get("caseName"))
				.replace("totalCount", m.get("totalCount")).replace("passCount", m.get("passCount"));

		return htmlResult;
	}
}
