<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>主页</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
  <head>
<body>
  <div class="header">主页</div>
  <div class="swiper-container">
    <ul class="swiper-container-ul">
      <li class="swiper-container-ul-li actives">活动</li>
      <li class="swiper-container-ul-li">店铺</li>
    </ul>
    <div class="swiper-wrapper">
      <div class="swiper-slide">
        <div class="content">
          <div class="left" id="left">
            <ul>
              <li v-for="item in items">{{item.name}}</li>
            </ul>
          </div>
          <div class="right" id="right">
            <ul>
              <li v-for="item in items">
                <div class="class-title">{{item.class}}</div>
                <div v-for="ite in item.list">
                  <div class="item">
                    <div class="item-left">
                      <div class="item-img"></div>
                    </div>
                    <div class="item-right">
                      <div class="title">{{ite.title}}</div>
                      <div class="subtitle"></div>
                      <div class="price"></div>
                    </div>
                  </div>
                </div>
              </li>
            </ul>
          </div>
        </div>
      </div>
      <div class="swiper-slide" style="display:none;">
        店铺介绍
      </div>
    </div>
  </div>
  <script src="js/jquery.min.js"></script>
  <script src="js/vue.min.js"></script>
  <script type="text/javascript">
  $(function(){
    $('.content').css('height',$('.right').height());
    $('.left ul li').eq(0).addClass('active');
    $(window).scroll(function(){
      if($(window).scrollTop() >= 150){
        $('.swiper-container-ul').css('position','fixed');
        $('.left').css('position','fixed');
        $('.right').css('margin-left',$('.left').width());
      }else {
        $('.swiper-container-ul').css('position','');
        $('.left').css('position','');
        $('.right').css('margin-left','');
      };
      //滚动到标杆位置,左侧导航加active
      $('.right ul li').each(function(){
        var target = parseInt($(this).offset().top-$(window).scrollTop()-150);
        var i = $(this).index();
        if (target<=0) {
          $('.left ul li').removeClass('active');
          $('.left ul li').eq(i).addClass('active');
        }
      });
    });
    $('.left ul li').click(function(){
      var i = $(this).index('.left ul li');
      $('body, html').animate({scrollTop:$('.right ul li').eq(i).offset().top-40},500);
    });
    $('.swiper-container-ul-li').click(function(){
      var index = $(this).index();
      if(index == 0){
        $('.swiper-slide').eq(0).show();
        $('.swiper-container-ul-li').eq(0).addClass('actives');
        $('.swiper-slide').eq(1).hide();
        $('.swiper-container-ul-li').eq(1).removeClass('actives');
      }else {
        $('.swiper-slide').eq(0).hide();
        $('.swiper-container-ul-li').eq(0).removeClass('actives');
        $('.swiper-slide').eq(1).show();
        $('.swiper-container-ul-li').eq(1).addClass('actives');
      }
    });
  });
  </script>
  <script>
  var left = new Vue({
    el: '#left',
    data: {
      items: [
        { name : '分类1' },
        { name : '分类2' },
        { name : '分类3' },
        { name : '分类4' },
        { name : '分类5' },
        { name : '分类6' },
        { name : '分类7' },
        { name : '分类8' }
      ]
    }
  });
  var right = new Vue({
    el: '#right',
    data: {
      items: [
        { class : '分类1',list : [ { title : '1' },{ title : '2' } ] },
        { class : '分类2',list : [ { title : '1' },{ title : '2' } ] },
        { class : '分类3',list : [ { title : '1' },{ title : '2' } ] },
        { class : '分类4',list : [ { title : '1' },{ title : '2' } ] },
        { class : '分类5',list : [ { title : '1' },{ title : '2' } ] },
        { class : '分类6',list : [ { title : '1' },{ title : '2' } ] },
        { class : '分类7',list : [ { title : '1' },{ title : '2' } ] },
        { class : '分类8',list : [ { title : '1' },{ title : '2' } ] }
      ]
    }
  });
  </script>
</body>
</html>
