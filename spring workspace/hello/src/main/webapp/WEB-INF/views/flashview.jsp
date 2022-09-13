<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>포워드 : ${ fowardtest } </p>
	<p>리다이렉트 : ${ redirecttest } </p>
	<p>파람 : ${ param.redirecttest } </p>
	<!-- 파라미터 값으로 꺼내야한다. 알아서 파라미터의 값으로 설정 해 주기 때문.
	스프링에서 리다이렉트 하고 모델이 있으면 알아서 파라미터에 값을 설정해준다. -->
	<!-- 주소에 입력한 값이 다 보인다. 이걸 어떻게 해결할 수 있을까? -->
</body>
</html>