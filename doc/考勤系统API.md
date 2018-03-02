## 考勤系统API

### 1.员工打卡
```
GET /attendance/doAttendance
```

参数

```
无
```

返回

```
正常：
{
    "code": 0,
    "msg": "打卡成功" 
}

错误:
{
    "code": -1,
    "msg": "打卡失败" 
}
```


### 2.员工查看打卡情况
```
GET /attendance/list
```

参数

```
startTime:'2018-01-22'
endTime:'2018-02-02'
```

返回

```
{
    "code": 0,
    "msg": "成功",
    "data": [
        {
            "date":'2018-02-01',
            "dateTime": '2018-02-01 08:30:34', //上班打卡时间
            "dateTime": '2018-02-01 08:30:34', //下班打卡时间
        },
        {
            "date":'2018-02-02',
            "dateTime": '2018-02-01 08:30:34', //上班打卡时间
            "dateTime": '2018-02-01 08:30:34', //下班打卡时间
        }
    ]
}
```


### 3.部门经理查看所管理员工信息
```
GET /manager/getUserInfo
```

参数

```
无
```

返回

```
{
    "code": 0,
    "msg": "成功",
    "data": [
        {
            "userId":1,
            "userName": "张三"
           
        },
        {
            "userId":2,
            "userName": "李四"
        }
    ]
}
```


### 4.查看用户信息
```
GET /user/getUserInfo
```

参数

```
无
```

返回

```
{
    "code": 0,
    "msg": "成功",
    "data": [
        {
            "userId":1,
            "userName": "张三"
            "depertmentName":"部门名称"
            "roleName":"管理员"
           
        },
        {
            "userId":2,
            "userName": "李四"
            "depertmentName":"部门名称"
            "roleName":"部门经理"
        }
    ]
}
```


### 5.修改用户信息
```
GET /user/editUserInfo
```

参数

```
userId:1
depertmentId:2
roleId:3
```

返回

```
{
    "code": 0,
    "msg": "修改成功",
    
}
```


### 6.删除用户信息
```
GET /user/deleteUserInfo
```

参数

```
userId:1
depertmentId:2
roleId:3

```

返回

```
{
    "code": 0,
    "msg": "删除成功",
    
}
```


### 7.新建用户信息
```
GET /user/createUser
```

参数

```
userId:1

```

返回

```
{
    "code": 0,
    "msg": "新建成功",
    
}
```