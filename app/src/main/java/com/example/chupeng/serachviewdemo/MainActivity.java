package com.example.chupeng.serachviewdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.Window;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private SearchView searchView;
    private ListView listView;
    private List<iconInformation> list;
    private List<iconInformation> findList;
    private List<String> nameList;
    private listViewAdapter adapter;
    private listViewAdapter findAdapter;
    private Bitmap bitmap;

    private Handler handler = new Handler()
    {
        public void handleMessage(Message msg)
        {
            switch (msg.what)
            {
                case 123:
                    adapter = new listViewAdapter(MainActivity.this, list);
                    listView.setAdapter(adapter);
                    for(int i = 0; i < list.size(); i++)
                    {
                        iconInformation information = list.get(i);
                        nameList.add(information.getName());
                    }
                    break;
            }
        }
    };


    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        searchView = (SearchView) findViewById(R.id.searchEdit);
        listView = (ListView) findViewById(R.id.listView);
        findList = new ArrayList<iconInformation>();
        nameList = new ArrayList<String>();

        /**
         * 默认情况下是没提交搜索的按钮，所以用户必须在键盘上按下"enter"键来提交搜索.你可以同过setSubmitButtonEnabled(
         * true)来添加一个提交按钮（"submit" button)
         * 设置true后，右边会出现一个箭头按钮。如果用户没有输入，就不会触发提交（submit）事件
         */
        searchView.setSubmitButtonEnabled(true);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener()
        {
            //输入完成后，提交时触发的方法，一般情况是点击输入法中的搜索按钮才会触发，表示现在正式提交了
            public boolean onQueryTextSubmit(String query)
            {

                if(TextUtils.isEmpty(query))
                {
                    Toast.makeText(MainActivity.this, "请输入查找内容！", Toast.LENGTH_SHORT).show();
                    listView.setAdapter(adapter);
                }
                else
                {
                    findList.clear();
                    for(int i = 0; i < list.size(); i++)
                    {
                        iconInformation information = list.get(i);
                        if(information.getName().equals(query))
                        {
                            findList.add(information);
                            break;
                        }
                    }
                    if(findList.size() == 0)
                    {
                        Toast.makeText(MainActivity.this, "查找的商品不在列表中", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "查找成功", Toast.LENGTH_SHORT).show();
                        findAdapter = new listViewAdapter(MainActivity.this, findList);
                        listView.setAdapter(findAdapter);
                    }
                }
                return true;
            }

            //在输入时触发的方法，当字符真正显示到searchView中才触发，像是拼音，在输入法组词的时候不会触发
            public boolean onQueryTextChange(String newText)
            {
                if(TextUtils.isEmpty(newText))
                {
                    listView.setAdapter(adapter);
                }
                else
                {
                    findList.clear();
                    for(int i = 0; i < list.size(); i++)
                    {
                        iconInformation information = list.get(i);
                        if(information.getName().contains(newText))
                        {
                            findList.add(information);
                        }
                    }
                    findAdapter = new listViewAdapter(MainActivity.this, findList);
                    findAdapter.notifyDataSetChanged();
                    listView.setAdapter(findAdapter);
                }
                return true;
            }
        });



        new Thread(new Runnable()
        {
            public void run()
            {
                list = new ArrayList<iconInformation>();
                iconInformation iconInfo1 = new iconInformation();
                bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.mipmap.beer);
                iconInfo1.setName("Beer");
                iconInfo1.setIcon(bitmap);
                list.add(iconInfo1);
                iconInformation iconInfo2 = new iconInformation();
                bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.mipmap.bread);
                iconInfo2.setName("Bread");
                iconInfo2.setIcon(bitmap);
                list.add(iconInfo2);
                iconInformation iconInfo3 = new iconInformation();
                bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.mipmap.breakfast);
                iconInfo3.setName("Breakfast");
                iconInfo3.setIcon(bitmap);
                list.add(iconInfo3);
                iconInformation iconInfo4 = new iconInformation();
                bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.mipmap.burger);
                iconInfo4.setName("Burger");
                iconInfo4.setIcon(bitmap);
                list.add(iconInfo4);
                iconInformation iconInfo5 = new iconInformation();
                bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.mipmap.cake);
                iconInfo5.setName("Cake");
                iconInfo5.setIcon(bitmap);
                list.add(iconInfo5);
                iconInformation iconInfo6 = new iconInformation();
                bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.mipmap.carrot);
                iconInfo6.setName("Carrot");
                iconInfo6.setIcon(bitmap);
                list.add(iconInfo6);
                iconInformation iconInfo7 = new iconInformation();
                bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.mipmap.check);
                iconInfo7.setName("Check");
                iconInfo7.setIcon(bitmap);
                list.add(iconInfo7);
                iconInformation iconInfo8 = new iconInformation();
                bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.mipmap.chicken);
                iconInfo8.setName("Chicken");
                iconInfo8.setIcon(bitmap);
                list.add(iconInfo8);
                iconInformation iconInfo9 = new iconInformation();
                bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.mipmap.closed);
                iconInfo9.setName("Closed");
                iconInfo9.setIcon(bitmap);
                list.add(iconInfo9);
                iconInformation iconInfo10 = new iconInformation();
                bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.mipmap.cocktails);
                iconInfo10.setName("Cocktails");
                iconInfo10.setIcon(bitmap);
                list.add(iconInfo10);
                iconInformation iconInfo11 = new iconInformation();
                bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.mipmap.coffeecup);
                iconInfo11.setName("Coffee-Cup");
                iconInfo11.setIcon(bitmap);
                list.add(iconInfo11);
                iconInformation iconInfo12 = new iconInformation();
                bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.mipmap.croissant);
                iconInfo12.setName("Croissant");
                iconInfo12.setIcon(bitmap);
                list.add(iconInfo12);
                iconInformation iconInfo13 = new iconInformation();
                bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.mipmap.cutlery1);
                iconInfo13.setName("Cutlery1");
                iconInfo13.setIcon(bitmap);
                list.add(iconInfo13);
                iconInformation iconInfo14 = new iconInformation();
                bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.mipmap.cutlery);
                iconInfo14.setName("Cutlery");
                iconInfo14.setIcon(bitmap);
                list.add(iconInfo14);
                iconInformation iconInfo15 = new iconInformation();
                bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.mipmap.favorite);
                iconInfo15.setName("Favorite");
                iconInfo15.setIcon(bitmap);
                list.add(iconInfo15);
                iconInformation iconInfo16 = new iconInformation();
                bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.mipmap.fish);
                iconInfo16.setName("Fish");
                iconInfo16.setIcon(bitmap);
                list.add(iconInfo16);
                iconInformation iconInfo17 = new iconInformation();
                bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.mipmap.fork);
                iconInfo17.setName("Fork");
                iconInfo17.setIcon(bitmap);
                list.add(iconInfo17);
                iconInformation iconInfo18 = new iconInformation();
                bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.mipmap.fruits);
                iconInfo18.setName("Fruits");
                iconInfo18.setIcon(bitmap);
                list.add(iconInfo18);
                iconInformation iconInfo19 = new iconInformation();
                bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.mipmap.icecream);
                iconInfo19.setName("Ice-Cream");
                iconInfo19.setIcon(bitmap);
                list.add(iconInfo19);
                iconInformation iconInfo20 = new iconInformation();
                bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.mipmap.invoice);
                iconInfo20.setName("Invoice");
                iconInfo20.setIcon(bitmap);
                list.add(iconInfo20);
                iconInformation iconInfo21 = new iconInformation();
                bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.mipmap.juice);
                iconInfo21.setName("Juice");
                iconInfo21.setIcon(bitmap);
                list.add(iconInfo21);
                iconInformation iconInfo22 = new iconInformation();
                bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.mipmap.kettle1);
                iconInfo22.setName("Kettle1");
                iconInfo22.setIcon(bitmap);
                list.add(iconInfo22);
                iconInformation iconInfo23 = new iconInformation();
                bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.mipmap.kettle);
                iconInfo23.setName("Kettle");
                iconInfo23.setIcon(bitmap);
                list.add(iconInfo23);
                iconInformation iconInfo24 = new iconInformation();
                bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.mipmap.lobster);
                iconInfo24.setName("Lobster");
                iconInfo24.setIcon(bitmap);
                list.add(iconInfo24);
                iconInformation iconInfo25 = new iconInformation();
                bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.mipmap.menu);
                iconInfo25.setName("Menu");
                iconInfo25.setIcon(bitmap);
                list.add(iconInfo25);
                iconInformation iconInfo26 = new iconInformation();
                bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.mipmap.mushrooms);
                iconInfo26.setName("Mushrooms");
                iconInfo26.setIcon(bitmap);
                list.add(iconInfo26);
                iconInformation iconInfo27 = new iconInformation();
                bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.mipmap.napkins);
                iconInfo27.setName("Napkins");
                iconInfo27.setIcon(bitmap);
                list.add(iconInfo27);
                iconInformation iconInfo28 = new iconInformation();
                bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.mipmap.open);
                iconInfo28.setName("Open");
                iconInfo28.setIcon(bitmap);
                list.add(iconInfo28);
                iconInformation iconInfo29 = new iconInformation();
                bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.mipmap.pan);
                iconInfo29.setName("Pan");
                iconInfo29.setIcon(bitmap);
                list.add(iconInfo29);
                iconInformation iconInfo30 = new iconInformation();
                bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.mipmap.paymentmethod);
                iconInfo30.setName("Payment-Method");
                iconInfo30.setIcon(bitmap);
                list.add(iconInfo30);
                iconInformation iconInfo31 = new iconInformation();
                bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.mipmap.pieceofcake);
                iconInfo31.setName("Piece-Of-Cake");
                iconInfo31.setIcon(bitmap);
                list.add(iconInfo31);
                iconInformation iconInfo32 = new iconInformation();
                bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.mipmap.pizza);
                iconInfo32.setName("Pizza");
                iconInfo32.setIcon(bitmap);
                list.add(iconInfo32);
                iconInformation iconInfo33 = new iconInformation();
                bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.mipmap.reserved);
                iconInfo33.setName("Reserved");
                iconInfo33.setIcon(bitmap);
                list.add(iconInfo33);
                iconInformation iconInfo34 = new iconInformation();
                bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.mipmap.restaurant);
                iconInfo34.setName("Restaurant");
                iconInfo34.setIcon(bitmap);
                list.add(iconInfo34);
                iconInformation iconInfo35 = new iconInformation();
                bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.mipmap.saltandpepper);
                iconInfo35.setName("Salt-And-Pepper");
                iconInfo35.setIcon(bitmap);
                list.add(iconInfo35);
                iconInformation iconInfo36 = new iconInformation();
                bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.mipmap.sausage);
                iconInfo36.setName("Sausage");
                iconInfo36.setIcon(bitmap);
                list.add(iconInfo36);
                iconInformation iconInfo37 = new iconInformation();
                bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.mipmap.skewer);
                iconInfo37.setName("Skewer");
                iconInfo37.setIcon(bitmap);
                list.add(iconInfo37);
                iconInformation iconInfo38 = new iconInformation();
                bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.mipmap.soup);
                iconInfo38.setName("Soup");
                iconInfo38.setIcon(bitmap);
                list.add(iconInfo38);
                iconInformation iconInfo39 = new iconInformation();
                bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.mipmap.spoon);
                iconInfo39.setName("Spoon");
                iconInfo39.setIcon(bitmap);
                list.add(iconInfo39);
                iconInformation iconInfo40 = new iconInformation();
                bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.mipmap.steak);
                iconInfo40.setName("Steak");
                iconInfo40.setIcon(bitmap);
                list.add(iconInfo40);
                iconInformation iconInfo41 = new iconInformation();
                bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.mipmap.sushi);
                iconInfo41.setName("Sushi");
                iconInfo41.setIcon(bitmap);
                list.add(iconInfo41);
                iconInformation iconInfo42 = new iconInformation();
                bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.mipmap.sushi1);
                iconInfo42.setName("Sushi1");
                iconInfo42.setIcon(bitmap);
                list.add(iconInfo42);
                iconInformation iconInfo43 = new iconInformation();
                bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.mipmap.sushi);
                iconInfo43.setName("Sushi");
                iconInfo43.setIcon(bitmap);
                list.add(iconInfo43);
                iconInformation iconInfo44 = new iconInformation();
                bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.mipmap.table);
                iconInfo44.setName("Table");
                iconInfo44.setIcon(bitmap);
                list.add(iconInfo44);
                iconInformation iconInfo45 = new iconInformation();
                bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.mipmap.teacup);
                iconInfo45.setName("Tea-Cup");
                iconInfo45.setIcon(bitmap);
                list.add(iconInfo45);
                iconInformation iconInfo46 = new iconInformation();
                bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.mipmap.terrace);
                iconInfo46.setName("Terrace");
                iconInfo46.setIcon(bitmap);
                list.add(iconInfo46);
                iconInformation iconInfo47 = new iconInformation();
                bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.mipmap.tray1);
                iconInfo47.setName("Tray1");
                iconInfo47.setIcon(bitmap);
                list.add(iconInfo47);
                iconInformation iconInfo48 = new iconInformation();
                bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.mipmap.tray);
                iconInfo48.setName("Tray");
                iconInfo48.setIcon(bitmap);
                list.add(iconInfo48);
                iconInformation iconInfo49 = new iconInformation();
                bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.mipmap.vegetables);
                iconInfo49.setName("Vegetables");
                iconInfo49.setIcon(bitmap);
                list.add(iconInfo49);
                iconInformation iconInfo50 = new iconInformation();
                bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.mipmap.wine);
                iconInfo50.setName("Wine");
                iconInfo50.setIcon(bitmap);
                list.add(iconInfo50);
                Message message = new Message();
                message.what = 123;
                message.obj = list;
                handler.sendMessage(message);
            }
        }).start();
    }
}
