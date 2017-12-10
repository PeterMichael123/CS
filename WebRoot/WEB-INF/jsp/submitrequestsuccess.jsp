<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>SubmitResult</title>
</head>
<body>
    <h2>提交成功</h2>
    <form:form method="POST" action="/CE/mobile/getresult">
    <div style="font-size:16px">
         <input style="font-size:16px" type="button" value="再次提交" onclick="javascript:history.back(-1)">  
    </div>
    </form:form>
</body>
<script>   
</script>
</html>