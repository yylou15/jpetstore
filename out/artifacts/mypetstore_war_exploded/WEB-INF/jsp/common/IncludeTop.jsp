<%--
  Created by IntelliJ IDEA.
  User: Ice
  Date: 2018/12/7
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html xmlns="http://www.w3.org/1999/xhtml">

<head>

    <link href="https://cdn.bootcss.com/twitter-bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <script src="static/js/js.js"></script>
    <link rel="StyleSheet" href="static/css/jpetstore.css" type="text/css"
          media="screen" />

    <meta name="generator"
          content="HTML Tidy for Linux/x86 (vers 1st November 2002), see www.w3.org" />
    <title>JPetStore Demo</title>
    <meta content="text/html; charset=windows-1252"
          http-equiv="Content-Type" />
    <meta http-equiv="Cache-Control" content="max-age=0" />
    <meta http-equiv="Cache-Control" content="no-cache" />
    <meta http-equiv="expires" content="0" />
    <meta http-equiv="Expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
    <meta http-equiv="Pragma" content="no-cache" />
</head>

<body>

<div id="Header">

    <div id="Logo">
        <div id="LogoContent">
            <a href="main"><img src="static/images/logo-topbar.gif" /></a>
        </div>
    </div>

    <div id="Menu">
        <div id="MenuContent">
            <a href="viewCart"><img align="middle" name="img_cart" src="static/images/cart.gif" /></a>
            <img align="middle" src="static/images/separator.gif" />
            <c:if test="${sessionScope.username == null}">
                <a href="signon">Sign In</a>
            </c:if>
            <c:if test="${sessionScope.username != null}">
                <a href="signout">SignOut</a> <img align="middle" src="static/images/separator.gif" />
                <a href="editAccountForm?username=${sessionScope.username}">My Account</a>
            </c:if>
            <img align="middle" src="static/images/separator.gif" />
            <a href="help.html">?</a>
        </div>
    </div>

    <div id="Search">
        <div id="SearchContent">
            <form action="searchProduct" method="post">
                <input id="searchInput" type="text" name="keyword" size="14"  style="line-height: normal"/>
                <input type="submit" name="searchProducts" value="Search" style="line-height: normal"/>
            </form>
        </div>
    </div>

    <div id="QuickLinks">
        <a href="viewCategory?categoryId=FISH"><img
                src="static/images/sm_fish.gif" /></a> <img src="static/images/separator.gif" />
        <a href="viewCategory?categoryId=DOGS"><img
                src="static/images/sm_dogs.gif" /></a> <img src="static/images/separator.gif" />
        <a href="viewCategory?categoryId=REPTILES"><img
                src="static/images/sm_reptiles.gif" /></a> <img
            src="static/images/separator.gif" />
        <a href="viewCategory?categoryId=CATS"><img
            src="static/images/sm_cats.gif" /></a> <img src="static/images/separator.gif" />
        <a href="viewCategory?categoryId=BIRDS"><img
                src="static/images/sm_birds.gif" /></a>
    </div>

</div>

<div id="Content">
