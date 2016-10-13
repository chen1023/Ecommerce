// JavaScript Document
var count = 1;
var interId="";
function changeColor(){
	var img = document.getElementById("img");
	if(count==4)
	{
		count=0;
	}
	var k=++count;
	img.src = 'taobao/images/adv/adv_'+k+'.jpg';
}
  
function start_change(){
   	interId=setInterval("changeColor()",2000);
}