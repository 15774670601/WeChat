<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
	<meta name="author" content="m.ehaier.com">
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" name="viewport"  />
	<meta name="format-detection" content="telephone=no" />
	<meta content="yes" name="apple-mobile-web-app-capable" />
	<meta content="black" name="apple-mobile-web-app-status-bar-style" />
	<meta content="telephone=no" name="format-detection" />
	<meta content="false" id="twcClient" name="twcClient" />
	<link type="text/css" rel="stylesheet" href="css/v2/style.css">
	<link rel="apple-touch-icon-precomposed" href="../../images/ehaier-icon.png"/>	
	<link rel="shortcut icon" type="image/x-icon" href="../../images/ehaier-icon.png"/>
	<title>用户登录</title>
<link type="text/css" rel="stylesheet" href="css/v2/member.css">

</head>
<body id="page">
<header class="header"> 
	<span class="fh left"><a href="javascript:history.back(1)">&nbsp;</a></span>  	登录
  	<span class="hd_right right">
</span>
</header>
<span id="login_errorMsg" style=" padding:10px;"></span>
<div class="Login">
  <div class="Login_top">
    <ul>
      <li class="cur"><A href="/Regist">登录</A></li>
      <li><A href="/Login">注册</A></li>
    </ul>
  </div>
  <div> 
    <div class="Login_bottom">
      <form id="loginForm" action="/mobile/member/memberLogin.html" method="post">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="60" align="center" valign="middle"><input type="text" id="mobileNum" value="" name="phone1" placeholder="手机号" class="login_wbk"></td>
          </tr>
          <tr>
            <td height="60" align="center" valign="middle"><input type="password" id="password" name="password" placeholder="密码"  class="login_wbk"></td>
          </tr>
          <tr>
            <td height="60" align="center" valign="middle"><A href="#" id="memberLogin" class="dl_login">登录</A></td>
          </tr>
        </table>
      </form>
    </div>
   </div>
</div>
	<footer class="footer">
	<div id="footer" class="ft_top">
				<a href="toMemberLogin.html">登录</a>|<a href="toMemberRegist.html">注册</a>
			</div>
  	<p><a href="javascript:scroll(0,0)">返回顶部</a>|<a href="#">返回首页</a> </p>
</footer>
</body>
</html>
