<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<html>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/bootstrap-table.min.css">
<head>
<title>requestRecord</title>
</head>
<body>
    <h2>查看试驾结果</h2>
<table class="table table-hover" id="cusTable"  
       data-pagination="true"  
       data-show-refresh="true"  
       data-show-toggle="true"  
       data-showColumns="true">  
       <thead>   
       </thead>  
       <tbody>
       </tbody>  
</table> 

<script type="text/javascript" src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>  
<script type="text/javascript" src="https://cdn.bootcss.com/moment.js/2.18.1/moment-with-locales.min.js"></script>   
<script type="text/javascript" src="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/bootstrap-table.min.js"></script>
<!-- Latest compiled and minified Locales -->
<script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/locale/bootstrap-table-zh-CN.min.js"></script>

<script>
   function initTable() {  
        //先销毁表格  
        $('#cusTable').bootstrapTable('destroy');  
        //初始化表格,动态从服务器加载数据  
        $("#cusTable").bootstrapTable({  
            //method: "get",  //使用get请求到服务器获取数据  
            method: "post",
            contentType: "application/x-www-form-urlencoded",
            striped: true,  //表格显示条纹  
            url: "/CE/mobile/getrecord", //获取数据的Servlet地址  
            pagination: true, //启动分页  
            pageSize: 10,  //每页显示的记录数  
            pageNumber:1, //当前第几页  
            pageList: [10,20],  //记录数可选列表  
            search: false,  //是否启用查询  
            showColumns: false,  //显示下拉框勾选要显示的列  
            showRefresh: true,  //显示刷新按钮  
            //sidePagination: "client",
            sidePagination: "server", //表示服务端请求  
            showToggle:false,
            dataType:"json",
            clickToSelect:tru e,
            height:600,
            //设置为undefined可以获取pageNumber，pageSize，searchText，sortName，sortOrder  
            //设置为limit可以获取limit, offset, search, sort, order  
            queryParamsType : "limit",   
            queryParams: function queryParams(params) {   //设置查询参数  
              var param = {    
                  limit: params.limit,   //页面大小
                  offset: params.offset  //页码
                };
              return param;                   
            },  
            columns: [{
                    field: 'userName',
                    title: '用户'
                }, {
                    field: 'phoneNumber',
                    title: '手机号'
                }, {
                    field: 'seller',
                    title: '经销商'
                }, {
                    field: 'carModel',
                    title: '汽车型号'
                }, {
                    field: 'bookTime',
                    title: '试驾时间'
                },]
          });  
      }  
  
      $(document).ready(function () {
          //调用函数，初始化表格  
          initTable();    
          //当点击查询按钮的时候执行  
          $("#search").bind("click", initTable);  
      });
      
       $(".search").click(function(){
           var searchArgs={
                name:$("input[name='name']").val(),
                age:$("input[name='age']").val()
           }
           bstpTable.inint(searchArgs)
       })

</script>
</body>
</html>