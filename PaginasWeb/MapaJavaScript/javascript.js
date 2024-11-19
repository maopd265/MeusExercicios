(function(win,doc){
 'use strict';
 doc.querySelector('#svg2').addEventListener('mouseover',(e)=>{
    // console.log(e.target);
    let id = e.target.id;
    doc.querySelector('#'+id).style.fill='rgb(3,3,3)';
});
doc.querySelector('#svg2').addEventListener('mouseout',(e)=>{
    // console.log(e.target);
    let id = e.target.id;
    doc.querySelector('#'+id).style.fill='#999999';
}); 
doc.querySelector('#svg2').addEventListener('click',(e)=>{
    // console.log(e.target);
    let id = e.target.id;
    win.location.href = "https://www.google.com";
});

})(window,document);