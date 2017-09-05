<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="description" content="Metro, a sleek, intuitive, and powerful framework for faster and easier web development for Windows Metro Style.">
    <meta name="keywords" content="HTML, CSS, JS, JavaScript, framework, metro, front-end, frontend, web development">
    <meta name="author" content="Sergey Pimenov and Metro UI CSS contributors">

    <link rel='shortcut icon' type='image/x-icon' href='../favicon.ico' />

    <title>Login form :: Metro UI CSS - The front-end framework for developing projects on the web in Windows Metro Style</title>

    <link href="${cp}/resources/default.css" rel="stylesheet" type="text/css">
    <link href="${cp}/resources/metro.css" rel="stylesheet" type="text/css">
    <link href="${cp}/resources/metro-icons.css" rel="stylesheet" type="text/css">
    <link href="${cp}/resources/metro-responsive.css" rel="stylesheet" type="text/css">

    <script src="${cp}/resources/jquery-2.1.3.min.js"></script>
    <script src="${cp}/resources/metro.js"></script>
 
    <style>
        .login-form {
            width: 25rem;
            height: 18.75rem;
            position: fixed;
            top: 50%;
            margin-top: -9.375rem;
            left: 50%;
            margin-left: -12.5rem;
            background-color: #ffffff;
            opacity: 0;
            -webkit-transform: scale(.8);
            transform: scale(.8);
        }
    </style>

    <script>

        /*
        * Do not use this is a google analytics fro Metro UI CSS
        * */
       /*
        if (window.location.hostname !== 'localhost') {

            (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
                (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
                    m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
            })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

            ga('create', 'UA-58849249-3', 'auto');
            ga('send', 'pageview');

        }

 */
        $(function(){
            var form = $(".login-form");

            form.css({
                opacity: 1,
                "-webkit-transform": "scale(1)",
                "transform": "scale(1)",
                "-webkit-transition": ".5s",
                "transition": ".5s"
            });
        });
    </script>
</head>
<body > <!-- class="bg-darkTeal" -->
    <div class="login-form padding20 block-shadow">
        <form name="submitForm" method="POST">
            <h1 class="text-light">Organica.rs</h1>
            <hr class="thin"/>
            <br />
            <div class="input-control text full-size" data-role="input">
                <label for="user_login">User email:</label>
                <input type="text" name="userName" id="user_login" placeholder="demo">
                <button class="button helper-button clear"><span class="mif-cross"></span></button>
            </div>
            <br />
            <br />
            <div class="input-control password full-size" data-role="input">
                <label for="user_password">User password:</label>
                <input type="password" name="password" id="user_password" placeholder="demo">
                <button class="button helper-button reveal"><span class="mif-looks"></span></button>
            </div>
            <div style="color: red">${error}</div>
            <br />
            <br />
            <div class="form-actions">
     <!--           <button type="submit" class="button primary">Login to...</button> -->
                <input type="button" onclick="location.href='azuriranje.web';" value="Prijava" />
                <input type="button" onclick="location.href='pocetna.web';" value="Cancel" />

                <input type="submit" value="Obrada">
      <!--           <button type="button" class="button link">Cancel</button>
                 <a href="<c:url value="pocetna.web"></c:url>"> Povratak na stranu pretrage</a> 
       -->
            </div>
        </form>
    </div>
</body>
</html>