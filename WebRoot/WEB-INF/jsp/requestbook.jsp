<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>welcome页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  <body>
  <h2>提交试驾申请</h2>
    <form:form  method="POST" action="/CE/mobile/submitrequest" onsubmit="return check()">
        <table>
            <tr>
                <td><form:label path="UserName" >userName</form:label></td>
                <td><form:input id="csname" path="UserName" placeholder="input your name"/></td>
            </tr>
            <tr>
                <td><form:label path="PhoneNumber" text="input your phone number">phoneNumber</form:label></td>
                <td><form:input id="csphonenumber" path="PhoneNumber" placeholder="input your phonenumber" max-length="11"/></td>
            </tr>
            <tr>
                <td><form:label path="CarModel">carModel</form:label></td>
                <td>
                <form:select path="CarModel">
                    <form:options items="${carModelList}" />
               </form:select>
               </td>
            </tr>
            <tr>
                <td><form:label path="Seller">seller</form:label></td>
                <td><form:select path="Seller">
                        <form:options items="${sellerList}" />
                    </form:select>
                </td>
            </tr>
        </table>
        <table>
        <tr>
            <td>
            <div class="row">  
                <div class="col-sm-6">  
                    <div class="form-group">  
                        <label for="">Choose test drive date：</label>  
                        <div id='date1' class="input-group date">  
                            <input id="csbooktime"name="BookTime" type="text" value ="" class="form-control">
                            <span class="input-group-addon">  
                                <i class="glyphicon glyphicon-calendar"></i>  
                            </span>  
                        </div>  
                    </div>  
                </div>  
            </div>
            </td>
            </tr>
            </table>
           <tr>
                <td colspan="2">        
                    <input type="submit" value="submit" />
                </td>
            </tr>
    </form:form>
    <!-- 引入 Bootstrap -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css" rel="stylesheet"> 

<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script type="text/javascript" src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>  
<script type="text/javascript" src="https://cdn.bootcss.com/moment.js/2.18.1/moment-with-locales.min.js"></script>   
<script type="text/javascript" src="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script> 

<script type="text/javascript">
$(function () {  
    $('#date1').datetimepicker({  
        format: 'YYYY-MM-DD',  
        locale: moment.locale('zh-cn')
        }
    );
});

//check input
function check()
{
    //alert("0000");
    //name is not null
    if(csname.value == ""){
        alert("用户名不能为空");
        return false;
    } 
    if(csphonenumber.value==""){ 
        alert("请输入手机号码");
       return false; 
    }
/*     if(!(/^1[3|4|5|8][0-9]\d{4,8}$/.test(csphonenumber.value))){ 
        alert("请输入正确的手机号码"); 
        return false; 
    }  */   
    if(csbooktime.value == ""){
        alert("试驾日期不能为空");
        return false;    
    }
    return true; 
};
</script>
</body>
</html>
