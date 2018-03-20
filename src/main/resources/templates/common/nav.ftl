<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand active" href="/attendance/list">考勤系统</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="/attendance/list">员工打卡信息</a></li>
                <li><a href="/manager/getUserInfo">部门经理查看</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a ref="#" class="dropdown-toggle" data-toggle="dropdown">
                        <span class="glyphicon glyphicon-user"></span>
                        system-attendance
                        <b class="caret"></b>
                    </a>

                    <ul class="dropdown-menu">

                        <li><a href="/user/list">员工基础信息</a></li>
                        <li class="divider"></li>
                        <li><a href="/admin/userPermissionList">员工权限信息</a></li>
                        <li class="divider"></li>
                        <li><a href="/login/logout">logout</a></li>
                    </ul>
                </li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>