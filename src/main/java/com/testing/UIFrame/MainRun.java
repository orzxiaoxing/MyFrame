package com.testing.UIFrame;

import java.util.List;
import java.util.Map;

public class MainRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FrameWebKeyWord kw = new FrameWebKeyWord();

		ExcelReader er = new ExcelReader("testcase/baiduipcase.xlsx");
		ExcelWriter ew = new ExcelWriter("testcase/baiduipcase.xlsx", "resultcase/baiduipcaseresult.xlsx");
		Report r = new Report();
		SendMail mail = new SendMail();

		for (int a = 1; a < er.rows; a++) {
			List<String> list = er.readLine(a);
			switch (list.get(2)) {
			case "visit":
				kw.visit(list.get(3));
				ew.writeCell(a, 5, "PASS");
				break;
			case "searchByName":
				kw.searchByName(list.get(3), list.get(4));
				ew.writeCell(a, 5, "PASS");
				break;
			case "submit":
				kw.submit();
				ew.writeCell(a, 5, "PASS");
				break;
			case "sleep":
				kw.sleep(list.get(3));
				ew.writeCell(a, 5, "PASS");
				break;
			case "assertEqualByTitle":
				kw.assertEqualByTitle(list.get(3));
				ew.writeCell(a, 5, "PASS");
				break;
			case "closeBrower":
				kw.closeBrower();
				ew.writeCell(a, 5, "PASS");
				break;
			}
		}
		ew.save();

		Map<String, String> m = r.census(new ExcelReader("resultcase/baiduipcaseresult.xlsx"));
		String mailresult = r.html(m);
		System.out.println(mailresult);
		mail.initMail();
		try {
			mail.send(mailresult,"resultcase/baiduipcaseresult.xlsx");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
