<%--
  Created by IntelliJ IDEA.
  User: vincent
  Date: 2019-05-05
  Time: 00:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>welcome</title>
</head>
<body>
<%-- 从服务端 controller 层获取 ModelAndView 的属性值 --%>
<p>os name:        ${OS_NAME}</p>
<p>os version:     ${OS_VERSION}</p>
<p>java home:      ${JAVA_HOME}</p>
<p>java version:   ${JAVA_VERSION}</p>
<p>spring version: ${SPRING_VERSION}</p>
</body>
</html>
