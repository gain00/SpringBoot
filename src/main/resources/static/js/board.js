// board view
let newbdbtn = document.querySelector("#newbdbtn");
let moddbbtn = document.querySelector("#moddbtn");
let rmvbdbtn = document.querySelector("#rmvbdbtn");
let lstbdbtn = document.querySelector("#lstbdbtn");

newbdbtn?.addEventListener('click',()=>{
    location.href = '/board/write';
});
moddbbtn?.addEventListener('click',()=>{
    if(confirm("정말 수정하시겠어요?")){
        alert('아직 미지원 기능입니다');
    }
});
rmvbdbtn?.addEventListener('click',()=>{
    if(confirm("정말 삭제하시겠어요?")){
        alert('아직 미지원 기능입니다');
    }
});
lstbdbtn?.addEventListener('click',()=>{
    location.href = '/board/list/1';
});


//board write
let wrtbtn = document.querySelector("#wrtbtn");
let cancelbtn3 = document.querySelector("#cancelbtn3");
let bdfrm = document.querySelector("#bdfrm");

wrtbtn?.addEventListener('click',()=>{
    let frm = document.forms.bdfrm
    if(frm.title.value==='') alert('제목을작성하시오');
    else if(frm.content.value==='') alert('본문을작성하시오');
    else if(grecaptcha.getResponse()==='') alert('c체크하시오');
    else{
        bdfrm.method = 'post';
        bdfrm.submit();
    }


});
cancelbtn3?.addEventListener('click',()=>{
    location.href = '/board/list/1';
});


let newbdntn = document.querySelector("#newbdntn")
newbdntn?.addEventListener('click',()=>{
    location.href = '/board/write';
});

//board find
let findbtn = document.querySelector("#findbtn");
let findtype = document.querySelector("#findtype");
let findkey = document.querySelector("#findkey");

findbtn?.addEventListener('click',()=>{
    if(findkey.value === '') alert('검색어를 입력하세요');
    else{

        location.href = `/board/find/${findtype.value}/${findkey.value}/1`;

    }
});

