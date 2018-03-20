<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>考勤系统</title>

<link href="/login/css/main.css" rel="stylesheet" type="text/css" />

</head>
<body>

<div class="login">
    <div class="box png">
		<div class="logo png"></div>
		<div class="input">
			<div class="log">
                <form role="form" method="post" action="/login/loginSubmit">
					<div class="name">
						<label>用户名</label><input type="text" class="text" id="userName" placeholder="用户名" name="userName" tabindex="1">
					</div>
					<div class="pwd">
						<label>密　码</label><input type="password" class="text" id="password" placeholder="密码" name="password" tabindex="2">
                        <button type="submit" class="submit" tabindex="3" value="登录">提交</button>
						<#--<input type="button" class="submit" tabindex="3" value="登录">-->
                </form>

				</div>

			</div>
		</div>
	</div>
    <div class="air-balloon ab-1 png"></div>
	<div class="air-balloon ab-2 png"></div>
    <div class="footer"></div>
</div>

<script type="text/javascript" src="/login/js/jQuery.js"></script>
<script type="text/javascript" src="/login/js/fun.base.js"></script>
<script type="text/javascript" src="/login/js/script.js"></script>


<!--[if IE 6]>
<script src="/login/js/DD_belatedPNG.js" type="text/javascript"></script>
<script>DD_belatedPNG.fix('.png')</script>
<![endif]-->
<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';">
<p>适用浏览器：360、FireFox、Chrome、Safari、Opera、傲游、搜狗、世界之窗. 不支持IE8及以下浏览器。</p>
</div>
</body>
</html>