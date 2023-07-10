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
let fzipbtn = document.querySelector('#findzipbtn');
let zipbtn = document.querySelector('#zipbtn');
let zipmodal = document.querySelector('#zipmodal');


let dong = document.querySelector('#dong');
let addrlist  = document.querySelector('#addrlist');
let modal = null; // 우편번호 모달
let email3 = document.querySelector('#email3');


zipbtn?.addEventListener('click',()=>{
    while (addrlist.lastChild){
        addrlist.removeChild(addrlist.lastChild);
    }// 이전 검색 결과 지움
    dong.value = ''; // 이전 검색 키워드 지움


    try{
        // 새로운 모달 창 생성
        modal = new bootstrap.Modal(zipmodal, {});

    }catch (e){}
    modal.show(); // 모달창 띄우기
});



const showzipaddr = (jsons) => {
    jsons = JSON.parse(jsons); // 문자열을 객체로 변환 그럼 자바스크립트로 받을수있다
    let addr = '';
    jsons.forEach(function (data,idx){
        addr+= `<option>${data['zipcode']}${data['sido']}${data['gugun']}${data['dong']}${data['bunji']} </option>`;
    });
    addrlist.innerHTML = addr;

};
fzipbtn?.addEventListener('click',()=>{
    if (dong.value === '') {
        alert('동이름을 입력하세요11!');
        return;
    }

    const url = '/join/zipcode?dong='+ dong.value;
    fetch(url).then(response => response.text()).then(text => showzipaddr(text));
});


sendzip?.addEventListener('click', () => {
    let frm = document.forms.joinfrm;
    let addr = addrlist.value;   // 선택한 주소 항목
    if (addr !== '') {
        // 123-456 서울 관악구 신림동
        let zip = addr.split(' ')[0];  // 우편번호 추출
        let addrs = addr.split(' ');
        let vaddr = `${addrs[1]} ${addrs[2]} ${addrs[3]}`; // 주소추출

        frm.zip1.value = zip.split('-')[0];
        frm.zip2.value = zip.split('-')[1];
        frm.addr1.value = vaddr;

        modal.hide();    // 모달창 닫음
    } else {
        alert('주소를 선택하세요!!');
    }
});

email3.addEventListener('click',() => {
    let frm = document.forms.joinfrm;
    if(email3.value === '직접입력하기'){
        frm.email2.readOnly = false;
        frm.email2.value = '';

    }else if(email3.value !== '선택하세요'){
        frm.email2.readOnly = true;
        frm.email2.value = email3.value;
    }
});

//우편번호 검색 엔터키 차단
dong?.addEventListener('keydown', (e) => {
    if (e.keyCode===13) //엔터키(13)가 입력되면
        e.preventDefault(); // 이벤트 전파 방지
});
//비밀번호 확인

let pwd = document.joinfrm.passwd;
let repwd = document.joinfrm.repasswd;
let pwdmsg = document.querySelector("#pwdmsg");

repwd?.addEventListener('blur', () =>{
    let pmsg = '비밀번호가 서로 일치하지 않습니다';
    pwdmsg.className = 'text-danger';
    if(pwd.value === repwd.value){
       pmsg = '비밀번호가 서로 일치합니다';
        pwdmsg.className = 'text-primary';
    }
    pwdmsg.innerText = pmsg;
});

//아이디 중복 검사
let userid = document.joinfrm.userid;
let checkuid = document.joinfrm.checkuid;
let uidmsg = document.querySelector("#uidmsg");

const styleCheckuid = (chkuid) => {
    let umsg = '사용 불가능한 아이디입니다!!';
    uidmsg.className = 'text-danger';
    checkuid.value = 'no';
    if(chkuid === '0'){
        umsg = '사용가능한 아이디입니다';
        uidmsg.className = 'text-primary';
        checkuid.value = 'yes';
    }
    uidmsg.innerText = umsg;
};
userid?.addEventListener('blur',()=>{
    if (userid.value === '') {
       uidmsg.innerText = '6~16 자의 영문 소문자, 숫자와 특수기호(_)만 사용할 수 있습니다'
        uidmsg.className = 'text-danger';

        return;
    }

    const url = '/join/checkuid/'+ userid.value;
    fetch(url).then(response => response.text()).then(text => styleCheckuid(text));
});
