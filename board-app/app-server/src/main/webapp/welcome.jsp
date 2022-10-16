<%@page import="com.bitcamp.board.domain.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bitcamp</title>

   <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Varela+Round" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" /> 

</head>
<body id="page-top">

 <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
            <div class="container px-4 px-lg-5">
                <a class="navbar-brand, navbar-light" href="#page-top">Start 꼉이</a>
                <button class="navbar-toggler navbar-toggler-right" 
                type="button" data-bs-toggle="collapse" 
                data-bs-target="#navbarResponsive" 
                aria-controls="navbarResponsive" 
                aria-expanded="false" aria-label="Toggle navigation">
                    Menu
                    <i class="fas fa-bars"></i>
                </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ms-auto">
                        <li class="nav-item"><a class="nav-link" href="#about">About</a></li>
                        <li class="nav-item"><a class="nav-link" href="#projects">Projects</a></li>
                        <li class="nav-item"><a class="nav-link" href="#signup">Contact</a></li>
                    </ul>
                </div>
            </div>
        </nav>    
            
            
      <div class="container px-4 px-lg-5 d-flex h-100 align-items-center justify-content-center">
                <div class="d-flex justify-content-center">
                    <div class="text-center">       
            
<h1 class="mx-auto my-0 text-uppercase">환영합니다!-JSP</h1>
<p class="text-white-50">비트캠프 게시판 관리 시스템 프로젝트입니다.</p>
<ul>
  <li><a href='${contextPath}/app/board/list'>게시글</a></li>
  <li><a href='${contextPath}/app/member/list'>회원</a></li>
<c:choose>
  <c:when test="${not empty sessionScope.loginMember}">
    <li><a href="${contextPath}app/auth/logout">${sessionScope.loginMember.name}(로그아웃)</a></li>
  </c:when>
  <c:otherwise>
    <li><a href='${contextPath}/app/auth/form'>로그인</a></li>
  </c:otherwise>
</c:choose>

</ul>
      </div>
                </div>
            </div>
</body>
</html>




