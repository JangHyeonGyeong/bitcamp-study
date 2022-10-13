
// 모듈 추출 
const express = require('express');

// 서버를 생성 / 실행 
const app = express();
app.listen(52273, () => {
  console.log('Server Running at http://127.0.0.1:52273');
});

// 미들웨어를 추가
app.use(express.urlencoded({
  cxtended: false
}))

//변수 선언
let userCounter = 0;
const users = [];

// 라우트 한다 -------------
app.get('/user', (request, response) => {
  response.send(users);
});
// /user 로 GET 요청하면 전체 사용자를 조회한다 --------



// --------------
app.get('/user/:id', (request, response) => {
  //변수선언
  const id = request.params.id;
  
  //데이터를 찾는다
 const filltered = users.fillter((user) => user.id == id);
 
 //응답한다
 if (filltered.lenght ==1)
 response.send(filltered[0]);
 else
 response.status(404).send('데이터 존재하지 않음');
   });
   
   
   app.post('/user', (request, response) => {
    })
    
// /user/10 등으로  GET 요청하면 특정 사용자 정보를 조회 -----

app.post('/user/:id', (request, response) => {
  // 변수 선언
  const body = request.body;
  
  //예외 처리
  if(!body.name)
  return response.status(400).send('name을 보내주세요');
   else if(!body.region)
   return response.status(400).send('region을 보내주세요');
   
   //변수 추출
   const name = body.name;
   const region = body.region;
   
  // 데이터 저장
  const data = {
    id: userCounter++,
    name: name,
    region : region 
    };
    users.push(data);
    
    //응답
    response.send(data);
  });
// /user로 post 요청하면 사용자를 추가한다 ---------------------

// -----------------------------------------------
app.put('/user/:id', (request, response) => {
  // 데이터 찾음
  const id = request.params.id
  const user = users.find((user) => user.id == id)
  
  if(user) {
    //데이터가 존재한다면
    if(request.body.name)
    users[id].name = request.body.name;
    if(request.body.region)
    users[id].region = request.body.region;
     
    //응답
    response.send(user)
    } else {
      // 데이터가 존재하지 않는다면
      // 응답
      response.status(404).send('데이터가 존재하지 않습니다.');
    }
  }); 
  // /user/10 등으로 PUT 요청하면 특정 사용자 정보를 수집합니다. ---------
  
  // ---------------------------------------------------------------------
   app.delete('/user/:id', (request, response) => {
    //변수 선언
   const id = request.params.id
   const index = users.findIndex((user) => user.id == id)

//데이터 제거
if (index != -1){
  users.splice(index, 1);
  response.send('제거했습니다');
  
}else {
  response.status(404).send('데이터가 존재하지 않습니다');
}
  });
// /user/10 등으로 delete요청하면 특정 사용자 정보를 제거한다.
