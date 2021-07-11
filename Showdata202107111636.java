//20210711,会闪退版本
package com.example.networktest;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Showdata extends AppCompatActivity {
    ArrayList<HashMap<String,String>> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ListView lview = (ListView) findViewById(R.id.listview);
        listviewAdapter adapter = new listviewAdapter(this, list);
        lview.setAdapter(adapter);
        //new Thread(new Runnable(){
            //public void run() {
                //DBConnection conn=new DBConnection();
                //conn.link();

            //}
        //}).start();
        /*
        String path = Environment.getExternalStorageDirectory()+ "/data.txt";
        String content = ""; //文件内容字符串
        //打开文件
        File file = new File(path);
        //如果path是传递过来的参数，可以做一个非目录的判断
        if (file.isDirectory())
        {
            Log.d("TestFile", "The File doesn't not exist.");
        }
        else
        {
            try {
                InputStream instream = new FileInputStream(file);
                if (instream != null)
                {
                    InputStreamReader inputreader = new InputStreamReader(instream);
                    BufferedReader buffreader = new BufferedReader(inputreader);
                    String line;
                    //分行读取
                    while (( line = buffreader.readLine()) != null) {
                        content += line + "\n";
                    }
                    instream.close();
                }
            } catch (java.io.FileNotFoundException e)
            {
                Log.d("TestFile", "The File doesn't not exist.");
            }
            catch (IOException e)
            {
                Log.d("TestFile", e.getMessage());
            }
        }
         */

        /*
        JSONArray jsonArray = JSONObject.parseArray(content);
        if(jsonArray != null){
            for(Object object : jsonArray){
                JSONObject jsonObject = (JSONObject) object;
                HashMap map = new HashMap();
                for(Map.Entry entry : jsonObject.entrySet()){
                    map.put(entry.getKey(),entry.getValue());
                }
                list.add(map);
            }
        }
         */
        //System.out.println("ShowActivity得到TXT的值："+content);
        //list=jsonStringCastToArrayList(content);
        //ArrayList<HashMap<String,String>> list1 = new ArrayList();




    }

    public ArrayList<HashMap<String,String>> jsonStringCastToArrayList(String jsonString){
        ArrayList<HashMap<String,String>> list = new ArrayList();
        JSONArray jsonArray = JSONObject.parseArray(jsonString);
        if(jsonArray != null){
            for(Object object : jsonArray){
                JSONObject jsonObject = (JSONObject) object;
                HashMap map = new HashMap();
                for(Map.Entry entry : jsonObject.entrySet()){
                    map.put(entry.getKey(),entry.getValue());
                }
                list.add(map);
            }
        }
        return list;
    }

}
