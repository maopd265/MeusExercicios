let variableA=0,variableB="ola mundo";
function checkTime(i) {
    if (i < 10) {
      i = "0" + i;
    }
    
    return i;
  }
  
  function startTime() {
    var today = new Date();
    var h = today.getHours();
    var m = today.getMinutes();
    var s = today.getSeconds();
    // add a zero in front of numbers<10
    h=checkTime(h);
    m = checkTime(m);
    s = checkTime(s);
    console.log(h+':'+m+':'+s);
    t = setTimeout(function() {
      startTime()
    }, 1000);
  }
  startTime();
console.log('Ola mundo');
console.log("Ola mundo");

console.log(1===1);
console.log(1=='1')
console.log('1'===1);
let array = [1 ,2 , 3 ,4];
function max(valor,valor2)
{
    return Math.max(valor,valor2);
}
console.log(max(200,2000));
console.log(array);

console.log(array.length)
console.log(typeof(variableA));
console.log(typeof(variableB));
console.error("Hello world!");
console.warn("Hello world!");
console.log("Hello world!");
let i;
console.log(Math.random(i));
document.write('ola mundo');
 //let today = new Date();
 //console.log(today.getFullYear());
 //console.log(today.getHours()+':'+today.getMinutes()+':'+today.getSeconds());
 

