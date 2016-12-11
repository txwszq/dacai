package com.dacai

import com.mashape.unirest.http.Unirest
import grails.transaction.Transactional

import java.util.regex.Matcher
import java.util.regex.Pattern

@Transactional
class BaiduSearchService {

    def getForum() {
        def resp2 = Unirest.get("http://www.baidu.com/s?wd=%E5%8D%95%E6%9C%BA%E6%B8%B8%E6%88%8F%20powered%20by%20discuz&pn=10&oq=%E5%8D%95%E6%9C%BA%E6%B8%B8%E6%88%8F%20powered%20by%20discuz&tn=baiduhome_pg&ie=utf-8&rsv_idx=2&rsv_pq=8a7a688300004d55&rsv_t=46c8CHaWyLI709eIYgwtTewPwBMvNhHdNxUkTkaOnYbX1sDaos%2FpWFOEbZQBhCcSLGGF")
                .asString()
        println resp2.body
    }

//    public String getHTML(String key) throws IOException {
//        StringBuilder sb = new StringBuilder();
//        String path = "http://www.baidu.com/s?tn=ichuner&lm=-1&word=" + URLEncoder.encode(key, "gb2312") + "&rn=100";
//        URL url = new URL(path);
//        BufferedReader breader = new BufferedReader(new InputStreamReader(url.openStream()));
//        String line = null;
//        while ((line = breader.readLine()) != null) {
//            sb.append(line);
//        }
//        breader.close();
//        return sb.toString();
//    }
//
//    public String[][] parseHTML(String key) {
//        String page = null;
//        try {
//            page = getHTML(key);
//        }
//        catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        String[][] pageContent_list = new String[100][3];
//        if (page != null) {
//            String regx = "<table.*?</table>";
//            Pattern pattern = Pattern.compile(regx);
//            Matcher matcher = pattern.matcher(page);
//            for (int i = 0; i < 101; i++) {
//                if (matcher.find()) {
//                    if (i == 0) {
//                        continue;
//                    }
//                    //获得table中的数据
//                    String table_content = matcher.group().toString();
//                    String reg_URL = "href=\"(.*?)\"";
//                    Pattern pattern_URL = Pattern.compile(reg_URL);
//                    Matcher matcher_URL = pattern_URL.matcher(table_content);
//                    String page_URL = null;
//                    if (matcher_URL.find()) {
//                        page_URL = matcher_URL.group().toString();
//                    }
//                    page_URL = page_URL.substring(6);
//                    //得到了URL
//                    page_URL = page_URL.substring(0, page_URL.length() - 1);
//                    String reg_title = "<a.+?href\\s*=\\s*[\"]?(.+?)[\"|\\s].+?>(.+?)</a>";
//                    Pattern patter_title = Pattern.compile(reg_title);
//                    Matcher matcher_title = patter_title.matcher(table_content);
//                    String page_title = null;
//                    if (matcher_title.find()) {
//                        //得到了标题
//                        page_title = matcher_title.group().toString();
//                    }
//                    //从table_content中析取出正文
//                    String page_content = null;
//                    page_content = table_content.substring(table_content.lastIndexOf("</h3>") + 5);
//
//                    pageContent_list[i - 1][0] = page_URL;
//                    pageContent_list[i - 1][1] = page_title;
//                    pageContent_list[i - 1][2] = page_content;
//                }
//            }
//        }
//        return pageContent_list;
//    }

    /**
     * 下载页面源码
     * @param urlString
     * @return
     */
    public String getHtml(String urlString) {
        try {
            StringBuffer html = new StringBuffer();
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            InputStreamReader isr = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(isr);
            String temp;
            while ((temp = br.readLine()) != null) {
                html.append(temp).append("\n");
            }
            br.close();
            isr.close();
            return html.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * 字符串查找
     * @param expression 正则表达式字符串
     * @param text 要进行查找操作的字符串
     * @param str 要查找的字符串
     */
    private void findText(String expression, String text, String str) {
        Pattern p = Pattern.compile(expression); // 正则表达式
        Matcher m = p.matcher(text); // 操作的字符串
        StringBuffer sb = new StringBuffer();
        int i = 0;
        while (m.find()) {
            m.appendReplacement(sb, str);
            i++;
        }
        m.appendTail(sb);
        System.out.println(sb.toString());
        System.out.println(i);
    }
    /**
     * 提取百度结果标题连接摘要
     * @param html
     */
    public void baiduparser(String html)
    {
        Pattern pattern = Pattern.compile("<a onmousedown=\"return c[\\s\\S]+?href=\"([\\s\\S]+?)\"[\\s\\S]+?<font size=\"3\">([\\s\\S]+?)</a>([\\s\\S]+?)<a");
        Matcher m = pattern.matcher(html);

        int i = 1;
        while(m.find())
        {
            System.out.println(i);
            //System.out.println(m.group());
            System.out.println("href = "+m.group(1));
            String chinacode = jiecheng.china(m.group(2));
            System.out.println("Title = "+chinacode);
            String chinacode3 = jiecheng.china(m.group(3));
            System.out.println("Description = "+chinacode3);
            i++;
        }
        System.out.println("m.groupCount = "+m.groupCount());

    }
    /**
     * 判断中文字符
     * @param s
     * @return
     */
    public String china(String s)
    {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            if(s.substring(i, i+1).matches("[\u4e00-\u9fa5]"))
            {
                sb.append(s.subSequence(i, i+1));
            }
        }
        return sb.toString();
    }


}