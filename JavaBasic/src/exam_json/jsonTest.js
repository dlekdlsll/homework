let data = {"key":"키다","id":"아이디다", "name":"이름이다"};

console.log("key 출력하기 " + data.key);

console.log("key 수정하기 ");
data.key = "key다";
console.log(data);

console.log("key 삭제하기");
delete data.key;
console.log("key 삭제됨" + data);

console.log("key 추가하기");
data.key = "key 다시 생겼다";
console.log("key 생김 " + data);


