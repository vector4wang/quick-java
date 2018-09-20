package com.excel.service;

import com.sargeraswang.util.ExcelUtil.ExcelUtil;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author vector
 * @Data 2018/8/1 0001
 * @Description TODO
 */
public class TestMain {
	public static void main(String[] args) throws IOException {
		List<String> lines = IOUtils
				.readLines(new FileInputStream(new File("C:\\Users\\bd2\\Desktop\\sample.textile")));

		List<List<String>> bigList = new ArrayList<List<String>>();
		List<String> temp = new ArrayList<String>();
		for (String line : lines) {
			if (StringUtils.isBlank(line)) {
				bigList.add(temp);
				temp = new ArrayList<String>();
				continue;
			}
			temp.add(line);
		}
		System.out.println("bigList:" + bigList.size());

		List<SampleModel> sms = new ArrayList<SampleModel>();
		for (List<String> list : bigList) {
			if (list.size() != 10) {
				//				System.out.println(list);
			} else {
				try {
					SampleModel sm = new SampleModel();
					sm.setBegin(list.get(0));
					sm.setVersion(list.get(1));
					sm.setName(list.get(2));
					sm.setNt(list.get(3));
					sm.setType(list.get(4));
					sm.setEmail(list.get(5));
					sm.setType2(list.get(6));
					sm.setOrg(list.get(7));
					sm.setCate(list.get(8));
					sm.setEnd(list.get(9));
					sms.add(sm);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		List<OutVo> ovs = new ArrayList<OutVo>();

		/**
		 * BEGIN:VCARD
		 * VERSION:3.0
		 * FN:彭硕林
		 * N:;T00000715;;;
		 * TEL;TYPE=WORK:
		 * EMAIL;type=INTERNET;type=WORK;type=pref:
		 * TEL;TYPE=CELL:
		 * ORG:"RTXCompanyRoot\唯品会集团\唯品会\第三方人员"
		 * CATEGORIES:组织架构根
		 * END:VCARD
		 */
		for (SampleModel sm : sms) {
			OutVo ov = new OutVo();
			ov.setName(sm.getName().replace("FN:", ""));
			ov.setEngName(sm.getNt().replace("N:;", "").replace(";", ""));
			ov.setTel(sm.getType2().replace("TEL;TYPE=CELL:", ""));
			ov.setEmail(sm.getEmail().replace("EMAIL;type=INTERNET;type=WORK;type=pref:", ""));
			ov.setOrg(sm.getOrg().replace("ORG:\"RTXCompanyRoot\\", ""));
			if (StringUtils.isNotBlank(ov.getTel())) {
				try {
					Document doc = Jsoup
							.connect("http://www.ip138.com:8080/search.asp?mobile=" + ov.getTel() + "&action=mobile")
							.header("user-agent",
									"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.108 Safari/537.36")
							.execute().parse();


					//					String body = response.body().replace("/*fgg_again*/phone(", "").replace(")", "");
//					JSONObject jsonObject = JSON.parseObject(body);
					String address = doc.body().select("body > table:nth-child(5) > tbody > tr:nth-child(3) > td.tdc2")
							.get(0).text();
					ov.setAddress(address);
				} catch (Exception e) {
					System.out.println(ov.getTel());
					e.printStackTrace();
				}

			}
			ovs.add(ov);
		}

		List<List<OutVo>> partitions = ListUtils.partition(ovs, 10000);
		Map<String,String> map = new LinkedHashMap<String,String>();
		map.put("name","姓名");
		map.put("engName","英文姓名");
		map.put("tel","电话号码");
		map.put("email","邮箱");
		map.put("org","组织");
		map.put("address","手机归属地");
		for (int i = 0; i < partitions.size(); i++) {

			File f=new File("wph_"+i+".xls");
			OutputStream out =new FileOutputStream(f);
			ExcelUtil.exportExcel(map, partitions.get(i), out);
		}



	}
}
