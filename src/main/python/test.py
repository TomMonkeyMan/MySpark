# coding: utf-8
import requests
from bs4 import BeautifulSoup

# html = requests.get('http://www.dbmeinv.com/')
html="""
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <title>豆瓣美女 - 豆瓣妹子 - 豆瓣福利 | 真实的妹子私房照分享社区</title>
<link rel="shortcut icon" type="image/x-icon" href="http://www.dbmeinv.com/dbgroup/resource/images/favicon.ico" />
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<meta name="description" content="豆瓣妹子是最真实的妹子私房照分享社区。收集豆瓣羞涩组等热门小组的妹子私房照福利，豆瓣宅男福利，在这有豆瓣妹子的私房照和豆瓣福利、豆瓣大尺度照片、宅男福利，也可以使用豆瓣帖子搜索功能。">
<meta name="keywords" content="豆瓣妹子,豆瓣美女,豆瓣福利,豆瓣妹子网,豆瓣女,微拍福利,豆瓣美妞,妹子,妹子网,豆瓣妹子的私房照,豆瓣小组妹子,豆瓣妹子福利,豆瓣美女私房照,豆瓣帖子搜索,请不要害羞"/>
<link rel="stylesheet" href="http://www.dbmeinv.com/dbgroup/resource/css/bootstrap.min.css">
<link rel="stylesheet" href="http://www.dbmeinv.com/dbgroup/resource/css/bootstrap.new.theme.min.css">
<link rel="stylesheet" href="http://www.dbmeinv.com/dbgroup/resource/css/dbmeinv.css">
<script src="http://www.dbmeinv.com/resource/js/plugin/jquery.min.js"></script>
<script src="http://www.dbmeinv.com/dbgroup/resource/js/dbmeinv.js"></script>
<script type="text/javascript">
var basePath = "http://www.dbmeinv.com";
var pc_flag = checkSystem();
</script>
<!--[if lt IE 9]>
	<script src="http://www.dbmeinv.com/resource/js/plugin/bootstrap/js/html5shiv.min.js"></script>
	<script src="http://www.dbmeinv.com/resource/js/plugin/bootstrap/js/respond.min.js"></script>
<![endif]-->  </head>
 <body>
<div class="panel-body">
<ul class="thumbnails">
                <li class="span3">
                    <div class="thumbnail" style="text-align: center;">
                        <div class="img_single">
                            <a href="http://www.dbmeinv.com/dbgroup/987793" class="link" target="_topic_detail">
                                <img class="height_min" title="想亲么"
                                     alt="想亲么"
                                     onerror="img_error(this);"
                                     src="http://ww1.sinaimg.cn/bmiddle/0060lm7Tgw1f8xiy1ssrpj30dw0aajsu.jpg" />
                            </a>
                        </div>
                        <hr/>
                        <div class="bottombar">
                            <span class="fl p5">
                                <a href="http://www.dbmeinv.com/dbgroup/987793" class="link" target="_topic_detail">
                                    想亲么
                                </a>
                            </span>
                            <span class="fr p5 meta">
                                <span class="mstar-empty star" title="加入收藏" topic-image-id="865448" topic-id="92071668"></span>
                                <span class="starcount" topic-image-id="865448">0</span>
                            </span>
                        </div>
                    </div>

                </li>
                <li class="span3">
                    <div class="thumbnail" style="text-align: center;">
                        <div class="img_single">
                            <a href="http://www.dbmeinv.com/dbgroup/987778" class="link" target="_topic_detail">
                                <img class="height_min" title="哈哈哈哈哈哈"
                                     alt="哈哈哈哈哈哈"
                                     onerror="img_error(this);"
                                     src="http://ww1.sinaimg.cn/bmiddle/0060lm7Tgw1f8xiy88dnzj30dw0opwhl.jpg" />
                            </a>
                        </div>
                        <hr/>
                        <div class="bottombar">
                            <span class="fl p5">
                                <a href="http://www.dbmeinv.com/dbgroup/987778" class="link" target="_topic_detail">
                                    哈哈哈哈哈哈
                                </a>
                            </span>
                            <span class="fr p5 meta">
                                <span class="mstar-empty star" title="加入收藏" topic-image-id="865435" topic-id="92070724"></span>
                                <span class="starcount" topic-image-id="865435">0</span>
                            </span>
                        </div>
                    </div>

                </li>
                <li class="span3">
                    <div class="thumbnail" style="text-align: center;">
                        <div class="img_single">
                            <a href="http://www.dbmeinv.com/dbgroup/987771" class="link" target="_topic_detail">
                                <img class="height_min" title="【晒】高跟鞋"
                                     alt="【晒】高跟鞋"
                                     onerror="img_error(this);"
                                     src="http://ww4.sinaimg.cn/bmiddle/0060lm7Tgw1f8xiydvby0j30dw0gkq52.jpg" />
                            </a>
                        </div>
                        <hr/>
                        <div class="bottombar">
                            <span class="fl p5">
                                <a href="http://www.dbmeinv.com/dbgroup/987771" class="link" target="_topic_detail">
                                    【晒】高跟鞋
                                </a>
                            </span>
                            <span class="fr p5 meta">
                                <span class="mstar-empty star" title="加入收藏" topic-image-id="865424" topic-id="92070372"></span>
                                <span class="starcount" topic-image-id="865424">0</span>
                            </span>
                        </div>
                    </div>

                </li>
                <li class="span3">
                    <div class="thumbnail" style="text-align: center;">
                        <div class="img_single">
                            <a href="http://www.dbmeinv.com/dbgroup/987725" class="link" target="_topic_detail">
                                <img class="height_min" title="尺度会不会太大"
                                     alt="尺度会不会太大"
                                     onerror="img_error(this);"
                                     src="http://ww3.sinaimg.cn/bmiddle/0060lm7Tgw1f8xiyvznm0j30dw0clwfa.jpg" />
                            </a>
                        </div>
                        <hr/>
                        <div class="bottombar">
                            <span class="fl p5">
                                <a href="http://www.dbmeinv.com/dbgroup/987725" class="link" target="_topic_detail">
                                    尺度会不会太大
                                </a>
                            </span>
                            <span class="fr p5 meta">
                                <span class="mstar-empty star" title="加入收藏" topic-image-id="865354" topic-id="92067794"></span>
                                <span class="starcount" topic-image-id="865354">0</span>
                            </span>
                        </div>
                    </div>

                </li>
                <li class="span3">
                    <div class="thumbnail" style="text-align: center;">
                        <div class="img_single">
                            <a href="http://www.dbmeinv.com/dbgroup/987653" class="link" target="_topic_detail">
                                <img class="height_min" title="【晒】这个白眼很欠揍"
                                     alt="【晒】这个白眼很欠揍"
                                     onerror="img_error(this);"
                                     src="http://ww3.sinaimg.cn/bmiddle/0060lm7Tgw1f8xiz7gyxvj30du0dugnf.jpg" />
                            </a>
                        </div>
                        <hr/>
                        <div class="bottombar">
                            <span class="fl p5">
                                <a href="http://www.dbmeinv.com/dbgroup/987653" class="link" target="_topic_detail">
                                    【晒】这个白眼很欠揍
                                </a>
                            </span>
                            <span class="fr p5 meta">
                                <span class="mstar-empty star" title="加入收藏" topic-image-id="865268" topic-id="92063839"></span>
                                <span class="starcount" topic-image-id="865268">0</span>
                            </span>
                        </div>
                    </div>

                </li>
    </ul>
</div>

 </body>
</html>
"""
soup = BeautifulSoup(html)
print soup.select('img[src]')

