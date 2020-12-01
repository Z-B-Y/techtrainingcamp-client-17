package com.example.bulletin_zby;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class homePage extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);
        TextView[] titles = new TextView[10];
        titles[0] = (TextView)findViewById(R.id.title1);
        titles[1] = (TextView)findViewById(R.id.title2);
        titles[2] = (TextView)findViewById(R.id.title3);
        titles[3] = (TextView)findViewById(R.id.title4);
        titles[4] = (TextView)findViewById(R.id.title5);

        TextView [] authors = new TextView[10];
        authors[0] = (TextView)findViewById(R.id.author1);
        authors[1] = (TextView)findViewById(R.id.author2);
        authors[2] = (TextView)findViewById(R.id.author3);
        authors[3] = (TextView)findViewById(R.id.author4);
        authors[4] = (TextView)findViewById(R.id.author5);

        TextView [] publishtime = new TextView[10];
        publishtime[0] = (TextView)findViewById(R.id.publishtime1);
        publishtime[1] = (TextView)findViewById(R.id.publishtime2);
        publishtime[2] = (TextView)findViewById(R.id.publishtime3);
        publishtime[3] = (TextView)findViewById(R.id.publishtime4);
        publishtime[4] = (TextView)findViewById(R.id.publishtime5);

        ImageView [] imageViews = new ImageView[10];
        imageViews[0] = (ImageView) findViewById(R.id.img2);
        imageViews[1] = (ImageView) findViewById(R.id.img3);
        imageViews[2] = (ImageView) findViewById(R.id.img4);
        imageViews[3] = (ImageView) findViewById(R.id.img5);

        JsonParser parse =new JsonParser();  //创建json解析器
        try {
            JsonObject json = (JsonObject) parse.parse(new FileReader("metadata.json"));//创建jsonObject对象
            JsonArray array = json.getAsJsonObject("data").getAsJsonArray();
            for(int i = 0;i < array.size();i++) {
                JsonObject subObject = array.get(i).getAsJsonObject();
                String s = subObject.get("title").getAsString();
                titles[i].setText(s);
                //Log.d("info",s);
            }
            for(int i = 0;i < array.size();i++) {
                JsonObject subObject=array.get(i).getAsJsonObject();
                String s = subObject.get("author").getAsString();
                authors[i].setText(s);
                //Log.d("info",s);
            }
            for(int i = 0;i < array.size();i++) {
                JsonObject subObject=array.get(i).getAsJsonObject();
                String s = subObject.get("publishTime").getAsString();
                publishtime[i].setText(s);
                //Log.d("info",s);
            }
            for(int i = 0;i < array.size();i++) {
                JsonObject subObject=array.get(i).getAsJsonObject();
                String name = subObject.get("cover").getAsString(); // 获取图片的名称
                final BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 4; //对图像进行压缩，压缩后的图像尺寸为原图像的四分之一
                options.inMutable = true;
                String path = "";
                Bitmap img = BitmapFactory.decodeFile(path,options);
                imageViews[i].setImageBitmap(img);
            }
        } catch (
                JsonIOException e) {
            e.printStackTrace();
        } catch (
                JsonSyntaxException e) {
            e.printStackTrace();
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}

