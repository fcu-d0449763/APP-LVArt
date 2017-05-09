package com.start.lvart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class Activity extends AppCompatActivity {

    Button Bback;
    public String[] name = {"2017 焦點舞團【草根限定】"
                            ,"看見史前臺灣：國定遺址巡禮展"
                            ,"講座：十七歲的轉捩點"
                            ,"臺灣青年劇團-《2017<逆風花>音樂歌舞劇》"
                            ,"藝術亮點：紙藝X金工雕塑聯展(常態展)"};
    public String[] loc = {"臺中市","臺中市","臺中市","臺中市","臺中市"};
    public String[] style = {"表演與節慶","展覽","演講／講座／研討會","表演與節慶","展覽"};
    public String[] kind = {"舞蹈 - 現代舞 - 不分細類"
                            ,"設計 - 平面視覺 - 不分細類"
                            ,"語文與圖書 - 文學 - 不分細類"
                            ,"戲劇 - 現代戲劇 - 舞台劇"
                            ,"工藝（不含古物、古董） - 雕塑 - 不分細類"};
    public String[] player = {"(中華民國) 焦點舞團"
                                ,"(中華民國) 開物空間文創有限公司"
                                ,"(中華民國) 劉克襄"
                                ,"(中華民國) 臺灣青年劇團"
                                ,"(中華民國) 臺中市政府文化局"};
    public String[] time = {"2017/05/13 19:30 ~ 2017/05/13 21:00"
                            ,"2017/01/01 10:00 ~ 2017/07/16 18:00"
                            ,"2017/05/12 13:10 ~ 2017/05/12 14:30"
                            ,"2017/05/11 19:30 ~ 2017/05/11 21:00"
                            ,"2017/01/01 08:00 ~ 2017/12/31 20:00"};
    public String[] stand = {"臺中市中山堂 中山堂"
                                ,"台中文化創意產業園區 渭水樓"
                                ,"無場地資訊"
                                ,"臺中市中山堂 中山堂"
                                ,"無場地資訊"};
    public String[] address = {"臺中市北區學士路98號"
                                ,"臺中市南區興路三段362號"
                                ,"臺中市東勢區\n東勢玉山高中"
                                ,"臺中市北區學士路98號"
                                ,"臺中市北屯區\n東山路二段2巷2號(紙箱王創意園區)"};
    public String[] phone = {" "
                                ,"04-2229-5848＃214賴小姐"
                                ,"04-22289111-25325"
                                ,"04-22303100"
                                ,"04-2229-9333"};
    public String[] value = {"票價 300元","不售票","不售票","票價 200元\n票價 300元\n票價 500元\n票價 800元","大人 200元\n小孩 100元\n100公分以下免費"};
    public String[] system = {"兩廳院售票 "
                                ," "
                                ," "
                                ,"兩廳院售票 "
                                ," "};
    public String[] unit = {"主辦︰焦點舞團"
                            ,"主辦︰文化部文化資產局"
                            ,"主辦︰臺中市政府文化局"
                            ,"主辦︰臺灣青年劇團"
                            ,"指導︰臺中市政府文化局"};
    public String[] web = {"https://www.artsticket.com.tw/CKSCC2005/Product/Product00/ProductsDetailsPage.aspx?ProductID=hsobWfDDQ3Qk2udNzzgGm"
                            ,"http://tccip.boch.gov.tw/tccp/main.php?page=event_detail&id=450"
                            ," "
                            ,"http://hall.culture.taichung.gov.tw/news/index-1.asp?Parser=9,7,21,,,,1336,,,,1"
                            ," "};
    public String[] outline = {"2017焦點舞團【草根限定】，呈現世代對舞作不同的觀點及對世界的視野。其中包括Hofesh Shechter Company現任舞者、國立臺北藝術大學傑出校友張建明的《Black Hole》及擁有豐富國際經驗的法國編舞家Lucas Viallefond的《Every Little Movement》，以及九位即將從校園進入舞壇的新生代編舞家的作品，全新的自我詮釋與視覺的藝術洗禮，即將震撼畫寫2017年的舞台風景。 "
                                ,"齊柏林導演以《看見台灣》高空拍攝方式的電影紀錄臺灣環境現況；而文化部文化資產局則將以動人有趣的展示手法，帶你走過史前臺灣，述說著先民的故事，讓我們能更貼近理解這塊土地過去所發生的事，想像並推論在沒有文字記載的年代。如同遠古時期美麗的神話，魯凱族的祖先來到了萬山這片土地，其中一位族人的妻子在替家人準備晚餐時，吹口哨招來百步蛇一同悶煮、吃掉……，神秘留言仍待解讀，但吃蛇媳婦傳說和具有美麗紋路畫布的萬山岩雕群遺址，有了密不可分的關係。現在，就請大家跟著考古學家的腳步，來一趟探索數千、甚至數萬年的時空穿越之旅吧！"
                                ,"歡迎參加。"
                                ,"音樂劇《逆風花》敘述一群青年在戲劇甄選中努力爭取演出機會，在舞台上發光發亮的過程。主角是一位原住民女生，克服困難，積極爭取，終在舞台上找到自我。《逆風花》是全新自創青春音樂歌舞劇，劇中共新創十多首歌曲，並編排精彩舞蹈，歡迎喜愛音樂歌舞劇朋友蒞臨欣賞。"
                                ,"歡迎前來參加欣賞。"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act);

        Bback = (Button) findViewById(R.id.buttonBackList);
        Bback.setOnClickListener(back);

        Intent intent = getIntent();

        int num = intent.getIntExtra("KEY_NUMBER", 0);

        String[] str = {">>活動名稱\n" + name[num]
                        , "\n>>所在縣市\n" + loc[num]
                        , "\n>>活動型態\n" + style[num]
                        , "\n>>活動類別\n" + kind[num]
                        , "\n>>活動展演者\n" + player[num]
                        , "\n>>活動時間\n" + time[num]
                        , "\n>>活動場地\n" + stand[num]
                        , "\n>>場地地址\n" + address[num]
                        , "\n>>聯絡電話\n" + phone[num]
                        , "\n>>票價\n" + value[num]
                        , "\n>>售票系統\n" + system[num]
                        , "\n>>參與單位\n" + unit[num]
                        , "\n>>活動網址\n" + web[num]
                        , "\n>>簡介\n" + outline[num]};

        ListView listview = (ListView) findViewById(R.id.act);

        ArrayAdapter adapter2 = new ArrayAdapter(this,android.R.layout.simple_list_item_1,str);
        listview.setAdapter(adapter2);
        listview.setOnClickListener(back);

    }

    private View.OnClickListener back = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(Activity.this,list.class);
            startActivity(intent);
        }
    };
}
