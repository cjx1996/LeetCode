let myImage=document.querySelector('img');

myImage.onclick=function (){
    let mySrc = myImage.getAttribute('src');
    if(mySrc==='img.png'){
        myImage.setAttribute('src','img1.png');
    }else{
        myImage.setAttribute('src','img.png');
    }
}

let myButton =document.querySelector('button');
let myHeading=document.querySelector('h1');

if(!localStorage.getItem('name')){
    setUserName();
}else{
    let storedName=localStorage.getItem('name');
    myHeading.textContent='Mozilla酷毙了'+storedName;
}


function setUserName(){
    let myName=prompt('请输入你的名字：');
    if(!myName||myName===null){
        setUserName();
    }else {
        localStorage.setItem('name', myName);
        myHeading.textContent = 'Mozilla酷毙了' + myName;
    }
}
myButton.onclick=function (){
    setUserName();
}
