import{getGroupNO,getLoginUser,findgrouplistByGno} from '/ssang/js/module.js';
var getGroup = getGroupNO();//쿼리스트링에서 가져온 모임번호 
var loginUser = await getLoginUser() //로그인한 유저의 정보
var groupList = await findgrouplistByGno(getGroup) // 그룹번호로 조회한 모임과 회원정보 
console.log(loginUser.data)
var membContainer = document.querySelector("#membContainer");
var membTemplate = document.querySelector('#memb-template') 
var membGenerator = Handlebars.compile(membTemplate.innerHTML);
for (var list of groupList.data){
    if(list.memberGrade.gradeName == '모임장'){
        $('.x-memb-name').text(list.member.memberName)
    }
}
membContainer.innerHTML= membGenerator(groupList.data)