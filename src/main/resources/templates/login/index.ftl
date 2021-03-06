<!DOCTYPE html>
<html lang="en">
<head>
    <#include "./common/common.ftl"/>
</head>
<body>
<div id="vue">
    <div style="width: 250px;height: 300px">
        <el-form ref="ruleForm" :model="ruleForm" label-width="80px">
            <el-form-item label="用户名">
                <el-input v-model="ruleForm.name"></el-input>
            </el-form-item>
            <el-form-item label="密码">
                <el-input type="password" v-model="ruleForm.password"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="login">登陆</el-button>
                <el-button type="primary" @click="regist">注册</el-button>

            </el-form-item>
        </el-form>
    </div>
</div>
</body>
</html>
<script>
    var vm = new Vue({
        el: '#vue',
        data: {
            ruleForm: {name: '', password: ''},
            dialogVisible: '',
            loginUrl: '/login/login',
            userUrl: '/user/list',
            userId: window.localStorage.getItem("users")
        },
        methods: {
            login() {
                axios.post(this.loginUrl, this.ruleForm, this).then(function (res) {
                    window.location.href="yemian/index"
                });
                console.log("this.userid", this.userId)
            },
            regist() {
                console.log("ssssss", this.ruleForm)
            }
        },
        mounted: function () {
            axios.get(this.userUrl, {}, this).then(function (response) {
                window.localStorage.setItem("users", JSON.stringify(response.data));
            })

        },
        created: function () {

        }
    })
</script>