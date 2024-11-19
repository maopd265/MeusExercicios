var today = new Date();
var hourNow = today.getHours();
var minute = today.getMinutes();
var second = today.getSeconds();
var greeting;

if(hourNow>18){
    greeting='Good evening!';
}else if(hourNow>12)
{
    greeting='Good afternoon!';
}else if(hourNow>0)
{
    greeting='Good morning!';
}else 
{
    greeting='Welcome to new date!'
}
document.write('<h3>' + greeting + '</h3>');
document.write(hourNow +':'+minute+':'+second);


