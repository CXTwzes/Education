package com.example.wzes.education;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class SoftwareActivity extends AppCompatActivity {

    public static final String SOFTWARE_NAME = "software_name";
    public static final String SOFTWARE_IMAGE_ID = "software_image_id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_software);
        Intent intent = getIntent();
        String softwareName = intent.getStringExtra(SOFTWARE_NAME);
        int softwareImageId = intent.getIntExtra(SOFTWARE_IMAGE_ID, 0);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        ImageView softwareImageView = (ImageView) findViewById(R.id.software_image_view);
        TextView textView = (TextView) findViewById(R.id.software_content_text);

        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.download);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SoftwareActivity.this, "开始下载", Toast.LENGTH_SHORT).show();
            }
        });
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbarLayout.setTitle(softwareName);

        softwareImageView.setImageResource(softwareImageId);
        //Glide.with(this).load(softwareImageId).into(softwareImageView);
        String softwareContent = generateFruitContent(softwareName);
        textView.setText(softwareContent);
    }
    private String generateFruitContent(String softwareName){
        StringBuilder softwareContent = new StringBuilder();
        switch (softwareName){
            case "猿题库":
                softwareContent.append("猿题库是一款手机智能做题软件，已经完成对初中和高中6个年级的全面覆盖。\n" +
                        "猿题库针对高三学生还提供了总复习模式，涵盖全国各省市近六年高考真题和近四年模拟题，" +
                        "并匹配各省考试大纲和命题方向，可按考区、学科、知识点自主选择真题或模拟题练习。"+
                "1.覆盖初高中所有知识点：中学6年的伴读书童；不用再怕手机被没收。\n" +
                        "猿题库\n" +
                        "猿题库(4张)\n" +
                        "2.支持各种版本教材的同步练习：无论身在何处，都有机会逆袭当学霸！\n" +
                        "3.实时提供做题报告、评估能力、预测考试分数：让所有人见证你的进步。\n" +
                        "4.中高考总复习神器：历年高考真题、名校期末试题、真题及时更新。\n" +
                        "5.各科题目的优质解析：比老师课上讲的还详细；刚做过的题，考试就可能考到。\n" +
                        "6.各种实用贴心功能：随身的错题本和草稿纸，让你的学习更加高效便捷。\n" +
                        "7.支持多平台：全面支持安卓、iPhone、iPad同步使用。\n");
                break;
            case "知乎":
                softwareContent.append("知乎是一个真实的网络问答社区，社区氛围友好与理性，连接各行各业的精英。" +
                        "用户分享着彼此的专业知识、经验和见解，为中文互联网源源不断地提供高质量的信息。知乎个人主页大" +
                        "致分为5个版面：“个人资料”、“个人回答”、“个人主页”、“搜索用户问题和答案”、“关注人和被关注信息”" +
                        "和“关注话题”。具体如图4所示。\n" +
                        "在“个人资料”版面，用户可以通过点击“查看详细资料”查看用户“个人成就”（包括获得“赞同”数量、“感谢" +
                        "”数量、“收藏”数量和“分享”数量）、“职业经历“、”居住信息“、”教育经历“、”擅长技能“5个方面信息。" +
                        "如果是知乎用户，可以通过点击”编辑我的资料“完善以上5个方面信息。\n" +
                        "左下方，为“个人回答“版面，是用户对相关问题回答信息（按照赞同数量降序排列或按照回答时间顺序由" +
                        "近到远排列）。以上”个人资料“和”个人回答“两个版面能占到整个70%位置。\n" +
                        "在右上方，为“个人主页“版面，是对知乎最新动态，用户提的问题、回答、收藏和日志信息汇总。\n" +
                        "右侧中间位置，是一个搜索框。用户可以通过这个搜索框查询具体用户的问题和回答内容。\n" +
                        "右侧中下方，分别是用户个人关注人或被关注和关注话题信息。用户可以通过点击相关图标，一键连接具体板块中。");
                break;
            case "Android Studio":
                softwareContent.append("Android Studio 是一个Android集成开发工具，基于IntelliJ IDEA." +
                        " 类似 Eclipse ADT，" +
                        "Android Studio 提供了集成的 Android 开发工具用于开发和调试。\n"+"在IDEA的基础" +
                        "上，Android Studio 提供[1]  ：\n" +
                        "基于Gradle的构建支持\n" +
                        "Android 专属的重构和快速修复\n" +
                        "提示工具以捕获性能、可用性、版本兼容性等问题\n" +
                        "支持ProGuard 和应用签名\n" +
                        "基于模板的向导来生成常用的 Android 应用设计和组件\n" +
                        "功能强大的布局编辑器，可以让你拖拉 UI 控件并进行效果预览");
                break;
            case "金山词霸":
                softwareContent.append("金山词霸移动版中，[1-2]  Android版和ios版[3]  是一款经典、权威、" +
                        "免费的词典软件，完整收录柯林斯高阶英汉词典；整合500多万双语及权威例句，141本专业版" +
                        "权词典；并与CRI合力打造32万纯正真人语音。" +
                        "同时支持中文与英语、法语、韩语、日语、西班牙语、德语六种语言互译。采用更年轻、" +
                        "时尚的UI设计风格，界面简洁清新，在保证原有词条数目不变基础上，将安装包压缩至原来的" +
                        "1/3，运行内存也大大降低。[3] \n" +
                        "《金山词霸[1]  2014企业版》[4]  是金山软件为企业级用户全新定制的产品，，采用领先的" +
                        "C/S应用模式，由企业服务器金山词霸客户端组成。该版本的特点是部署灵活，便于企业对多" +
                        "用户实现统一管理。同时对主流操作系统和浏览器实现了更好的兼容性，屏幕取词更稳定快速" +
                        "，更符合专业用户的使用习惯。");
                break;
            case "学前必备600字":
                softwareContent.append("汉字是幼儿阶段重要的学习内容。本系列精心编排了600个" +
                        "基础汉字,配以相应的英文,常用的词语、句子和精美的插图,非常适合用于幼" +
                        "儿的识字启蒙。 本书特色： 1.每个汉字都配有相关联的插图、词语、句子以" +
                        "及英文,一点即读。 2.每个汉字都有标准的写法视频演示,汉字写法轻松掌握! " +
                        "3.每个汉字都支持描红功能,可以反复练习,快速学习汉字写法。 4.所有汉字" +
                        "严格按照汉字关联性组合,让" +
                        "孩子在学习一个汉字的同时,联想并学习到相关的其他汉字,举一反三,从而达" +
                        "到快速记忆多个汉字的目的。");
                break;
            case "百度传课KK":
                softwareContent.append("百度传课KK是百度传课独家推出的即时通讯工具。 " +
                        "百度传课KK实现了与用户网站账户的绑定，让用户的很多操作通过KK" +
                        "即可实现。大大简化了网友的使用操作流程，给网友带来全新的网络" +
                        "使用体验。 同时，百度传课KK让老师、同学之间有了一个在不上课的" +
                        "时候，也能进行即时沟通，互相联系的工具，让用户不仅可以学习课程" +
                        "，还能够交到朋友，实现用户价值的增值。");
                break;
            case "有道词典":
                softwareContent.append("免费中英文翻译软件。完美结合了互联网在线词典和桌面词典的优势，" +
                        "“权威词典+网络释义”的组合将各" +
                        "类新兴词汇和翻译收录其中，并可提供多达30条的例句参考，新增的全文翻译、百科" +
                        "全书及网络单词本让您的英文正式迈入互联网时代。");

                break;
            case "Xmind":
                softwareContent.append("X\n" +
                        "LOGO\n" +
                        "LOGO\n" +
                        "Mind采用Java语言开发，具备跨平台运行的性质，且基于EclipseRCP体系结构，可" +
                        "支持插件，插件通过编写XML清单文件可以扩展系统定义好的扩展点。XMind的程序" +
                        "主体由一组插件构成，包括一个核心主程序插件、一组Eclipse运行时插件、一个帮" +
                        "助文档插件和一组多语种资源文件插件。Eclipse用户会对它的界面非常亲切。\n" +
                        "XMind 应用EclipseRCP软件架构，XMind 的分发包在形式上是一组Eclipse Featu" +
                        "res，每\n" +
                        "软件界面\n" +
                        "软件界面\n" +
                        "个Eclipse Feature是一组Eclipse Plugins，Plugin之间相互依赖相互扩展。在此P" +
                        "luggable Platform的基础上，XMind 也可以支持其他开发人员为其编写Plugin，为X" +
                        "Mind增添新的功能或改进其设计。由于大部分Plugin是用Java语言编写，用本地语言" +
                        "编写的代码也针对各不同操作系统有不同版本，所以XMind理论上可以运行在几" +
                        "乎所有操作系统上，包括所有64位的操作系统，XMind Pro 6仅支持Windows、Mac OS" +
                        " X和Linux三大操作系统。");
                break;
        }
        return softwareContent.toString();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
