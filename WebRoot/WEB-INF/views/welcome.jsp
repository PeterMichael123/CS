<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <!-- 引入 Bootstrap -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css" rel="stylesheet"> 
    <title>welcome页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
  <form:form> 
  <h2>用户信息</h2>
        <table>
            <tr>
                <td><form:label path="username">username：</form:label></td>
                <td><form:input path="username" /></td>
            </tr>
            <tr>
                <td><form:label path="phonenumber">phonenumber：</form:label></td>
                <td><form:input path="phonenumber" /></td>
            </tr>
            <tr>
                <td><form:label path="carmodel">carModel：</form:label></td>
                <td><form:select path="carmodel">
                        <form:option value="NONE" label="请选择..." />
                        <form:options items="${carModelList}" />
                    </form:select></td>
            </tr>
            <tr>
                <td><form:label path="seller">seller：</form:label></td>
                <td><form:select path="seller">
                        <form:option value="NONE" label="请选择..." />
                        <form:options items="${sellerList}" />
                    </form:select></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="提交" /></td>
            </tr>
        </table>
    </form:form> 
<form role="form">
  <div class="form-group">
    <input class="form-control" id="name" type="text" placeholder="请输入姓名">
  </div>
  <div class="form-group">
    <input class="form-control" type="text" id="phonenumber" placeholder="请输入手机号">
  </div>
  <div class="form-group">
    <label class="col-sm-3 control-label">Car Model</label>
    <select id="carmodel" class="form-control input-sm">
      <option value="">奔驰</option>
      <option value="">奥迪</option>
      <option value="">宝马</option>
    </select>
  </div>
  <div class="form-group">
   <label class="col-sm-3 control-label">Seller</label>
    <select id="seller" class="form-control input-sm">
      <option value="">奔驰</option>
      <option value="">奥迪</option>
      <option value="">宝马</option>
    </select>
  </div>
<div class="row">  
    <div class="col-sm-6">  
        <div class="form-group">  
            <label for="">选择日期：</label>  
            <div class="input-group date" id='date1'>  
                <input type="text" class="form-control">  
                <span class="input-group-addon">  
                    <i class="glyphicon glyphicon-calendar"></i>  
                </span>  
            </div>  
        </div>  
    </div>  
</div>
</form>

<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script type="text/javascript" src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>  
<script type="text/javascript" src="https://cdn.bootcss.com/moment.js/2.18.1/moment-with-locales.min.js"></script>   
<script type="text/javascript" src="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script> 

<script type="text/javascript">
  $(function () {  
    $('#date1').datetimepicker({  
        format: 'YYYY-MM-DD',  
        locale: moment.locale('zh-cn'),
        defaultDate: "1990-1-1"  
    });  
});


</script>

</body>
</html>
