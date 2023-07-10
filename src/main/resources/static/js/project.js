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
      frm.method = 'post';
      frm.submit();
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

// joinme
let sendzip = document.querySelector('#sendzip');
let zipbtn = document.querySelector('#findzipbtn');
let dong = document.querySelector('#dong');
let addrlist  = document.querySelector('#addrlist');
const showzipaddr = (jsons) => {
    jsons = JSON.parse(jsons); // 문자열을 객체로 변환 그럼 자바스크립트로 받을수있다
    let addr = '';
    jsons.forEach(function (data,idx){
        addr+= `<option>${data['zipcode']}${data['sido']}${data['gugun']}${data['dong']}${data['bunji']} </option>`;
    });
    addrlist.innerHTML = addr;

};
zipbtn?.addEventListener('click',()=>{
    if (dong.value === '') {
        alert('동이름을 입력하세요11!');
        return;
    }

    const url = '/join/zipcode?dong='+ dong.value;
    fetch(url).then(response => response.text()).then(text => showzipaddr(text));
});

sendzip?.addEventListener('click',()=>{
    let addr = addrlist.value;
    let frm = document.forms.joinfrm;
    if(addr !== ''){
        //123-456 서울 관악구 신림동
        let zip = addr.split(' ');//우편번호 추출
        let vaddr = `${addr.split(' ')[1]} ${addr.split(' ')[2]} ${addr.split(' ')[3]}`;//주소 추출
        frm.zip1.value = zip.split('-')[0];
        frm.zip2.value = zip.split('-')[1];
        frm.addr1.value = addr;
    } else {
        alert('주소를 선택하세요!');
    }
});
