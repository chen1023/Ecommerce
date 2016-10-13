/**
 * Created by Administrator on 2015/11/5.
 */
//²Ëµ¥À¸µÄÏÔÊ¾
$("#banner_menu_wrap").children().hover(function(){
    $(this).css("background","#14B9D5");
    $(this).children(".banner_menu_content").css("border","1px solid #F0F0F0").show();
},function(){
    $(this).css("background","none");
    $(this).children(".banner_menu_content").css("border","0px solid #F0F0F0").hide();
})