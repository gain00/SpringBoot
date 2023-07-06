//agree
let agree1 = document.querySelector("#agree1");
let agree2 = document.querySelector("#agree2");
let okagree = document.querySelector("#okagree");
let noagree = document.querySelector("#noagree");

okagree?.addEventListener('click',()=>{
    if(!agree1.checked){
        alert('이용약관에 동의하세요');
    }else if(!agree2.checked){
        alert('이용약관에 동의하세요');
    }else{
        location.href="/join/checkme";
    }
});
noagree?.addEventListener('click',()=>{
    location.href= "/";
});


//check me
let frm = document.forms.agreefrm2;
let checkbtn2 = document.querySelector("#checkbtn2");
let cancelbtn2 = document.querySelector("#cancelbtn2");
/*let infoagree = document.querySelector("#infoagree");
let name2 = document.querySelector("#name2");
let jumin1 = document.querySelector("#jumin1");
let jumin2 = document.querySelector("#jumin2");*/

checkbtn2?.addEventListener('click',() => {
    if(frm.name.value === ''){
        alert('이름이 비었습니다');
    }else if(frm.jumin1.value === ''){
        alert('주민번호가 비었습니다');
    }else if(frm.jumin2.value === ''){
        alert('주민번호가 비었습니다');
    }else if(!frm.infoagree.checked){
        alert('주민등록번호 처리에 동의해주세요');
    }else{
        let params = '?name' + frm.name.value;
        params += '&jumin1=' + frm.jumin1.value;
        params += '&jumin2=' + frm.jumin2.value;
        location.href='/join/joinme' + params;
    }
});


/*checkbtn2?.addEventListener('click',() => {
    if(name2.value === ''){
        alert('이름이 비었습니다');
    }else if(jumin1.value === ''){
        alert('주민번호가 비었습니다');
    }else if(jumin2.value === ''){
        alert('주민번호가 비었습니다');
    }else if(!infoagree.checked){
        alert('주민등록번호 처리에 동의해주세요');
    }else{
        location.href="/join/joinme";
    }
});*/
cancelbtn2?.addEventListener('click',()=>{
    location.href= "/";
});

//


