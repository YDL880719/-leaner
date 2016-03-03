<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>Servlet3.0实现文件上传</title>
  </head>
  
  <body>
        <fieldset>
            <legend>
                上传单个文件
            </legend>
            <!-- 文件上传时必须要设置表单的enctype="multipart/form-data"-->
            <form action="${pageContext.request.contextPath}/app/test1"
                method="post" enctype="multipart/form-data">
                上传文件：
                <input type="file" name="icon"/>
                <br>
                <input type="text" name="trueName"/>
                <br>
                <input type="submit" value="上传">
            </form>
        </fieldset>
        <hr />
       
    </body>
</html>