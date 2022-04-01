/***************************************************************************
*
*        Date            : 2004-12-24
*        Copyright        : aucd29
*        E-mail            : aucd29@daum.net
*        Type            :
*
*        지역 설정을 쉽게 해보도록 하자.
*
***************************************************************************/

//
// select 에서 선택된 것을 바탕으로 CityData.js를 참조하여 하위 Area를 보여준다.
//
function Next(n,val)
{
    var str,len,k=0;
    if(n==0) return;    // 첫번째 선택했으면

    len = cat2_info0[n].length;
    var chk3;
    var j = 1;

    // 전국이 체크 되었는지 확인
    var chk = Checked('전국')?'CHECKED':'';
    str = "<input id='BoxAll' type='checkbox' name='sCity2[]' value='전국' onClick=Clicked(this,"+n+",'"+val+"') "+chk+" />전국";

    // 도 지역일경우 해당 도를 선택했는지
    var chk2 = Checked(val)?'CHECKED':'';
    if(n>7)
    {
        chk2 = chk=='CHECKED'?'DISABLED':chk2;
        str += "<input id='BoxBig' type='checkbox' name='sCity2[]' value='"+val+"'";
        str += " onClick=Clicked(this,"+n+",'"+val+"') "+chk2+" />"+val;
    }
    for(var i=0; i<len; ++i)
    {
        // 상위 것들 체킹
        // 여기서 상위가 체크되면 하위는 자동으로 disabled 시킨다.
        chk3 = Checked(cat2_info0[n][i].name)?'CHECKED':'';
        chk3 = chk2=='CHECKED'?'DISABLED':chk3;
        chk3 = chk=='CHECKED'?'DISABLED':chk3;

        str += "<input id='Box_"+n+"_"+i+"' type='checkbox' name='sCity2[]' value='"+cat2_info0[n][i].name+"'";
        str += " onClick=Clicked(this,"+n+",'"+val+"') "+chk3+" />"+cat2_info0[n][i].name;

        if(j%7==0&&!k || j%10==0&&k) { k=1; j=1; str += "<br>"; }
        ++j;
    }
    document.getElementById('ChkBox').innerHTML = str;
}

//
// 해당하는 객체가 선택된 것인지 아닌지를 확인
//
function Checked(str)
{
    var z;
    var len2 = selectBox.length;
    if(len2 > 0)
    {
        for(z=0;z<len;++z)
        {
            if(selectBox[z]==str)
            {
                return true;
            }
        }
    }
    return false;
}

//
// 체크박스를 선택했을 때 발생하는 이벤트를 조정
//
function Clicked(obj,n,val)
{
    var len = selectBox.length;
    var tmp = new Array();
    var tmp2 = new Array();

    var data,rechk;
    if(len > 4&&obj.checked == true)
    {
        alert('5개 이상을 선택하실 수 없습니다.');
        obj.checked = false;
        return false;
    }
    data = obj.value;
    //if(obj.value == '전국')
    //else
    //data = p.value+'('+obj.value+')';
    //alert(obj+','+n+','+val);
    //alert(obj.id);                        object identity

    // 이곳에서 rechk가 존재하면 선택했던 것을 다시 선택하게 된것으로
    // 해당 객체를 없앤다.
    for(i=0; i<len; ++i)
    {
        if(selectBox[i]==data) rechk = true;
    }

    if(rechk != true)
    {
        selectBox[len] = data;
        identity[len] = obj.id;
    }
    else
    {
        var j=0;
        for(i=0; i<len; ++i)
        {
            if(selectBox[i]!=data)
            {
                tmp[j] = selectBox[i];
                tmp2[j] = identity[i];
                ++j;
            }
        }
        obj.checked = false;

        selectBox = null;
        identity = null;
        selectBox = tmp;
        identity = tmp2;
    }

    ClickedPrint(n,val);

    if(    data=='전국'||data=='전남'||data=='전북'||data=='경기'||data=='충남'||
        data=='충북'||data=='강원'||data=='경남'||data=='경북'||data=='제주')
    {
        Next(n,val);
    }
}

//
// 선택된 객체를 하단에 뿌려주는 역할을 한다.
//
function ClickedPrint(n,val)
{
    var len = selectBox.length;
    //alert(len);
    var str = '';
    for(i=0; i<len; ++i)
    {
        if(i==0)
            str = "<a href=javascript:RemoveArea('"+selectBox[i]+"',"+n+",'"+val+"')>"+selectBox[i];
            //str = selectBox[i];
        else
            str += ", <a href=javascript:RemoveArea('"+selectBox[i]+"',"+n+",'"+val+"')>"+selectBox[i];
            //str += ", "+selectBox[i];
        str += "<input type='hidden' name='area[]' value='"+selectBox[i]+"' />";
    }
    document.getElementById('SelectBox').innerHTML=str;
}

//
// 하단에 뿌려져 있는 Text를 선택시 checkbox를 disabled시키고 text를 remove한다.
//
function RemoveArea(box,n,val)
{
    var len = selectBox.length;
    var j = 0;
    var tmp = new Array();
    //var tmp2 = new Array();

    for(var i=0; i<len; ++i)
    {
        if(selectBox[i]!=box)
        {
            tmp[j] = selectBox[i];
            //tmp2[j] = identity[i];
            ++j;
        }
    }
    selectBox = tmp;
    //identity = tmp2;

    Next(n,val);
    ClickedPrint(n,val);
}

//
// submit checking
//
function Checking(obj)
{
    var len = obj.elements['type'].length;
    var chk = 0;

    for(i=0; i<len; ++i)
    {
        if(obj.elements['type'][i].checked == true) ++chk;
    }

    if(!chk)
    {
        alert('관심종목을 선택하세요');
        obj.elements['type[0]'].focus();
        return false;
    }

    if(obj.elements['amount_t'].selectedIndex >= 1 && !obj.elements['amount'].value)
    {
        alert('금액을 입력하세요');
        obj.elements['amount'].focus();
        return false;
    }

    return true;
}

